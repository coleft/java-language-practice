package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Employee {
	
	//늘 가장 중요한 게 crud임
	Connection conn;	//java.sql에 들어가있는 인터페이스이다.
	
	public Employee() {
		this.conn = new DBConn().getConn();
	}
	
	//메서드를 네 개 만들 것이다.
	public void insert() throws Exception{
		conn.setAutoCommit(false);
		String sql = "insert into test(id,name) values(?,?)";
		PreparedStatement ps = conn.prepareStatement(sql);	//sql이 문자열이 아니라 데이터베이스에서 쓸 수 있는 Statement가 된거다.
		ps.setString(1, "e001");
		ps.setString(2, "가씨");
		
		int cnt = ps.executeUpdate();
		if(cnt>0) conn.commit();
		else	  conn.rollback();
		
		ps.close();
		conn.close();
	}
	
	public void select() throws Exception {
		String sql = "select * from test";
		PreparedStatement ps = conn.prepareStatement(sql);
		ResultSet rs = ps.executeQuery(); //명시적 커서라고 생각하면 된다.
		while(rs.next()) {
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
	
	
	public static void main(String[] args) {
		Employee e = new Employee();
		try {
			//e.insert();
			//e.select();
			//e.update();
			e.delete();
		}catch(Exception e1) {
			e1.printStackTrace();
		}
	}	
}
