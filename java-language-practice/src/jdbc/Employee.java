package jdbc;

import java.sql.Connection;	//인터페이스?
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
//이 페이지에서는 CRUD에서 R빼고 구현했다.
public class Employee {
	
	//늘 가장 중요한 게 crud임
	Connection conn;	//java.sql에 들어가있는 인터페이스이다.
	
	public Employee() {
		this.conn = new DBConn().getConn();	//DBConn : 드라이버명, path(한글때문에 unicode식 추가했다.), 
	}
	
	//메서드를 네 개 만들 것이다.
	public void insert() throws Exception{
		conn.setAutoCommit(false);	//트랜젝션기능수동변경
		String sql = "insert into test(id,name) values(?,?)";	//sql 문장 쓰기
		PreparedStatement ps = conn.prepareStatement(sql);	//sql이 문자열이 아니라 데이터베이스에서 쓸 수 있는 Statement가 된거다.
		ps.setString(1, "e001");	//주의 java는 zero base, sql은 one base
		ps.setString(2, "가씨");
		
		int cnt = ps.executeUpdate();	//~가 적용된 행수
		if(cnt>0) conn.commit();	
		else	  conn.rollback();	//조치 내용 없으면 롤백
		
		ps.close();	//자원 아끼기 위해 종료해줘야합니다.
		conn.close();
	}
	
	public void select() throws Exception {		//CRUD를 조치하기 위해 만들었다.
		String sql = "select * from test";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery(); //명시적 커서라고 생각하면 된다.	//executeQuery의 반환타입은 ResultSet이다.
		while(rs.next()) {	//rs.next() - 현재 데이터를 반환하고 다음 위치로 이동한다. //현재 위치를 bof(bot), eof(eot), f:file, t:type //단선적인 파일구조의 맨 앞과 뒤(007 생각해라)
			String id = rs.getString("id");
			String name = rs.getString("name");
			System.out.printf("%s (%s)\n", id, name);
		}
	}
	
	public void update() throws Exception{
		conn = new DBConn().getConn();
		conn.setAutoCommit(false);
		String sql = "update test set name=? where id=?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, "나씨");
		ps.setString(2, "e001");
		int cnt = ps.executeUpdate();
		if(cnt>0) conn.commit();
		else	  conn.rollback();
		
		select();//확인해보자
		
		ps.close();
		conn.close();//웹에서는 이거 안써주면 서버 반나절이면 죽는다.
	}
	
	public void delete() throws Exception{
		//conn = new DBConn().getConn();
		conn.setAutoCommit(false);
		String sql = "delete from test where id = ?";
		PreparedStatement ps = conn.prepareStatement(sql);
		ps.setString(1, "e001");
		int cnt = ps.executeUpdate();
		if(cnt>0) {
			System.out.println("정상삭제...");
			conn.commit();
		}else {
			System.out.println("삭제할 자료가 없네요");
			conn.rollback();
		}
		
		select();
		
		ps.close();
		conn.close();		
	}
	
	public void metaTest() throws Exception {	//resultSetMetaData
		conn = new DBConn().getConn();
		String sql = "select * from score";
		PreparedStatement ps = conn.prepareStatement(sql);	//미완성이지만, statement가 만들어졌다.
		ResultSet rs = ps.executeQuery();
		ResultSetMetaData meta = rs.getMetaData();
				
		//select절에서 선택한 컬럼명//mysql은 1부터 시작해
		for(int i = 1; i<=meta.getColumnCount(); i++) {
			System.out.printf("%-20s", meta.getColumnName(i));
		}
		System.out.println();
		System.out.println("-".repeat(160));
		while(rs.next()) {
			for(int i = 1; i<=meta.getColumnCount(); i++) {
				String cn = meta.getColumnName(i); //cn : ColumnName
				System.out.printf("%-20s", rs.getString(cn));
			}
			System.out.println();
		}
	}
	
	public static void main(String[] args) {
		Employee e = new Employee();
		try {
			//e.insert();
			//e.select();
			//e.update();
			//e.delete();
			e.metaTest();
		}catch(Exception e1) {
			e1.printStackTrace();
		}
	}
}
