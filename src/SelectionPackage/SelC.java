package SelectionPackage;

import java.awt.*;

import javax.swing.*;

import java.sql.*;
import java.awt.event.*;

public class SelC extends JPanel implements ActionListener{
	JTextField Cno=new JTextField(20);//�γ̺�
	JTextField Cn=new JTextField(20);//�γ���
	JTextField Cs=new JTextField(20);//ѧ��
	JTextField Cp=new JTextField(20);//ѧʱ
	JTextField Cc=new JTextField(20);//����
	JTextField Dno=new JTextField(20);//רҵ����
	JButton jb=new JButton("����");
	
	//�������
	public SelC(){
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
		box2.add(new JLabel("�γ���",JLabel.CENTER));
		box2.add(Cn);
		box3.add(new JLabel("ѧ��",JLabel.CENTER));
		box3.add(Cs);
		box4.add(new JLabel("ѧʱ",JLabel.CENTER));
		box4.add(Cp);
		box5.add(new JLabel("����",JLabel.CENTER));
		box5.add(Cc);
		box6.add(new JLabel("רҵ����",JLabel.CENTER));
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
		
		BackgroundPanelSelC jp;//�������
		jp=new BackgroundPanelSelC((new ImageIcon("C:\\Users\\11862\\Pictures\\ZM\\��γ�.png")).getImage());
		jp.add(boxH);
		setLayout(new BorderLayout()); //�߿򲼾�
		add(jp,BorderLayout.CENTER);
		validate();
	}
	
	//�����¼�ִ��
	public void actionPerformed(ActionEvent c){
		Object obj=c.getSource();
		Statement stmt=null;//�����ӿ�
		ResultSet rs=null; //�������ؽ��
		String sql=null;
		forSelC K;
		if(obj==jb){
			if(Cno.getText().equals("")&&Cn.getText().equals("")&&Cno.getText().equals("")&&Dno.getText().equals("")){
				sql="select * from C";
			}
			else if((!Cno.getText().equals(""))&&Cn.getText().equals("")&&Cn.getText().equals("")&&Dno.getText().equals("")){
				sql="select * from C where cno='"+Cno.getText()+"'";
			}
			else if(Cno.getText().equals("")&&(!Cn.getText().equals(""))&&Cn.getText().equals("")&&Dno.getText().equals("")){
				sql="select * from C where cn='"+Cn.getText()+"'";
			}
			else if(Cno.getText().equals("")&&Cn.getText().equals("")&&(!Cn.getText().equals(""))&&Dno.getText().equals("")){
				sql="select * from C where cn='"+Cn.getText()+"'";
			}
			else if(Cno.getText().equals("")&&Cn.getText().equals("")&&Cn.getText().equals("")&&(!Dno.getText().equals(""))){
				sql="select * from C where dno='"+Dno.getText()+"'";
			}
			else if((!Cno.getText().equals(""))&&(!Cn.getText().equals(""))&&Cn.getText().equals("")&&Dno.getText().equals("")){
				sql="select * from C where cno='"+Cno.getText()+"' and tn='"+Cn.getText()+"'";
			}
			else if((!Cno.getText().equals(""))&&Cn.getText().equals("")&&(!Cn.getText().equals(""))&&Dno.getText().equals("")){
				sql="select * from C where cno='"+Cno.getText()+"' and cn='"+Cn.getText()+"'";
			}
			else if((!Cno.getText().equals(""))&&Cn.getText().equals("")&&Cn.getText().equals("")&&(!Dno.getText().equals(""))){
				sql="select * from C where cno='"+Cno.getText()+"' and dno='"+Dno.getText()+"'";
			}
			else if(Cno.getText().equals("")&&(!Cn.getText().equals(""))&&(!Cn.getText().equals(""))&&Dno.getText().equals("")){
				sql="select * from C where cn='"+Cn.getText()+"' and cn='"+Cn.getText()+"'";
			}
			else if(Cno.getText().equals("")&&(!Cn.getText().equals(""))&&Cn.getText().equals("")&&(!Dno.getText().equals(""))){
				sql="select * from C where cn='"+Cn.getText()+"' and dno='"+Dno.getText()+"'";
			}
			else if(Cno.getText().equals("")&&Cn.getText().equals("")&&(!Cn.getText().equals(""))&&(!Dno.getText().equals(""))){
				sql="select * from C where cn='"+Cn.getText()+"' and dno='"+Dno.getText()+"'";
			}
			else if((!Cno.getText().equals(""))&&(!Cn.getText().equals(""))&&(!Cn.getText().equals(""))&&Dno.getText().equals("")){
				sql="select * from C where cno='"+Cno.getText()+"' and tn='"+Cn.getText()+"' and Cn='"+Cn.getText()+"'";
			}
			else if((!Cno.getText().equals(""))&&(!Cn.getText().equals(""))&&Cn.getText().equals("")&&(!Dno.getText().equals(""))){
				sql="select * from C where cno='"+Cno.getText()+"' and tn='"+Cn.getText()+"' and dno='"+Dno.getText()+"'";
			}
			else if((!Cno.getText().equals(""))&&Cn.getText().equals("")&&(!Cn.getText().equals(""))&&(!Dno.getText().equals(""))){
				sql="select * from C where cno='"+Cno.getText()+"' and ty='"+Cn.getText()+"' and dno='"+Dno.getText()+"'";
			}
			else if(Cno.getText().equals("")&&(!Cn.getText().equals(""))&&(!Cn.getText().equals(""))&&(!Dno.getText().equals(""))){
				sql="select * from C where cn='"+Cn.getText()+"' and ty='"+Cn.getText()+"' and dno='"+Dno.getText()+"'";
			}
			else{
				sql="select * from C where tno='"+Cno.getText()+"' and tn='"+Cn.getText()+"' and Cn='"+Cn.getText()+"' and dno='"+Dno.getText()+"'";
			}
			K=new forSelC(sql);
		}
	}
}

class BackgroundPanelSelC extends JPanel  
{  
    Image im;  
    public BackgroundPanelSelC(Image im)  
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