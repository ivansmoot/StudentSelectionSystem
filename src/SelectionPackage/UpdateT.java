package SelectionPackage;

import java.awt.*;

import javax.swing.*;

import java.sql.*;
import java.awt.event.*;

public class UpdateT extends JPanel implements ActionListener{
	JTextField Tno=new JTextField(20);//教师号
	JTextField Tn=new JTextField(20);//姓名
	JTextField Ty=new JTextField(20);//入职年
	JTextField Tp=new JTextField(20);//密码
	JTextField Dno=new JTextField(20);//专业代码 
	JButton jb=new JButton("修改");//删除按钮
	
	//组件设置
		public UpdateT(){
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
			Box box6=Box.createHorizontalBox();
					
			box1.add(new JLabel("教师号",JLabel.CENTER));
			box1.add(Tno);
			box2.add(new JLabel("新的姓名",JLabel.CENTER));
			box2.add(Tn);
			box3.add(new JLabel("新的入职年",JLabel.CENTER));
			box3.add(Ty);
			box4.add(new JLabel("新的密码",JLabel.CENTER));
			box4.add(Tp);
			box5.add(new JLabel("新的专业代码",JLabel.CENTER));
			box5.add(Dno);
			box6.add(jb);
					
			Box boxH=Box.createVerticalBox();
			boxH.add(box1);
			boxH.add(box2);
			boxH.add(box3);
			boxH.add(box4);
			boxH.add(box5);
			boxH.add(box6);
			boxH.add(Box.createVerticalGlue());
					
			
			BackgroundPanelUpdateT pCenter;//创建面板
			pCenter=new BackgroundPanelUpdateT((new ImageIcon("C:\\Users\\11862\\Pictures\\ZM\\改老师.png")).getImage());
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
			if(obj==jb){
				if(Tno.getText().equals("")){ //教师号可以为空值
					JOptionPane.showMessageDialog(this,"教师号为空");
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
							if(Tn.getText().equals("")&&Ty.getText().equals("")&&Tp.getText().equals("")&&Dno.getText().equals("")){ //不允许全部为空值
								JOptionPane.showMessageDialog(this,"请至少填写一个修改项");
							}
							else{
								Statement stmt=null;//创建接口
								ResultSet rs=null; //声明返回结果
								String sql,sql1,sql2,sql3,sql4;
								sql="select * from T where tno='"+Tno.getText()+"'";
								try{
									CONN co=new CONN();
									Connection dbConn1=co.CO();//添加数据库连接
									stmt=(Statement)dbConn1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
											ResultSet.CONCUR_READ_ONLY);//可以任意向前后移动游标，ResultSet数据只读
									rs=stmt.executeQuery(sql);//executeQuery()方法会把数据库响应的查询结果存放在ResultSet类对象中
									if(!rs.next()){
										JOptionPane.showMessageDialog(this,"教师不存在");
									}
									else{
										if((!Tn.getText().equals(""))&&Ty.getText().equals("")&&Tp.getText().equals("")&&Dno.getText().equals("")){
											if(Tn.getText().length()>4||Tn.getText().length()<2){
												JOptionPane.showMessageDialog(this,"姓名为2至4个汉字");
											}
											else{
												if(!checkname(Tn.getText())){
													JOptionPane.showMessageDialog(this,"姓名必须为汉字");
												}
												else{
													sql1="update T set tn='"+Tn.getText()+"' where tno='"+Tno.getText()+"'";
													stmt.executeUpdate(sql1);
													JOptionPane.showMessageDialog(this, "教师修改成功");
												}
											}
											
										}
										else if(Tn.getText().equals("")&&(!Ty.getText().equals(""))&&Tp.getText().equals("")&&Dno.getText().equals("")){
											if(Ty.getText().length()!=4){
												JOptionPane.showMessageDialog(this,"入职年必须是4位");
											}
											else{
												int i = Integer.parseInt(Ty.getText());
												if(!(i>=2000&&i<=2018)){
													JOptionPane.showMessageDialog(this,"入职年在2000到2018");
												}
												else{
													sql1="update T set ty='"+Ty.getText()+"' where tno='"+Tno.getText()+"'";
													stmt.executeUpdate(sql1);
													JOptionPane.showMessageDialog(this, "教师修改成功");
												}
											}
										}
					
										else if(Tn.getText().equals("")&&Ty.getText().equals("")&&(!Tp.getText().equals(""))&&Dno.getText().equals("")){
											int length3=Tp.getText().length();
											if(length3!=8){
												JOptionPane.showMessageDialog(this,"密码必须为8位数字");
											}
											else{
												int num1=0;
												for(int j=0;j<8;j++){
													if(Tno.getText().charAt(j)>='0'&&Tno.getText().charAt(j)<='9'){
														num1++;
													}
												}
												if(num1!=8){
													JOptionPane.showMessageDialog(this,"密码必须为纯数字");
												}
												else{
													sql1="update T set tp='"+Tp.getText()+"' where tno='"+Tno.getText()+"'";
													stmt.executeUpdate(sql1);
													JOptionPane.showMessageDialog(this, "教师修改成功");
												}
											}
										}
										
										else if(Tn.getText().equals("")&&Ty.getText().equals("")&&Tp.getText().equals("")&&(!Dno.getText().equals(""))){
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
													sql1="update T set dno='"+Dno.getText()+"' where tno='"+Tno.getText()+"'";
													stmt.executeUpdate(sql1);
													JOptionPane.showMessageDialog(this, "教师修改成功");
												}
											}
										}
										
										else if((!Tn.getText().equals(""))&&(!Ty.getText().equals(""))&&Tp.getText().equals("")&&Dno.getText().equals("")){
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
															sql1="update T set tn='"+Tn.getText()+"' where tno='"+Tno.getText()+"'";
															sql2="update T set ty='"+Ty.getText()+"' where tno='"+Tno.getText()+"'";
															stmt.executeUpdate(sql1);
															stmt.executeUpdate(sql2);
															JOptionPane.showMessageDialog(this, "教师修改成功");
														}
													}
												}
											}
										}
										
										else if((!Tn.getText().equals(""))&&Ty.getText().equals("")&&(!Tp.getText().equals(""))&&Dno.getText().equals("")){
											tn:
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
																				sql1="update T set tn='"+Tn.getText()+"' where tno='"+Tno.getText()+"'";
																				sql2="update T set tp='"+Tp.getText()+"' where tno='"+Tno.getText()+"'";
																				stmt.executeUpdate(sql1);
																				stmt.executeUpdate(sql2);
																				JOptionPane.showMessageDialog(this, "教师修改成功");
																			}
																		}
																	}
																}	
										}
										else if((!Tn.getText().equals(""))&&Ty.getText().equals("")&&Tp.getText().equals("")&&(!Dno.getText().equals(""))){
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
															sql1="update T set tn='"+Tn.getText()+"' where tno='"+Tno.getText()+"'";
															sql2="update T set dno='"+Dno.getText()+"' where tno='"+Tno.getText()+"'";
															stmt.executeUpdate(sql1);
															stmt.executeUpdate(sql2);
															JOptionPane.showMessageDialog(this, "教师修改成功");
														}
													}
												}
											}	
										}
										
										else if(Tn.getText().equals("")&&(!Ty.getText().equals(""))&&(!Tp.getText().equals(""))&&Dno.getText().equals("")){
											if(Ty.getText().length()!=4){
												JOptionPane.showMessageDialog(this,"入职年必须是4位");
											}
											else{
												int i = Integer.parseInt(Ty.getText());
												if(!(i>=2000&&i<=2018)){
													JOptionPane.showMessageDialog(this,"入职年在2000到2018");
												}
												else{
													int length3=Tp.getText().length();
													if(length3!=8){
														JOptionPane.showMessageDialog(this,"密码必须为8位数字");
													}
													else{
														int num1=0;
														for(int j=0;j<8;j++){
															if(Tno.getText().charAt(j)>='0'&&Tno.getText().charAt(j)<='9'){
																num1++;
															}
														}
														if(num1!=8){
															JOptionPane.showMessageDialog(this,"密码必须为纯数字");
														}
														else{
															sql1="update T set ty='"+Ty.getText()+"' where tno='"+Tno.getText()+"'";
															sql2="update T set tp='"+Tp.getText()+"' where tno='"+Tno.getText()+"'";
															stmt.executeUpdate(sql1);
															stmt.executeUpdate(sql2);
															JOptionPane.showMessageDialog(this, "教师修改成功");
														}
													}
												}
											}
										}
										
										else if(Tn.getText().equals("")&&(!Ty.getText().equals(""))&&Tp.getText().equals("")&&(!Dno.getText().equals(""))){
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
															sql1="update T set ty='"+Ty.getText()+"' where tno='"+Tno.getText()+"'";
															sql2="update T set dno='"+Dno.getText()+"' where tno='"+Tno.getText()+"'";
															stmt.executeUpdate(sql1);
															stmt.executeUpdate(sql2);
															JOptionPane.showMessageDialog(this, "教师修改成功");
														}
													}
												}
											}			
										}
										
										else if(Tn.getText().equals("")&&Ty.getText().equals("")&&(!Tp.getText().equals(""))&&(!Dno.getText().equals(""))){
											int length3=Tp.getText().length();
											if(length3!=8){
												JOptionPane.showMessageDialog(this,"密码必须为8位数字");
											}
											else{
												int num1=0;
												for(int j=0;j<8;j++){
													if(Tno.getText().charAt(j)>='0'&&Tno.getText().charAt(j)<='9'){
														num1++;
													}
												}
												if(num1!=8){
													JOptionPane.showMessageDialog(this,"密码必须为纯数字");
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
															sql1="update T set tp='"+Tp.getText()+"' where tno='"+Tno.getText()+"'";
															sql2="update T set dno='"+Dno.getText()+"' where tno='"+Tno.getText()+"'";
															stmt.executeUpdate(sql1);
															stmt.executeUpdate(sql2);
															JOptionPane.showMessageDialog(this, "教师修改成功");
														}
													}
												
												}
											}					
										}
										
										else if((!Tn.getText().equals(""))&&(!Ty.getText().equals(""))&&(!Tp.getText().equals(""))&&Dno.getText().equals("")){
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
															int length3=Tp.getText().length();
															if(length3!=8){
																JOptionPane.showMessageDialog(this,"密码必须为8位数字");
															}
															else{
																int num1=0;
																for(int j=0;j<8;j++){
																	if(Tno.getText().charAt(j)>='0'&&Tno.getText().charAt(j)<='9'){
																		num1++;
																	}
																}
																if(num1!=8){
																	JOptionPane.showMessageDialog(this,"密码必须为纯数字");
																}
																else{
																	sql1="update T set tn='"+Tn.getText()+"' where tno='"+Tno.getText()+"'";
																	sql2="update T set ty='"+Ty.getText()+"' where tno='"+Tno.getText()+"'";
																	sql3="update T set tp='"+Tp.getText()+"' where tno='"+Tno.getText()+"'";
																	stmt.executeUpdate(sql1);
																	stmt.executeUpdate(sql2);
																	stmt.executeUpdate(sql3);
																	JOptionPane.showMessageDialog(this, "教师修改成功");					
																}
															}
														}
													}
												}
											}	
										}
										
										else if((!Tn.getText().equals(""))&&(!Ty.getText().equals(""))&&Tp.getText().equals("")&&(!Dno.getText().equals(""))){
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
																	sql1="update T set tn='"+Tn.getText()+"' where tno='"+Tno.getText()+"'";
																	sql2="update T set ty='"+Ty.getText()+"' where tno='"+Tno.getText()+"'";
																	sql3="update T set dno='"+Dno.getText()+"' where tno='"+Tno.getText()+"'";
																	stmt.executeUpdate(sql1);
																	stmt.executeUpdate(sql2);
																	stmt.executeUpdate(sql3);
																	JOptionPane.showMessageDialog(this, "教师修改成功");
																}
															}
														}
													}
												}
											}
										}
										
										else if((!Tn.getText().equals(""))&&Ty.getText().equals("")&&(!Tp.getText().equals(""))&&(!Dno.getText().equals(""))){
											if(Tn.getText().length()>4||Tn.getText().length()<2){
												JOptionPane.showMessageDialog(this,"姓名为2至4个汉字");
											}
											else{
												if(!checkname(Tn.getText())){
													JOptionPane.showMessageDialog(this,"姓名必须为汉字");
												}
												else{
													int length3=Tp.getText().length();
													if(length3!=8){
														JOptionPane.showMessageDialog(this,"密码必须为8位数字");
													}
													else{
														int num1=0;
														for(int j=0;j<8;j++){
															if(Tno.getText().charAt(j)>='0'&&Tno.getText().charAt(j)<='9'){
																num1++;
															}
														}
														if(num1!=8){
															JOptionPane.showMessageDialog(this,"密码必须为纯数字");
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
																	sql1="update T set tn='"+Tn.getText()+"' where tno='"+Tno.getText()+"'";
																	sql2="update T set tp='"+Tp.getText()+"' where tno='"+Tno.getText()+"'";
																	sql3="update T set dno='"+Dno.getText()+"' where tno='"+Tno.getText()+"'";
																	stmt.executeUpdate(sql1);
																	stmt.executeUpdate(sql2);
																	stmt.executeUpdate(sql3);
																	JOptionPane.showMessageDialog(this, "教师修改成功");
																}
															}
														}
													}
												}
											}		
										}
										else if(Tn.getText().equals("")&&(!Ty.getText().equals(""))&&(!Tp.getText().equals(""))&&(!Dno.getText().equals(""))){
											if(Ty.getText().length()!=4){
												JOptionPane.showMessageDialog(this,"入职年必须是4位");
											}
											else{
												int i = Integer.parseInt(Ty.getText());
												if(!(i>=2000&&i<=2018)){
													JOptionPane.showMessageDialog(this,"入职年在2000到2018");
												}
												else{
													int length3=Tp.getText().length();
													if(length3!=8){
														JOptionPane.showMessageDialog(this,"密码必须为8位数字");
													}
													else{
														int num1=0;
														for(int j=0;j<8;j++){
															if(Tno.getText().charAt(j)>='0'&&Tno.getText().charAt(j)<='9'){
																num1++;
															}
														}
														if(num1!=8){
															JOptionPane.showMessageDialog(this,"密码必须为纯数字");
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
																	sql1="update T set ty='"+Ty.getText()+"' where tno='"+Tno.getText()+"'";
																	sql2="update T set tp='"+Tp.getText()+"' where tno='"+Tno.getText()+"'";
																	sql3="update T set dno='"+Dno.getText()+"' where tno='"+Tno.getText()+"'";
																	stmt.executeUpdate(sql1);
																	stmt.executeUpdate(sql2);
																	stmt.executeUpdate(sql3);
																	JOptionPane.showMessageDialog(this, "教师修改成功");
																}
															}
														}
													}
												}
											}							
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
															int length3=Tp.getText().length();
															if(length3!=8){
																JOptionPane.showMessageDialog(this,"密码必须为8位数字");
															}
															else{
																int num1=0;
																for(int j=0;j<8;j++){
																	if(Tno.getText().charAt(j)>='0'&&Tno.getText().charAt(j)<='9'){
																		num1++;
																	}
																}
																if(num1!=8){
																	JOptionPane.showMessageDialog(this,"密码必须为纯数字");
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
																			sql1="update T set tn='"+Tn.getText()+"' where tno='"+Tno.getText()+"'";
																			sql2="update T set ty='"+Ty.getText()+"' where tno='"+Tno.getText()+"'";
																			sql3="update T set tp='"+Tp.getText()+"' where tno='"+Tno.getText()+"'";
																			sql4="update T set dno='"+Dno.getText()+"' where tno='"+Tno.getText()+"'";
																			stmt.executeUpdate(sql1);
																			stmt.executeUpdate(sql2);
																			stmt.executeUpdate(sql3);
																			stmt.executeUpdate(sql4);
																			JOptionPane.showMessageDialog(this, "教师修改成功");
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
							rs.close();
							stmt.close();
						}catch(SQLException e){
							System.out.print("SQL Exception occur.Message is:"+e.getMessage());
						}
					}
				}
			}
		}
			}
}

class BackgroundPanelUpdateT extends JPanel  
{  
    Image im;  
    public BackgroundPanelUpdateT(Image im)  
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
}