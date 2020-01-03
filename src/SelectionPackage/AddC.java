package SelectionPackage;

import java.awt.*;

import javax.swing.*;

import java.sql.*;
import java.awt.event.*;


public class AddC extends JPanel implements ActionListener{
	
	JTextField Cno=new JTextField(20); //课程表输入框
	JTextField cn=new JTextField(20);  //课程名输入框
	JTextField cs=new JTextField(20); //学分输入框
	JTextField cp=new JTextField(20); //学时
	JTextField cc=new JTextField(20); //性质
	JTextField dno=new JTextField(20); //专业代码
	JButton jb=new JButton("录入"); //录入按钮
	
	//组件设置
	public AddC(){
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
		
		box1.add(new JLabel("课程号"));
		box1.add(Cno);
		box2.add(new JLabel("课程名")); 
		box2.add(cn);
		box3.add(new JLabel("学分"));
		box3.add(cs);
		box4.add(new JLabel("学时"));
		box4.add(cp);
		box5.add(new JLabel("性质"));
		box5.add(cc);
		box6.add(new JLabel("专业代码"));
		box6.add(dno);
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
		
		BackgroundPanelAddC jp;//创建面板
		jp=new BackgroundPanelAddC((new ImageIcon("C:\\Users\\11862\\Pictures\\ZM\\加课.png")).getImage());
		jp.add(boxH);
		setLayout(new BorderLayout()); //边框布局
		add(jp,BorderLayout.CENTER);
		validate();
	}
	
	//动作事件执行
	public void actionPerformed(ActionEvent c){ 
		Object obj=c.getSource();
		if(obj==jb){
			
			Statement stmt=null;//创建接口
			ResultSet rs=null; //声明返回结果
			String sql,sql1;
			sql="select * from C where dno='"+Cno.getText()+"'";
			sql1="insert into C values('"+Cno.getText()+"','"+cn.getText()+"','"+cs.getText()+"','"+cp.getText()+"','"+cc.getText()+"','"+dno.getText()+"','0')";
			try{
				Connection dbConn1=CONN.CO();//添加数据库连接
				stmt=(Statement)dbConn1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);//可以任意向前后移动游标，ResultSet数据只读
				rs=stmt.executeQuery(sql);//executeQuery()方法会把数据库响应的查询结果存放在ResultSet类对象中
				if(Cno.getText().equals("")){ //学生学号不可以为空值
					JOptionPane.showMessageDialog(this,"课程号不能为空");
				}
				else{
					if(cn.getText().equals("")){//学生密码不可以为空值
						JOptionPane.showMessageDialog(this,"课程名不能为空");
					}
					else{
						if(rs.next()){
							JOptionPane.showMessageDialog(this,"课程已存在");
						}
						else{
							stmt.executeUpdate(sql1);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
							JOptionPane.showMessageDialog(this, "课程添加成功");
						}
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

class BackgroundPanelAddC extends JPanel  
{  
    Image im;  
    public BackgroundPanelAddC(Image im)  
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