package SelectionPackage;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class SelD extends JPanel implements ActionListener{
	JTextField Dno=new JTextField(20);//专业代码
	JTextField Dn=new JTextField(20);//专业名称
	JButton jb=new JButton("查找");
	
	//组件设置
	public SelD(){
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
		
		box1.add(new JLabel("专业代码",JLabel.CENTER));
		box1.add(Dno);
		box2.add(new JLabel("专业名称",JLabel.CENTER));
		box2.add(Dn);
		box3.add(jb);
		
		Box boxH=Box.createVerticalBox();
		boxH.add(box1);
		boxH.add(box2);
		boxH.add(box3);
		boxH.add(Box.createVerticalGlue());
		
		BackgroundPanelSelD pCenter;//创建面板
		pCenter=new BackgroundPanelSelD((new ImageIcon("C:\\Users\\11862\\Pictures\\ZM\\查专业.png")).getImage());
		pCenter.add(boxH);
		setLayout(new BorderLayout()); //边框布局
		add(pCenter,BorderLayout.CENTER);
		validate();
	}
	
	//动作事件执行
	public void actionPerformed(ActionEvent c){
		Object obj=c.getSource();
		Statement stmt=null;//创建接口
		ResultSet rs=null; //声明返回结果
		String sql=null;
		forSelD K;
		if(obj==jb){
			if(Dno.getText().equals("")&&Dn.getText().equals("")){
				sql="select * from D"; K=new forSelD(sql);
			}
			else if(Dno.getText().equals("")){
				byte[] b=Dn.getText().getBytes();
				if(b.length>15){
					JOptionPane.showMessageDialog(this,"专业名称过长");
				}
				else{
				int i=Dn.getText().length();
				int num=0;
				for(int j=0;j<i;j++){
					if(Dn.getText().charAt(j)>='0'&&Dn.getText().charAt(j)<='9'){
						num++;
					}
				}
					if(num==i){
						JOptionPane.showMessageDialog(this,"专业名称不能为纯数字");
					}
					else{ 
				sql="select * from D where dn='"+Dn.getText()+"'"; K=new forSelD(sql);
					}
			}
			}
			else if(Dn.getText().equals("")){
				int length=Dno.getText().length();
				if(length!=3){//专业代码
					JOptionPane.showMessageDialog(this,"专业代码必须为3位数字");
				}
				else{
					if(!(Dno.getText().charAt(0)>='0'&&Dno.getText().charAt(0)<='9'
							&&Dno.getText().charAt(1)>='0'&&Dno.getText().charAt(1)<='9'
							&&Dno.getText().charAt(2)>='0'&&Dno.getText().charAt(2)<='9')){
						JOptionPane.showMessageDialog(this,"专业代码必须为纯数字");
					}
					else{
				sql="select * from D where dno='"+Dno.getText()+"'"; K=new forSelD(sql);
					}
				}
			}
			
			
			else{
				int length=Dno.getText().length();
				if(length!=3){//专业代码
					JOptionPane.showMessageDialog(this,"专业代码必须为3位数字");
				}
				else{
					if(!(Dno.getText().charAt(0)>='0'&&Dno.getText().charAt(0)<='9'
							&&Dno.getText().charAt(1)>='0'&&Dno.getText().charAt(1)<='9'
							&&Dno.getText().charAt(2)>='0'&&Dno.getText().charAt(2)<='9')){
						JOptionPane.showMessageDialog(this,"专业代码必须为纯数字");
					}
					else{
						byte[] b=Dn.getText().getBytes();
						if(b.length>15){
							JOptionPane.showMessageDialog(this,"专业名称过长");
						}
						else{
						int i=Dn.getText().length();
						int num=0;
						for(int j=0;j<i;j++){
							if(Dn.getText().charAt(j)>='0'&&Dn.getText().charAt(j)<='9'){
								num++;
							}
						}
							if(num==i){
								JOptionPane.showMessageDialog(this,"专业名称不能为纯数字");
							}
							else{



							sql="select * from D where dno='"+Dno.getText()+"' and dn='"+Dn.getText()+"'";
							K=new forSelD(sql);
					}
							}
						}
				}
			}
			
		}
	}
}

class BackgroundPanelSelD extends JPanel  
{  
    Image im;  
    public BackgroundPanelSelD(Image im)  
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