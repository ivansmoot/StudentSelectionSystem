package SelectionPackage;

import java.sql.Connection;
import java.sql.DriverManager;

public class CONN{
	public static Connection CO(){
		String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";//����JDBC����
		String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=StudentSelectionSystem";//���ӷ�����
		String userName="sa";//�û���
		String userPassword="miss1186285865";//����
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