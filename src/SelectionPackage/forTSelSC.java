package SelectionPackage;

import javax.swing.*;
import java.sql.*;
import java.util.*;

public class forTSelSC extends JFrame{
	Vector rowData=new Vector();//������
	Vector columnNames=new Vector();//����
	Statement stmt=null;//�����ӿ�
	String sql=null;
	JTable jt=null;//������
	JScrollPane jsp=null;
	PreparedStatement ps=null;
	ResultSet rs=null;//�������ؽ��
	public forTSelSC(String sql1){
		sql=sql1;
		columnNames.add("רҵ");
		columnNames.add("�γ�");
		columnNames.add("����");
		columnNames.add("ѧ��");
		columnNames.add("����");
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
				hang.add(rs.getString("רҵ��"));System.out.print(rs.getString("רҵ��"));
				hang.add(rs.getString("�γ���"));System.out.print(rs.getString("�γ���"));
				hang.add(rs.getString("����"));System.out.print(rs.getString("����"));
				hang.add(rs.getString("ѧ��"));System.out.print(rs.getString("ѧ��"));
				hang.add(rs.getString("����"));System.out.print(rs.getString("����"));
				hang.add(rs.getString("ѧ��"));System.out.print(rs.getString("ѧ��"));
				hang.add(rs.getString("ѧ��"));System.out.print(rs.getString("ѧ��"));
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