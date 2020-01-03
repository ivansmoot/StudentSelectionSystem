package SelectionPackage;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.*;
public  class AddD1 extends JPanel implements ActionListener  {
	JLabel a=new JLabel("查找选课信息");
	JTextField cno=new JTextField(20);//课程号;
	JTextField cn=new JTextField(20);//课程名;
	JButton jb=new JButton("查找");
	BackgroundPanelAddD1 jp;
	 JPanel jpanel;
	public AddD1( JPanel jpanel1){
		jpanel=jpanel1;
		jb.addActionListener(this);
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
	 jp=new BackgroundPanelAddD1((new ImageIcon("C:\\Users\\11862\\Pictures\\ZM\\查询选课.png")).getImage());
		jp.add(boxH);
		
		setLayout(new BorderLayout()); //边框布局
		this.add(jp,BorderLayout.CENTER);
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
		String sql1;
		ResultSet rs1=null;;
		forSelD1 K;
		if(obj==jb){
			String q=cno.getText();
			System.out.println(cno.getText().equals(""));
			if(!(isChineseChar(q))&&!cno.getText().equals("")) {
				JOptionPane.showMessageDialog(this,"学号不能输入汉字");
			}else {
			if(cno.getText().equals("")&&cn.getText().equals("")){
				sql="select * from c where cc=0";
				K=new forSelD1(sql,jpanel);
			}
			else if(cno.getText().equals("")){
				try{
					
              sql1="select * from c where cn='"+cn.getText()+"'and cc=0";
					CONN co=new CONN();
					Connection dbConn1=co.CO();//添加数据库连接
					stmt=(Statement)dbConn1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_READ_ONLY);//可以任意向前后移动游标，ResultSet数据只读
					rs1=stmt.executeQuery(sql1);//executeQuery()方法会把数据库响应的查询结果存放在ResultSet类对象中
				if(!rs1.next()) {
					JOptionPane.showMessageDialog(this,"没有该课程");
				}else {
					sql="select * from c where cn='"+cn.getText()+"'and cc=0";
					K=new forSelD1(sql,jpanel);
				}
					rs1.close();
					stmt.close();
				}catch(SQLException e){
					System.out.print("SQL Exception occur.Message is:"+e.getMessage());
				}
			}
			else if(cn.getText().equals("")){
				try{
					
		              sql1="select * from c where cno='"+cno.getText()+"'"+"and cc=0";
							CONN co=new CONN();
							Connection dbConn1=co.CO();//添加数据库连接
							stmt=(Statement)dbConn1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
									ResultSet.CONCUR_READ_ONLY);//可以任意向前后移动游标，ResultSet数据只读
							rs1=stmt.executeQuery(sql1);//executeQuery()方法会把数据库响应的查询结果存放在ResultSet类对象中
						if(!rs1.next()) {
							JOptionPane.showMessageDialog(this,"没有该课程");
						}else {
							sql="select * from c where cno='"+cno.getText()+"'"+"and cc=0";
							K=new forSelD1(sql,jpanel);
						}
							rs1.close();
							stmt.close();
						}catch(SQLException e){
							System.out.print("SQL Exception occur.Message is:"+e.getMessage());
						}
				
			}
			else{
				try{
		              sql1="select * from c where cno='"+cno.getText()+"'"+"and cc=0 and "+"cn='"+cn.getText()+"'";
							CONN co=new CONN();
							Connection dbConn1=co.CO();//添加数据库连接
							stmt=(Statement)dbConn1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
									ResultSet.CONCUR_READ_ONLY);//可以任意向前后移动游标，ResultSet数据只读
							rs1=stmt.executeQuery(sql1);//executeQuery()方法会把数据库响应的查询结果存放在ResultSet类对象中
						if(!rs1.next()) {
							JOptionPane.showMessageDialog(this,"没有该课程");
						}else {
							sql="select * from c where cno='"+cno.getText()+"' and cn='"+cn.getText()+"'"+"and cc=0";
							K=new forSelD1(sql,jpanel);
						}
							rs1.close();
							stmt.close();
						}catch(SQLException e){
							System.out.print("SQL Exception occur.Message is:"+e.getMessage());
						}
				
			}
			
			
		}
		}
	}
	

	
}
class BackgroundPanelAddD1 extends JPanel  
{  
    Image im;  
    public BackgroundPanelAddD1(Image im)  
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