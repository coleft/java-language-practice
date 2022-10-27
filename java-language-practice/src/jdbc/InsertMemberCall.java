package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;

public class InsertMemberCall {
	public InsertMemberCall() {
		Connection conn = new DBConn("mydb").getConn();		
		try {
			conn.setAutoCommit(false);
			String sql = "{call InsertMember(?,?,?,?,?)}";
			CallableStatement cstmt = conn.prepareCall(sql);
			cstmt.setString(1, "a001231234");
			cstmt.setString(2, "Kang");
			cstmt.setString(3, "m");
			cstmt.setString(4, "0109");
			cstmt.setString(5, "pics");
			//cstmt.registerOutParameter(6, java.sql.JDBCType.INTEGER);
			
			cstmt.executeQuery();
			cstmt.close();
			conn.close();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		new InsertMemberCall();
	}
}
