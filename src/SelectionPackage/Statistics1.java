package SelectionPackage;

import java.awt.*;

import javax.swing.*;

import java.sql.*;
import java.util.Vector;
import java.awt.event.*;

public class Statistics1 extends JPanel implements ActionListener {

	JTextField Cno=new JTextField(20);//课程
	JTextField Max_grade=new JTextField(20);//分数上限
	JTextField Min_grade=new JTextField(20);//分数下限
	JButton jb=new JButton("查询"); //查询按钮
	
	public Statistics1() {
		
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
				
				
				
				box1.add(new JLabel("课程号"));
				box1.add(Cno);
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
				boxH.add(Box.createVerticalGlue());
				
				BackgroundPanelStatistics1 jp;//创建面板
				jp=new BackgroundPanelStatistics1((new ImageIcon("C:\\Users\\11862\\Pictures\\ZM\\背景.png")).getImage());
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
			forStatistics1 K;
			if(obj==jb){
				
					if(!(Cno.getText().equals("")&&Max_grade.getText().equals("")&&Min_grade.getText().equals("")))
						{
						sql="select count(*) 学生人数, avg(score) 平均分  from SC,S where cno='"+Cno.getText()+"' and SC.sno=S.sno and score between '"+Min_grade.getText()+"' and '"+Max_grade.getText()+"'";
						
						}
					
					
					else {
						JOptionPane.showMessageDialog(this, "请输入查询条件");
					}
					
					
			
					 K=new forStatistics1(sql);
			}
		}
}

class BackgroundPanelStatistics1 extends JPanel  
{  
    Image im;  
    public BackgroundPanelStatistics1(Image im)  
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