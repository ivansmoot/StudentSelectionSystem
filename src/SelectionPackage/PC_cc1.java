package SelectionPackage;


import javax.swing.*;

import java.sql.*;
import java.awt.BorderLayout;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.*;
public class PC_cc1 extends JPanel implements ActionListener {

	JTextField Sy=new JTextField(20); //学年
	JTextField Term=new JTextField(20);  //学期
	JTextField Sy1=new JTextField(20); //年级
	JTextField Dno=new JTextField(20); //专业
	JTextField Cno=new JTextField(20);  //课程号
	JTextField Tno=new JTextField(20);//教师号
	
	JTextField Week1=new JTextField(20);//起始周
	JTextField Week2=new JTextField(20);//结束周
	JTextField Weekday1=new JTextField(20);//星期
	JTextField Weekday2=new JTextField(20);//星期
	JTextField Section1=new JTextField(20);//节数
	JTextField Section2=new JTextField(20);//节数
	JButton jb=new JButton("生成课表"); //课表按钮
	
	public PC_cc1() {
		
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());//绐楀彛澶栬璁剧疆涓烘墍鐢ㄧ郴缁熷钩鍙板瑙�
		}catch(Exception e){
			System.out.println("无法设置外观"+e);
		}
		
		jb.addActionListener(this); //涓烘寜閽缃簨浠�
		
		//灏嗚緭鍏ユ鍜屾寜閽斁鍏OX缁勪欢瀹瑰櫒
				Box box1=Box.createHorizontalBox();
				Box box2=Box.createHorizontalBox();
				Box box3=Box.createHorizontalBox();
				Box box4=Box.createHorizontalBox();
				Box box5=Box.createHorizontalBox();
				Box box6=Box.createHorizontalBox();
				Box box7=Box.createHorizontalBox();
				Box box8=Box.createHorizontalBox();
				Box box9=Box.createHorizontalBox();
				Box box10=Box.createHorizontalBox();
				Box box11=Box.createHorizontalBox();
				Box box12=Box.createHorizontalBox();
				Box box13=Box.createHorizontalBox();
				
				box1.add(new JLabel("学年"));
				box1.add(Sy);
				box2.add(new JLabel("学期"));
				box2.add(Term);
				box3.add(new JLabel("年级"));
				box3.add(Sy1);
				box4.add(new JLabel("专业"));
				box4.add(Dno);
				box5.add(new JLabel("课程号"));
				box5.add(Cno);
				box6.add(new JLabel("教师号"));
				box6.add(Tno);
				box7.add(new JLabel("开始周"));
				box7.add(Week1);
				box8.add(new JLabel("结束周"));
				box8.add(Week2);
				box9.add(new JLabel("星期1"));
				box9.add(Weekday1);
				box10.add(new JLabel("星期2"));
				box10.add(Weekday2);
				box11.add(new JLabel("节数1"));
				box11.add(Section1);
				box12.add(new JLabel("节数2"));
				box13.add(Section2);
				box13.add(jb);
				
				Box boxH=Box.createVerticalBox();
				boxH.add(box1);
				boxH.add(box2);
				boxH.add(box3);
				boxH.add(box4);
				boxH.add(box5);
				boxH.add(box6);
				boxH.add(box7);
				boxH.add(box8);
				boxH.add(box9);
				boxH.add(box10);
				boxH.add(box11);
				boxH.add(box12);
				boxH.add(box13);
				boxH.add(Box.createVerticalGlue());
				
				BackgroundPanelPC_cc1 jp;//创建面板
				jp=new BackgroundPanelPC_cc1((new ImageIcon("C:\\Users\\11862\\Pictures\\ZM\\背景.png")).getImage());
				jp.add(boxH);
				setLayout(new BorderLayout()); //杈规甯冨眬
				add(jp,BorderLayout.CENTER);
				validate();

	}
	
	public void actionPerformed(ActionEvent c){ 
		Object obj=c.getSource();
		if(obj==jb){
			
			Statement stmt1=null,stmt2=null;//鍒涘缓鎺ュ彛
			ResultSet rs1=null,rs2=null; //澹版槑杩斿洖缁撴灉
			String sql,sql1,sql2,sql3,sql4,sql5;
			
			
			//给课表中已存在的课程排时间
			sql="update CTimetable set tno='"+Tno.getText()+"' ,week1='"+Week1.getText()+"' ,week2='"+Week2.getText()+"' ,weekday1='"+Weekday1.getText()+"' ,weekday2='"+Weekday2.getText()+"' ,section1='"+Section1.getText()+"' ,section2='"+Section2.getText()+"' where sy='"+Sy.getText()+"' and term='"+Term.getText()+"' and dno='"+Dno.getText()+"' and cno='"+Cno.getText()+"' ";
			//验证时间是否冲突
			sql1="select * from CTimetable where  week1='"+Week1.getText()+"' and week2='"+Week2.getText()+"' and weekday1='"+Weekday1.getText()+"' and section1='"+Section1.getText()+"' and sy='"+Sy.getText()+"' and term='"+Term.getText()+"' and dno='"+Dno.getText()+"' and sy1='"+Sy1.getText()+"'";
			sql2="select * from CTimetable where  week1='"+Week1.getText()+"' and week2='"+Week2.getText()+"' and weekday2='"+Weekday2.getText()+"' and section2='"+Section2.getText()+"' and sy='"+Sy.getText()+"' and term='"+Term.getText()+"' and dno='"+Dno.getText()+"' and sy1='"+Sy1.getText()+"'";
			//在TC,SC表中添加数据、触发器
			sql3="insert into TC values('"+Tno.getText()+"','"+Cno.getText()+"','"+Sy.getText()+"','"+Term.getText()+"')";
			sql4=" create Trigger TC_SC on TC for insert as begin insert into SC(sno,cno,sy,term) select sno,cno,inserted.sy,term from S,inserted where S.dno='"+Dno.getText()+"' and S.sy='"+Sy1.getText()+"'end ";
			sql5="drop trigger TC_SC";
			try{
				CONN co=new CONN();
				Connection dbConn1=co.CO();//娣诲姞鏁版嵁搴撹繛鎺�
				stmt1=(Statement)dbConn1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);//鍙互浠绘剰鍚戝墠鍚庣Щ鍔ㄦ父鏍囷紝ResultSet鏁版嵁鍙
				stmt2=(Statement)dbConn1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				//executeQuery()鏂规硶浼氭妸鏁版嵁搴撳搷搴旂殑鏌ヨ缁撴灉瀛樻斁鍦≧esultSet绫诲璞′腑
				rs1=stmt1.executeQuery(sql1);
				rs2=stmt2.executeQuery(sql2);
				
				if(Sy.getText().equals("")||Term.getText().equals("")||Sy1.getText().equals("")||Dno.getText().equals("")||Cno.getText().equals("")||Week1.getText().equals("")||Week2.getText().equals("")){ //涓撲笟浠ｇ爜涓嶅彲浠ヤ负绌哄��
					JOptionPane.showMessageDialog(this,"学年、学期、年级、专业、课程号、开始周、结束周不能为空");
				}
				else {
					if(!(Term.getText().equals("1")||Term.getText().equals("2")))
						JOptionPane.showMessageDialog(this,"学期仅为1或2");
					
					if((Weekday1.getText().equals("")&&Section1.getText().equals(""))||(Weekday2.getText().equals("")&&Section2.getText().equals(""))) {
						
						JOptionPane.showMessageDialog(this,"星期1和节数1、星期2和节数2不能同时为空");
					}
					else {
						if(!(Weekday1.getText().equals("星期一")||Weekday1.getText().equals("星期二")||Weekday1.getText().equals("星期三")||Weekday1.getText().equals("星期四")||Weekday1.getText().equals("星期五")||Weekday1.getText().equals("星期六")||Weekday2.getText().equals("星期一")||Weekday2.getText().equals("星期二")||Weekday2.getText().equals("星期三")||Weekday2.getText().equals("星期四")||Weekday2.getText().equals("星期五")||Weekday2.getText().equals("星期六")))
							JOptionPane.showMessageDialog(this,"星期1、星期2仅为星期一到星期六");
						if(!(Section1.getText().equals("1,2节")||Section1.getText().equals("3,4节")||Section1.getText().equals("5,6节")||Section1.getText().equals("7,8节")||Section1.getText().equals("9,10节")||Section2.getText().equals("1,2节")||Section2.getText().equals("3,4节")||Section2.getText().equals("5,6节")||Section2.getText().equals("7,8节")||Section2.getText().equals("9,10节")))
							JOptionPane.showMessageDialog(this,"节数1，节数2仅为1，2节、3，4节、5，6节、7，8节、9，10节");
						if(rs1.next()||rs2.next())
							JOptionPane.showMessageDialog(this,"已存在");
						else {
						stmt1.executeUpdate(sql);
						stmt1.executeUpdate(sql4);
						stmt1.executeUpdate(sql3);
						stmt1.executeUpdate(sql5);
						JOptionPane.showMessageDialog(this,"课程时间安排成功");
						}
					}
				}
				
				rs1.close();
				rs2.close();
				stmt1.close();
				
			}
			catch(SQLException e){
				System.out.print("SQL Exception occur.Message is:"+e.getMessage());
			}
		}
		
	}
	
}
class BackgroundPanelPC_cc1 extends JPanel  
{  
    Image im;  
    public BackgroundPanelPC_cc1(Image im)  
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
