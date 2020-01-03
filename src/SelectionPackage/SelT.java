package SelectionPackage;

import java.awt.*;

import javax.swing.*;

import java.sql.*;
import java.awt.event.*;

public class SelT extends JPanel implements ActionListener{
	JTextField Tno=new JTextField(20);//��ʦ��
	JTextField Tn=new JTextField(20);//����
	JTextField Ty=new JTextField(20);//��ְ��
	JTextField Dno=new JTextField(20);//רҵ����
	JButton jb=new JButton("����");
	
	//�������
	public SelT(){
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
		
		box1.add(new JLabel("��ʦ��",JLabel.CENTER));
		box1.add(Tno);
		box2.add(new JLabel("����",JLabel.CENTER));
		box2.add(Tn);
		box3.add(new JLabel("��ְ��",JLabel.CENTER));
		box3.add(Ty);
		box4.add(new JLabel("רҵ����",JLabel.CENTER));
		box4.add(Dno);
		box5.add(jb);
		
		Box boxH=Box.createVerticalBox();
		boxH.add(box1);
		boxH.add(box2);
		boxH.add(box3);
		boxH.add(box4);
		boxH.add(box5);
		boxH.add(Box.createVerticalGlue());
		
		BackgroundPanelSelT pCenter;//�������
		pCenter=new BackgroundPanelSelT((new ImageIcon("C:\\Users\\11862\\Pictures\\ZM\\����ʦ.png")).getImage());
		pCenter.add(boxH);
		setLayout(new BorderLayout()); //�߿򲼾�
		add(pCenter,BorderLayout.CENTER);
		validate();
	}
	public boolean checkname(String name){ 
		int n = 0; 
	for(int k = 0; k < name.length(); k++) 
	{
		n = (int)name.charAt(k);
	if(!(19968 <= n && n <40869)) 
	{ 
		return false; 
		} 
	}
	return true; 
	}
	
	//�����¼�ִ��
	public void actionPerformed(ActionEvent c){
		Object obj=c.getSource();
		Statement stmt=null;//�����ӿ�
		ResultSet rs=null; //�������ؽ��
		String sql=null;
		forSelT K;
		boolean TnoB,TnB,TyB;	
		
		if(obj==jb){
			if(Tno.getText().equals("")&&Tn.getText().equals("")&&Ty.getText().equals("")&&Dno.getText().equals("")){
				sql="select * from T";
				K=new forSelT(sql);
			}
			
			else if((!Tno.getText().equals(""))&&Tn.getText().equals("")&&Ty.getText().equals("")&&Dno.getText().equals("")){
				int length=Tno.getText().length();
				if(length!=9){
					JOptionPane.showMessageDialog(this,"��ʦ�ű���Ϊ9λ����");
				}
				else{
					int num=0;
					for(int j=0;j<9;j++){
						if(Tno.getText().charAt(j)>='0'&&Tno.getText().charAt(j)<='9'){
							num++;
						}
					}
					if(num!=9){
						JOptionPane.showMessageDialog(this,"��ʦ�ű���Ϊ������");
					}
					else{
						sql="select * from T where tno='"+Tno.getText()+"'";
						K=new forSelT(sql);
					}
				}
			}
			
			else if(Tno.getText().equals("")&&(!Tn.getText().equals(""))&&Ty.getText().equals("")&&Dno.getText().equals("")){
				if(Tn.getText().length()>4||Tn.getText().length()<2){
					JOptionPane.showMessageDialog(this,"����Ϊ2��4������");
				}
				else{
					if(!checkname(Tn.getText())){
						JOptionPane.showMessageDialog(this,"��������Ϊ����");
					}
					else{
						sql="select * from T where tn='"+Tn.getText()+"'";
						K=new forSelT(sql);
					}
				}
			}
			
			else if(Tno.getText().equals("")&&Tn.getText().equals("")&&(!Ty.getText().equals(""))&&Dno.getText().equals("")){
				if(Ty.getText().length()!=4){
					JOptionPane.showMessageDialog(this,"��ְ�������4λ");
				}
				else{
					int i = Integer.parseInt(Ty.getText());
					if(!(i>=2000&&i<=2018)){
						JOptionPane.showMessageDialog(this,"��ְ����2000��2018");
					}
					else{
						sql="select * from T where ty='"+Ty.getText()+"'";
						K=new forSelT(sql);
					}
				}
				
			}
			
			else if(Tno.getText().equals("")&&Tn.getText().equals("")&&Ty.getText().equals("")&&(!Dno.getText().equals(""))){
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
						sql="select * from T where dno='"+Dno.getText()+"'";
						K=new forSelT(sql);
					}
				}
			}
			else if((!Tno.getText().equals(""))&&(!Tn.getText().equals(""))&&Ty.getText().equals("")&&Dno.getText().equals("")){
				int length=Tno.getText().length();
				if(length!=9){
					JOptionPane.showMessageDialog(this,"��ʦ�ű���Ϊ9λ����");
				}
				else{
					int num=0;
					for(int j=0;j<9;j++){
						if(Tno.getText().charAt(j)>='0'&&Tno.getText().charAt(j)<='9'){
							num++;
						}
					}
					if(num!=9){
						JOptionPane.showMessageDialog(this,"��ʦ�ű���Ϊ������");
					}
					else{
						if(Tn.getText().length()>4||Tn.getText().length()<2){
							JOptionPane.showMessageDialog(this,"����Ϊ2��4������");
						}
						else{
							if(!checkname(Tn.getText())){
								JOptionPane.showMessageDialog(this,"��������Ϊ����");
							}
							else{
								sql="select * from T where tno='"+Tno.getText()+"' and tn='"+Tn.getText()+"'";
								K=new forSelT(sql);
							}
						}
					}
				}
				
			}
			else if((!Tno.getText().equals(""))&&Tn.getText().equals("")&&(!Ty.getText().equals(""))&&Dno.getText().equals("")){
				int length=Tno.getText().length();
				if(length!=9){
					JOptionPane.showMessageDialog(this,"��ʦ�ű���Ϊ9λ����");
				}
				else{
					int num=0;
					for(int j=0;j<9;j++){
						if(Tno.getText().charAt(j)>='0'&&Tno.getText().charAt(j)<='9'){
							num++;
						}
					}
					if(num!=9){
						JOptionPane.showMessageDialog(this,"��ʦ�ű���Ϊ������");
					}
					else{
						if(Ty.getText().length()!=4){
							JOptionPane.showMessageDialog(this,"��ְ�������4λ");
						}
						else{
							int i = Integer.parseInt(Ty.getText());
							if(!(i>=2000&&i<=2018)){
								JOptionPane.showMessageDialog(this,"��ְ����2000��2018");
							}
							else{
								sql="select * from T where tno='"+Tno.getText()+"' and ty='"+Ty.getText()+"'";
								K=new forSelT(sql);
							}
						}
					}
				}			
			}
			
