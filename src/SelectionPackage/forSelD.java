package SelectionPackage;

import javax.swing.*;
import java.sql.*;
import java.util.*;

public class forSelD extends JFrame{
	Vector rowData=new Vector();//行数据
	Vector columnNames=new Vector();//列名
	Statement stmt=null;//创建接口
	String sql=null;
	JTable jt=null;//创建表单
	JScrollPane jsp=null;
	PreparedStatement ps=null;
	ResultSet rs=null;//声明返回结果
	public forSelD(String sql1){
		sql=sql1;
		columnNames.add("专业代码");
		columnNames.add("专业名称");
		try{
			CONN co=new CONN();
			Connection dbConn1=co.CO();//添加数据库连接
			stmt=(Statement)dbConn1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);//可以任意向前后移动游标，ResultSet数据只读
			rs=stmt.executeQuery(sql);//executeQuery()方法会把数据库响应的查询结果存放在ResultSet类对象中
			while(rs.next()){
				Vector hang=new Vector();
				hang.add(rs.getString("dno"));System.out.print(rs.getString("dno"));
				hang.add(rs.getString("dn"));System.out.print(rs.getString("dn"));
				rowData.add(hang);
			}
			jt=new JTable(rowData,columnNames);
			jsp=new JScrollPane(jt);
			this.add(jsp);
			this.setSize(800,600);
			this.setVisible(true);
		}catch(SQLException e){
			System.out.print("SQL Exception occur.Message is:"+e.getMessage());
		}
	}
}