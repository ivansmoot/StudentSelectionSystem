package SelectionPackage;

import java.awt.*;

import javax.swing.*;

import java.sql.*;
import java.awt.event.*;

public class SelS extends JPanel implements ActionListener{
	JTextField sno=new JTextField(20);//学生学号

	JButton jb=new JButton("查找");
	
	//组件设置
	public SelS(){
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
		
		box1.add(new JLabel("学生学号",JLabel.CENTER));
		box1.add(sno);

	
		box3.add(jb);
		
		Box boxH=Box.createVerticalBox();
		boxH.add(box1);
		boxH.add(box2);
		boxH.add(box3);
		boxH.add(Box.createVerticalGlue());
		
		BackgroundPanelSelS jp;//创建面板
		jp=new BackgroundPanelSelS((new ImageIcon("C:\\Users\\11862\\Pictures\\ZM\\查学生.png")).getImage());
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
		forSelS K;
		if(obj==jb){
			if (sno.getText().equals(""))
				sql="select * from S";
			else
				sql="select * from S where sno='"+sno.getText()+"'";
			
		K=new forSelS(sql);
		}
	}
}

class BackgroundPanelSelS extends JPanel  
{  
    Image im;  
    public BackgroundPanelSelS(Image im)  
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