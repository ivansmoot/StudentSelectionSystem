package SelectionPackage;

import java.awt.*;

import javax.swing.*;

import java.sql.*;
import java.awt.event.*;

public class UpdateS extends JPanel implements ActionListener{
	JTextField Sno=new JTextField(20);//学号
	JTextField Sn=new JTextField(20);//姓名
	JTextField Ssex=new JTextField(20);//性别
	JTextField Sy=new JTextField(20);//入学年
	JTextField Sp=new JTextField(20);//密码
	JTextField Dno=new JTextField(20);//专业代码
	JButton jb=new JButton("修改");//修改按钮 
	
	//组件设置
		public UpdateS(){
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
		;
					
			box1.add(new JLabel("学号",JLabel.CENTER));
			box1.add(Sno);
			box2.add(new JLabel("新的姓名",JLabel.CENTER));
			box2.add(Sn);
			box3.add(new JLabel("新的密码",JLabel.CENTER));
			box3.add(Sp);;
			box4.add(new JLabel("新的专业代码",JLabel.CENTER));
			box4.add(Dno);
			box5.add(jb);
					
			Box boxH=Box.createVerticalBox();
			boxH.add(box1);
			boxH.add(box2);
			boxH.add(box3); 
			boxH.add(box4);
			boxH.add(box5);
			boxH.add(Box.createVerticalGlue());
					
			BackgroundPanelUpdateS jp;//创建面板
			jp=new BackgroundPanelUpdateS((new ImageIcon("C:\\Users\\11862\\Pictures\\ZM\\改学生.png")).getImage());
			jp.add(boxH);
			setLayout(new BorderLayout()); //边框布局
			add(jp,BorderLayout.CENTER);
			validate();
		}
		
		//动作事件执行
		public void actionPerformed(ActionEvent c){
			Object obj=c.getSource();
			if(obj==jb){
				if(Sno.getText().equals("")){ //学生号可以为空值
					JOptionPane.showMessageDialog(this,"学生号为空");
				}
				else{
					if(Sn.getText().equals("")&&Ssex.getText().equals("")&&Sy.getText().equals("")&&Sp.getText().equals("")&&Dno.getText().equals("")){ //不允许全部为空值
						JOptionPane.showMessageDialog(this,"请至少填写一个修改项");
					}
					else{
						Statement stmt=null;//创建接口
						ResultSet rs=null; //声明返回结果
						String sql,sql1,sql2,sql3,sql4;
						sql="select * from S where sno='"+Sno.getText()+"'";
						try{
							CONN co=new CONN();
							Connection dbConn1=co.CO();//添加数据库连接
							stmt=(Statement)dbConn1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
									ResultSet.CONCUR_READ_ONLY);//可以任意向前后移动游标，ResultSet数据只读
							rs=stmt.executeQuery(sql);//executeQuery()方法会把数据库响应的查询结果存放在ResultSet类对象中
							if(!rs.next()){
								JOptionPane.showMessageDialog(this,"学生不存在");
							}
							else{
								if((!Sn.getText().equals(""))&&Sp.getText().equals("")&&Dno.getText().equals("")){
									sql1="update S set sn='"+Sn.getText()+"' where sno='"+Sno.getText()+"'";
									stmt.executeUpdate(sql1);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									JOptionPane.showMessageDialog(this, "学生姓名修改成功");
								}
								else if(Sn.getText().equals("")&&(!Sp.getText().equals(""))&&Dno.getText().equals("")){
									sql1="update S set sp='"+Sp.getText()+"' where sno='"+Sno.getText()+"'";
									stmt.executeUpdate(sql1);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									JOptionPane.showMessageDialog(this, "学生密码修改成功");
								}
								else if(Sn.getText().equals("")&&(Sp.getText().equals(""))&&!Dno.getText().equals("")){
									sql1="update S set dno='"+Dno.getText()+"' where sno='"+Sno.getText()+"'";
									stmt.executeUpdate(sql1);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									JOptionPane.showMessageDialog(this, "学生专业修改成功");
								}
								else if((!Sn.getText().equals(""))&&(!Sp.getText().equals(""))&&Dno.getText().equals("")){
									sql1="update S set sn='"+Sn.getText()+"' where sno='"+Sno.getText()+"'";
									sql2="update S set sp='"+Sp.getText()+"' where sno='"+Sno.getText()+"'";
									stmt.executeUpdate(sql1);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									stmt.executeUpdate(sql2);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									JOptionPane.showMessageDialog(this, "学生姓名，密码修改成功");
								}
								else if((!Sn.getText().equals(""))&&Sp.getText().equals("")&&!Dno.getText().equals("")){
									sql1="update S set sn='"+Sn.getText()+"' where sno='"+Sno.getText()+"'";
									sql2="update S set dno='"+Dno.getText()+"' where sno='"+Sno.getText()+"'";
									stmt.executeUpdate(sql1);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									stmt.executeUpdate(sql2);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									JOptionPane.showMessageDialog(this, "学生姓名，专业修改成功");
								}
								else if((Sn.getText().equals(""))&&!Sp.getText().equals("")&&!Dno.getText().equals("")){
									sql1="update S set sp='"+Sp.getText()+"' where sno='"+Sno.getText()+"'";
									sql2="update S set dno='"+Dno.getText()+"' where sno='"+Sno.getText()+"'";
									stmt.executeUpdate(sql1);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									stmt.executeUpdate(sql2);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									JOptionPane.showMessageDialog(this, "学生密码，专业修改成功");
								}
								else if((!Sn.getText().equals(""))&&!Sp.getText().equals("")&&!Dno.getText().equals("")){
									sql1="update S set sn='"+Sn.getText()+"' where sno='"+Sno.getText()+"'";
									sql2="update S set sp='"+Sp.getText()+"' where sno='"+Sno.getText()+"'";
									sql3="update S set dno='"+Dno.getText()+"' where sno='"+Sno.getText()+"'";
									stmt.executeUpdate(sql1);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									stmt.executeUpdate(sql2);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									stmt.executeUpdate(sql3);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
									JOptionPane.showMessageDialog(this, "学生姓名，密码，专业修改成功");
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

class BackgroundPanelUpdateS extends JPanel  
{  
    Image im;  
    public BackgroundPanelUpdateS(Image im)  
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