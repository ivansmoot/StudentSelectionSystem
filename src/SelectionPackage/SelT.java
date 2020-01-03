package SelectionPackage;

import java.awt.*;

import javax.swing.*;

import java.sql.*;
import java.awt.event.*;

public class SelT extends JPanel implements ActionListener{
	JTextField Tno=new JTextField(20);//教师号
	JTextField Tn=new JTextField(20);//姓名
	JTextField Ty=new JTextField(20);//入职年
	JTextField Dno=new JTextField(20);//专业代码
	JButton jb=new JButton("查找");
	
	//组件设置
	public SelT(){
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());//窗口外观设置为所用系统平台外观
		}catch(Exception e){
			System.out.println("无法设置外观："+e);
		}

		jb.addActionListener(this); //为按钮设置事件
		
		//将输入框和按钮放入BOX组件容器
		Box box1=Box.createHorizontalBox();
		Box box2=Box.createHorizontalBox();
		Box box3=Box.createHorizontalBox();
		Box box4=Box.createHorizontalBox();
		Box box5=Box.createHorizontalBox();
		
		box1.add(new JLabel("教师号",JLabel.CENTER));
		box1.add(Tno);
		box2.add(new JLabel("姓名",JLabel.CENTER));
		box2.add(Tn);
		box3.add(new JLabel("入职年",JLabel.CENTER));
		box3.add(Ty);
		box4.add(new JLabel("专业代码",JLabel.CENTER));
		box4.add(Dno);
		box5.add(jb);
		
		Box boxH=Box.createVerticalBox();
		boxH.add(box1);
		boxH.add(box2);
		boxH.add(box3);
		boxH.add(box4);
		boxH.add(box5);
		boxH.add(Box.createVerticalGlue());
		
		BackgroundPanelSelT pCenter;//创建面板
		pCenter=new BackgroundPanelSelT((new ImageIcon("C:\\Users\\11862\\Pictures\\ZM\\查老师.png")).getImage());
		pCenter.add(boxH);
		setLayout(new BorderLayout()); //边框布局
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
	
	//动作事件执行
	public void actionPerformed(ActionEvent c){
		Object obj=c.getSource();
		Statement stmt=null;//创建接口
		ResultSet rs=null; //声明返回结果
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
					JOptionPane.showMessageDialog(this,"教师号必须为9位数字");
				}
				else{
					int num=0;
					for(int j=0;j<9;j++){
						if(Tno.getText().charAt(j)>='0'&&Tno.getText().charAt(j)<='9'){
							num++;
						}
					}
					if(num!=9){
						JOptionPane.showMessageDialog(this,"教师号必须为纯数字");
					}
					else{
						sql="select * from T where tno='"+Tno.getText()+"'";
						K=new forSelT(sql);
					}
				}
			}
			
			else if(Tno.getText().equals("")&&(!Tn.getText().equals(""))&&Ty.getText().equals("")&&Dno.getText().equals("")){
				if(Tn.getText().length()>4||Tn.getText().length()<2){
					JOptionPane.showMessageDialog(this,"姓名为2至4个汉字");
				}
				else{
					if(!checkname(Tn.getText())){
						JOptionPane.showMessageDialog(this,"姓名必须为汉字");
					}
					else{
						sql="select * from T where tn='"+Tn.getText()+"'";
						K=new forSelT(sql);
					}
				}
			}
			
			else if(Tno.getText().equals("")&&Tn.getText().equals("")&&(!Ty.getText().equals(""))&&Dno.getText().equals("")){
				if(Ty.getText().length()!=4){
					JOptionPane.showMessageDialog(this,"入职年必须是4位");
				}
				else{
					int i = Integer.parseInt(Ty.getText());
					if(!(i>=2000&&i<=2018)){
						JOptionPane.showMessageDialog(this,"入职年在2000到2018");
					}
					else{
						sql="select * from T where ty='"+Ty.getText()+"'";
						K=new forSelT(sql);
					}
				}
				
			}
			
			else if(Tno.getText().equals("")&&Tn.getText().equals("")&&Ty.getText().equals("")&&(!Dno.getText().equals(""))){
				int length=Dno.getText().length();
				if(length!=3){//专业代码
					JOptionPane.showMessageDialog(this,"专业代码必须为3位数字");
				}
				else{
					if(!(Dno.getText().charAt(0)>='0'&&Dno.getText().charAt(0)<='9'
							&&Dno.getText().charAt(1)>='0'&&Dno.getText().charAt(1)<='9'
							&&Dno.getText().charAt(2)>='0'&&Dno.getText().charAt(2)<='9')){
						JOptionPane.showMessageDialog(this,"专业代码必须为纯数字");
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
					JOptionPane.showMessageDialog(this,"教师号必须为9位数字");
				}
				else{
					int num=0;
					for(int j=0;j<9;j++){
						if(Tno.getText().charAt(j)>='0'&&Tno.getText().charAt(j)<='9'){
							num++;
						}
					}
					if(num!=9){
						JOptionPane.showMessageDialog(this,"教师号必须为纯数字");
					}
					else{
						if(Tn.getText().length()>4||Tn.getText().length()<2){
							JOptionPane.showMessageDialog(this,"姓名为2至4个汉字");
						}
						else{
							if(!checkname(Tn.getText())){
								JOptionPane.showMessageDialog(this,"姓名必须为汉字");
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
					JOptionPane.showMessageDialog(this,"教师号必须为9位数字");
				}
				else{
					int num=0;
					for(int j=0;j<9;j++){
						if(Tno.getText().charAt(j)>='0'&&Tno.getText().charAt(j)<='9'){
							num++;
						}
					}
					if(num!=9){
						JOptionPane.showMessageDialog(this,"教师号必须为纯数字");
					}
					else{
						if(Ty.getText().length()!=4){
							JOptionPane.showMessageDialog(this,"入职年必须是4位");
						}
						else{
							int i = Integer.parseInt(Ty.getText());
							if(!(i>=2000&&i<=2018)){
								JOptionPane.showMessageDialog(this,"入职年在2000到2018");
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
					JOptionPane.showMessageDialog(this,"教师号必须为9位数字");
				}
				else{
					int num=0;
					for(int j=0;j<9;j++){
						if(Tno.getText().charAt(j)>='0'&&Tno.getText().charAt(j)<='9'){
							num++;
						}
					}
					if(num!=9){
						JOptionPane.showMessageDialog(this,"教师号必须为纯数字");
					}
					else{
						int length1=Dno.getText().length();
						if(length1!=3){//专业代码
							JOptionPane.showMessageDialog(this,"专业代码必须为3位数字");
						}
						else{
							if(!(Dno.getText().charAt(0)>='0'&&Dno.getText().charAt(0)<='9'
									&&Dno.getText().charAt(1)>='0'&&Dno.getText().charAt(1)<='9'
									&&Dno.getText().charAt(2)>='0'&&Dno.getText().charAt(2)<='9')){
								JOptionPane.showMessageDialog(this,"专业代码必须为纯数字");
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
					JOptionPane.showMessageDialog(this,"姓名为2至4个汉字");
				}
				else{
					if(!checkname(Tn.getText())){
						JOptionPane.showMessageDialog(this,"姓名必须为汉字");
					}
					else{
						if(Ty.getText().length()!=4){
							JOptionPane.showMessageDialog(this,"入职年必须是4位");
						}
						else{
							int i = Integer.parseInt(Ty.getText());
							if(!(i>=2000&&i<=2018)){
								JOptionPane.showMessageDialog(this,"入职年在2000到2018");
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
					JOptionPane.showMessageDialog(this,"姓名为2至4个汉字");
				}
				else{
					if(!checkname(Tn.getText())){
						JOptionPane.showMessageDialog(this,"姓名必须为汉字");
					}
					else{
						int length=Dno.getText().length();
						if(length!=3){//专业代码
							JOptionPane.showMessageDialog(this,"专业代码必须为3位数字");
						}
						else{
							if(!(Dno.getText().charAt(0)>='0'&&Dno.getText().charAt(0)<='9'
									&&Dno.getText().charAt(1)>='0'&&Dno.getText().charAt(1)<='9'
									&&Dno.getText().charAt(2)>='0'&&Dno.getText().charAt(2)<='9')){
								JOptionPane.showMessageDialog(this,"专业代码必须为纯数字");
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
					JOptionPane.showMessageDialog(this,"入职年必须是4位");
				}
				else{
					int i = Integer.parseInt(Ty.getText());
					if(!(i>=2000&&i<=2018)){
						JOptionPane.showMessageDialog(this,"入职年在2000到2018");
					}
					else{
						int length=Dno.getText().length();
						if(length!=3){//专业代码
							JOptionPane.showMessageDialog(this,"专业代码必须为3位数字");
						}
						else{
							if(!(Dno.getText().charAt(0)>='0'&&Dno.getText().charAt(0)<='9'
									&&Dno.getText().charAt(1)>='0'&&Dno.getText().charAt(1)<='9'
									&&Dno.getText().charAt(2)>='0'&&Dno.getText().charAt(2)<='9')){
								JOptionPane.showMessageDialog(this,"专业代码必须为纯数字");
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
					JOptionPane.showMessageDialog(this,"教师号必须为9位数字");
				}
				else{
					int num=0;
					for(int j=0;j<9;j++){
						if(Tno.getText().charAt(j)>='0'&&Tno.getText().charAt(j)<='9'){
							num++;
						}
					}
					if(num!=9){
						JOptionPane.showMessageDialog(this,"教师号必须为纯数字");
					}
					else{
						if(Tn.getText().length()>4||Tn.getText().length()<2){
							JOptionPane.showMessageDialog(this,"姓名为2至4个汉字");
						}
						else{
							if(!checkname(Tn.getText())){
								JOptionPane.showMessageDialog(this,"姓名必须为汉字");
							}
							else{
								if(Ty.getText().length()!=4){
									JOptionPane.showMessageDialog(this,"入职年必须是4位");
								}
								else{
									int i = Integer.parseInt(Ty.getText());
									if(!(i>=2000&&i<=2018)){
										JOptionPane.showMessageDialog(this,"入职年在2000到2018");
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
					JOptionPane.showMessageDialog(this,"教师号必须为9位数字");
				}
				else{
					int num=0;
					for(int j=0;j<9;j++){
						if(Tno.getText().charAt(j)>='0'&&Tno.getText().charAt(j)<='9'){
							num++;
						}
					}
					if(num!=9){
						JOptionPane.showMessageDialog(this,"教师号必须为纯数字");
					}
					else{
						if(Tn.getText().length()>4||Tn.getText().length()<2){
							JOptionPane.showMessageDialog(this,"姓名为2至4个汉字");
						}
						else{
							if(!checkname(Tn.getText())){
								JOptionPane.showMessageDialog(this,"姓名必须为汉字");
							}
							else{
								int length1=Dno.getText().length();
								if(length1!=3){//专业代码
									JOptionPane.showMessageDialog(this,"专业代码必须为3位数字");
								}
								else{
									if(!(Dno.getText().charAt(0)>='0'&&Dno.getText().charAt(0)<='9'
											&&Dno.getText().charAt(1)>='0'&&Dno.getText().charAt(1)<='9'
											&&Dno.getText().charAt(2)>='0'&&Dno.getText().charAt(2)<='9')){
										JOptionPane.showMessageDialog(this,"专业代码必须为纯数字");
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
					JOptionPane.showMessageDialog(this,"教师号必须为9位数字");
				}
				else{
					int num=0;
					for(int j=0;j<9;j++){
						if(Tno.getText().charAt(j)>='0'&&Tno.getText().charAt(j)<='9'){
							num++;
						}
					}
					if(num!=9){
						JOptionPane.showMessageDialog(this,"教师号必须为纯数字");
					}
					else{
						if(Ty.getText().length()!=4){
							JOptionPane.showMessageDialog(this,"入职年必须是4位");
						}
						else{
							int i = Integer.parseInt(Ty.getText());
							if(!(i>=2000&&i<=2018)){
								JOptionPane.showMessageDialog(this,"入职年在2000到2018");
							}
							else{
								int length1=Dno.getText().length();
								if(length1!=3){//专业代码
									JOptionPane.showMessageDialog(this,"专业代码必须为3位数字");
								}
								else{
									if(!(Dno.getText().charAt(0)>='0'&&Dno.getText().charAt(0)<='9'
											&&Dno.getText().charAt(1)>='0'&&Dno.getText().charAt(1)<='9'
											&&Dno.getText().charAt(2)>='0'&&Dno.getText().charAt(2)<='9')){
										JOptionPane.showMessageDialog(this,"专业代码必须为纯数字");
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
					JOptionPane.showMessageDialog(this,"姓名为2至4个汉字");
				}
				else{
					if(!checkname(Tn.getText())){
						JOptionPane.showMessageDialog(this,"姓名必须为汉字");
					}
					else{
						if(Ty.getText().length()!=4){
							JOptionPane.showMessageDialog(this,"入职年必须是4位");
						}
						else{
							int i = Integer.parseInt(Ty.getText());
							if(!(i>=2000&&i<=2018)){
								JOptionPane.showMessageDialog(this,"入职年在2000到2018");
							}
							else{
								int length=Dno.getText().length();
								if(length!=3){//专业代码
									JOptionPane.showMessageDialog(this,"专业代码必须为3位数字");
								}
								else{
									if(!(Dno.getText().charAt(0)>='0'&&Dno.getText().charAt(0)<='9'
											&&Dno.getText().charAt(1)>='0'&&Dno.getText().charAt(1)<='9'
											&&Dno.getText().charAt(2)>='0'&&Dno.getText().charAt(2)<='9')){
										JOptionPane.showMessageDialog(this,"专业代码必须为纯数字");
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
					JOptionPane.showMessageDialog(this,"教师号必须为9位数字");
				}
				else{
					int num=0;
					for(int j=0;j<9;j++){
						if(Tno.getText().charAt(j)>='0'&&Tno.getText().charAt(j)<='9'){
							num++;
						}
					}
					if(num!=9){
						JOptionPane.showMessageDialog(this,"教师号必须为纯数字");
					}
					else{
						if(Tn.getText().length()>4||Tn.getText().length()<2){
							JOptionPane.showMessageDialog(this,"姓名为2至4个汉字");
						}
						else{
							if(!checkname(Tn.getText())){
								JOptionPane.showMessageDialog(this,"姓名必须为汉字");
							}
							else{
								int length1=Dno.getText().length();
								if(length1!=3){//专业代码
									JOptionPane.showMessageDialog(this,"专业代码必须为3位数字");
								}
								else{
									if(!(Dno.getText().charAt(0)>='0'&&Dno.getText().charAt(0)<='9'
											&&Dno.getText().charAt(1)>='0'&&Dno.getText().charAt(1)<='9'
											&&Dno.getText().charAt(2)>='0'&&Dno.getText().charAt(2)<='9')){
										JOptionPane.showMessageDialog(this,"专业代码必须为纯数字");
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
        this.setOpaque(true);                    //设置控件不透明,若是false,那么就是透明
    }  
    //Draw the background again,继承自Jpanle,是Swing控件需要继承实现的方法,而不是AWT中的Paint()
    public void paintComponent(Graphics g)       //绘图类,详情可见博主的Java 下 java-Graphics 
    {  
        super.paintComponents(g);  
        g.drawImage(im,0,0,this.getWidth(),this.getHeight(),this);  //绘制指定图像中当前可用的图像。图像的左上角位于该图形上下文坐标空间的 (x, y)。图像中的透明像素不影响该处已存在的像素

    }  
}