package jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;

public class GetEmailCall {
	public GetEmailCall() {
		Connection conn = new DBConn().getConn();
		
		try {
			conn.setAutoCommit(false);
			String sql = "{call GetEmail(?,?,?)};";
			CallableStatement cstmt = conn.prepareCall(sql);
			cstmt.setString(1, "Jones");
			cstmt.setString(2, "Barry");
			cstmt.registerOutParameter(3, java.sql.JDBCType.VARCHAR);
			
			cstmt.executeQuery();
			String e = cstmt.getString(3);
			System.out.println(e);
			
			cstmt.close();
			conn.close();
			
		}catch(Exception ex) {
			ex.printStackTrace();
		}
	}
	public static void main(String[] args) {
		new GetEmailCall();
	}
}
