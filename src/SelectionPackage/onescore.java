package SelectionPackage;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.*;
public  class onescore extends JPanel implements ActionListener  {
	JTextField cno=new JTextField(20);//课程号;
	JTextField cn=new JTextField(20);//课程名;
	JButton jb=new JButton("查找");
	JPanel jp;
	String id;
	JLabel a=new JLabel("查询单科成绩");
	public onescore(String id1){
		id=id1;
		jb.addActionListener(this);
		Box box1=Box.createHorizontalBox();
		Box box0=Box.createHorizontalBox();
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
		BackgroundPanelonescore jp=new BackgroundPanelonescore((new ImageIcon("C:\\Users\\11862\\Pictures\\ZM\\该查成绩了.png")).getImage());
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
	public void actionPerformed(ActionEvent c){
		Object obj=c.getSource();
		Statement stmt=null;//创建接口
		ResultSet rs=null; //声明返回结果
		String sql=null;
		onescore2 K;
		String sql1;
		if(obj==jb){
			if(cno.getText().equals("")&&cn.getText().equals("")){
				JOptionPane.showMessageDialog(this,"课程号和课程名不能同时为空");
			}
			else if(!isChineseChar(cno.getText())&&!cno.getText().equals("")) {
				JOptionPane.showMessageDialog(this,"课程号不能为汉字");
			}
			else if(cno.getText().equals("")){
				try{
					sql1="select c.cno,cn,cs,score from c,sc where c.cno=sc.cno and sc.sno='"+id+"'and c.cn='"+cn.getText()+"'";
										CONN co=new CONN();
										Connection dbConn1=co.CO();//添加数据库连接
										stmt=(Statement)dbConn1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
												ResultSet.CONCUR_READ_ONLY);//可以任意向前后移动游标，ResultSet数据只读
										rs=stmt.executeQuery(sql1);//executeQuery()方法会把数据库响应的查询结果存放在ResultSet类对象中
										
										if(!(rs.next())){
											JOptionPane.showMessageDialog(this,"该课程你没有选");}
										else {
											sql="select c.cno,cn,cs,score from c,sc where c.cno=sc.cno and sc.sno='"+id+"'and c.cn='"+cn.getText()+"'";
											K=new onescore2(sql);
										}
										rs.close();
										stmt.close();
									}catch(SQLException e){
										System.out.print("SQL Exception occur.Message is:"+e.getMessage());
									}
				
			}
			else if(cn.getText().equals("")){
				try{
					sql1="select c.cno,cn,cs,score from c,sc where c.cno=sc.cno and sc.sno='"+id+"'and c.cno='"+cno.getText()+"'";
										CONN co=new CONN();
										Connection dbConn1=co.CO();//添加数据库连接
										stmt=(Statement)dbConn1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
												ResultSet.CONCUR_READ_ONLY);//可以任意向前后移动游标，ResultSet数据只读
										rs=stmt.executeQuery(sql1);//executeQuery()方法会把数据库响应的查询结果存放在ResultSet类对象中
										
										if(!(rs.next())){
											JOptionPane.showMessageDialog(this,"该课程你没有选");}
										else {
											sql="select c.cno,cn,cs,score from c,sc where c.cno=sc.cno and sc.sno='"+id+"'and c.cno='"+cno.getText()+"'";
											K=new onescore2(sql);
										}
										rs.close();
										stmt.close();
									}catch(SQLException e){
										System.out.print("SQL Exception occur.Message is:"+e.getMessage());
									}
			
			}
			else{
				String sql2="select * from c where cno='"+cno.getText()+"'";
				try{
					Statement stmt1=null;
					ResultSet rs1=null;
					CONN co=new CONN();
					Connection dbConn1=co.CO();//添加数据库连接
					stmt=(Statement)dbConn1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_READ_ONLY);//可以任意向前后移动游标，ResultSet数据只读
					stmt1=(Statement)dbConn1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_READ_ONLY);
					rs=stmt.executeQuery(sql2);//executeQuery()方法会把数据库响应的查询结果存放在ResultSet类对象中
					if(!(rs.next())){
						JOptionPane.showMessageDialog(this,"课程不存在");}
					else {
						if(!(cn.getText().equals(rs.getString("cn").trim()))) {
							JOptionPane.showMessageDialog(this,"课程号与课程名不符");
						}
						else {
							sql="select c.cno,cn,cs,score from c,sc where c.cno=sc.cno and sc.sno='"+id+"'and c.cno='"+cno.getText()+"'";
							rs1=stmt.executeQuery(sql2);
							if(!(rs1.next())){
								JOptionPane.showMessageDialog(this,"该课程你没有选");}
							else {
								sql="select c.cno,cn,cs,score from c,sc where c.cno=sc.cno and sc.sno='"+id+"'and c.cno='"+cno.getText()+"'";
								K=new onescore2(sql);
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
class BackgroundPanelonescore extends JPanel  
{  
    Image im;  
    public BackgroundPanelonescore(Image im)  
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
	
