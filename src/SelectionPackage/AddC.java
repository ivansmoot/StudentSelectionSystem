package SelectionPackage;

import java.awt.*;

import javax.swing.*;

import java.sql.*;
import java.awt.event.*;


public class AddC extends JPanel implements ActionListener{
	
	JTextField Cno=new JTextField(20); //�γ̱������
	JTextField cn=new JTextField(20);  //�γ��������
	JTextField cs=new JTextField(20); //ѧ�������
	JTextField cp=new JTextField(20); //ѧʱ
	JTextField cc=new JTextField(20); //����
	JTextField dno=new JTextField(20); //רҵ����
	JButton jb=new JButton("¼��"); //¼�밴ť
	
	//�������
	public AddC(){
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
		
		box1.add(new JLabel("�γ̺�"));
		box1.add(Cno);
		box2.add(new JLabel("�γ���")); 
		box2.add(cn);
		box3.add(new JLabel("ѧ��"));
		box3.add(cs);
		box4.add(new JLabel("ѧʱ"));
		box4.add(cp);
		box5.add(new JLabel("����"));
		box5.add(cc);
		box6.add(new JLabel("רҵ����"));
		box6.add(dno);
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
		
		BackgroundPanelAddC jp;//�������
		jp=new BackgroundPanelAddC((new ImageIcon("C:\\Users\\11862\\Pictures\\ZM\\�ӿ�.png")).getImage());
		jp.add(boxH);
		setLayout(new BorderLayout()); //�߿򲼾�
		add(jp,BorderLayout.CENTER);
		validate();
	}
	
	//�����¼�ִ��
	public void actionPerformed(ActionEvent c){ 
		Object obj=c.getSource();
		if(obj==jb){
			
			Statement stmt=null;//�����ӿ�
			ResultSet rs=null; //�������ؽ��
			String sql,sql1;
			sql="select * from C where dno='"+Cno.getText()+"'";
			sql1="insert into C values('"+Cno.getText()+"','"+cn.getText()+"','"+cs.getText()+"','"+cp.getText()+"','"+cc.getText()+"','"+dno.getText()+"','0')";
			try{
				Connection dbConn1=CONN.CO();//������ݿ�����
				stmt=(Statement)dbConn1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);//����������ǰ���ƶ��α꣬ResultSet����ֻ��
				rs=stmt.executeQuery(sql);//executeQuery()����������ݿ���Ӧ�Ĳ�ѯ��������ResultSet�������
				if(Cno.getText().equals("")){ //ѧ��ѧ�Ų�����Ϊ��ֵ
					JOptionPane.showMessageDialog(this,"�γ̺Ų���Ϊ��");
				}
				else{
					if(cn.getText().equals("")){//ѧ�����벻����Ϊ��ֵ
						JOptionPane.showMessageDialog(this,"�γ�������Ϊ��");
					}
					else{
						if(rs.next()){
							JOptionPane.showMessageDialog(this,"�γ��Ѵ���");
						}
						else{
							stmt.executeUpdate(sql1);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
							JOptionPane.showMessageDialog(this, "�γ���ӳɹ�");
						}
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

class BackgroundPanelAddC extends JPanel  
{  
    Image im;  
    public BackgroundPanelAddC(Image im)  
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