package SelectionPackage;

import javax.swing.*;
import java.sql.*;
import java.util.*;
public class forStatistics2 extends JFrame{

	Vector rowData=new Vector();//������
	Vector columnNames=new Vector();//����
	Statement stmt=null;//�����ӿ�
	String sql=null;
	JTable jt=null;//������
	JScrollPane jsp=null;
	PreparedStatement ps=null;
	ResultSet rs=null;//�������ؽ��
	public forStatistics2(String sql1){
		sql=sql1;
		columnNames.add("ѧ��");
		columnNames.add("�γ̺�");
		columnNames.add("ѧ������");
		columnNames.add("ƽ����");
		try{
			CONN co=new CONN();
			Connection dbConn1=co.CO();//������ݿ�����
			stmt=(Statement)dbConn1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
					ResultSet.CONCUR_READ_ONLY);//����������ǰ���ƶ��α꣬ResultSet����ֻ��
			rs=stmt.executeQuery(sql);//executeQuery()����������ݿ���Ӧ�Ĳ�ѯ��������ResultSet�������
			while(rs.next()){
				
				Vector hang=new Vector();
				hang.add(rs.getString(1));System.out.print(rs.getString(1));
				hang.add(rs.getString(2));System.out.print(rs.getString(2));
				hang.add(rs.getString(3));System.out.print(rs.getString(3));
				hang.add(rs.getString(4));System.out.print(rs.getString(4));
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