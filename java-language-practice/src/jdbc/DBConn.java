package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConn {
	String driver = "com.mysql.cj.jdbc.Driver";	//드라이버명 상수
	String path = "jdbc:mysql://localhost:3306/classicmodels"
				 +"?useUnicode=true&characterEncoding=utf8";	//3306으로 정해져있다.
	String user = "hong";
	String pwd = "1111";
	Connection conn;
	
	//getConn만
	public Connection getConn() {	//가장 중요한 연결고리
		return conn;
	}

	public DBConn() {
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(path, user, pwd);
			System.out.println("connection ok~");
		} catch (Exception e) {	//통일을 시키지 않으면 catch 문을 한 번 더 써야 하는 수가 있다.
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		DBConn dbcon = new DBConn();
	}
}
