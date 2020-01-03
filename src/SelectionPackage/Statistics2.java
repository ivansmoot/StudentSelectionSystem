package SelectionPackage;

import java.awt.*;

import javax.swing.*;

import java.sql.*;
import java.awt.event.*;
public class Statistics2 extends JPanel implements ActionListener{

	JTextField Dno=new JTextField(20);//专业代码
	JTextField Max_grade=new JTextField(20);//分数上限
	JTextField Min_grade=new JTextField(20);//分数下限
	JButton jb=new JButton("查询"); //查询按钮
	
	
	public Statistics2() {
		
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
	
		
		box1.add(new JLabel("专业代码"));
		box1.add(Dno);
		box2.add(new JLabel("最高分"));
		box2.add(Max_grade);
		box3.add(new JLabel("最低分"));
		box3.add(Min_grade);
		box4.add(jb);
		
		Box boxH=Box.createVerticalBox();
		boxH.add(box1);
		boxH.add(box2);
		boxH.add(box3);
		boxH.add(box4);
		
		
		BackgroundPanelStatistics2 jp;//创建面板
		jp=new BackgroundPanelStatistics2((new ImageIcon("C:\\Users\\11862\\Pictures\\ZM\\背景.png")).getImage());
		jp.add(boxH);
		setLayout(new BorderLayout()); //边框布局
		add(jp,BorderLayout.CENTER);
		validate();
		
	}
	
	public void actionPerformed(ActionEvent c){ 
		Object obj=c.getSource();
		Statement stmt=null;//创建接口
		ResultSet rs=null; //声明返回结果
		String sql=null;
		forStatistics2 K;
		if(obj==jb){
			
			if(!(Dno.getText().equals("")&&Max_grade.getText().equals("")&&Min_grade.getText().equals("")))
			{
			sql="select SC.sy 学年,cno 课程,count(*) 学生人数, avg(score) 平均分 from SC,S where S.dno='"+Dno.getText()+"' and S.sno=SC.sno and score between '"+Min_grade.getText()+"' and '"+Max_grade.getText()+"'  group by SC.sy,cno";
			}
		else {
			JOptionPane.showMessageDialog(this, "请输入查询条件");
		}
			 K=new forStatistics2(sql);
			
			
			
				
				
				
		}
		
	}
	
}
class BackgroundPanelStatistics2 extends JPanel  
{  
    Image im;  
    public BackgroundPanelStatistics2(Image im)  
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