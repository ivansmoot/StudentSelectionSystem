package SelectionPackage;

import javax.swing.*;
import java.sql.*;
import java.util.*;

public class forSelC extends JFrame{
	Vector rowData=new Vector();//������
	Vector columnNames=new Vector();//����
	Statement stmt=null;//�����ӿ�
	String sql=null;
	JTable jt=null;//������
	JScrollPane jsp=null;
	PreparedStatement ps=null;
	ResultSet rs=null;//�������ؽ��
	public forSelC(String sql1){
		sql=sql1;
		columnNames.add("�γ̺�");
		columnNames.add("�γ���");
		columnNames.add("ѧ��");
		columnNames.add("ѧʱ");
		columnNames.add("����");
		columnNames.add("רҵ����");
		try{
			CONN co=new CONN();
			Connection dbConn1=co.CO();//������ݿ�����
			stmt=(Statement)dbConn1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);//����������ǰ���ƶ��α꣬ResultSet����ֻ��
			rs=stmt.executeQuery(sql);//executeQuery()����������ݿ���Ӧ�Ĳ�ѯ��������ResultSet�������
			while(rs.next()){
				Vector hang=new Vector();
				hang.add(rs.getString("cno"));System.out.print(rs.getString("cno"));
				hang.add(rs.getString("cn"));System.out.print(rs.getString("cn"));
				hang.add(rs.getString("cs"));System.out.print(rs.getString("cs"));
				hang.add(rs.getString("cp"));System.out.print(rs.getString("cp"));
				hang.add(rs.getString("cc"));System.out.print(rs.getString("cc"));
				hang.add(rs.getString("dno"));System.out.print(rs.getString("dno"));
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