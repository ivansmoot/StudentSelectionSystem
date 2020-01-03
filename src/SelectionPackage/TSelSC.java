package SelectionPackage;

import java.awt.*;

import javax.swing.*;

import java.sql.*;
import java.awt.event.*;

public class TSelSC extends JPanel implements ActionListener{
	JTextField Cn=new JTextField(20);//课程名称
	JTextField Dn=new JTextField(20);//专业名称
	JTextField Year=new JTextField(20);//学年
	JTextField Term=new JTextField(20);//学期
	JButton jb=new JButton("查找");
	String id;
	public TSelSC(String id1){
		id=id1;
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
				
		box1.add(new JLabel("课程名称",JLabel.CENTER));
		box1.add(Cn);
		box2.add(new JLabel("专业名称",JLabel.CENTER));
		box2.add(Dn);
		box3.add(new JLabel("学年",JLabel.CENTER));
		box3.add(Year);
		box4.add(new JLabel("学期",JLabel.CENTER));
		box4.add(Term);
		box5.add(jb);
		
		Box boxH=Box.createVerticalBox();
		boxH.add(box1);
		boxH.add(box2);
		boxH.add(box3);
		boxH.add(box4);
		boxH.add(box5);
		boxH.add(Box.createVerticalGlue());
		
		BackgroundPanelTSelSC pCenter;//创建面板
		pCenter=new BackgroundPanelTSelSC((new ImageIcon("C:\\Users\\11862\\Pictures\\ZM\\该查成绩了.png")).getImage());
		pCenter.add(boxH);
		setLayout(new BorderLayout()); //边框布局
		add(pCenter,BorderLayout.CENTER);
		validate();
	}
	
