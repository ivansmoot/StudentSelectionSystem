package SelectionPackage;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.*;
public class tian extends JPanel implements ActionListener{
	private static final String Int = null;
	JTextField cno=new JTextField(20);//课程号
	JTextField cn=new JTextField(20);//课程名
	JTextField year=new JTextField(20);
	JTextField term=new JTextField(20);
	JButton jb=new JButton("添加");
	String id1;
	JLabel a=new JLabel("添加选课信息");
public tian(String id) {
	try{
		UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());//窗口外观设置为所用系统平台外观
	}catch(Exception e){
		System.out.println("无法设置外观："+e);
	}
    id1=id;
	jb.addActionListener(this); //为按钮设置事件
	
	//将输入框和按钮放入BOX组件容器
	Box box0=Box.createHorizontalBox();
	Box box1=Box.createHorizontalBox();
	Box box2=Box.createHorizontalBox();
	Box box3=Box.createHorizontalBox();
	box0.add(a);
	box1.add(new JLabel("课程号",JLabel.CENTER));
	box1.add(cno);
	box2.add(new JLabel("课程名",JLabel.CENTER));
	box2.add(cn);
	box3.add(jb);
	Box boxH=Box.createVerticalBox();
	boxH.add(box0);
	boxH.add(box1);
	boxH.add(box2);
	boxH.add(box3);

	boxH.add(Box.createVerticalGlue());
	BackgroundPaneltian jp=new BackgroundPaneltian((new ImageIcon("C:\\Users\\11862\\Pictures\\ZM\\该选课了.png")).getImage());
	jp.add(boxH);
	setLayout(new BorderLayout()); //边框布局
	add(jp,BorderLayout.CENTER);
	validate();
}
public static boolean isChineseChar(String str){
    Pattern p=Pattern.compile("[u4e00-u9fa5]"); 
    Matcher m=p.matcher(str); 
    if(m.find()){ 
        return  true;
    }
    return false;
}
public void actionPerformed(ActionEvent c) {
	Object obj=c.getSource();
	if(obj==jb) {
		
    String sql3="select * from sc where cno='"+cno.getText()+"'and sno='"+id1+"'";
	String sql="insert into sc values('"+id1+"','"+cno.getText()+"',"+null+","+null+","+null+")";
	String sql1="update c set n=n+1 where cno='"+cno.getText()+"'";
	String sql2="select * from c where cno='"+cno.getText()+"'";
			
	Statement stmt=null;
	Statement stmt1=null;
	Statement stmt2=null;
	ResultSet rs=null;
	ResultSet rs1=null;
	ResultSet rs2=null;
	//System.out.println(cno.getText());
	 if(!isChineseChar(cno.getText())&&!cno.getText().equals("")) {
		JOptionPane.showMessageDialog(this,"课程号不能为汉字");
	}
	 else {
		 if(cno.getText().equals("")){
			JOptionPane.showMessageDialog(tian.this, "课程号不能为空");
		}
		else {
			if(!cn.getText().equals("")){
			try{
				CONN co=new CONN();
				Connection dbConn1=co.CO();//添加数据库连接
				stmt=(Statement)dbConn1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);//可以任意向前后移动游标，ResultSet数据只读
				stmt1=(Statement)dbConn1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				stmt2=(Statement)dbConn1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				rs=stmt.executeQuery(sql2);//executeQuery()方法会把数据库响应的查询结果存放在ResultSet类对象中
				rs1=stmt1.executeQuery(sql3);
				if(!(rs.next())){
					JOptionPane.showMessageDialog(this,"课程不存在");}
				else {/*
					String  a;
					int b;
					int  d;
					year.getText();
					b=Integer.parseInt(year.getText());
					d=Integer.parseInt(term.getText());
					a=rs.getString("dno");
					String sql4="insert into t_ime values("+"'"+cno.getText()+"'"+",'"+id1+"',"+"'"+a+"',"+b+","+d+")";
					stmt.executeUpdate(sql4);	*/
					if(!(cn.getText().equals(rs.getString("cn").trim()))) {
						JOptionPane.showMessageDialog(this,"课程号与课程名不符");
					}
					else {
						if(rs1.next()) {
							JOptionPane.showMessageDialog(this,"已选该课程");
						}
					 if(rs.getInt("n")>=100) {
						JOptionPane.showMessageDialog(this,"人数超限");
					}
					else{
							stmt.executeUpdate(sql);
							stmt.executeUpdate(sql1);
							JOptionPane.showMessageDialog(this,"添加成功");
						}
					}
				}
				rs1.close();
				rs.close();
				stmt.close();
				stmt1.close();
			}catch(SQLException e){
				System.out.print("SQL Exception occur.Message is:"+e.getMessage());
			}
			}
			else
				try{
					CONN co=new CONN();
					Connection dbConn1=co.CO();//添加数据库连接
					stmt=(Statement)dbConn1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_READ_ONLY);//可以任意向前后移动游标，ResultSet数据只读
					stmt1=(Statement)dbConn1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_READ_ONLY);
					rs=stmt.executeQuery(sql2);//executeQuery()方法会把数据库响应的查询结果存放在ResultSet类对象中
					rs1=stmt1.executeQuery(sql3);
					if(!(rs.next())){
						JOptionPane.showMessageDialog(this,"课程不存在");}
					else {
							if(rs1.next()) {
								JOptionPane.showMessageDialog(this,"已选该课程");
							}
							else {
						 if(rs.getInt("n")>=0) {
							JOptionPane.showMessageDialog(this,"人数超限");
						}
						else{
								stmt.executeUpdate(sql);
								stmt.executeUpdate(sql1);
								JOptionPane.showMessageDialog(this,"添加成功");
							}
						}
					}
					
					rs1.close();
					rs.close();
					stmt.close();
					stmt1.close();
				}catch(SQLException e){
					System.out.print("SQL Exception occur.Message is:"+e.getMessage());
				}
				
				
		}
	 }
	}
    }
}
class BackgroundPaneltian extends JPanel  
{  
    Image im;  
    public BackgroundPaneltian(Image im)  
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

