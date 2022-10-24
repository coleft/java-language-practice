package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class MemberDto {	//데이터 처리 DAO, 통신 기능이 포함되면 DTO라는 개념을 활용
	
	Connection conn;
	
	/*
	public MemberDto() {
		conn = new DBConn().getConn();	그냥 각각의 메서드에서 알아서 하라고 지웠다.
	}
	*/
	
	public int insert(MemberVo vo) {
		int cnt = 0;
		
		//connection 생성
		conn = new DBConn().getConn();
				
		try {
			//transaction수동
			conn.setAutoCommit(false);
			
			//sql 문장
			String sql = "insert into member(id,name,gender,phone,picture,mdate)"
						+" values(?,?,?,?,?, now())";	//주의 : 사이에 띄어쓰기 고민해야한다.
			
			//statement 생성/완성
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getIrum());
			ps.setString(3, vo.getGender());
			ps.setString(4, vo.getPhone());
			ps.setString(5, vo.getPicture());		
			
			//저장(실행)
			cnt = ps.executeUpdate();
			if(cnt>0) conn.commit();
			else	  conn.rollback();
			
			//close
			ps.close();
			conn.close();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return cnt;
	}
	
	public int update(MemberVo vo) {
		int cnt = 0;
		return cnt;
	}
	
	public int delete(String id) {
		int cnt = 0;
		return cnt;
	}	
	
	public Vector<Vector> select(String findStr){
		Vector<Vector> list = new Vector<Vector>();		
		try {			
			conn = new DBConn("mydb").getConn();
			String sql = "select * from member "+
						 "where id like ? "+
						 "or name like ? "+
						 "or phone like ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+findStr+"%");
			ps.setString(2, "%"+findStr+"%");
			ps.setString(3, "%"+findStr+"%");
			
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				Vector v = new Vector();
				v.add(rs.getString("id"));
				v.add(rs.getString("name"));
				v.add(rs.getString("gender"));
				v.add(rs.getString("phone"));
				v.add(rs.getString("mdate"));
				list.add(v);
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}		
		return list;
	}
	
}
