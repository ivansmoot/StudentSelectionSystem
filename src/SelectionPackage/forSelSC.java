package SelectionPackage;

import javax.swing.*;
import java.sql.*;
import java.util.*;

public class forSelSC extends JFrame{
	Vector rowData=new Vector();//������
	Vector columnNames=new Vector();//����
	Statement stmt=null;//�����ӿ�
	String sql=null;
	JTable jt=null;//������
	JScrollPane jsp=null;
	PreparedStatement ps=null;
	ResultSet rs=null;//�������ؽ��
	public forSelSC(String sql1){
		sql=sql1;
		columnNames.add("ѧ��");
		columnNames.add("�γ̺�");
		columnNames.add("�ɼ�");
		columnNames.add("ѧ��");
		columnNames.add("ѧ��");
		try{
			CONN co=new CONN();
			Connection dbConn1=co.CO();//������ݿ�����
			stmt=(Statement)dbConn1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);//����������ǰ���ƶ��α꣬ResultSet����ֻ��
			rs=stmt.executeQuery(sql);//executeQuery()����������ݿ���Ӧ�Ĳ�ѯ��������ResultSet�������
			while(rs.next()){
				Vector hang=new Vector();
				hang.add(rs.getString("sno"));System.out.print(rs.getString("sno"));
				hang.add(rs.getString("cno"));System.out.print(rs.getString("cno"));
				hang.add(rs.getString("score"));System.out.print(rs.getString("score"));
				hang.add(rs.getString("sy"));System.out.print(rs.getString("sy"));
				hang.add(rs.getString("term"));System.out.print(rs.getString("term"));
				rowData.add(hang);
			}
			jt=new JTable(rowData,columnNames);
			jsp=new JScrollPane(jt);
			this.add(jsp);
			this.setSize(800,600);
			this.setVisible(true);
		}catch(SQLException e){
			System.out.print("SQL Exception occur.Message is:"+e.getMessage());
		}
	}
}