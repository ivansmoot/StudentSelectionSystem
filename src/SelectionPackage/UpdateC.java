package SelectionPackage;

import java.awt.*;

import javax.swing.*;

import java.sql.*;
import java.awt.event.*;

public class UpdateC extends JPanel implements ActionListener{
	JTextField Cno=new JTextField(20);//�γ̺�
	JTextField Cn=new JTextField(20);//�γ���
	JTextField Cs=new JTextField(20);//ѧ��
	JTextField Cp=new JTextField(20);//ѧʱ
	JTextField Cc=new JTextField(20);//רҵ����
	JTextField Dno=new JTextField(20);//רҵ����
	JButton jb=new JButton("�޸�");//ɾ����ť
	
	//�������
		public UpdateC(){
			try{
				UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());//�����������Ϊ����ϵͳƽ̨���
			}catch(Exception e){
				System.out.println("�޷�������ۣ�"+e);
			}

			jb.addActionListener(this); //Ϊ��ť�����¼�
			
			//�������Ͱ�ť����BOX�������
			Box box1=Box.createHorizontalBox();
			Box box2=Box.createHorizontalBox(); 
			Box box3=Box.createHorizontalBox();
			Box box4=Box.createHorizontalBox();
			Box box5=Box.createHorizontalBox();
			Box box6=Box.createHorizontalBox();
			Box box7=Box.createHorizontalBox();
			
			
			box1.add(new JLabel("�γ̺�",JLabel.CENTER));
			box1.add(Cno);
			box2.add(new JLabel("�µĿγ���",JLabel.CENTER));
			box2.add(Cn);
			box3.add(new JLabel("�µ�ѧ��",JLabel.CENTER));
			box3.add(Cs);
			box4.add(new JLabel("�µ�ѧʱ",JLabel.CENTER));
			box4.add(Cp);
			box5.add(new JLabel("�µ�����",JLabel.CENTER));
			box5.add(Cc);
			box6.add(new JLabel("�µ�רҵ����",JLabel.CENTER));
			box6.add(Dno);
			box7.add(jb);
					
			Box boxH=Box.createVerticalBox();
			boxH.add(box1);
			boxH.add(box2);
			boxH.add(box3);
			boxH.add(box4);
			boxH.add(box5);
			boxH.add(box6);
			boxH.add(box7);
			boxH.add(Box.createVerticalGlue());
					