	public void actionPerformed(ActionEvent c){
		Object obj=c.getSource();
		Statement stmt=null;//创建接口
		ResultSet rs=null; //声明返回结果
		String sql=null;
		forTSelSC K;
		if(obj==jb){
			if(Cn.getText().equals("")&&Dn.getText().equals("")&&Year.getText().equals("")&&Term.getText().equals("")){
				sql="select  D.dn 专业名,C.cn 课程名,S.sn 姓名,C.cs 学分,SC.score 分数,t_ime._year 学年,t_ime.term 学期 from D,C,S,SC,TC,t_ime "
						+ "where TC.tno='"+id+"' and TC.cno=C.cno and SC.cno=TC.cno and S.dno=D.dno and S.sno=SC.sno and TC.cno=SC.cno and t_ime.cno=C.cno and t_ime.dno=d.dno " ;
				K=new forTSelSC(sql);
			}
			else if(Cn.getText().equals("")&&!Dn.getText().equals("")&&Year.getText().equals("")&&Term.getText().equals("")){
				if(Dn.getText().equals("")){//专业名称不可以为空值
					JOptionPane.showMessageDialog(this,"专业名称不能为空");
				}
	
				else{
					byte[] b=Dn.getText().getBytes();
					if(b.length>15){
						JOptionPane.showMessageDialog(this,"专业名称过长");
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
								JOptionPane.showMessageDialog(this,"专业名称不能为纯数字");
							}
							else{
								sql="select  D.dn 专业名,C.cn 课程名,S.sn 姓名,C.cs 学分,SC.score 分数,t_ime._year 学年,t_ime.term 学期 from D,C,S,SC,TC,t_ime "
										+ "where TC.tno='"+id+"' and TC.cno=C.cno and SC.cno=TC.cno and S.dno=D.dno and S.sno=SC.sno and TC.cno=SC.cno and D.dn='"+Dn.getText()+"' and t_ime.cno=C.cno and t_ime.dno=d.dno" ;
								K=new forTSelSC(sql);
							}
					}
				}
			}
			else if(!Cn.getText().equals("")&&Dn.getText().equals("")&&Year.getText().equals("")&&Term.getText().equals("")){
				if(Cn.getText().equals("")){//课程名称不可以为空值
					JOptionPane.showMessageDialog(this,"课程名称不能为空");
				}
	
				else{
					byte[] b=Cn.getText().getBytes();
					if(b.length>30){
						JOptionPane.showMessageDialog(this,"课程名称过长");
					}
					else{
						int i=Cn.getText().length();
						int num=0;
						for(int j=0;j<i;j++){
							if(Cn.getText().charAt(j)>='0'&&Cn.getText().charAt(j)<='9'){
								num++;
							}
						}
							if(num==i){
								JOptionPane.showMessageDialog(this,"课程名称不能为纯数字");
							}
							else{
								sql="select  D.dn 专业名,C.cn 课程名,S.sn 姓名,C.cs 学分,SC.score 分数,t_ime._year 学年,t_ime.term 学期 from D,C,S,SC,TC,t_ime "
										+ "where TC.tno='"+id+"' and TC.cno=C.cno and SC.cno=TC.cno and S.dno=D.dno and S.sno=SC.sno and TC.cno=SC.cno and C.cn='"+Cn.getText()+"'  and t_ime.cno=C.cno and t_ime.dno=d.dno" ;
								K=new forTSelSC(sql);
							}
					}
				}
			}
			
			else if(Cn.getText().equals("")&&Dn.getText().equals("")&&!Year.getText().equals("")&&Term.getText().equals("")){
				if(Year.getText().length()!=4){
					JOptionPane.showMessageDialog(this,"学年必须是4位");
				}
				else{
					int i = Integer.parseInt(Year.getText());
					if(!(i>=2000&&i<=2018)){
						JOptionPane.showMessageDialog(this,"学年在2000到2018");
					}
					else{
						sql="select  D.dn 专业名,C.cn 课程名,S.sn 姓名,C.cs 学分,SC.score 分数,t_ime._year 学年,t_ime.term 学期 from D,C,S,SC,TC,t_ime "
								+ "where TC.tno='"+id+"' and TC.cno=C.cno and SC.cno=TC.cno and S.dno=D.dno and S.sno=SC.sno and TC.cno=SC.cno and t_ime._year='"+Year.getText()+"'  and t_ime.cno=C.cno and t_ime.dno=d.dno" ;
						K=new forTSelSC(sql);
					}
				}
			}
			
			else if(Cn.getText().equals("")&&Dn.getText().equals("")&&Year.getText().equals("")&&!Term.getText().equals("")){
				JOptionPane.showMessageDialog(this,"不可以只填学期不填学年");
			}
			
			else if(!Cn.getText().equals("")&&!Dn.getText().equals("")&&Year.getText().equals("")&&Term.getText().equals("")){
				Dn:
					if(Dn.getText().equals("")){//专业名称不可以为空值
										JOptionPane.showMessageDialog(this,"专业名称不能为空");
									}
						
									else{
										byte[] b=Dn.getText().getBytes();
										if(b.length>15){
											JOptionPane.showMessageDialog(this,"专业名称过长");
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
													JOptionPane.showMessageDialog(this,"专业名称不能为纯数字");
												}
												else{
													if(Cn.getText().equals("")){//课程名称不可以为空值
														JOptionPane.showMessageDialog(this,"课程名称不能为空");
													}
										
													else{
														byte[] d=Cn.getText().getBytes();
														if(d.length>30){
															JOptionPane.showMessageDialog(this,"课程名称过长");
														}
														else{
															int k=Cn.getText().length();
															int num1=0;
															for(int j=0;j<k;j++){
																if(Cn.getText().charAt(j)>='0'&&Cn.getText().charAt(j)<='9'){
																	num1++;
																}
															}
																if(num1==k){
																	JOptionPane.showMessageDialog(this,"课程名称不能为纯数字");
																}
																else{
																	sql="select  D.dn 专业名,C.cn 课程名,S.sn 姓名,C.cs 学分,SC.score 分数,t_ime._year 学年,t_ime.term 学期 from D,C,S,SC,TC,t_ime "
																			+ "where TC.tno='"+id+"' and TC.cno=C.cno and SC.cno=TC.cno and S.dno=D.dno and S.sno=SC.sno and TC.cno=SC.cno and D.dn='"+Dn.getText()+"' and C.cn='"+Cn.getText()+"' and t_ime.cno=C.cno and t_ime.dno=d.dno" ;
																	K=new forTSelSC(sql);
																}
														}
													}
												}
										}
									}
			}
			
