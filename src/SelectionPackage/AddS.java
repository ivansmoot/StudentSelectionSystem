package SelectionPackage;

import java.awt.*;

import javax.swing.*;

import java.sql.*;
import java.awt.event.*;


public class AddS extends JPanel implements ActionListener{
	
	JTextField Sno=new JTextField(20); //学生学号输入框
	JTextField sn=new JTextField(20);  //学生姓名名称输入框
	JTextField ssex=new JTextField(20); //学生性别输入框
	JTextField sy=new JTextField(20); //学生入学年份
	JTextField sp=new JTextField(20); //学生登录密码
	JTextField dno=new JTextField(20); //专业代码
	JButton jb=new JButton("录入"); //录入按钮
	
	//组件设置
	public AddS(){
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
		
		box1.add(new JLabel("学生学号"));
		box1.add(Sno);
		box2.add(new JLabel("学生姓名"));
		box2.add(sn);
		box3.add(new JLabel("性别"));
		box3.add(ssex);
		box4.add(new JLabel("学生入学年份"));
		box4.add(sy);
		box5.add(new JLabel("学生登录密码"));
		box5.add(sp);
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
		
		BackgroundPanelAddS jp;//创建面板
		jp=new BackgroundPanelAddS((new ImageIcon("C:\\Users\\11862\\Pictures\\ZM\\加学生.png")).getImage());
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
			sql="     select * from S where sno=' "+Sno.getText()+" '    ";
			sql1="insert into S values('"+Sno.getText()+"','"+sn.getText()+"','"+ssex.getText()+"','"+sy.getText()+"','"+sp.getText()+"','"+dno.getText()+"')";
			try{
				Connection dbConn1=CONN.CO();//添加数据库连接
				stmt=(Statement)dbConn1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);//可以任意向前后移动游标，ResultSet数据只读
				rs=stmt.executeQuery(sql);//executeQuery()方法会把数据库响应的查询结果存放在ResultSet类对象中
				if(Sno.getText().equals("")){ //学生学号不可以为空值
					JOptionPane.showMessageDialog(this,"学生学号不能为空");
				}
				else{
					if(sp.getText().equals("")){//学生密码不可以为空值
						JOptionPane.showMessageDialog(this,"学生密码不能为空");
					}
					else{
						if(rs.next()){
							JOptionPane.showMessageDialog(this,"学生已存在");
						}
						else{
							stmt.executeUpdate(sql1);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
							JOptionPane.showMessageDialog(this, "学生添加成功");
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

class BackgroundPanelAddS extends JPanel  
{  
    Image im;  
    public BackgroundPanelAddS(Image im)  
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