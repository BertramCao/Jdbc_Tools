package jdbcTest;

import java.util.ArrayList;
import java.util.Map;

public class Test {

	public static void main(String[] args) {
		
		JDBCTools JDBCTools = new JDBCTools();
		String sql = "select * from test";
		String ip = "localhost";
		String port = "3306";
		String dataBase = "test";
		String user = "ucc";
		String pwd = "123456789";
		ArrayList<Map<String, String>> rsList = new ArrayList<Map<String, String>>();
		rsList = JDBCTools.find(sql, ip, port, dataBase, user, pwd);
		String dog = JDBCTools.look();
		System.out.println(rsList);
		System.out.println(dog);
	}
}