			BackgroundPanelUpdateC jp;//�������
			jp=new BackgroundPanelUpdateC((new ImageIcon("C:\\Users\\11862\\Pictures\\ZM\\�Ŀ�.png")).getImage());
			jp.add(boxH);
			setLayout(new BorderLayout()); //�߿򲼾�
			add(jp,BorderLayout.CENTER);
			validate();
		}
		
		//�����¼�ִ��
		public void actionPerformed(ActionEvent c){
			Object obj=c.getSource();
			if(obj==jb){
				if(Cno.getText().equals("")){ //�γ̺ſ���Ϊ��ֵ
					JOptionPane.showMessageDialog(this,"�γ̺Ų���Ϊ��");
				}
				else{
					if(Cn.getText().equals("")&&Cs.getText().equals("")&&Cp.getText().equals("")&&Cc.getText().equals("")&&Dno.getText().equals("")){ //������ȫ��Ϊ��ֵ
						JOptionPane.showMessageDialog(this,"��������дһ���޸���");
					}
					else{
						Statement stmt=null;//�����ӿ�
						ResultSet rs=null; //�������ؽ��
						String sql,sql1,sql2,sql3,sql4,sql5;
						sql="select * from C where cno='"+Cno.getText()+"'";
						try{
							CONN co=new CONN();
							Connection dbConn1=co.CO();//������ݿ�����
							stmt=(Statement)dbConn1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
									ResultSet.CONCUR_READ_ONLY);//����������ǰ���ƶ��α꣬ResultSet����ֻ��
							rs=stmt.executeQuery(sql);//executeQuery()����������ݿ���Ӧ�Ĳ�ѯ��������ResultSet�������
							if(!rs.next()){
								JOptionPane.showMessageDialog(this,"�γ̲�����");
							}
							else{
								if((!Cn.getText().equals(""))&&Cs.getText().equals("")&&Cp.getText().equals("")&&Cc.getText().equals("")&&Dno.getText().equals("")){
									sql1="update C set Cn='"+Cn.getText()+"' where cno='"+Cno.getText()+"'";
									stmt.executeUpdate(sql1);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									JOptionPane.showMessageDialog(this, "�γ��޸ĳɹ�");
								}
								else if(Cn.getText().equals("")&&(!Cs.getText().equals(""))&&Cp.getText().equals("")&&Cc.getText().equals("")&&Dno.getText().equals("")){
									sql1="update C set Cs='"+Cs.getText()+"' where Cno='"+Cno.getText()+"'";
									stmt.executeUpdate(sql1);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									JOptionPane.showMessageDialog(this, "�γ��޸ĳɹ�");
								}
								else if(Cn.getText().equals("")&&Cs.getText().equals("")&&(!Cp.getText().equals(""))&&Cc.getText().equals("")&&Dno.getText().equals("")){
									sql1="update C set cp='"+Cp.getText()+"' where Cno='"+Cno.getText()+"'";
									stmt.executeUpdate(sql1);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									JOptionPane.showMessageDialog(this, "�γ��޸ĳɹ�");
								}
								else if(Cn.getText().equals("")&&Cs.getText().equals("")&&Cp.getText().equals("")&&!Cc.getText().equals("")&&(Dno.getText().equals(""))){
									sql1="update C set cc='"+Cc.getText()+"' where Cno='"+Cno.getText()+"'";
									stmt.executeUpdate(sql1);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									JOptionPane.showMessageDialog(this, "�γ��޸ĳɹ�");
								}
								else if(Cn.getText().equals("")&&Cs.getText().equals("")&&Cp.getText().equals("")&&Cc.getText().equals("")&&(!Dno.getText().equals(""))){
									sql1="update C set dno='"+Dno.getText()+"' where Cno='"+Cno.getText()+"'";
									stmt.executeUpdate(sql1);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									JOptionPane.showMessageDialog(this, "�γ��޸ĳɹ�");
								}
								else if((!Cn.getText().equals(""))&&(!Cs.getText().equals(""))&&Cp.getText().equals("")&&Cc.getText().equals("")&&Dno.getText().equals("")){
									sql1="update C set Cn='"+Cn.getText()+"' where cno='"+Cno.getText()+"'";
									sql2="update C set Cs='"+Cs.getText()+"' where cno='"+Cno.getText()+"'";
									stmt.executeUpdate(sql1);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									stmt.executeUpdate(sql2);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									JOptionPane.showMessageDialog(this, "�γ��޸ĳɹ�");
								}
								else if((!Cn.getText().equals(""))&&Cs.getText().equals("")&&!Cp.getText().equals("")&&Cc.getText().equals("")&&(Dno.getText().equals(""))){
									sql1="update C set Cn='"+Cn.getText()+"' where cno='"+Cno.getText()+"'";
									sql2="update C set cp='"+Cp.getText()+"' where cno='"+Cno.getText()+"'";
									stmt.executeUpdate(sql1);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									stmt.executeUpdate(sql2);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									JOptionPane.showMessageDialog(this, "�γ��޸ĳɹ�");
								}
								else if((!Cn.getText().equals(""))&&Cs.getText().equals("")&&Cp.getText().equals("")&&!Cc.getText().equals("")&&(Dno.getText().equals(""))){
									sql1="update C set Cn='"+Cn.getText()+"' where cno='"+Cno.getText()+"'";
									sql2="update C set cc='"+Cc.getText()+"' where cno='"+Cno.getText()+"'";
									stmt.executeUpdate(sql1);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									stmt.executeUpdate(sql2);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									JOptionPane.showMessageDialog(this, "�γ��޸ĳɹ�");
								}
								else if((!Cn.getText().equals(""))&&Cs.getText().equals("")&&(Cp.getText().equals(""))&&Cc.getText().equals("")&&!Dno.getText().equals("")){
									sql1="update C set cn='"+Cn.getText()+"' where cno='"+Cno.getText()+"'";
									sql2="update C set dno='"+Dno.getText()+"' where cno='"+Cno.getText()+"'";
									stmt.executeUpdate(sql1);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									stmt.executeUpdate(sql2);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									JOptionPane.showMessageDialog(this, "�γ��޸ĳɹ�");
								}
								else if((Cn.getText().equals(""))&&!Cs.getText().equals("")&&!Cp.getText().equals("")&&Cc.getText().equals("")&&(Dno.getText().equals(""))){
									sql1="update C set Cs='"+Cs.getText()+"' where cno='"+Cno.getText()+"'";
									sql2="update C set cp='"+Cp.getText()+"' where cno='"+Cno.getText()+"'";
									stmt.executeUpdate(sql1);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									stmt.executeUpdate(sql2);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									JOptionPane.showMessageDialog(this, "�γ��޸ĳɹ�");
								}
								
								else if(Cn.getText().equals("")&&(!Cs.getText().equals(""))&&(Cp.getText().equals(""))&&!Cc.getText().equals("")&&Dno.getText().equals("")){
									sql1="update C set cs='"+Cs.getText()+"' where cno='"+Cno.getText()+"'";
									sql2="update C set cc='"+Cc.getText()+"' where cno='"+Cno.getText()+"'";
									stmt.executeUpdate(sql1);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									stmt.executeUpdate(sql2);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									JOptionPane.showMessageDialog(this, "�γ��޸ĳɹ�");
								}
								else if(Cn.getText().equals("")&&(!Cs.getText().equals(""))&&Cp.getText().equals("")&&Cc.getText().equals("")&&(!Dno.getText().equals(""))){
									sql1="update C set cs='"+Cs.getText()+"' where cno='"+Cno.getText()+"'";
									sql2="update C set dno='"+Dno.getText()+"' where cno='"+Cno.getText()+"'";
									stmt.executeUpdate(sql1);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									stmt.executeUpdate(sql2);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									JOptionPane.showMessageDialog(this, "�γ��޸ĳɹ�");
								}
								else if(Cn.getText().equals("")&&Cs.getText().equals("")&&(!Cp.getText().equals(""))&&!Cc.getText().equals("")&&(Dno.getText().equals(""))){
									sql1="update C set cp='"+Cp.getText()+"' where cno='"+Cno.getText()+"'";
									sql2="update C set cc='"+Cc.getText()+"' where cno='"+Cno.getText()+"'";
									stmt.executeUpdate(sql1);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									stmt.executeUpdate(sql2);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									JOptionPane.showMessageDialog(this, "�γ��޸ĳɹ�");
								}
								else if(Cn.getText().equals("")&&Cs.getText().equals("")&&(!Cp.getText().equals(""))&&Cc.getText().equals("")&&(!Dno.getText().equals(""))){
									sql1="update C set cp='"+Cp.getText()+"' where cno='"+Cno.getText()+"'";
									sql2="update C set dno='"+Dno.getText()+"' where Cno='"+Cno.getText()+"'";
									stmt.executeUpdate(sql1);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									stmt.executeUpdate(sql2);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									JOptionPane.showMessageDialog(this, "�γ��޸ĳɹ�");
								}
								else if(Cn.getText().equals("")&&Cs.getText().equals("")&&(Cp.getText().equals(""))&&!Cc.getText().equals("")&&(!Dno.getText().equals(""))){
									sql1="update C set cc='"+Cc.getText()+"' where Cno='"+Cno.getText()+"'";
									sql2="update C set dno='"+Dno.getText()+"' where Cno='"+Cno.getText()+"'";
									stmt.executeUpdate(sql1);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									stmt.executeUpdate(sql2);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									JOptionPane.showMessageDialog(this, "�γ��޸ĳɹ�");
								}
								else if(!Cn.getText().equals("")&&!Cs.getText().equals("")&&(!Cp.getText().equals(""))&&Cc.getText().equals("")&&Dno.getText().equals("")){
									sql1="update C set cn='"+Cn.getText()+"' where Cno='"+Cno.getText()+"'";
									sql2="update C set cs='"+Cs.getText()+"' where Cno='"+Cno.getText()+"'";
									sql3="update C set cp='"+Cp.getText()+"' where Cno='"+Cno.getText()+"'";
									stmt.executeUpdate(sql1);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									stmt.executeUpdate(sql2);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									stmt.executeUpdate(sql3);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									JOptionPane.showMessageDialog(this, "�γ��޸ĳɹ�");
								}
								else if((!Cn.getText().equals(""))&&(!Cs.getText().equals(""))&&Cp.getText().equals("")&&!Cc.getText().equals("")&&(Dno.getText().equals(""))){
									sql1="update C set cn='"+Cn.getText()+"' where cno='"+Cno.getText()+"'";
									sql2="update C set cs='"+Cs.getText()+"' where cno='"+Cno.getText()+"'";
									sql3="update C set cc='"+Cc.getText()+"' where cno='"+Cno.getText()+"'";
									stmt.executeUpdate(sql1);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									stmt.executeUpdate(sql2);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									stmt.executeUpdate(sql3);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									JOptionPane.showMessageDialog(this, "�γ��޸ĳɹ�");
								}
								else if((!Cn.getText().equals(""))&&(!Cs.getText().equals(""))&&Cp.getText().equals("")&&Cc.getText().equals("")&&(!Dno.getText().equals(""))){
									sql1="update C set cn='"+Cn.getText()+"' where cno='"+Cno.getText()+"'";
									sql2="update C set cs='"+Cs.getText()+"' where cno='"+Cno.getText()+"'";
									sql3="update C set dno='"+Dno.getText()+"' where cno='"+Cno.getText()+"'";
									stmt.executeUpdate(sql1);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									stmt.executeUpdate(sql2);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									stmt.executeUpdate(sql3);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									JOptionPane.showMessageDialog(this, "�γ��޸ĳɹ�");
								}
								else if((!Cn.getText().equals(""))&&(Cs.getText().equals(""))&&!Cp.getText().equals("")&&!Cc.getText().equals("")&&(Dno.getText().equals(""))){
									sql1="update C set cn='"+Cn.getText()+"' where cno='"+Cno.getText()+"'";
									sql2="update C set cp='"+Cp.getText()+"' where cno='"+Cno.getText()+"'";
									sql3="update C set cc='"+Cc.getText()+"' where cno='"+Cno.getText()+"'";
									stmt.executeUpdate(sql1);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									stmt.executeUpdate(sql2);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									stmt.executeUpdate(sql3);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									JOptionPane.showMessageDialog(this, "�γ��޸ĳɹ�");
								}
								else if((!Cn.getText().equals(""))&&(Cs.getText().equals(""))&&!Cp.getText().equals("")&&Cc.getText().equals("")&&(!Dno.getText().equals(""))){
									sql1="update C set cn='"+Cn.getText()+"' where cno='"+Cno.getText()+"'";
									sql2="update C set cp='"+Cp.getText()+"' where cno='"+Cno.getText()+"'";
									sql3="update C set dno='"+Dno.getText()+"' where cno='"+Cno.getText()+"'";
									stmt.executeUpdate(sql1);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									stmt.executeUpdate(sql2);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									stmt.executeUpdate(sql3);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									JOptionPane.showMessageDialog(this, "�γ��޸ĳɹ�");
								}
								else if((!Cn.getText().equals(""))&&(Cs.getText().equals(""))&&Cp.getText().equals("")&&!Cc.getText().equals("")&&(!Dno.getText().equals(""))){
									sql1="update C set cn='"+Cn.getText()+"' where cno='"+Cno.getText()+"'";
									sql2="update C set cc='"+Cc.getText()+"' where cno='"+Cno.getText()+"'";
									sql3="update C set dno='"+Dno.getText()+"' where cno='"+Cno.getText()+"'";
									stmt.executeUpdate(sql1);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									stmt.executeUpdate(sql2);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									stmt.executeUpdate(sql3);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									JOptionPane.showMessageDialog(this, "�γ��޸ĳɹ�");
								}
								else if((!Cn.getText().equals(""))&&(!Cs.getText().equals(""))&&!Cp.getText().equals("")&&!Cc.getText().equals("")&&(Dno.getText().equals(""))){
									sql1="update C set cn='"+Cn.getText()+"' where cno='"+Cno.getText()+"'";
									sql2="update C set cs='"+Cs.getText()+"' where cno='"+Cno.getText()+"'";
									sql3="update C set cp='"+Cp.getText()+"' where cno='"+Cno.getText()+"'";
									sql4="update C set cc='"+Cc.getText()+"' where cno='"+Cno.getText()+"'";
									stmt.executeUpdate(sql1);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									stmt.executeUpdate(sql2);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									stmt.executeUpdate(sql3);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									stmt.executeUpdate(sql4);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									JOptionPane.showMessageDialog(this, "�γ��޸ĳɹ�");
								}
								else if((!Cn.getText().equals(""))&&(!Cs.getText().equals(""))&&Cp.getText().equals("")&&!Cc.getText().equals("")&&(!Dno.getText().equals(""))){
									sql1="update C set cn='"+Cn.getText()+"' where cno='"+Cno.getText()+"'";
									sql2="update C set cs='"+Cs.getText()+"' where cno='"+Cno.getText()+"'";
									sql3="update C set cc='"+Cc.getText()+"' where cno='"+Cno.getText()+"'";
									sql4="update C set dno='"+Dno.getText()+"' where cno='"+Cno.getText()+"'";
									stmt.executeUpdate(sql1);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									stmt.executeUpdate(sql2);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									stmt.executeUpdate(sql3);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									stmt.executeUpdate(sql4);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									JOptionPane.showMessageDialog(this, "�γ��޸ĳɹ�");
								}
								else if((!Cn.getText().equals(""))&&(!Cs.getText().equals(""))&&!Cp.getText().equals("")&&Cc.getText().equals("")&&(!Dno.getText().equals(""))){
									sql1="update C set cn='"+Cn.getText()+"' where cno='"+Cno.getText()+"'";
									sql2="update C set cs='"+Cs.getText()+"' where cno='"+Cno.getText()+"'";
									sql3="update C set cp='"+Cp.getText()+"' where cno='"+Cno.getText()+"'";
									sql4="update C set dno='"+Dno.getText()+"' where cno='"+Cno.getText()+"'";
									stmt.executeUpdate(sql1);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									stmt.executeUpdate(sql2);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									stmt.executeUpdate(sql3);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									stmt.executeUpdate(sql4);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									JOptionPane.showMessageDialog(this, "�γ��޸ĳɹ�");
								}
								else if((!Cn.getText().equals(""))&&(Cs.getText().equals(""))&&!Cp.getText().equals("")&&!Cc.getText().equals("")&&(!Dno.getText().equals(""))){
									sql1="update C set cn='"+Cn.getText()+"' where cno='"+Cno.getText()+"'";
									sql2="update C set cp='"+Cp.getText()+"' where cno='"+Cno.getText()+"'";
									sql3="update C set cc='"+Cc.getText()+"' where cno='"+Cno.getText()+"'";
									sql4="update C set dno='"+Dno.getText()+"' where cno='"+Cno.getText()+"'";
									stmt.executeUpdate(sql1);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									stmt.executeUpdate(sql2);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									stmt.executeUpdate(sql3);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									stmt.executeUpdate(sql4);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									JOptionPane.showMessageDialog(this, "�γ��޸ĳɹ�");
								}
								else if((!Cn.getText().equals(""))&&(!Cs.getText().equals(""))&&!Cp.getText().equals("")&&!Cc.getText().equals("")&&(!Dno.getText().equals(""))){
									sql1="update C set cn='"+Cn.getText()+"' where cno='"+Cno.getText()+"'";
									sql2="update C set cp='"+Cp.getText()+"' where cno='"+Cno.getText()+"'";
									sql3="update C set cs='"+Cs.getText()+"' where cno='"+Cno.getText()+"'";
									sql4="update C set cc='"+Cc.getText()+"' where cno='"+Cno.getText()+"'";
									sql5="update C set dno='"+Dno.getText()+"' where cno='"+Cno.getText()+"'";
									stmt.executeUpdate(sql1);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									stmt.executeUpdate(sql2);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									stmt.executeUpdate(sql3);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									stmt.executeUpdate(sql4);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									JOptionPane.showMessageDialog(this, "�γ��޸ĳɹ�");
								}
							}
							rs.close();
							stmt.close();
						}catch(SQLException e){
							System.out.print("SQL?Exception?occur.Message?is:"+e.getMessage());
						}
					}
				}
			}
		}
}

class BackgroundPanelUpdateC extends JPanel  
{  
    Image im;  
    public BackgroundPanelUpdateC(Image im)  
    {  
        this.im=im;  
        this.setOpaque(true);                    //���ÿؼ���͸��,����false,��ô����͸��
    }  
    //Draw the background again,�̳���Jpanle,��Swing�ؼ���Ҫ�̳�ʵ�ֵķ���,������AWT�е�Paint()
    public void paintComponent(Graphics g)       //��ͼ��,����ɼ�������Java �� java-Graphics 
    {  
        super.paintComponents(g);  
        g.drawImage(im,0,0,this.getWidth(),this.getHeight(),this);  //����ָ��ͼ���е�ǰ���õ�ͼ��ͼ������Ͻ�λ�ڸ�ͼ������������ռ�� (x, y)��ͼ���е�͸�����ز�Ӱ��ô��Ѵ��ڵ�����

    }  
}