			else if((!Tno.getText().equals(""))&&Tn.getText().equals("")&&Ty.getText().equals("")&&(!Dno.getText().equals(""))){
				int length=Tno.getText().length();
				if(length!=9){
					JOptionPane.showMessageDialog(this,"��ʦ�ű���Ϊ9λ����");
				}
				else{
					int num=0;
					for(int j=0;j<9;j++){
						if(Tno.getText().charAt(j)>='0'&&Tno.getText().charAt(j)<='9'){
							num++;
						}
					}
					if(num!=9){
						JOptionPane.showMessageDialog(this,"��ʦ�ű���Ϊ������");
					}
					else{
						int length1=Dno.getText().length();
						if(length1!=3){//רҵ����
							JOptionPane.showMessageDialog(this,"רҵ�������Ϊ3λ����");
						}
						else{
							if(!(Dno.getText().charAt(0)>='0'&&Dno.getText().charAt(0)<='9'
									&&Dno.getText().charAt(1)>='0'&&Dno.getText().charAt(1)<='9'
									&&Dno.getText().charAt(2)>='0'&&Dno.getText().charAt(2)<='9')){
								JOptionPane.showMessageDialog(this,"רҵ�������Ϊ������");
							}
							else{
								sql="select * from T where tno='"+Tno.getText()+"' and dno='"+Dno.getText()+"'";
								K=new forSelT(sql);
							}
						}
					}
				}	
			}
			
			else if(Tno.getText().equals("")&&(!Tn.getText().equals(""))&&(!Ty.getText().equals(""))&&Dno.getText().equals("")){
				if(Tn.getText().length()>4||Tn.getText().length()<2){
					JOptionPane.showMessageDialog(this,"����Ϊ2��4������");
				}
				else{
					if(!checkname(Tn.getText())){
						JOptionPane.showMessageDialog(this,"��������Ϊ����");
					}
					else{
						if(Ty.getText().length()!=4){
							JOptionPane.showMessageDialog(this,"��ְ�������4λ");
						}
						else{
							int i = Integer.parseInt(Ty.getText());
							if(!(i>=2000&&i<=2018)){
								JOptionPane.showMessageDialog(this,"��ְ����2000��2018");
							}
							else{
								sql="select * from T where tn='"+Tn.getText()+"' and ty='"+Ty.getText()+"'";
								K=new forSelT(sql);
							}
						}
					}
				}	
			}
			
