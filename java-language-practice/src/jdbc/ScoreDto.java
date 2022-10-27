package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

public class ScoreDto {
	
	Connection conn;
	
	public int insert(ScoreVo vo) {
		int cnt = 0;
		
		conn = new DBConn("mydb").getConn();
		
		try {
			conn.setAutoCommit(false);
			
			String sql = "insert into score(id, mdate, subject, score)"+
						" values(?,?,?,?)";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			//ps.setString(1, vo.getSerial());
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getMdate());
			ps.setString(3, vo.getSubject());
			ps.setString(4, vo.getScore());
			
			cnt = ps.executeUpdate();
			if(cnt>0) conn.commit();
			else 	  conn.rollback();
			
			ps.close();
			conn.close();			
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return cnt;	//성공여부가 결과물입니다.
	}
	
	public int update(ScoreVo vo) {
		int cnt = 0;
		try {
			conn = new DBConn("mydb").getConn();
			conn.setAutoCommit(false);
			String sql = "update score set "
					   + "id = ?, "
					   + "mdate = ?, "
					   + "subject = ?, "
					   + "score = ? where serial = ? ";					
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, vo.getId());
			ps.setString(2, vo.getMdate());
			ps.setString(3, vo.getSubject());
			ps.setString(4, vo.getScore());
			ps.setString(5, vo.getSerial());
			
			cnt = ps.executeUpdate();
			if(cnt>0) conn.commit();
			else 	  conn.rollback();
			
			ps.close();
			conn.close();
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return cnt;
	}
	
	public int delete(String serial) {
		int cnt = 0;
		try {
			conn = new DBConn("mydb").getConn();
			conn.setAutoCommit(false);
			
			String sql = "delete from score where serial = ? ";
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, serial);
			cnt = ps.executeUpdate();
			if(cnt>0) conn.commit();
			else	  conn.rollback();
			
			ps.close();
			conn.close();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		return cnt;
	}
	
	public Vector<Vector> select(String findStr){
		Vector<Vector> list = new Vector<Vector>();
		/*
		try {
			conn = new DBConn("mydb").getConn();
			
			String sql = "select * from score "+
						 "where serial like ? "+
						 "or id like ? "+
						 "or subject like ? ";
			
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, "%"+findStr+"%");
			ps.setString(2, "%"+findStr+"%");
			ps.setString(3, "%"+findStr+"%");
			
			ResultSet rs = ps.executeQuery();	//Query 실행 결과물을 Object타입으로 반환
			while(rs.next()) {
				Vector v = new Vector();	//벡터의 벡터
				v.add(rs.getString("serial"));
				v.add(rs.getString("id"));
				v.add(rs.getString("mdate"));
				v.add(rs.getString("subject"));
				v.add(rs.getString("score"));
				list.add(v);
			
			}
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		*/
		//Bot ~~~~~ Eot
		
		try {
	         conn = new DBConn("mydb").getConn();
	         String sql = " select serial, id, subject, score, "
	                  + " date_format(mDate, '%Y-%m-%d') mDate from score "
	                  + " where id like ? "
	                  + " or subject like ? ";
	         PreparedStatement ps = conn.prepareStatement(sql);
	         ps.setString(1, "%"+findStr+"%");
	         ps.setString(2, "%"+findStr+"%");
	         
	         ResultSet rs = ps.executeQuery();
	         while(rs.next()) {
	            Vector v = new Vector();
	            v.add(rs.getString("serial"));
	            v.add(rs.getString("id"));
	            v.add(rs.getString("mDate"));
	            v.add(rs.getString("subject"));
	            v.add(rs.getString("score"));
	            list.add(v);
	         }
	         ps.close();
	         conn.close();
	      }catch(Exception ex) {
	         ex.printStackTrace();
	      }
		
		return list;
	}
	
	
	
	public ScoreVo selectOne(String serial) {
		ScoreVo vo = new ScoreVo();
		try {
			String sql = "select serial, id, subject, score, "
					+ " date_format(mdate, '%Y-%m-%d') mdate from score where serial = ? ";
			conn = new DBConn("mydb").getConn();
			PreparedStatement ps = conn.prepareStatement(sql);
			ps.setString(1, serial);
			
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				vo.setSerial(rs.getString("serial"));
				vo.setId(rs.getString("id"));
				vo.setMdate(rs.getString("mdate"));
				vo.setSubject(rs.getString("subject"));
				vo.setScore(rs.getString("score"));
			}
		}catch(Exception ex) {
			ex.printStackTrace();
		}
		
		return vo;
	}
	
}