			else if(!Cn.getText().equals("")&&Dn.getText().equals("")&&!Year.getText().equals("")&&Term.getText().equals("")){
				if(Cn.getText().equals("")){//课程名称不可以为空值
					JOptionPane.showMessageDialog(this,"课程名称不能为空");
				}
	
				else{
					byte[] b=Cn.getText().getBytes();
					if(b.length>30){
						JOptionPane.showMessageDialog(this,"课程名称过长");
					}
					else{
						int i=Cn.getText().length();
						int num=0;
						for(int j=0;j<i;j++){
							if(Cn.getText().charAt(j)>='0'&&Cn.getText().charAt(j)<='9'){
								num++;
							}
						}
							if(num==i){
								JOptionPane.showMessageDialog(this,"课程名称不能为纯数字");
							}
							else{
								if(Year.getText().length()!=4){
									JOptionPane.showMessageDialog(this,"学年必须是4位");
								}
								else{
									int j = Integer.parseInt(Year.getText());
									if(!(j>=2000&&j<=2018)){
										JOptionPane.showMessageDialog(this,"学年在2000到2018");
									}
									else{
										sql="select  D.dn 专业名,C.cn 课程名,S.sn 姓名,C.cs 学分,SC.score 分数,t_ime._year 学年,t_ime.term 学期 from D,C,S,SC,TC,t_ime "
												+ "where TC.tno='"+id+"' and TC.cno=C.cno and SC.cno=TC.cno and S.dno=D.dno and S.sno=SC.sno and TC.cno=SC.cno and t_ime._year='"+Year.getText()+"' and C.cn='"+Cn.getText()+"' and t_ime.cno=C.cno and t_ime.dno=d.dno" ;
										K=new forTSelSC(sql);
									}
								}
							}
							}
					}
				}
			
			
			else if(!Cn.getText().equals("")&&Dn.getText().equals("")&&Year.getText().equals("")&&!Term.getText().equals("")){
				JOptionPane.showMessageDialog(this,"不可以只填学期不填学年");
			}
		
