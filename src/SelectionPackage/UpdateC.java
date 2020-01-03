package SelectionPackage;

import java.awt.*;

import javax.swing.*;

import java.sql.*;
import java.awt.event.*;

public class UpdateC extends JPanel implements ActionListener{
	JTextField Cno=new JTextField(20);//课程号
	JTextField Cn=new JTextField(20);//课程名
	JTextField Cs=new JTextField(20);//学分
	JTextField Cp=new JTextField(20);//学时
	JTextField Cc=new JTextField(20);//专业性质
	JTextField Dno=new JTextField(20);//专业代码
	JButton jb=new JButton("修改");//删除按钮
	
	//组件设置
		public UpdateC(){
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
			Box box7=Box.createHorizontalBox();
			
			
			box1.add(new JLabel("课程号",JLabel.CENTER));
			box1.add(Cno);
			box2.add(new JLabel("新的课程名",JLabel.CENTER));
			box2.add(Cn);
			box3.add(new JLabel("新的学分",JLabel.CENTER));
			box3.add(Cs);
			box4.add(new JLabel("新的学时",JLabel.CENTER));
			box4.add(Cp);
			box5.add(new JLabel("新的性质",JLabel.CENTER));
			box5.add(Cc);
			box6.add(new JLabel("新的专业代码",JLabel.CENTER));
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
					
			BackgroundPanelUpdateC jp;//创建面板
			jp=new BackgroundPanelUpdateC((new ImageIcon("C:\\Users\\11862\\Pictures\\ZM\\改课.png")).getImage());
			jp.add(boxH);
			setLayout(new BorderLayout()); //边框布局
			add(jp,BorderLayout.CENTER);
			validate();
		}
		
