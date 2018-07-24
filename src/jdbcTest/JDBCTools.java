package jdbcTest;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/*
 * update	澧炪�鍒犮�鏀�
 * find		鏌ヨ
 * batch	鎵归噺
 * transaction	浜嬪姟
 * 
 * */
public class JDBCTools {
	
	private Connection conn = null;
	private Statement stmt = null;
	private ResultSet rs = null;
	
	private void connect(String ip,String port,String database,String user,String pwd) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://"+ip+":"+port+"/"+database, user, pwd);
			stmt = conn.createStatement();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void close() {
		try {
			if (rs != null) {
				rs.close();
			}
			if (stmt != null) {
				stmt.close();
			} 
			if (conn != null) {
				conn.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public ArrayList<Map<String, String>> find(String sql,String ip,String port,String dataBase,String user,String pwd) {
		ArrayList<Map<String, String>> rsList = new ArrayList<Map<String, String>>();
		try {
			connect(ip,port,dataBase,user,pwd);
			rs = stmt.executeQuery(sql);
			ResultSetMetaData rsmd = rs.getMetaData();
			while (rs.next()) {
				Map<String, String> rsMap = new HashMap<String, String>();
				for (int i = 1; i <= rsmd.getColumnCount(); i++) {
					rsMap.put(rsmd.getColumnName(i), rs.getString(rsmd.getColumnName(i)));
				}
				rsList.add(rsMap);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			close();
		}
		return rsList;
	}
	
	public String look() {
		String dog = "lili";
		return dog;
	}
	
}















