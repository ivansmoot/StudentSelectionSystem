package SelectionPackage;

import javax.swing.*;
import java.sql.*;
import java.util.*;

public class forTSelSC extends JFrame{
	Vector rowData=new Vector();//行数据
	Vector columnNames=new Vector();//列名
	Statement stmt=null;//创建接口
	String sql=null;
	JTable jt=null;//创建表单
	JScrollPane jsp=null;
	PreparedStatement ps=null;
	ResultSet rs=null;//声明返回结果
	public forTSelSC(String sql1){
		sql=sql1;
		columnNames.add("专业");
		columnNames.add("课程");
		columnNames.add("姓名");
		columnNames.add("学分");
		columnNames.add("分数");
		columnNames.add("学年");
		columnNames.add("学期");
		try{
			CONN co=new CONN();
			Connection dbConn1=co.CO();//添加数据库连接
			stmt=(Statement)dbConn1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);//可以任意向前后移动游标，ResultSet数据只读
			rs=stmt.executeQuery(sql);//executeQuery()方法会把数据库响应的查询结果存放在ResultSet类对象中
			while(rs.next()){
				Vector hang=new Vector();
				hang.add(rs.getString("专业名"));System.out.print(rs.getString("专业名"));
				hang.add(rs.getString("课程名"));System.out.print(rs.getString("课程名"));
				hang.add(rs.getString("姓名"));System.out.print(rs.getString("姓名"));
				hang.add(rs.getString("学分"));System.out.print(rs.getString("学分"));
				hang.add(rs.getString("分数"));System.out.print(rs.getString("分数"));
				hang.add(rs.getString("学年"));System.out.print(rs.getString("学年"));
				hang.add(rs.getString("学期"));System.out.print(rs.getString("学期"));
				rowData.add(hang);
			}
			jt=new JTable(rowData,columnNames);
			jsp=new JScrollPane(jt);
			this.add(jsp);
			this.setSize(800,600);
			this.setVisible(true);
		}catch(SQLException e){
			System.out.print("SQL?Exception?occur.Message?is:"+e.getMessage());
		}
	}
}