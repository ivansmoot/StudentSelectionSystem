package SelectionPackage;

import java.awt.*;

import javax.swing.*;

import java.sql.*;
import java.awt.event.*;

public class DelSC extends JPanel implements ActionListener{
	JTextField Sno=new JTextField(20);//专业名称输入框
	JTextField Cno=new JTextField(20);  //课程号输入框
	JTextField Sy=new JTextField(20);//学年
	JTextField Term=new JTextField(20);//学期
	JButton jb=new JButton("删除");//删除按钮
	//输入数据限制
	boolean digitCheck(String input) {
	    for(int i = 0; i < input.length(); i++) {
	        char c = input.charAt(i);
	        if( (c < '0' || c > '9') ) {
	        return false;
	        }
	    }
	    return true;
	}
	
	//组件设置
	public DelSC(){
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
		
		
		
		box1.add(new JLabel("学号"));
		box1.add(Sno);
		box2.add(new JLabel("课程号"));
		box2.add(Cno);
		box3.add(new JLabel("学年"));
		box3.add(Sy);
		box4.add(new JLabel("学期"));
		box4.add(Term);
		box5.add(jb);
		
		Box boxH=Box.createVerticalBox();
		boxH.add(box1);
		boxH.add(box2);
		boxH.add(box3);
		boxH.add(box4);
		boxH.add(box5);
		boxH.add(Box.createVerticalGlue());
				
		BackgroundPanelDelSC jp;//创建面板
		jp=new BackgroundPanelDelSC((new ImageIcon("C:\\Users\\11862\\Pictures\\ZM\\背景.png")).getImage());
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
			sql="select * from SC where sno='"+Sno.getText()+"'and cno='"+Cno.getText()+"'and sy='"+Sy.getText()+"'and term='"+Term.getText()+"'";
			sql1="delete from SC where sno='"+Sno.getText()+"'and cno='"+Cno.getText()+"'";
			String s1=Sno.getText();
			String s2=Cno.getText();
			try{
				CONN co=new CONN();
				Connection dbConn1=co.CO();//添加数据库连接
				stmt=(Statement)dbConn1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);//可以任意向前后移动游标，ResultSet数据只读
				rs=stmt.executeQuery(sql);//executeQuery()方法会把数据库响应的查询结果存放在ResultSet类对象中
				if(Sno.getText().equals("")){//学号不可以为空值
					JOptionPane.showMessageDialog(this,"学号不能为空");
				}
				else {
					if(!digitCheck(s1)||s1.length()>7) {
						JOptionPane.showMessageDialog(this,"学号请输入不超过7位的数字");
					}
					    if(Cno.getText().equals("")) {
					    	
					    	JOptionPane.showMessageDialog(this,"课程号不能为空");
					    }
				  else{
					  if(!digitCheck(s2)||s2.length()>12) {
							JOptionPane.showMessageDialog(this,"课程号请输入不超过12位的数字");
					  }
					   if(!rs.next()){
						JOptionPane.showMessageDialog(this,"选课记录不存在");
					}
					  else{
						stmt.executeUpdate(sql1);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
						JOptionPane.showMessageDialog(this, "选课记录删除成功");
					}
				}
			}
				rs.close();
				stmt.close();
			}catch(SQLException e){
				System.out.print("SQL Exception occur.Message is:"+e.getMessage());
			}
		}
	}
}

class BackgroundPanelDelSC extends JPanel  
{  
    Image im;  
    public BackgroundPanelDelSC(Image im)  
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