			else if(Cn.getText().equals("")&&!Dn.getText().equals("")&&!Year.getText().equals("")&&Term.getText().equals("")){
				if(Dn.getText().equals("")){//专业名称不可以为空值
					JOptionPane.showMessageDialog(this,"专业名称不能为空");
				}
	
				else{
					byte[] b=Dn.getText().getBytes();
					if(b.length>15){
						JOptionPane.showMessageDialog(this,"专业名称过长");
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
								JOptionPane.showMessageDialog(this,"专业名称不能为纯数字");
							}
							else{
								if(Year.getText().length()!=4){
									JOptionPane.showMessageDialog(this,"学年必须是4位");
								}
								else{
									int k = Integer.parseInt(Year.getText());
									if(!(k>=2000&&k<=2018)){
										JOptionPane.showMessageDialog(this,"学年在2000到2018");
									}
									else{
										sql="select  D.dn 专业名,C.cn 课程名,S.sn 姓名,C.cs 学分,SC.score 分数,t_ime._year 学年,t_ime.term 学期 from D,C,S,SC,TC,t_ime "
												+ "where TC.tno='"+id+"' and TC.cno=C.cno and SC.cno=TC.cno and S.dno=D.dno and S.sno=SC.sno and TC.cno=SC.cno and t_ime._year='"+Year.getText()+"' and D.dn='"+Dn.getText()+"'  and t_ime.cno=C.cno and t_ime.dno=d.dno" ;
										K=new forTSelSC(sql);
									}
								}
							}
							}
					}
				}
			
			else if(Cn.getText().equals("")&&!Dn.getText().equals("")&&Year.getText().equals("")&&!Term.getText().equals("")){
				JOptionPane.showMessageDialog(this,"不可以只填学期不填学年");
			}
			
			else if(Cn.getText().equals("")&&Dn.getText().equals("")&&!Year.getText().equals("")&&!Term.getText().equals("")){
				if(Year.getText().length()!=4){
					JOptionPane.showMessageDialog(this,"学年必须是4位");
				}
				else{
					int i = Integer.parseInt(Year.getText());
					if(!(i>=2000&&i<=2018)){
						JOptionPane.showMessageDialog(this,"学年在2000到2018");
					}
					else{
						if(!(Term.getText().equals("1")||Term.getText().equals("2"))){
							JOptionPane.showMessageDialog(this,"学期1为上半学期，2为下半学期");
						}
						else{
							sql="select  D.dn 专业名,C.cn 课程名,S.sn 姓名,C.cs 学分,SC.score 分数,t_ime._year 学年,t_ime.term 学期 from D,C,S,SC,TC,t_ime "
									+ "where TC.tno='"+id+"' and TC.cno=C.cno and SC.cno=TC.cno and S.dno=D.dno and S.sno=SC.sno and TC.cno=SC.cno and t_ime.term='"+Term.getText()+"' and t_ime._year='"+Year.getText()+"' and t_ime.cno=C.cno and t_ime.dno=d.dno" ;
							K=new forTSelSC(sql);
						}
					}
				}
			}

			
			else if(!Cn.getText().equals("")&&!Dn.getText().equals("")&&!Year.getText().equals("")&&Term.getText().equals("")){
				if(Dn.getText().equals("")){//专业名称不可以为空值
					JOptionPane.showMessageDialog(this,"专业名称不能为空");
				}
	
				else{
					byte[] b=Dn.getText().getBytes();
					if(b.length>15){
						JOptionPane.showMessageDialog(this,"专业名称过长");
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
								JOptionPane.showMessageDialog(this,"专业名称不能为纯数字");
							}
							else{
								if(Cn.getText().equals("")){//课程名称不可以为空值
									JOptionPane.showMessageDialog(this,"课程名称不能为空");
								}
					
								else{
									byte[] d=Cn.getText().getBytes();
									if(d.length>30){
										JOptionPane.showMessageDialog(this,"课程名称过长");
									}
									else{
										int k=Cn.getText().length();
										int num1=0;
										for(int j=0;j<k;j++){
											if(Cn.getText().charAt(j)>='0'&&Cn.getText().charAt(j)<='9'){
												num1++;
											}
										}
											if(num1==k){
												JOptionPane.showMessageDialog(this,"课程名称不能为纯数字");
											}
											else{
												if(Year.getText().length()!=4){
													JOptionPane.showMessageDialog(this,"学年必须是4位");
												}
												else{
													int j = Integer.parseInt(Year.getText());
													if(!(j>=2000&&j<=2018)){
														JOptionPane.showMessageDialog(this,"学年在2000到2018");
													}
													else{
														sql="select  D.dn 专业名,C.cn 课程名,S.sn 姓名,C.cs 学分,SC.score 分数,t_ime._year 学年,t_ime.term 学期 from D,C,S,SC,TC,t_ime "
																+ "where TC.tno='"+id+"' and TC.cno=C.cno and SC.cno=TC.cno and S.dno=D.dno and S.sno=SC.sno and TC.cno=SC.cno and t_ime._year='"+Year.getText()+"' and C.cn='"+Cn.getText()+"' and D.dn='"+Dn.getText()+"' and t_ime.cno=C.cno and t_ime.dno=d.dno" ;
														K=new forTSelSC(sql);
													}
												}
											}

											}
									}
								}
							}
					}
				}
			


			else if(!Cn.getText().equals("")&&!Dn.getText().equals("")&&Year.getText().equals("")&&!Term.getText().equals("")){
				JOptionPane.showMessageDialog(this,"不可以只填学期不填学年");
			}
			
			else if(!Cn.getText().equals("")&&Dn.getText().equals("")&&!Year.getText().equals("")&&!Term.getText().equals("")){
				if(Cn.getText().equals("")){//课程名称不可以为空值
					JOptionPane.showMessageDialog(this,"课程名称不能为空");
				}
	
				else{
					byte[] b=Cn.getText().getBytes();
					if(b.length>30){
						JOptionPane.showMessageDialog(this,"课程名称过长");
					}
					else{
						int i=Cn.getText().length();
						int num=0;
						for(int j=0;j<i;j++){
							if(Cn.getText().charAt(j)>='0'&&Cn.getText().charAt(j)<='9'){
								num++;
							}
						}
							if(num==i){
								JOptionPane.showMessageDialog(this,"课程名称不能为纯数字");
							}
							else{
								if(Year.getText().length()!=4){
									JOptionPane.showMessageDialog(this,"学年必须是4位");
								}
								else{
									int k = Integer.parseInt(Year.getText());
									if(!(k>=2000&&k<=2018)){
										JOptionPane.showMessageDialog(this,"学年在2000到2018");
									}
									else{
										if(!(Term.getText().equals("1")||Term.getText().equals("2"))){
											JOptionPane.showMessageDialog(this,"学期1为上半学期，2为下半学期");
										}
										else{
											sql="select  D.dn 专业名,C.cn 课程名,S.sn 姓名,C.cs 学分,SC.score 分数,t_ime._year 学年,t_ime.term 学期 from D,C,S,SC,TC,t_ime "
													+ "where TC.tno='"+id+"' and TC.cno=C.cno and SC.cno=TC.cno and S.dno=D.dno and S.sno=SC.sno and TC.cno=SC.cno and t_ime.term='"+Term.getText()+"' and C.cn='"+Cn.getText()+"' and D.dn='"+Dn.getText()+"' and t_ime.cno=C.cno and t_ime.dno=d.dno" ;
											K=new forTSelSC(sql);
										}
								}
							}

							}
					}
				}
			}
			
			else if(Cn.getText().equals("")&&!Dn.getText().equals("")&&!Year.getText().equals("")&&!Term.getText().equals("")){
				if(Dn.getText().equals("")){//专业名称不可以为空值
					JOptionPane.showMessageDialog(this,"专业名称不能为空");
				}
	
				else{
					byte[] b=Dn.getText().getBytes();
					if(b.length>15){
						JOptionPane.showMessageDialog(this,"专业名称过长");
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
								JOptionPane.showMessageDialog(this,"专业名称不能为纯数字");
							}
							else{
								if(Year.getText().length()!=4){
									JOptionPane.showMessageDialog(this,"学年必须是4位");
								}
								else{
									int k = Integer.parseInt(Year.getText());
									if(!(k>=2000&&k<=2018)){
										JOptionPane.showMessageDialog(this,"学年在2000到2018");
									}
									else{
										if(!(Term.getText().equals("1")||Term.getText().equals("2"))){
											JOptionPane.showMessageDialog(this,"学期1为上半学期，2为下半学期");
										}
										else{
											sql="select  D.dn 专业名,C.cn 课程名,S.sn 姓名,C.cs 学分,SC.score 分数,t_ime._year 学年,t_ime.term 学期 from D,C,S,SC,TC,t_ime "
													+ "where TC.tno='"+id+"' and TC.cno=C.cno and SC.cno=TC.cno and S.dno=D.dno and S.sno=SC.sno and TC.cno=SC.cno and t_ime.term='"+Term.getText()+"' and D.dn='"+Dn.getText()+"' and t_ime._year='"+Year.getText()+"'  and t_ime.cno=C.cno and t_ime.dno=d.dno" ;
											K=new forTSelSC(sql);
										}
									}
								}
							}
							}
					}
				}

			
			else if(!Cn.getText().equals("")&&!Dn.getText().equals("")&&!Year.getText().equals("")&&!Term.getText().equals("")){
				if(Dn.getText().equals("")){//专业名称不可以为空值
					JOptionPane.showMessageDialog(this,"专业名称不能为空");
				}
	
				else{
					byte[] b=Dn.getText().getBytes();
					if(b.length>15){
						JOptionPane.showMessageDialog(this,"专业名称过长");
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
								JOptionPane.showMessageDialog(this,"专业名称不能为纯数字");
							}
							else{
								if(Cn.getText().equals("")){//课程名称不可以为空值
									JOptionPane.showMessageDialog(this,"课程名称不能为空");
								}
					
								else{
									byte[] d=Cn.getText().getBytes();
									if(d.length>30){
										JOptionPane.showMessageDialog(this,"课程名称过长");
									}
									else{
										int l=Cn.getText().length();
										int num2=0;
										for(int j=0;j<l;j++){
											if(Cn.getText().charAt(j)>='0'&&Cn.getText().charAt(j)<='9'){
												num2++;
											}
										}
											if(num2==l){
												JOptionPane.showMessageDialog(this,"课程名称不能为纯数字");
											}
											else{
												if(Year.getText().length()!=4){
													JOptionPane.showMessageDialog(this,"学年必须是4位");
												}
												else{
													int k = Integer.parseInt(Year.getText());
													if(!(k>=2000&&k<=2018)){
														JOptionPane.showMessageDialog(this,"学年在2000到2018");
													}
													else{
														if(!(Term.getText().equals("1")||Term.getText().equals("2"))){
															JOptionPane.showMessageDialog(this,"学期1为上半学期，2为下半学期");
														}
														else{
															sql="select  D.dn 专业名,C.cn 课程名,S.sn 姓名,C.cs 学分,SC.score 分数,t_ime._year 学年,t_ime.term 学期 from D,C,S,SC,TC,t_ime "
																	+ "where TC.tno='"+id+"' and TC.cno=C.cno and SC.cno=TC.cno and S.dno=D.dno and S.sno=SC.sno and TC.cno=SC.cno and t_ime.term='"+Term.getText()+"' and D.dn='"+Dn.getText()+"' and C.cn='"+Cn.getText()+"' and t_ime._year='"+Year.getText()+"'  and t_ime.cno=C.cno and t_ime.dno=d.dno" ;
															K=new forTSelSC(sql);
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
			}
		}
}

class BackgroundPanelTSelSC extends JPanel  
{  
    Image im;  
    public BackgroundPanelTSelSC(Image im)  
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