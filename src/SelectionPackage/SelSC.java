package SelectionPackage;

import java.awt.*;

import javax.swing.*;

import java.sql.*;
import java.awt.event.*;

public class SelSC extends JPanel implements ActionListener{
	JTextField Sy=new JTextField(20);//ѧ��
	JTextField Term=new JTextField(20);//ѧ��
	JTextField Sno=new JTextField(20); //ѧ�������
	JTextField Cno=new JTextField(20);  //�γ̺������
	
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
	public SelSC(){
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
		
		box1.add(new JLabel("ѧ��",JLabel.CENTER));
		box1.add(Sy);
		box2.add(new JLabel("ѧ��",JLabel.CENTER));
		box2.add(Term);
		box3.add(new JLabel("ѧ��",JLabel.CENTER));
		box3.add(Sno);
		box4.add(new JLabel("�γ̺�",JLabel.CENTER));
		box4.add(Cno);
		
		box5.add(jb);
		
		Box boxH=Box.createVerticalBox();
		boxH.add(box1);
		boxH.add(box2);
		boxH.add(box3);
		boxH.add(box4);
		boxH.add(box5);
		boxH.add(Box.createVerticalGlue());
		
		BackgroundPanelSelSC jp;//�������
		jp=new BackgroundPanelSelSC((new ImageIcon("C:\\Users\\11862\\Pictures\\ZM\\����.png")).getImage());
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
		String s1=Sno.getText();
		String s2=Cno.getText();
		//String s3=Score.getText();
		forSelSC K;
		if(obj==jb){
			if(Sno.getText().equals("")&&Cno.getText().equals("")&&Sy.getText().equals("")){
				sql="select * from SC";
			}
			else if(Sno.getText().equals("")&&Cno.getText().equals("")) {
				sql="select * from SC where sy='"+Sy.getText()+"'and term='"+Term.getText()+"'";
			}
			else if(Sno.getText().equals("")){
				if(!digitCheck(s2)||s2.length()>12) {
					JOptionPane.showMessageDialog(this,"�γ̺������벻����12λ������");}
				else {
				sql="select * from SC where cno='"+Cno.getText()+"' and sy='"+Sy.getText()+"'and term='"+Term.getText()+"'";
				}
				}
			
			else if(Cno.getText().equals("")){
				if(!digitCheck(s1)||s1.length()>7) {
					JOptionPane.showMessageDialog(this,"ѧ�������벻����7λ������");
				}
				else {
				sql="select * from SC where sno='"+Sno.getText()+"' and sy='"+Sy.getText()+"'and term='"+Term.getText()+"'";
				}
				}
			else if(!(Sno.getText().equals("")&&Cno.getText().equals(""))) {
				if(!digitCheck(s1)||s1.length()>7) {
					JOptionPane.showMessageDialog(this,"ѧ�������벻����7λ������");
				}
				else {
					if(!digitCheck(s2)||s2.length()>12) {
						JOptionPane.showMessageDialog(this,"�γ̺������벻����12λ������");}
					else {
				     sql="select * from SC where sno='"+Sno.getText()+"'and term='"+Term.getText()+"' and cno='"+Cno.getText()+"'";
					}
				}
				}
			
			
			K=new forSelSC(sql);
		}
	}
}

class BackgroundPanelSelSC extends JPanel  
{  
    Image im;  
    public BackgroundPanelSelSC(Image im)  
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