package SelectionPackage;

import java.awt.*;

import javax.swing.*;

import java.sql.*;
import java.awt.event.*;

public class TSelSC extends JPanel implements ActionListener{
	JTextField Cn=new JTextField(20);//�γ�����
	JTextField Dn=new JTextField(20);//רҵ����
	JTextField Year=new JTextField(20);//ѧ��
	JTextField Term=new JTextField(20);//ѧ��
	JButton jb=new JButton("����");
	String id;
	public TSelSC(String id1){
		id=id1;
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
				
		box1.add(new JLabel("�γ�����",JLabel.CENTER));
		box1.add(Cn);
		box2.add(new JLabel("רҵ����",JLabel.CENTER));
		box2.add(Dn);
		box3.add(new JLabel("ѧ��",JLabel.CENTER));
		box3.add(Year);
		box4.add(new JLabel("ѧ��",JLabel.CENTER));
		box4.add(Term);
		box5.add(jb);
		
		Box boxH=Box.createVerticalBox();
		boxH.add(box1);
		boxH.add(box2);
		boxH.add(box3);
		boxH.add(box4);
		boxH.add(box5);
		boxH.add(Box.createVerticalGlue());
		
		BackgroundPanelTSelSC pCenter;//�������
		pCenter=new BackgroundPanelTSelSC((new ImageIcon("C:\\Users\\11862\\Pictures\\ZM\\�ò�ɼ���.png")).getImage());
		pCenter.add(boxH);
		setLayout(new BorderLayout()); //�߿򲼾�
		add(pCenter,BorderLayout.CENTER);
		validate();
	}
	