			else if(Tno.getText().equals("")&&(!Tn.getText().equals(""))&&Ty.getText().equals("")&&(!Dno.getText().equals(""))){
				if(Tn.getText().length()>4||Tn.getText().length()<2){
					JOptionPane.showMessageDialog(this,"����Ϊ2��4������");
				}
				else{
					if(!checkname(Tn.getText())){
						JOptionPane.showMessageDialog(this,"��������Ϊ����");
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
								sql="select * from T where tn='"+Tn.getText()+"' and dno='"+Dno.getText()+"'";
								K=new forSelT(sql);
							}
						}
					}
				}	
			}
			else if(Tno.getText().equals("")&&Tn.getText().equals("")&&(!Ty.getText().equals(""))&&(!Dno.getText().equals(""))){
				if(Ty.getText().length()!=4){
					JOptionPane.showMessageDialog(this,"��ְ�������4λ");
				}
				else{
					int i = Integer.parseInt(Ty.getText());
					if(!(i>=2000&&i<=2018)){
						JOptionPane.showMessageDialog(this,"��ְ����2000��2018");
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
								sql="select * from T where ty='"+Ty.getText()+"' and dno='"+Dno.getText()+"'";
								K=new forSelT(sql);
							}
						}
					}
				}	
			}
			else if((!Tno.getText().equals(""))&&(!Tn.getText().equals(""))&&(!Ty.getText().equals(""))&&Dno.getText().equals("")){
				int length=Tno.getText().length();
				if(length!=9){
					JOptionPane.showMessageDialog(this,"��ʦ�ű���Ϊ9λ����");
				}
				else{
					int num=0;
					for(int j=0;j<9;j++){
						if(Tno.getText().charAt(j)>='0'&&Tno.getText().charAt(j)<='9'){
							num++;
						}
					}
					if(num!=9){
						JOptionPane.showMessageDialog(this,"��ʦ�ű���Ϊ������");
					}
					else{
						if(Tn.getText().length()>4||Tn.getText().length()<2){
							JOptionPane.showMessageDialog(this,"����Ϊ2��4������");
						}
						else{
							if(!checkname(Tn.getText())){
								JOptionPane.showMessageDialog(this,"��������Ϊ����");
							}
							else{
								if(Ty.getText().length()!=4){
									JOptionPane.showMessageDialog(this,"��ְ�������4λ");
								}
								else{
									int i = Integer.parseInt(Ty.getText());
									if(!(i>=2000&&i<=2018)){
										JOptionPane.showMessageDialog(this,"��ְ����2000��2018");
									}
									else{
										sql="select * from T where tno='"+Tno.getText()+"' and tn='"+Tn.getText()+"' and ty='"+Ty.getText()+"'";
										K=new forSelT(sql);
									}
								}
							}
						}
					}
				}		
			}
			
			else if((!Tno.getText().equals(""))&&(!Tn.getText().equals(""))&&Ty.getText().equals("")&&(!Dno.getText().equals(""))){
				int length=Tno.getText().length();
				if(length!=9){
					JOptionPane.showMessageDialog(this,"��ʦ�ű���Ϊ9λ����");
				}
				else{
					int num=0;
					for(int j=0;j<9;j++){
						if(Tno.getText().charAt(j)>='0'&&Tno.getText().charAt(j)<='9'){
							num++;
						}
					}
					if(num!=9){
						JOptionPane.showMessageDialog(this,"��ʦ�ű���Ϊ������");
					}
					else{
						if(Tn.getText().length()>4||Tn.getText().length()<2){
							JOptionPane.showMessageDialog(this,"����Ϊ2��4������");
						}
						else{
							if(!checkname(Tn.getText())){
								JOptionPane.showMessageDialog(this,"��������Ϊ����");
							}
							else{
								int length1=Dno.getText().length();
								if(length1!=3){//רҵ����
									JOptionPane.showMessageDialog(this,"רҵ�������Ϊ3λ����");
								}
								else{
									if(!(Dno.getText().charAt(0)>='0'&&Dno.getText().charAt(0)<='9'
											&&Dno.getText().charAt(1)>='0'&&Dno.getText().charAt(1)<='9'
											&&Dno.getText().charAt(2)>='0'&&Dno.getText().charAt(2)<='9')){
										JOptionPane.showMessageDialog(this,"רҵ�������Ϊ������");
									}
									else{
										sql="select * from T where tno='"+Tno.getText()+"' and tn='"+Tn.getText()+"' and dno='"+Dno.getText()+"'";
										K=new forSelT(sql);
									}
								}
							}
						}
					}
				}			
			}
			
			else if((!Tno.getText().equals(""))&&Tn.getText().equals("")&&(!Ty.getText().equals(""))&&(!Dno.getText().equals(""))){
				int length=Tno.getText().length();
				if(length!=9){
					JOptionPane.showMessageDialog(this,"��ʦ�ű���Ϊ9λ����");
				}
				else{
					int num=0;
					for(int j=0;j<9;j++){
						if(Tno.getText().charAt(j)>='0'&&Tno.getText().charAt(j)<='9'){
							num++;
						}
					}
					if(num!=9){
						JOptionPane.showMessageDialog(this,"��ʦ�ű���Ϊ������");
					}
					else{
						if(Ty.getText().length()!=4){
							JOptionPane.showMessageDialog(this,"��ְ�������4λ");
						}
						else{
							int i = Integer.parseInt(Ty.getText());
							if(!(i>=2000&&i<=2018)){
								JOptionPane.showMessageDialog(this,"��ְ����2000��2018");
							}
							else{
								int length1=Dno.getText().length();
								if(length1!=3){//רҵ����
									JOptionPane.showMessageDialog(this,"רҵ�������Ϊ3λ����");
								}
								else{
									if(!(Dno.getText().charAt(0)>='0'&&Dno.getText().charAt(0)<='9'
											&&Dno.getText().charAt(1)>='0'&&Dno.getText().charAt(1)<='9'
											&&Dno.getText().charAt(2)>='0'&&Dno.getText().charAt(2)<='9')){
										JOptionPane.showMessageDialog(this,"רҵ�������Ϊ������");
									}
									else{
										sql="select * from T where tno='"+Tno.getText()+"' and ty='"+Ty.getText()+"' and dno='"+Dno.getText()+"'";
										K=new forSelT(sql);
									}
								}
							}
						}
					}
				}	
			}
			
			else if(Tno.getText().equals("")&&(!Tn.getText().equals(""))&&(!Ty.getText().equals(""))&&(!Dno.getText().equals(""))){
				if(Tn.getText().length()>4||Tn.getText().length()<2){
					JOptionPane.showMessageDialog(this,"����Ϊ2��4������");
				}
				else{
					if(!checkname(Tn.getText())){
						JOptionPane.showMessageDialog(this,"��������Ϊ����");
					}
					else{
						if(Ty.getText().length()!=4){
							JOptionPane.showMessageDialog(this,"��ְ�������4λ");
						}
						else{
							int i = Integer.parseInt(Ty.getText());
							if(!(i>=2000&&i<=2018)){
								JOptionPane.showMessageDialog(this,"��ְ����2000��2018");
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
										sql="select * from T where tn='"+Tn.getText()+"' and ty='"+Ty.getText()+"' and dno='"+Dno.getText()+"'";
										K=new forSelT(sql);
									}
								}
							}
						}
					}
				}	
			}
			else{
				int length=Tno.getText().length();
				if(length!=9){
					JOptionPane.showMessageDialog(this,"��ʦ�ű���Ϊ9λ����");
				}
				else{
					int num=0;
					for(int j=0;j<9;j++){
						if(Tno.getText().charAt(j)>='0'&&Tno.getText().charAt(j)<='9'){
							num++;
						}
					}
					if(num!=9){
						JOptionPane.showMessageDialog(this,"��ʦ�ű���Ϊ������");
					}
					else{
						if(Tn.getText().length()>4||Tn.getText().length()<2){
							JOptionPane.showMessageDialog(this,"����Ϊ2��4������");
						}
						else{
							if(!checkname(Tn.getText())){
								JOptionPane.showMessageDialog(this,"��������Ϊ����");
							}
							else{
								int length1=Dno.getText().length();
								if(length1!=3){//רҵ����
									JOptionPane.showMessageDialog(this,"רҵ�������Ϊ3λ����");
								}
								else{
									if(!(Dno.getText().charAt(0)>='0'&&Dno.getText().charAt(0)<='9'
											&&Dno.getText().charAt(1)>='0'&&Dno.getText().charAt(1)<='9'
											&&Dno.getText().charAt(2)>='0'&&Dno.getText().charAt(2)<='9')){
										JOptionPane.showMessageDialog(this,"רҵ�������Ϊ������");
									}
									else{
										sql="select * from T where tno='"+Tno.getText()+"' and tn='"+Tn.getText()+"' and ty='"+Ty.getText()+"' and dno='"+Dno.getText()+"'";
										K=new forSelT(sql);
									}
								}
							}
						}
					}
				}
			}
		}
	}
}

class BackgroundPanelSelT extends JPanel  
{  
    Image im;  
    public BackgroundPanelSelT(Image im)  
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