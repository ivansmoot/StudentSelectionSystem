package SelectionPackage;

import java.sql.Connection;
import java.sql.DriverManager;

public class CONN{
	public static Connection CO(){
		String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";//加载JDBC驱动
		String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=StudentSelectionSystem";//连接服务器
		String userName="sa";//用户名
		String userPassword="miss1186285865";//密码
		Connection dbConn=null;
		try{
			Class.forName(driverName);
			dbConn=DriverManager.getConnection(dbURL,userName,userPassword);
			System.out.println("Connection Successfully");
		}catch(Exception e){
			e.printStackTrace();
		}
		return dbConn;
	}
}