		//动作事件执行
		public void actionPerformed(ActionEvent c){
			Object obj=c.getSource();
			if(obj==jb){
				if(Cno.getText().equals("")){ //课程号可以为空值
					JOptionPane.showMessageDialog(this,"课程号不能为空");
				}
				else{
					if(Cn.getText().equals("")&&Cs.getText().equals("")&&Cp.getText().equals("")&&Cc.getText().equals("")&&Dno.getText().equals("")){ //不允许全部为空值
						JOptionPane.showMessageDialog(this,"请至少填写一个修改项");
					}
					else{
						Statement stmt=null;//创建接口
						ResultSet rs=null; //声明返回结果
						String sql,sql1,sql2,sql3,sql4,sql5;
						sql="select * from C where cno='"+Cno.getText()+"'";
						try{
							CONN co=new CONN();
							Connection dbConn1=co.CO();//添加数据库连接
							stmt=(Statement)dbConn1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
									ResultSet.CONCUR_READ_ONLY);//可以任意向前后移动游标，ResultSet数据只读
							rs=stmt.executeQuery(sql);//executeQuery()方法会把数据库响应的查询结果存放在ResultSet类对象中
							if(!rs.next()){
								JOptionPane.showMessageDialog(this,"课程不存在");
							}
							else{
								if((!Cn.getText().equals(""))&&Cs.getText().equals("")&&Cp.getText().equals("")&&Cc.getText().equals("")&&Dno.getText().equals("")){
									sql1="update C set Cn='"+Cn.getText()+"' where cno='"+Cno.getText()+"'";
									stmt.executeUpdate(sql1);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									JOptionPane.showMessageDialog(this, "课程修改成功");
								}
								else if(Cn.getText().equals("")&&(!Cs.getText().equals(""))&&Cp.getText().equals("")&&Cc.getText().equals("")&&Dno.getText().equals("")){
									sql1="update C set Cs='"+Cs.getText()+"' where Cno='"+Cno.getText()+"'";
									stmt.executeUpdate(sql1);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									JOptionPane.showMessageDialog(this, "课程修改成功");
								}
								else if(Cn.getText().equals("")&&Cs.getText().equals("")&&(!Cp.getText().equals(""))&&Cc.getText().equals("")&&Dno.getText().equals("")){
									sql1="update C set cp='"+Cp.getText()+"' where Cno='"+Cno.getText()+"'";
									stmt.executeUpdate(sql1);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									JOptionPane.showMessageDialog(this, "课程修改成功");
								}
								else if(Cn.getText().equals("")&&Cs.getText().equals("")&&Cp.getText().equals("")&&!Cc.getText().equals("")&&(Dno.getText().equals(""))){
									sql1="update C set cc='"+Cc.getText()+"' where Cno='"+Cno.getText()+"'";
									stmt.executeUpdate(sql1);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									JOptionPane.showMessageDialog(this, "课程修改成功");
								}
								else if(Cn.getText().equals("")&&Cs.getText().equals("")&&Cp.getText().equals("")&&Cc.getText().equals("")&&(!Dno.getText().equals(""))){
									sql1="update C set dno='"+Dno.getText()+"' where Cno='"+Cno.getText()+"'";
									stmt.executeUpdate(sql1);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									JOptionPane.showMessageDialog(this, "课程修改成功");
								}
								else if((!Cn.getText().equals(""))&&(!Cs.getText().equals(""))&&Cp.getText().equals("")&&Cc.getText().equals("")&&Dno.getText().equals("")){
									sql1="update C set Cn='"+Cn.getText()+"' where cno='"+Cno.getText()+"'";
									sql2="update C set Cs='"+Cs.getText()+"' where cno='"+Cno.getText()+"'";
									stmt.executeUpdate(sql1);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									stmt.executeUpdate(sql2);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									JOptionPane.showMessageDialog(this, "课程修改成功");
								}
								else if((!Cn.getText().equals(""))&&Cs.getText().equals("")&&!Cp.getText().equals("")&&Cc.getText().equals("")&&(Dno.getText().equals(""))){
									sql1="update C set Cn='"+Cn.getText()+"' where cno='"+Cno.getText()+"'";
									sql2="update C set cp='"+Cp.getText()+"' where cno='"+Cno.getText()+"'";
									stmt.executeUpdate(sql1);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									stmt.executeUpdate(sql2);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									JOptionPane.showMessageDialog(this, "课程修改成功");
								}
								else if((!Cn.getText().equals(""))&&Cs.getText().equals("")&&Cp.getText().equals("")&&!Cc.getText().equals("")&&(Dno.getText().equals(""))){
									sql1="update C set Cn='"+Cn.getText()+"' where cno='"+Cno.getText()+"'";
									sql2="update C set cc='"+Cc.getText()+"' where cno='"+Cno.getText()+"'";
									stmt.executeUpdate(sql1);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									stmt.executeUpdate(sql2);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									JOptionPane.showMessageDialog(this, "课程修改成功");
								}
								else if((!Cn.getText().equals(""))&&Cs.getText().equals("")&&(Cp.getText().equals(""))&&Cc.getText().equals("")&&!Dno.getText().equals("")){
									sql1="update C set cn='"+Cn.getText()+"' where cno='"+Cno.getText()+"'";
									sql2="update C set dno='"+Dno.getText()+"' where cno='"+Cno.getText()+"'";
									stmt.executeUpdate(sql1);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									stmt.executeUpdate(sql2);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									JOptionPane.showMessageDialog(this, "课程修改成功");
								}
								else if((Cn.getText().equals(""))&&!Cs.getText().equals("")&&!Cp.getText().equals("")&&Cc.getText().equals("")&&(Dno.getText().equals(""))){
									sql1="update C set Cs='"+Cs.getText()+"' where cno='"+Cno.getText()+"'";
									sql2="update C set cp='"+Cp.getText()+"' where cno='"+Cno.getText()+"'";
									stmt.executeUpdate(sql1);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									stmt.executeUpdate(sql2);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									JOptionPane.showMessageDialog(this, "课程修改成功");
								}
								
								else if(Cn.getText().equals("")&&(!Cs.getText().equals(""))&&(Cp.getText().equals(""))&&!Cc.getText().equals("")&&Dno.getText().equals("")){
									sql1="update C set cs='"+Cs.getText()+"' where cno='"+Cno.getText()+"'";
									sql2="update C set cc='"+Cc.getText()+"' where cno='"+Cno.getText()+"'";
									stmt.executeUpdate(sql1);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									stmt.executeUpdate(sql2);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									JOptionPane.showMessageDialog(this, "课程修改成功");
								}
								else if(Cn.getText().equals("")&&(!Cs.getText().equals(""))&&Cp.getText().equals("")&&Cc.getText().equals("")&&(!Dno.getText().equals(""))){
									sql1="update C set cs='"+Cs.getText()+"' where cno='"+Cno.getText()+"'";
									sql2="update C set dno='"+Dno.getText()+"' where cno='"+Cno.getText()+"'";
									stmt.executeUpdate(sql1);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									stmt.executeUpdate(sql2);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									JOptionPane.showMessageDialog(this, "课程修改成功");
								}
								else if(Cn.getText().equals("")&&Cs.getText().equals("")&&(!Cp.getText().equals(""))&&!Cc.getText().equals("")&&(Dno.getText().equals(""))){
									sql1="update C set cp='"+Cp.getText()+"' where cno='"+Cno.getText()+"'";
									sql2="update C set cc='"+Cc.getText()+"' where cno='"+Cno.getText()+"'";
									stmt.executeUpdate(sql1);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									stmt.executeUpdate(sql2);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									JOptionPane.showMessageDialog(this, "课程修改成功");
								}
								else if(Cn.getText().equals("")&&Cs.getText().equals("")&&(!Cp.getText().equals(""))&&Cc.getText().equals("")&&(!Dno.getText().equals(""))){
									sql1="update C set cp='"+Cp.getText()+"' where cno='"+Cno.getText()+"'";
									sql2="update C set dno='"+Dno.getText()+"' where Cno='"+Cno.getText()+"'";
									stmt.executeUpdate(sql1);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									stmt.executeUpdate(sql2);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									JOptionPane.showMessageDialog(this, "课程修改成功");
								}
								else if(Cn.getText().equals("")&&Cs.getText().equals("")&&(Cp.getText().equals(""))&&!Cc.getText().equals("")&&(!Dno.getText().equals(""))){
									sql1="update C set cc='"+Cc.getText()+"' where Cno='"+Cno.getText()+"'";
									sql2="update C set dno='"+Dno.getText()+"' where Cno='"+Cno.getText()+"'";
									stmt.executeUpdate(sql1);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									stmt.executeUpdate(sql2);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									JOptionPane.showMessageDialog(this, "课程修改成功");
								}
								else if(!Cn.getText().equals("")&&!Cs.getText().equals("")&&(!Cp.getText().equals(""))&&Cc.getText().equals("")&&Dno.getText().equals("")){
									sql1="update C set cn='"+Cn.getText()+"' where Cno='"+Cno.getText()+"'";
									sql2="update C set cs='"+Cs.getText()+"' where Cno='"+Cno.getText()+"'";
									sql3="update C set cp='"+Cp.getText()+"' where Cno='"+Cno.getText()+"'";
									stmt.executeUpdate(sql1);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									stmt.executeUpdate(sql2);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									stmt.executeUpdate(sql3);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									JOptionPane.showMessageDialog(this, "课程修改成功");
								}
								else if((!Cn.getText().equals(""))&&(!Cs.getText().equals(""))&&Cp.getText().equals("")&&!Cc.getText().equals("")&&(Dno.getText().equals(""))){
									sql1="update C set cn='"+Cn.getText()+"' where cno='"+Cno.getText()+"'";
									sql2="update C set cs='"+Cs.getText()+"' where cno='"+Cno.getText()+"'";
									sql3="update C set cc='"+Cc.getText()+"' where cno='"+Cno.getText()+"'";
									stmt.executeUpdate(sql1);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									stmt.executeUpdate(sql2);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									stmt.executeUpdate(sql3);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									JOptionPane.showMessageDialog(this, "课程修改成功");
								}
								else if((!Cn.getText().equals(""))&&(!Cs.getText().equals(""))&&Cp.getText().equals("")&&Cc.getText().equals("")&&(!Dno.getText().equals(""))){
									sql1="update C set cn='"+Cn.getText()+"' where cno='"+Cno.getText()+"'";
									sql2="update C set cs='"+Cs.getText()+"' where cno='"+Cno.getText()+"'";
									sql3="update C set dno='"+Dno.getText()+"' where cno='"+Cno.getText()+"'";
									stmt.executeUpdate(sql1);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									stmt.executeUpdate(sql2);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									stmt.executeUpdate(sql3);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									JOptionPane.showMessageDialog(this, "课程修改成功");
								}
								else if((!Cn.getText().equals(""))&&(Cs.getText().equals(""))&&!Cp.getText().equals("")&&!Cc.getText().equals("")&&(Dno.getText().equals(""))){
									sql1="update C set cn='"+Cn.getText()+"' where cno='"+Cno.getText()+"'";
									sql2="update C set cp='"+Cp.getText()+"' where cno='"+Cno.getText()+"'";
									sql3="update C set cc='"+Cc.getText()+"' where cno='"+Cno.getText()+"'";
									stmt.executeUpdate(sql1);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									stmt.executeUpdate(sql2);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									stmt.executeUpdate(sql3);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									JOptionPane.showMessageDialog(this, "课程修改成功");
								}
								else if((!Cn.getText().equals(""))&&(Cs.getText().equals(""))&&!Cp.getText().equals("")&&Cc.getText().equals("")&&(!Dno.getText().equals(""))){
									sql1="update C set cn='"+Cn.getText()+"' where cno='"+Cno.getText()+"'";
									sql2="update C set cp='"+Cp.getText()+"' where cno='"+Cno.getText()+"'";
									sql3="update C set dno='"+Dno.getText()+"' where cno='"+Cno.getText()+"'";
									stmt.executeUpdate(sql1);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									stmt.executeUpdate(sql2);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									stmt.executeUpdate(sql3);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									JOptionPane.showMessageDialog(this, "课程修改成功");
								}
								else if((!Cn.getText().equals(""))&&(Cs.getText().equals(""))&&Cp.getText().equals("")&&!Cc.getText().equals("")&&(!Dno.getText().equals(""))){
									sql1="update C set cn='"+Cn.getText()+"' where cno='"+Cno.getText()+"'";
									sql2="update C set cc='"+Cc.getText()+"' where cno='"+Cno.getText()+"'";
									sql3="update C set dno='"+Dno.getText()+"' where cno='"+Cno.getText()+"'";
									stmt.executeUpdate(sql1);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									stmt.executeUpdate(sql2);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									stmt.executeUpdate(sql3);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									JOptionPane.showMessageDialog(this, "课程修改成功");
								}
								else if((!Cn.getText().equals(""))&&(!Cs.getText().equals(""))&&!Cp.getText().equals("")&&!Cc.getText().equals("")&&(Dno.getText().equals(""))){
									sql1="update C set cn='"+Cn.getText()+"' where cno='"+Cno.getText()+"'";
									sql2="update C set cs='"+Cs.getText()+"' where cno='"+Cno.getText()+"'";
									sql3="update C set cp='"+Cp.getText()+"' where cno='"+Cno.getText()+"'";
									sql4="update C set cc='"+Cc.getText()+"' where cno='"+Cno.getText()+"'";
									stmt.executeUpdate(sql1);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									stmt.executeUpdate(sql2);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									stmt.executeUpdate(sql3);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									stmt.executeUpdate(sql4);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									JOptionPane.showMessageDialog(this, "课程修改成功");
								}
								else if((!Cn.getText().equals(""))&&(!Cs.getText().equals(""))&&Cp.getText().equals("")&&!Cc.getText().equals("")&&(!Dno.getText().equals(""))){
									sql1="update C set cn='"+Cn.getText()+"' where cno='"+Cno.getText()+"'";
									sql2="update C set cs='"+Cs.getText()+"' where cno='"+Cno.getText()+"'";
									sql3="update C set cc='"+Cc.getText()+"' where cno='"+Cno.getText()+"'";
									sql4="update C set dno='"+Dno.getText()+"' where cno='"+Cno.getText()+"'";
									stmt.executeUpdate(sql1);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									stmt.executeUpdate(sql2);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									stmt.executeUpdate(sql3);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									stmt.executeUpdate(sql4);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									JOptionPane.showMessageDialog(this, "课程修改成功");
								}
								else if((!Cn.getText().equals(""))&&(!Cs.getText().equals(""))&&!Cp.getText().equals("")&&Cc.getText().equals("")&&(!Dno.getText().equals(""))){
									sql1="update C set cn='"+Cn.getText()+"' where cno='"+Cno.getText()+"'";
									sql2="update C set cs='"+Cs.getText()+"' where cno='"+Cno.getText()+"'";
									sql3="update C set cp='"+Cp.getText()+"' where cno='"+Cno.getText()+"'";
									sql4="update C set dno='"+Dno.getText()+"' where cno='"+Cno.getText()+"'";
									stmt.executeUpdate(sql1);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									stmt.executeUpdate(sql2);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									stmt.executeUpdate(sql3);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									stmt.executeUpdate(sql4);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									JOptionPane.showMessageDialog(this, "课程修改成功");
								}
								else if((!Cn.getText().equals(""))&&(Cs.getText().equals(""))&&!Cp.getText().equals("")&&!Cc.getText().equals("")&&(!Dno.getText().equals(""))){
									sql1="update C set cn='"+Cn.getText()+"' where cno='"+Cno.getText()+"'";
									sql2="update C set cp='"+Cp.getText()+"' where cno='"+Cno.getText()+"'";
									sql3="update C set cc='"+Cc.getText()+"' where cno='"+Cno.getText()+"'";
									sql4="update C set dno='"+Dno.getText()+"' where cno='"+Cno.getText()+"'";
									stmt.executeUpdate(sql1);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									stmt.executeUpdate(sql2);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									stmt.executeUpdate(sql3);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									stmt.executeUpdate(sql4);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									JOptionPane.showMessageDialog(this, "课程修改成功");
								}
								else if((!Cn.getText().equals(""))&&(!Cs.getText().equals(""))&&!Cp.getText().equals("")&&!Cc.getText().equals("")&&(!Dno.getText().equals(""))){
									sql1="update C set cn='"+Cn.getText()+"' where cno='"+Cno.getText()+"'";
									sql2="update C set cp='"+Cp.getText()+"' where cno='"+Cno.getText()+"'";
									sql3="update C set cs='"+Cs.getText()+"' where cno='"+Cno.getText()+"'";
									sql4="update C set cc='"+Cc.getText()+"' where cno='"+Cno.getText()+"'";
									sql5="update C set dno='"+Dno.getText()+"' where cno='"+Cno.getText()+"'";
									stmt.executeUpdate(sql1);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									stmt.executeUpdate(sql2);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									stmt.executeUpdate(sql3);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									stmt.executeUpdate(sql4);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									JOptionPane.showMessageDialog(this, "课程修改成功");
								}
							}
							rs.close();
							stmt.close();
						}catch(SQLException e){
							System.out.print("SQL?Exception?occur.Message?is:"+e.getMessage());
						}
					}
				}
			}
		}
}

class BackgroundPanelUpdateC extends JPanel  
{  
    Image im;  
    public BackgroundPanelUpdateC(Image im)  
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