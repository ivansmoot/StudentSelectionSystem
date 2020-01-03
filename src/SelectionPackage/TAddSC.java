package SelectionPackage;

import java.awt.*;

import javax.swing.*;

import java.sql.*;
import java.awt.event.*;

public class TAddSC extends JPanel implements ActionListener{
	
	JTextField Cn=new JTextField(20); //课程名称输入框 
	JTextField Sno=new JTextField(20);  //学号输入框
	JTextField Score=new JTextField(20);  //分数输入框
	JButton jb=new JButton("录入"); //录入按钮
	String id;
	//组件设置
	public TAddSC(String id1){ 
		id=id1;
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
		
		box1.add(new JLabel("课程名"));
		box1.add(Cn);
		box2.add(new JLabel("学号"));
		box2.add(Sno);
		box3.add(new JLabel("分数"));
		box3.add(Score);
		box4.add(jb);
		
		Box boxH=Box.createVerticalBox();
		boxH.add(box1);
		boxH.add(box2);
		boxH.add(box3);
		boxH.add(box4);
		boxH.add(Box.createVerticalGlue());
		
		BackgroundPanelTAddSC pCenter;//创建面板
		pCenter=new BackgroundPanelTAddSC((new ImageIcon("C:\\Users\\11862\\Pictures\\ZM\\该录成绩了.png")).getImage());
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
			String sql,sql1,sql2,sql3;
			sql="select * from TC,C where TC.tno='"+id+"' and TC.cno=C.cno and C.cn='"+Cn.getText()+"'";
			sql1="select * from TC,SC where TC.tno='"+id+"' and TC.cno =SC.cno and SC.sno='"+Sno.getText()+"'";
			sql2="select * from SC where sno='"+Sno.getText()+"' and cno=(select cno from C where cn='"+Cn.getText()+"') and score is not null ";
			sql3="update SC set score='"+Score.getText()+"' where sno='"+Sno.getText()+"' and cno=(select cno from C where cn='"+Cn.getText()+"')";
			try{
				CONN co=new CONN();
				Connection dbConn1=co.CO();//添加数据库连接
				stmt=(Statement)dbConn1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);//可以任意向前后移动游标，ResultSet数据只读
				rs=stmt.executeQuery(sql);//executeQuery()方法会把数据库响应的查询结果存放在ResultSet类对象中
				if(Cn.getText().equals("")){ //课程名不可以为空值
					JOptionPane.showMessageDialog(this,"课程名称不能为空");
				}
				else{
					int i=Cn.getText().length();
					int num=0;
					for(int j=0;j<i;j++){
						if(Cn.getText().charAt(j)>='0'&&Cn.getText().charAt(j)<='9'){
							num++;
						}
					}
						if(num==i){
							JOptionPane.showMessageDialog(this,"课程名不能为纯数字");
						}
						else{
							if(!rs.next()){
								JOptionPane.showMessageDialog(this,"课程不存在或不是您的所教授课程");
							}
							else{
								if(Sno.getText().equals("")){ //学号不可以为空值
									JOptionPane.showMessageDialog(this,"学号不能为空");
								}
								else{
									int l=Sno.getText().length();
									int num2=0;
									for(int j=0;j<l;j++){
										if(Sno.getText().charAt(j)>='0'&&Sno.getText().charAt(j)<='9'){
											num2++;
										}
									}
										if(!(num2==l)){
											JOptionPane.showMessageDialog(this,"学号请输入纯数字");
										}
										else{
											int length=Sno.getText().length();
											if(length!=7){
												JOptionPane.showMessageDialog(this,"学号必须为7位数字");
											}
											else{
								ResultSet rs1=null; //声明返回结果
								rs1=stmt.executeQuery(sql1);
								if(!rs1.next()){
									JOptionPane.showMessageDialog(this,"学生不存在或未修该课程");
								}
								else{
									int k=Score.getText().length();
									int num3=0;
									for(int j=0;j<k;j++){
										if(Score.getText().charAt(j)>='0'&&Score.getText().charAt(j)<='9'){
											num3++;
										}
									}
										if(!(num3==k)){
											JOptionPane.showMessageDialog(this,"分数请输入纯数字");
										}
										else{
									if(!(Float.parseFloat(Score.getText())<=100&&Float.parseFloat(Score.getText())>=0)){
										JOptionPane.showMessageDialog(this,"请输入0-100的分数(可有小数)");
									}
									else{
										ResultSet rs3=null; //声明返回结果
										rs3=stmt.executeQuery(sql2);
										if(rs3.next()){
											JOptionPane.showMessageDialog(this, "该学生已有成绩");
										}
										else{
											stmt.executeUpdate(sql3);
											JOptionPane.showMessageDialog(this, "分数添加成功");
										}
									}
										}
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

class BackgroundPanelTAddSC extends JPanel  
{  
    Image im;  
    public BackgroundPanelTAddSC(Image im)  
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