package SelectionPackage;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class SelD extends JPanel implements ActionListener{
	JTextField Dno=new JTextField(20);//רҵ����
	JTextField Dn=new JTextField(20);//רҵ����
	JButton jb=new JButton("����");
	
	//�������
	public SelD(){
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
		
		box1.add(new JLabel("רҵ����",JLabel.CENTER));
		box1.add(Dno);
		box2.add(new JLabel("רҵ����",JLabel.CENTER));
		box2.add(Dn);
		box3.add(jb);
		
		Box boxH=Box.createVerticalBox();
		boxH.add(box1);
		boxH.add(box2);
		boxH.add(box3);
		boxH.add(Box.createVerticalGlue());
		
		BackgroundPanelSelD pCenter;//�������
		pCenter=new BackgroundPanelSelD((new ImageIcon("C:\\Users\\11862\\Pictures\\ZM\\��רҵ.png")).getImage());
		pCenter.add(boxH);
		setLayout(new BorderLayout()); //�߿򲼾�
		add(pCenter,BorderLayout.CENTER);
		validate();
	}
	
	//�����¼�ִ��
	public void actionPerformed(ActionEvent c){
		Object obj=c.getSource();
		Statement stmt=null;//�����ӿ�
		ResultSet rs=null; //�������ؽ��
		String sql=null;
		forSelD K;
		if(obj==jb){
			if(Dno.getText().equals("")&&Dn.getText().equals("")){
				sql="select * from D"; K=new forSelD(sql);
			}
			else if(Dno.getText().equals("")){
				byte[] b=Dn.getText().getBytes();
				if(b.length>15){
					JOptionPane.showMessageDialog(this,"רҵ���ƹ���");
				}
				else{
				int i=Dn.getText().length();
				int num=0;
				for(int j=0;j<i;j++){
					if(Dn.getText().charAt(j)>='0'&&Dn.getText().charAt(j)<='9'){
						num++;
					}
				}
					if(num==i){
						JOptionPane.showMessageDialog(this,"רҵ���Ʋ���Ϊ������");
					}
					else{ 
				sql="select * from D where dn='"+Dn.getText()+"'"; K=new forSelD(sql);
					}
			}
			}
			else if(Dn.getText().equals("")){
				int length=Dno.getText().length();
				if(length!=3){//רҵ����
					JOptionPane.showMessageDialog(this,"רҵ�������Ϊ3λ����");
				}
				else{
					if(!(Dno.getText().charAt(0)>='0'&&Dno.getText().charAt(0)<='9'
							&&Dno.getText().charAt(1)>='0'&&Dno.getText().charAt(1)<='9'
							&&Dno.getText().charAt(2)>='0'&&Dno.getText().charAt(2)<='9')){
						JOptionPane.showMessageDialog(this,"רҵ�������Ϊ������");
					}
					else{
				sql="select * from D where dno='"+Dno.getText()+"'"; K=new forSelD(sql);
					}
				}
			}
			
			
			else{
				int length=Dno.getText().length();
				if(length!=3){//רҵ����
					JOptionPane.showMessageDialog(this,"רҵ�������Ϊ3λ����");
				}
				else{
					if(!(Dno.getText().charAt(0)>='0'&&Dno.getText().charAt(0)<='9'
							&&Dno.getText().charAt(1)>='0'&&Dno.getText().charAt(1)<='9'
							&&Dno.getText().charAt(2)>='0'&&Dno.getText().charAt(2)<='9')){
						JOptionPane.showMessageDialog(this,"רҵ�������Ϊ������");
					}
					else{
						byte[] b=Dn.getText().getBytes();
						if(b.length>15){
							JOptionPane.showMessageDialog(this,"רҵ���ƹ���");
						}
						else{
						int i=Dn.getText().length();
						int num=0;
						for(int j=0;j<i;j++){
							if(Dn.getText().charAt(j)>='0'&&Dn.getText().charAt(j)<='9'){
								num++;
							}
						}
							if(num==i){
								JOptionPane.showMessageDialog(this,"רҵ���Ʋ���Ϊ������");
							}
							else{



							sql="select * from D where dno='"+Dno.getText()+"' and dn='"+Dn.getText()+"'";
							K=new forSelD(sql);
					}
							}
						}
				}
			}
			
		}
	}
}

class BackgroundPanelSelD extends JPanel  
{  
    Image im;  
    public BackgroundPanelSelD(Image im)  
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