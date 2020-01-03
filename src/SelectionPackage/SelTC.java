package SelectionPackage;

import java.awt.*;

import javax.swing.*;

import java.sql.*;
import java.awt.event.*;

public class SelTC extends JPanel implements ActionListener{
	JTextField Tno=new JTextField(20);//教师号
	JTextField Cno=new JTextField(20);//课程号
	JButton jb=new JButton("查找");
	
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
	public SelTC(){
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
		
		box1.add(new JLabel("教师号",JLabel.CENTER));
		box1.add(Tno);
		box2.add(new JLabel("课程号",JLabel.CENTER));
		box2.add(Cno);
		box3.add(jb);
		
		Box boxH=Box.createVerticalBox();
		boxH.add(box1);
		boxH.add(box2);
		boxH.add(box3);
		boxH.add(Box.createVerticalGlue());
		
		BackgroundPanelSelTC jp;//创建面板
		jp=new BackgroundPanelSelTC((new ImageIcon("C:\\Users\\11862\\Pictures\\ZM\\背景.png")).getImage());
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
		String s1=Tno.getText();
		String s2=Cno.getText();
		forSelTC K;
		if(obj==jb){
			if(Tno.getText().equals("")&&Cno.getText().equals("")){
				sql="select * from TC";
			}
			else if(Tno.getText().equals("")){
				if(!digitCheck(s2)||s2.length()>12) 
					JOptionPane.showMessageDialog(this,"课程号请输入不超过12位的数字");
				else
				sql="select * from TC where cno='"+Cno.getText()+"'";
			}
			else if(Cno.getText().equals("")){
				if(!digitCheck(s1)||s1.length()>9) 
					JOptionPane.showMessageDialog(this,"教师号请输入不超过9位的数字");
				else
				sql="select * from TC where tno='"+Tno.getText()+"'";
			}
			else{
				if(!digitCheck(s1)||s1.length()>9) 
					JOptionPane.showMessageDialog(this,"教师号请输入不超过9位的数字");
				else {
					if(!digitCheck(s2)||s2.length()>12) 
						JOptionPane.showMessageDialog(this,"课程号请输入不超过12位的数字");
					else
				        sql="select * from TC where tno='"+Tno.getText()+"' and cno='"+Cno.getText()+"'";
				}
			}
			K=new forSelTC(sql);
		}
	}
}

class BackgroundPanelSelTC extends JPanel  
{  
    Image im;  
    public BackgroundPanelSelTC(Image im)  
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