	public void actionPerformed(ActionEvent c){
		Object obj=c.getSource();
		Statement stmt=null;//�����ӿ�
		ResultSet rs=null; //�������ؽ��
		String sql=null;
		forTSelSC K;
		if(obj==jb){
			if(Cn.getText().equals("")&&Dn.getText().equals("")&&Year.getText().equals("")&&Term.getText().equals("")){
				sql="select  D.dn רҵ��,C.cn �γ���,S.sn ����,C.cs ѧ��,SC.score ����,t_ime._year ѧ��,t_ime.term ѧ�� from D,C,S,SC,TC,t_ime "
						+ "where TC.tno='"+id+"' and TC.cno=C.cno and SC.cno=TC.cno and S.dno=D.dno and S.sno=SC.sno and TC.cno=SC.cno and t_ime.cno=C.cno and t_ime.dno=d.dno " ;
				K=new forTSelSC(sql);
			}
			else if(Cn.getText().equals("")&&!Dn.getText().equals("")&&Year.getText().equals("")&&Term.getText().equals("")){
				if(Dn.getText().equals("")){//רҵ���Ʋ�����Ϊ��ֵ
					JOptionPane.showMessageDialog(this,"רҵ���Ʋ���Ϊ��");
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
								sql="select  D.dn רҵ��,C.cn �γ���,S.sn ����,C.cs ѧ��,SC.score ����,t_ime._year ѧ��,t_ime.term ѧ�� from D,C,S,SC,TC,t_ime "
										+ "where TC.tno='"+id+"' and TC.cno=C.cno and SC.cno=TC.cno and S.dno=D.dno and S.sno=SC.sno and TC.cno=SC.cno and D.dn='"+Dn.getText()+"' and t_ime.cno=C.cno and t_ime.dno=d.dno" ;
								K=new forTSelSC(sql);
							}
					}
				}
			}
			else if(!Cn.getText().equals("")&&Dn.getText().equals("")&&Year.getText().equals("")&&Term.getText().equals("")){
				if(Cn.getText().equals("")){//�γ����Ʋ�����Ϊ��ֵ
					JOptionPane.showMessageDialog(this,"�γ����Ʋ���Ϊ��");
				}
	
				else{
					byte[] b=Cn.getText().getBytes();
					if(b.length>30){
						JOptionPane.showMessageDialog(this,"�γ����ƹ���");
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
								JOptionPane.showMessageDialog(this,"�γ����Ʋ���Ϊ������");
							}
							else{
								sql="select  D.dn רҵ��,C.cn �γ���,S.sn ����,C.cs ѧ��,SC.score ����,t_ime._year ѧ��,t_ime.term ѧ�� from D,C,S,SC,TC,t_ime "
										+ "where TC.tno='"+id+"' and TC.cno=C.cno and SC.cno=TC.cno and S.dno=D.dno and S.sno=SC.sno and TC.cno=SC.cno and C.cn='"+Cn.getText()+"'  and t_ime.cno=C.cno and t_ime.dno=d.dno" ;
								K=new forTSelSC(sql);
							}
					}
				}
			}
			
			else if(Cn.getText().equals("")&&Dn.getText().equals("")&&!Year.getText().equals("")&&Term.getText().equals("")){
				if(Year.getText().length()!=4){
					JOptionPane.showMessageDialog(this,"ѧ�������4λ");
				}
				else{
					int i = Integer.parseInt(Year.getText());
					if(!(i>=2000&&i<=2018)){
						JOptionPane.showMessageDialog(this,"ѧ����2000��2018");
					}
					else{
						sql="select  D.dn רҵ��,C.cn �γ���,S.sn ����,C.cs ѧ��,SC.score ����,t_ime._year ѧ��,t_ime.term ѧ�� from D,C,S,SC,TC,t_ime "
								+ "where TC.tno='"+id+"' and TC.cno=C.cno and SC.cno=TC.cno and S.dno=D.dno and S.sno=SC.sno and TC.cno=SC.cno and t_ime._year='"+Year.getText()+"'  and t_ime.cno=C.cno and t_ime.dno=d.dno" ;
						K=new forTSelSC(sql);
					}
				}
			}
			
			else if(Cn.getText().equals("")&&Dn.getText().equals("")&&Year.getText().equals("")&&!Term.getText().equals("")){
				JOptionPane.showMessageDialog(this,"������ֻ��ѧ�ڲ���ѧ��");
			}
			
			else if(!Cn.getText().equals("")&&!Dn.getText().equals("")&&Year.getText().equals("")&&Term.getText().equals("")){
				Dn:
					if(Dn.getText().equals("")){//רҵ���Ʋ�����Ϊ��ֵ
										JOptionPane.showMessageDialog(this,"רҵ���Ʋ���Ϊ��");
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
													if(Cn.getText().equals("")){//�γ����Ʋ�����Ϊ��ֵ
														JOptionPane.showMessageDialog(this,"�γ����Ʋ���Ϊ��");
													}
										
													else{
														byte[] d=Cn.getText().getBytes();
														if(d.length>30){
															JOptionPane.showMessageDialog(this,"�γ����ƹ���");
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
																	JOptionPane.showMessageDialog(this,"�γ����Ʋ���Ϊ������");
																}
																else{
																	sql="select  D.dn רҵ��,C.cn �γ���,S.sn ����,C.cs ѧ��,SC.score ����,t_ime._year ѧ��,t_ime.term ѧ�� from D,C,S,SC,TC,t_ime "
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
				if(Cn.getText().equals("")){//�γ����Ʋ�����Ϊ��ֵ
					JOptionPane.showMessageDialog(this,"�γ����Ʋ���Ϊ��");
				}
	
				else{
					byte[] b=Cn.getText().getBytes();
					if(b.length>30){
						JOptionPane.showMessageDialog(this,"�γ����ƹ���");
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
								JOptionPane.showMessageDialog(this,"�γ����Ʋ���Ϊ������");
							}
							else{
								if(Year.getText().length()!=4){
									JOptionPane.showMessageDialog(this,"ѧ�������4λ");
								}
								else{
									int j = Integer.parseInt(Year.getText());
									if(!(j>=2000&&j<=2018)){
										JOptionPane.showMessageDialog(this,"ѧ����2000��2018");
									}
									else{
										sql="select  D.dn רҵ��,C.cn �γ���,S.sn ����,C.cs ѧ��,SC.score ����,t_ime._year ѧ��,t_ime.term ѧ�� from D,C,S,SC,TC,t_ime "
												+ "where TC.tno='"+id+"' and TC.cno=C.cno and SC.cno=TC.cno and S.dno=D.dno and S.sno=SC.sno and TC.cno=SC.cno and t_ime._year='"+Year.getText()+"' and C.cn='"+Cn.getText()+"' and t_ime.cno=C.cno and t_ime.dno=d.dno" ;
										K=new forTSelSC(sql);
									}
								}
							}
							}
					}
				}
			
			
			else if(!Cn.getText().equals("")&&Dn.getText().equals("")&&Year.getText().equals("")&&!Term.getText().equals("")){
				JOptionPane.showMessageDialog(this,"������ֻ��ѧ�ڲ���ѧ��");
			}
		
			else if(Cn.getText().equals("")&&!Dn.getText().equals("")&&!Year.getText().equals("")&&Term.getText().equals("")){
				if(Dn.getText().equals("")){//רҵ���Ʋ�����Ϊ��ֵ
					JOptionPane.showMessageDialog(this,"רҵ���Ʋ���Ϊ��");
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
								if(Year.getText().length()!=4){
									JOptionPane.showMessageDialog(this,"ѧ�������4λ");
								}
								else{
									int k = Integer.parseInt(Year.getText());
									if(!(k>=2000&&k<=2018)){
										JOptionPane.showMessageDialog(this,"ѧ����2000��2018");
									}
									else{
										sql="select  D.dn רҵ��,C.cn �γ���,S.sn ����,C.cs ѧ��,SC.score ����,t_ime._year ѧ��,t_ime.term ѧ�� from D,C,S,SC,TC,t_ime "
												+ "where TC.tno='"+id+"' and TC.cno=C.cno and SC.cno=TC.cno and S.dno=D.dno and S.sno=SC.sno and TC.cno=SC.cno and t_ime._year='"+Year.getText()+"' and D.dn='"+Dn.getText()+"'  and t_ime.cno=C.cno and t_ime.dno=d.dno" ;
										K=new forTSelSC(sql);
									}
								}
							}
							}
					}
				}
			
			else if(Cn.getText().equals("")&&!Dn.getText().equals("")&&Year.getText().equals("")&&!Term.getText().equals("")){
				JOptionPane.showMessageDialog(this,"������ֻ��ѧ�ڲ���ѧ��");
			}
			
			else if(Cn.getText().equals("")&&Dn.getText().equals("")&&!Year.getText().equals("")&&!Term.getText().equals("")){
				if(Year.getText().length()!=4){
					JOptionPane.showMessageDialog(this,"ѧ�������4λ");
				}
				else{
					int i = Integer.parseInt(Year.getText());
					if(!(i>=2000&&i<=2018)){
						JOptionPane.showMessageDialog(this,"ѧ����2000��2018");
					}
					else{
						if(!(Term.getText().equals("1")||Term.getText().equals("2"))){
							JOptionPane.showMessageDialog(this,"ѧ��1Ϊ�ϰ�ѧ�ڣ�2Ϊ�°�ѧ��");
						}
						else{
							sql="select  D.dn רҵ��,C.cn �γ���,S.sn ����,C.cs ѧ��,SC.score ����,t_ime._year ѧ��,t_ime.term ѧ�� from D,C,S,SC,TC,t_ime "
									+ "where TC.tno='"+id+"' and TC.cno=C.cno and SC.cno=TC.cno and S.dno=D.dno and S.sno=SC.sno and TC.cno=SC.cno and t_ime.term='"+Term.getText()+"' and t_ime._year='"+Year.getText()+"' and t_ime.cno=C.cno and t_ime.dno=d.dno" ;
							K=new forTSelSC(sql);
						}
					}
				}
			}

			
			else if(!Cn.getText().equals("")&&!Dn.getText().equals("")&&!Year.getText().equals("")&&Term.getText().equals("")){
				if(Dn.getText().equals("")){//רҵ���Ʋ�����Ϊ��ֵ
					JOptionPane.showMessageDialog(this,"רҵ���Ʋ���Ϊ��");
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
								if(Cn.getText().equals("")){//�γ����Ʋ�����Ϊ��ֵ
									JOptionPane.showMessageDialog(this,"�γ����Ʋ���Ϊ��");
								}
					
								else{
									byte[] d=Cn.getText().getBytes();
									if(d.length>30){
										JOptionPane.showMessageDialog(this,"�γ����ƹ���");
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
												JOptionPane.showMessageDialog(this,"�γ����Ʋ���Ϊ������");
											}
											else{
												if(Year.getText().length()!=4){
													JOptionPane.showMessageDialog(this,"ѧ�������4λ");
												}
												else{
													int j = Integer.parseInt(Year.getText());
													if(!(j>=2000&&j<=2018)){
														JOptionPane.showMessageDialog(this,"ѧ����2000��2018");
													}
													else{
														sql="select  D.dn רҵ��,C.cn �γ���,S.sn ����,C.cs ѧ��,SC.score ����,t_ime._year ѧ��,t_ime.term ѧ�� from D,C,S,SC,TC,t_ime "
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
				JOptionPane.showMessageDialog(this,"������ֻ��ѧ�ڲ���ѧ��");
			}
			
			else if(!Cn.getText().equals("")&&Dn.getText().equals("")&&!Year.getText().equals("")&&!Term.getText().equals("")){
				if(Cn.getText().equals("")){//�γ����Ʋ�����Ϊ��ֵ
					JOptionPane.showMessageDialog(this,"�γ����Ʋ���Ϊ��");
				}
	
				else{
					byte[] b=Cn.getText().getBytes();
					if(b.length>30){
						JOptionPane.showMessageDialog(this,"�γ����ƹ���");
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
								JOptionPane.showMessageDialog(this,"�γ����Ʋ���Ϊ������");
							}
							else{
								if(Year.getText().length()!=4){
									JOptionPane.showMessageDialog(this,"ѧ�������4λ");
								}
								else{
									int k = Integer.parseInt(Year.getText());
									if(!(k>=2000&&k<=2018)){
										JOptionPane.showMessageDialog(this,"ѧ����2000��2018");
									}
									else{
										if(!(Term.getText().equals("1")||Term.getText().equals("2"))){
											JOptionPane.showMessageDialog(this,"ѧ��1Ϊ�ϰ�ѧ�ڣ�2Ϊ�°�ѧ��");
										}
										else{
											sql="select  D.dn רҵ��,C.cn �γ���,S.sn ����,C.cs ѧ��,SC.score ����,t_ime._year ѧ��,t_ime.term ѧ�� from D,C,S,SC,TC,t_ime "
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
				if(Dn.getText().equals("")){//רҵ���Ʋ�����Ϊ��ֵ
					JOptionPane.showMessageDialog(this,"רҵ���Ʋ���Ϊ��");
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
								if(Year.getText().length()!=4){
									JOptionPane.showMessageDialog(this,"ѧ�������4λ");
								}
								else{
									int k = Integer.parseInt(Year.getText());
									if(!(k>=2000&&k<=2018)){
										JOptionPane.showMessageDialog(this,"ѧ����2000��2018");
									}
									else{
										if(!(Term.getText().equals("1")||Term.getText().equals("2"))){
											JOptionPane.showMessageDialog(this,"ѧ��1Ϊ�ϰ�ѧ�ڣ�2Ϊ�°�ѧ��");
										}
										else{
											sql="select  D.dn רҵ��,C.cn �γ���,S.sn ����,C.cs ѧ��,SC.score ����,t_ime._year ѧ��,t_ime.term ѧ�� from D,C,S,SC,TC,t_ime "
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
				if(Dn.getText().equals("")){//רҵ���Ʋ�����Ϊ��ֵ
					JOptionPane.showMessageDialog(this,"רҵ���Ʋ���Ϊ��");
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
								if(Cn.getText().equals("")){//�γ����Ʋ�����Ϊ��ֵ
									JOptionPane.showMessageDialog(this,"�γ����Ʋ���Ϊ��");
								}
					
								else{
									byte[] d=Cn.getText().getBytes();
									if(d.length>30){
										JOptionPane.showMessageDialog(this,"�γ����ƹ���");
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
												JOptionPane.showMessageDialog(this,"�γ����Ʋ���Ϊ������");
											}
											else{
												if(Year.getText().length()!=4){
													JOptionPane.showMessageDialog(this,"ѧ�������4λ");
												}
												else{
													int k = Integer.parseInt(Year.getText());
													if(!(k>=2000&&k<=2018)){
														JOptionPane.showMessageDialog(this,"ѧ����2000��2018");
													}
													else{
														if(!(Term.getText().equals("1")||Term.getText().equals("2"))){
															JOptionPane.showMessageDialog(this,"ѧ��1Ϊ�ϰ�ѧ�ڣ�2Ϊ�°�ѧ��");
														}
														else{
															sql="select  D.dn רҵ��,C.cn �γ���,S.sn ����,C.cs ѧ��,SC.score ����,t_ime._year ѧ��,t_ime.term ѧ�� from D,C,S,SC,TC,t_ime "
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
        this.setOpaque(true);                    //���ÿؼ���͸��,����false,��ô����͸��
    }  
    //Draw the background again,�̳���Jpanle,��Swing�ؼ���Ҫ�̳�ʵ�ֵķ���,������AWT�е�Paint()
    public void paintComponent(Graphics g)       //��ͼ��,����ɼ�������Java �� java-Graphics 
    {  
        super.paintComponents(g);  
        g.drawImage(im,0,0,this.getWidth(),this.getHeight(),this);  //����ָ��ͼ���е�ǰ���õ�ͼ��ͼ������Ͻ�λ�ڸ�ͼ������������ռ�� (x, y)��ͼ���е�͸�����ز�Ӱ��ô��Ѵ��ڵ�����

    }  
}