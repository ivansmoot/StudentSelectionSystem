package SelectionPackage;

import java.awt.*;

import javax.swing.*;

import java.sql.*;
import java.awt.event.*;

public class SelC extends JPanel implements ActionListener{
	JTextField Cno=new JTextField(20);//课程号
	JTextField Cn=new JTextField(20);//课程名
	JTextField Cs=new JTextField(20);//学分
	JTextField Cp=new JTextField(20);//学时
	JTextField Cc=new JTextField(20);//性质
	JTextField Dno=new JTextField(20);//专业代码
	JButton jb=new JButton("查找");
	
	//组件设置
	public SelC(){
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
		box2.add(new JLabel("课程名",JLabel.CENTER));
		box2.add(Cn);
		box3.add(new JLabel("学分",JLabel.CENTER));
		box3.add(Cs);
		box4.add(new JLabel("学时",JLabel.CENTER));
		box4.add(Cp);
		box5.add(new JLabel("性质",JLabel.CENTER));
		box5.add(Cc);
		box6.add(new JLabel("专业代码",JLabel.CENTER));
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
		
		BackgroundPanelSelC jp;//创建面板
		jp=new BackgroundPanelSelC((new ImageIcon("C:\\Users\\11862\\Pictures\\ZM\\查课程.png")).getImage());
		jp.add(boxH);
		setLayout(new BorderLayout()); //边框布局
		add(jp,BorderLayout.CENTER);
		validate();
	}
	
	//动作事件执行
	public void actionPerformed(ActionEvent c){
		Object obj=c.getSource();
		Statement stmt=null;//创建接口
		ResultSet rs=null; //声明返回结果
		String sql=null;
		forSelC K;
		if(obj==jb){
			if(Cno.getText().equals("")&&Cn.getText().equals("")&&Cno.getText().equals("")&&Dno.getText().equals("")){
				sql="select * from C";
			}
			else if((!Cno.getText().equals(""))&&Cn.getText().equals("")&&Cn.getText().equals("")&&Dno.getText().equals("")){
				sql="select * from C where cno='"+Cno.getText()+"'";
			}
			else if(Cno.getText().equals("")&&(!Cn.getText().equals(""))&&Cn.getText().equals("")&&Dno.getText().equals("")){
				sql="select * from C where cn='"+Cn.getText()+"'";
			}
			else if(Cno.getText().equals("")&&Cn.getText().equals("")&&(!Cn.getText().equals(""))&&Dno.getText().equals("")){
				sql="select * from C where cn='"+Cn.getText()+"'";
			}
			else if(Cno.getText().equals("")&&Cn.getText().equals("")&&Cn.getText().equals("")&&(!Dno.getText().equals(""))){
				sql="select * from C where dno='"+Dno.getText()+"'";
			}
			else if((!Cno.getText().equals(""))&&(!Cn.getText().equals(""))&&Cn.getText().equals("")&&Dno.getText().equals("")){
				sql="select * from C where cno='"+Cno.getText()+"' and tn='"+Cn.getText()+"'";
			}
			else if((!Cno.getText().equals(""))&&Cn.getText().equals("")&&(!Cn.getText().equals(""))&&Dno.getText().equals("")){
				sql="select * from C where cno='"+Cno.getText()+"' and cn='"+Cn.getText()+"'";
			}
			else if((!Cno.getText().equals(""))&&Cn.getText().equals("")&&Cn.getText().equals("")&&(!Dno.getText().equals(""))){
				sql="select * from C where cno='"+Cno.getText()+"' and dno='"+Dno.getText()+"'";
			}
			else if(Cno.getText().equals("")&&(!Cn.getText().equals(""))&&(!Cn.getText().equals(""))&&Dno.getText().equals("")){
				sql="select * from C where cn='"+Cn.getText()+"' and cn='"+Cn.getText()+"'";
			}
			else if(Cno.getText().equals("")&&(!Cn.getText().equals(""))&&Cn.getText().equals("")&&(!Dno.getText().equals(""))){
				sql="select * from C where cn='"+Cn.getText()+"' and dno='"+Dno.getText()+"'";
			}
			else if(Cno.getText().equals("")&&Cn.getText().equals("")&&(!Cn.getText().equals(""))&&(!Dno.getText().equals(""))){
				sql="select * from C where cn='"+Cn.getText()+"' and dno='"+Dno.getText()+"'";
			}
			else if((!Cno.getText().equals(""))&&(!Cn.getText().equals(""))&&(!Cn.getText().equals(""))&&Dno.getText().equals("")){
				sql="select * from C where cno='"+Cno.getText()+"' and tn='"+Cn.getText()+"' and Cn='"+Cn.getText()+"'";
			}
			else if((!Cno.getText().equals(""))&&(!Cn.getText().equals(""))&&Cn.getText().equals("")&&(!Dno.getText().equals(""))){
				sql="select * from C where cno='"+Cno.getText()+"' and tn='"+Cn.getText()+"' and dno='"+Dno.getText()+"'";
			}
			else if((!Cno.getText().equals(""))&&Cn.getText().equals("")&&(!Cn.getText().equals(""))&&(!Dno.getText().equals(""))){
				sql="select * from C where cno='"+Cno.getText()+"' and ty='"+Cn.getText()+"' and dno='"+Dno.getText()+"'";
			}
			else if(Cno.getText().equals("")&&(!Cn.getText().equals(""))&&(!Cn.getText().equals(""))&&(!Dno.getText().equals(""))){
				sql="select * from C where cn='"+Cn.getText()+"' and ty='"+Cn.getText()+"' and dno='"+Dno.getText()+"'";
			}
			else{
				sql="select * from C where tno='"+Cno.getText()+"' and tn='"+Cn.getText()+"' and Cn='"+Cn.getText()+"' and dno='"+Dno.getText()+"'";
			}
			K=new forSelC(sql);
		}
	}
}

class BackgroundPanelSelC extends JPanel  
{  
    Image im;  
    public BackgroundPanelSelC(Image im)  
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