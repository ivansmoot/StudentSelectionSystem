package SelectionPackage;

import java.awt.*;

import javax.swing.*;

import java.sql.*;
import java.awt.event.*;

public class SelS extends JPanel implements ActionListener{
	JTextField sno=new JTextField(20);//ѧ��ѧ��

	JButton jb=new JButton("����");
	
	//�������
	public SelS(){
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
		
		box1.add(new JLabel("ѧ��ѧ��",JLabel.CENTER));
		box1.add(sno);

	
		box3.add(jb);
		
		Box boxH=Box.createVerticalBox();
		boxH.add(box1);
		boxH.add(box2);
		boxH.add(box3);
		boxH.add(Box.createVerticalGlue());
		
		BackgroundPanelSelS jp;//�������
		jp=new BackgroundPanelSelS((new ImageIcon("C:\\Users\\11862\\Pictures\\ZM\\��ѧ��.png")).getImage());
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
		forSelS K;
		if(obj==jb){
			if (sno.getText().equals(""))
				sql="select * from S";
			else
				sql="select * from S where sno='"+sno.getText()+"'";
			
		K=new forSelS(sql);
		}
	}
}

class BackgroundPanelSelS extends JPanel  
{  
    Image im;  
    public BackgroundPanelSelS(Image im)  
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