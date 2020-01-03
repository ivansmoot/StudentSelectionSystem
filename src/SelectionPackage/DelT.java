package SelectionPackage;

import java.awt.*;

import javax.swing.*;

import java.sql.*;
import java.awt.event.*;

public class DelT extends JPanel implements ActionListener{
	JTextField Tno=new JTextField(20);//教师号输入框
	JButton jb=new JButton("删除");//删除按钮
	
	//组件设置
	public DelT(){
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());//窗口外观设置为所用系统平台外观
		}catch(Exception e){
			System.out.println("无法设置外观："+e);
		}

		jb.addActionListener(this); //为按钮设置事件
		
		//将输入框和按钮放入BOX组件容器
		Box box1=Box.createHorizontalBox();
		Box box2=Box.createHorizontalBox();
				
		box1.add(new JLabel("教师号"));
		box1.add(Tno);
		box2.add(jb);
				
		Box boxH=Box.createVerticalBox();
		boxH.add(box1);
		boxH.add(box2);
		boxH.add(Box.createVerticalGlue());
				
		BackgroundPanelDelT pCenter;//创建面板
		pCenter=new BackgroundPanelDelT((new ImageIcon("C:\\Users\\11862\\Pictures\\ZM\\删老师.png")).getImage());
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
			sql="select * from T where tno='"+Tno.getText()+"'";
			sql1="delete from T where tno='"+Tno.getText()+"'";
			boolean TnoB;
			try{
				CONN co=new CONN();
				Connection dbConn1=co.CO();//添加数据库连接
				stmt=(Statement)dbConn1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);//可以任意向前后移动游标，ResultSet数据只读
				rs=stmt.executeQuery(sql);//executeQuery()方法会把数据库响应的查询结果存放在ResultSet类对象中
				
				if(Tno.getText().equals("")){ //教师号不可以为空值
					JOptionPane.showMessageDialog(this,"教师号不能为空");
					TnoB=false;
				}
				else{
					int length=Tno.getText().length();
					if(length!=9){
						JOptionPane.showMessageDialog(this,"教师号必须为9位数字");
						TnoB=false;
					}
					else{
						int num=0;
						for(int j=0;j<9;j++){
							if(Tno.getText().charAt(j)>='0'&&Tno.getText().charAt(j)<='9'){
								num++;
							}
						}
						if(num!=9){
							JOptionPane.showMessageDialog(this,"教师号必须为纯数字");
							TnoB=false;
						}
						else{
							if(rs.next()){
								JOptionPane.showMessageDialog(this,"教师已存在");
								TnoB=false;
							}
							else{
								TnoB=true;
							}
						}
					}
				}
				
				if(TnoB){
						stmt.executeUpdate(sql1);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
						JOptionPane.showMessageDialog(this, "专业删除成功");
				}
				rs.close();
				stmt.close();
			}catch(SQLException e){
				System.out.print("SQL Exception occur.Message is:"+e.getMessage());
			}
		}
	}
}

class BackgroundPanelDelT extends JPanel  
{  
    Image im;  
    public BackgroundPanelDelT(Image im)  
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