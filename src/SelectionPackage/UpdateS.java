package SelectionPackage;

import java.awt.*;

import javax.swing.*;

import java.sql.*;
import java.awt.event.*;

public class UpdateS extends JPanel implements ActionListener{
	JTextField Sno=new JTextField(20);//ѧ��
	JTextField Sn=new JTextField(20);//����
	JTextField Ssex=new JTextField(20);//�Ա�
	JTextField Sy=new JTextField(20);//��ѧ��
	JTextField Sp=new JTextField(20);//����
	JTextField Dno=new JTextField(20);//רҵ����
	JButton jb=new JButton("�޸�");//�޸İ�ť 
	
	//�������
		public UpdateS(){
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
		;
					
			box1.add(new JLabel("ѧ��",JLabel.CENTER));
			box1.add(Sno);
			box2.add(new JLabel("�µ�����",JLabel.CENTER));
			box2.add(Sn);
			box3.add(new JLabel("�µ�����",JLabel.CENTER));
			box3.add(Sp);;
			box4.add(new JLabel("�µ�רҵ����",JLabel.CENTER));
			box4.add(Dno);
			box5.add(jb);
					
			Box boxH=Box.createVerticalBox();
			boxH.add(box1);
			boxH.add(box2);
			boxH.add(box3); 
			boxH.add(box4);
			boxH.add(box5);
			boxH.add(Box.createVerticalGlue());
					
			BackgroundPanelUpdateS jp;//�������
			jp=new BackgroundPanelUpdateS((new ImageIcon("C:\\Users\\11862\\Pictures\\ZM\\��ѧ��.png")).getImage());
			jp.add(boxH);
			setLayout(new BorderLayout()); //�߿򲼾�
			add(jp,BorderLayout.CENTER);
			validate();
		}
		
		//�����¼�ִ��
		public void actionPerformed(ActionEvent c){
			Object obj=c.getSource();
			if(obj==jb){
				if(Sno.getText().equals("")){ //ѧ���ſ���Ϊ��ֵ
					JOptionPane.showMessageDialog(this,"ѧ����Ϊ��");
				}
				else{
					if(Sn.getText().equals("")&&Ssex.getText().equals("")&&Sy.getText().equals("")&&Sp.getText().equals("")&&Dno.getText().equals("")){ //������ȫ��Ϊ��ֵ
						JOptionPane.showMessageDialog(this,"��������дһ���޸���");
					}
					else{
						Statement stmt=null;//�����ӿ�
						ResultSet rs=null; //�������ؽ��
						String sql,sql1,sql2,sql3,sql4;
						sql="select * from S where sno='"+Sno.getText()+"'";
						try{
							CONN co=new CONN();
							Connection dbConn1=co.CO();//������ݿ�����
							stmt=(Statement)dbConn1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
									ResultSet.CONCUR_READ_ONLY);//����������ǰ���ƶ��α꣬ResultSet����ֻ��
							rs=stmt.executeQuery(sql);//executeQuery()����������ݿ���Ӧ�Ĳ�ѯ��������ResultSet�������
							if(!rs.next()){
								JOptionPane.showMessageDialog(this,"ѧ��������");
							}
							else{
								if((!Sn.getText().equals(""))&&Sp.getText().equals("")&&Dno.getText().equals("")){
									sql1="update S set sn='"+Sn.getText()+"' where sno='"+Sno.getText()+"'";
									stmt.executeUpdate(sql1);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									JOptionPane.showMessageDialog(this, "ѧ�������޸ĳɹ�");
								}
								else if(Sn.getText().equals("")&&(!Sp.getText().equals(""))&&Dno.getText().equals("")){
									sql1="update S set sp='"+Sp.getText()+"' where sno='"+Sno.getText()+"'";
									stmt.executeUpdate(sql1);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									JOptionPane.showMessageDialog(this, "ѧ�������޸ĳɹ�");
								}
								else if(Sn.getText().equals("")&&(Sp.getText().equals(""))&&!Dno.getText().equals("")){
									sql1="update S set dno='"+Dno.getText()+"' where sno='"+Sno.getText()+"'";
									stmt.executeUpdate(sql1);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									JOptionPane.showMessageDialog(this, "ѧ��רҵ�޸ĳɹ�");
								}
								else if((!Sn.getText().equals(""))&&(!Sp.getText().equals(""))&&Dno.getText().equals("")){
									sql1="update S set sn='"+Sn.getText()+"' where sno='"+Sno.getText()+"'";
									sql2="update S set sp='"+Sp.getText()+"' where sno='"+Sno.getText()+"'";
									stmt.executeUpdate(sql1);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									stmt.executeUpdate(sql2);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									JOptionPane.showMessageDialog(this, "ѧ�������������޸ĳɹ�");
								}
								else if((!Sn.getText().equals(""))&&Sp.getText().equals("")&&!Dno.getText().equals("")){
									sql1="update S set sn='"+Sn.getText()+"' where sno='"+Sno.getText()+"'";
									sql2="update S set dno='"+Dno.getText()+"' where sno='"+Sno.getText()+"'";
									stmt.executeUpdate(sql1);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									stmt.executeUpdate(sql2);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									JOptionPane.showMessageDialog(this, "ѧ��������רҵ�޸ĳɹ�");
								}
								else if((Sn.getText().equals(""))&&!Sp.getText().equals("")&&!Dno.getText().equals("")){
									sql1="update S set sp='"+Sp.getText()+"' where sno='"+Sno.getText()+"'";
									sql2="update S set dno='"+Dno.getText()+"' where sno='"+Sno.getText()+"'";
									stmt.executeUpdate(sql1);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									stmt.executeUpdate(sql2);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									JOptionPane.showMessageDialog(this, "ѧ�����룬רҵ�޸ĳɹ�");
								}
								else if((!Sn.getText().equals(""))&&!Sp.getText().equals("")&&!Dno.getText().equals("")){
									sql1="update S set sn='"+Sn.getText()+"' where sno='"+Sno.getText()+"'";
									sql2="update S set sp='"+Sp.getText()+"' where sno='"+Sno.getText()+"'";
									sql3="update S set dno='"+Dno.getText()+"' where sno='"+Sno.getText()+"'";
									stmt.executeUpdate(sql1);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									stmt.executeUpdate(sql2);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									stmt.executeUpdate(sql3);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
									JOptionPane.showMessageDialog(this, "ѧ�����������룬רҵ�޸ĳɹ�");
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

class BackgroundPanelUpdateS extends JPanel  
{  
    Image im;  
    public BackgroundPanelUpdateS(Image im)  
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