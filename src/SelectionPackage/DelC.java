package SelectionPackage;

import java.awt.*;

import javax.swing.*;

import java.sql.*;
import java.awt.event.*;

public class DelC extends JPanel implements ActionListener{
	JTextField Cno=new JTextField(20);//�γ̺������
	JButton jb=new JButton("ɾ��");//ɾ����ť
	 
	//�������
	public DelC(){
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());//�����������Ϊ����ϵͳƽ̨���
		}catch(Exception e){
			System.out.println("�޷�������ۣ�"+e);
		}

		jb.addActionListener(this); //Ϊ��ť�����¼�
		
		//�������Ͱ�ť����BOX�������
		Box box1=Box.createHorizontalBox();
		Box box2=Box.createHorizontalBox();
				
		box1.add(new JLabel("�γ̺�"));
		box1.add(Cno);
		box2.add(jb);
				
		Box boxH=Box.createVerticalBox();
		boxH.add(box1);
		boxH.add(box2);
		boxH.add(Box.createVerticalGlue());
				
		BackgroundPanelDelC jp;//�������
		jp=new BackgroundPanelDelC((new ImageIcon("C:\\Users\\11862\\Pictures\\ZM\\ɾ��.png")).getImage());
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
			sql="select * from C where cno='"+Cno.getText()+"'";
			sql1="delete from C where cno='"+Cno.getText()+"'";
			try{
				CONN co=new CONN();
				Connection dbConn1=co.CO();//������ݿ�����
				stmt=(Statement)dbConn1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);//����������ǰ���ƶ��α꣬ResultSet����ֻ��
				rs=stmt.executeQuery(sql);//executeQuery()����������ݿ���Ӧ�Ĳ�ѯ��������ResultSet�������
				if(Cno.getText().equals("")){//�γ̺Ų�����Ϊ��ֵ
					JOptionPane.showMessageDialog(this,"�γ̺Ų���Ϊ��");
				}
				else{
					if(!rs.next()){
						JOptionPane.showMessageDialog(this,"�γ̲�����");
					}
					else{
						stmt.executeUpdate(sql1);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
						JOptionPane.showMessageDialog(this, "�γ�ɾ���ɹ�");
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

class BackgroundPanelDelC extends JPanel  
{  
    Image im;  
    public BackgroundPanelDelC(Image im)  
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