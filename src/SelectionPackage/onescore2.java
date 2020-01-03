package SelectionPackage;
import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.sql.*;
import java.util.*;

public class onescore2 extends JFrame{
	Vector rowData=new Vector();//行数据
	Vector<String> columnNames=new Vector();//列名
	Statement stmt=null;//创建接口
	String sql=null;
	JTable table=null;//创建表单
	JScrollPane jsp=null;
	PreparedStatement ps=null;
	ResultSet rs=null;//声明返回结果
	public onescore2(String sql1){
		JScrollPane jsp;
		sql=sql1;
		columnNames.add("课程号");
		columnNames.add("课程名");
		columnNames.add("学分");
		columnNames.add("成绩");
		try{
			CONN co=new CONN();
			Connection dbConn1=co.CO();//添加数据库连接
			stmt=(Statement)dbConn1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);//可以任意向前后移动游标，ResultSet数据只读
			rs=stmt.executeQuery(sql);//executeQuery()方法会把数据库响应的查询结果存放在ResultSet类对象中
			while(rs.next()){
				Vector<String> hang=new Vector();
				hang.add(rs.getString("cno"));System.out.print(rs.getString("cno"));
				hang.add(rs.getString("cn"));System.out.print(rs.getString("cn"));
				hang.add(rs.getString("cs"));System.out.print(rs.getString("cs"));
				hang.add(rs.getString("score"));System.out.print(rs.getString("score"));
				rowData.add(hang);
			}
			table=new JTable(rowData,columnNames);
			table.setForeground(Color.BLACK);                   // 字体颜色
	        table.setFont(new Font(null, Font.PLAIN, 14));      // 字体样式
	        table.setSelectionForeground(Color.DARK_GRAY);      // 选中后字体颜色
	        table.setSelectionBackground(Color.LIGHT_GRAY);     // 选中后字体背景
	        table.setGridColor(Color.GRAY);                     // 网格颜色

	        // 设置表头
	        table.getTableHeader().setFont(new Font(null, Font.BOLD, 14));  // 设置表头名称字体样式
	        table.getTableHeader().setForeground(Color.RED);                // 设置表头名称字体颜色
	        table.getTableHeader().setResizingAllowed(false);               // 设置不允许手动改变列宽
	        table.getTableHeader().setReorderingAllowed(false);             // 设置不允许拖动重新排序各列

	        // 设置行高
	        table.setRowHeight(30);

	        // 第一列列宽设置为40
	        table.getColumnModel().getColumn(0).setPreferredWidth(40);

	        // 设置滚动面板视口大小（超过该大小的行数据，需要拖动滚动条才能看到）
	        table.setPreferredScrollableViewportSize(new Dimension(400, 300));
			jsp=new JScrollPane(table);
			this.add(jsp);
			//add(jsp,BorderLayout.SOUTH);
			this.setSize(800,600);
			this.setVisible(true);
		}catch(SQLException e){
			System.out.print("SQL Exception occur.Message is:"+e.getMessage());
		}
	}
	
}
