package SelectionPackage;

import java.awt.*;

import javax.swing.*;

import java.sql.*;
import java.awt.event.*;

public class SelTC extends JPanel implements ActionListener{
	JTextField Tno=new JTextField(20);//��ʦ��
	JTextField Cno=new JTextField(20);//�γ̺�
	JButton jb=new JButton("����");
	
	//������������
	boolean digitCheck(String input) {
	    for(int i = 0; i < input.length(); i++) {
	        char c = input.charAt(i);
	        if( (c < '0' || c > '9') ) {
	        return false;
	        }
	    }
	    return true;
	}
	
	//�������
	public SelTC(){
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
		
		box1.add(new JLabel("��ʦ��",JLabel.CENTER));
		box1.add(Tno);
		box2.add(new JLabel("�γ̺�",JLabel.CENTER));
		box2.add(Cno);
		box3.add(jb);
		
		Box boxH=Box.createVerticalBox();
		boxH.add(box1);
		boxH.add(box2);
		boxH.add(box3);
		boxH.add(Box.createVerticalGlue());
		
		BackgroundPanelSelTC jp;//�������
		jp=new BackgroundPanelSelTC((new ImageIcon("C:\\Users\\11862\\Pictures\\ZM\\����.png")).getImage());
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
		String s1=Tno.getText();
		String s2=Cno.getText();
		forSelTC K;
		if(obj==jb){
			if(Tno.getText().equals("")&&Cno.getText().equals("")){
				sql="select * from TC";
			}
			else if(Tno.getText().equals("")){
				if(!digitCheck(s2)||s2.length()>12) 
					JOptionPane.showMessageDialog(this,"�γ̺������벻����12λ������");
				else
				sql="select * from TC where cno='"+Cno.getText()+"'";
			}
			else if(Cno.getText().equals("")){
				if(!digitCheck(s1)||s1.length()>9) 
					JOptionPane.showMessageDialog(this,"��ʦ�������벻����9λ������");
				else
				sql="select * from TC where tno='"+Tno.getText()+"'";
			}
			else{
				if(!digitCheck(s1)||s1.length()>9) 
					JOptionPane.showMessageDialog(this,"��ʦ�������벻����9λ������");
				else {
					if(!digitCheck(s2)||s2.length()>12) 
						JOptionPane.showMessageDialog(this,"�γ̺������벻����12λ������");
					else
				        sql="select * from TC where tno='"+Tno.getText()+"' and cno='"+Cno.getText()+"'";
				}
			}
			K=new forSelTC(sql);
		}
	}
}

class BackgroundPanelSelTC extends JPanel  
{  
    Image im;  
    public BackgroundPanelSelTC(Image im)  
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