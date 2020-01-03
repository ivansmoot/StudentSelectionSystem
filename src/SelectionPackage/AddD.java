package SelectionPackage;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class AddD extends JPanel implements ActionListener{
	
	JTextField Dno=new JTextField(20); //专业代码输入框 
	JTextField Dn=new JTextField(20);  //专业名称输入框
	JButton jb=new JButton("录入"); //录入按钮
	
	//组件设置
	public AddD(){ 
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
		
		box1.add(new JLabel("专业代码"));
		box1.add(Dno);
		box2.add(new JLabel("专业名称"));
		box2.add(Dn);
		box3.add(jb);
		
		Box boxH=Box.createVerticalBox();
		boxH.add(box1);
		boxH.add(box2);
		boxH.add(box3);
		boxH.add(Box.createVerticalGlue());
		
		BackgroundPanelAddD pCenter;//创建面板
		pCenter=new BackgroundPanelAddD((new ImageIcon("C:\\Users\\11862\\Pictures\\ZM\\该加专业了.png")).getImage());
		pCenter.add(boxH);
		setLayout(new BorderLayout()); //边框布局
		add(pCenter,BorderLayout.CENTER);
		validate();
	}
	
	//动作事件执行
	public void actionPerformed(ActionEvent c){ 
		Object obj=c.getSource();
		if(obj==jb){
			
			Statement stmt=null;//创建接口
			ResultSet rs=null; //声明返回结果
			String sql,sql1;
			sql="select * from D where dno='"+Dno.getText()+"'";
			sql1="insert into D values('"+Dno.getText()+"','"+Dn.getText()+"')";
			try{
				CONN co=new CONN();
				Connection dbConn1=co.CO();//添加数据库连接
				stmt=(Statement)dbConn1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);//可以任意向前后移动游标，ResultSet数据只读
				rs=stmt.executeQuery(sql);//executeQuery()方法会把数据库响应的查询结果存放在ResultSet类对象中
				if(Dno.getText().equals("")){ //专业代码不可以为空值
					JOptionPane.showMessageDialog(this,"专业代码不能为空");
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
					if(Dn.getText().equals("")){//专业名称不可以为空值
						JOptionPane.showMessageDialog(this,"专业名称不能为空");
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
									if(rs.next()){
										JOptionPane.showMessageDialog(this,"专业已存在");
									}
									else{
										stmt.executeUpdate(sql1);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
										JOptionPane.showMessageDialog(this, "专业添加成功");
									}
							
						
							}
						
					}
					}
					}
				}
				}
				rs.close();
				stmt.close();
			}catch(SQLException e){
				System.out.print("SQL Exception occur.Message is:"+e.getMessage());
			}
		}
	}
}

class BackgroundPanelAddD extends JPanel  
{  
    Image im;  
    public BackgroundPanelAddD(Image im)  
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