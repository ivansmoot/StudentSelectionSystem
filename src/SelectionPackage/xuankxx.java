package SelectionPackage;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.*;
public  class xuankxx extends JPanel implements ActionListener  {
	JTextField year=new JTextField(20);//课程号;
	JTextField term=new JTextField(20);//课程名;
	JButton jb=new JButton("查找所学课程");
	JButton jb1=new JButton("查找选修课程");
	JButton jb2=new JButton("查找必修课程");
	JPanel jp;
	String id;
	JLabel a=new JLabel("查询所选课信息");
	public xuankxx(String id1){
		id=id1;
		jb.addActionListener(this);
		jb1.addActionListener(this);
		jb2.addActionListener(this);
		Box box1=Box.createHorizontalBox();
		Box box2=Box.createHorizontalBox();
		Box box3=Box.createHorizontalBox();
		Box box0=Box.createHorizontalBox();
		box0.add(a);
		box1.add(new JLabel("学年",JLabel.CENTER));
		box1.add(year);
		box2.add(new JLabel("学期",JLabel.CENTER));
		box2.add(term);
		box3.add(jb);
		box3.add(jb1);
		box3.add(jb2);
		Box boxH=Box.createVerticalBox();
		boxH.add(box0);
		boxH.add(box1);
		boxH.add(box2);
		boxH.add(box3);
		boxH.add(Box.createVerticalGlue());
		BackgroundPanelxuankxx jp=new BackgroundPanelxuankxx((new ImageIcon("C:\\Users\\11862\\Pictures\\ZM\\该选课了.png")).getImage());
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
	public static boolean iskong(String str,String str1){
        if(!(isChineseChar(str)&&isChineseChar(str1))){
       if((str.equals("")&&str1.equals(""))){ 
           return  false;
       }
       if((str.equals("")&&isChineseChar(str1))) {
       return false;
       }
       if((str1.equals("")&&isChineseChar(str))) {
           return false;
           }
       else
       	return true;
        }
        else
		  return false;
	}
	public void actionPerformed(ActionEvent c){
		Object obj=c.getSource();
		Statement stmt=null;//创建接口
		Statement stmt1=null;
		ResultSet rs=null; //声明返回结果
		String sql=null;
		xuankxx1 K;
		String q=year.getText();
		String w=term.getText();
		if(iskong(q,w)) {
			JOptionPane.showMessageDialog(this,"学年和学期不能输入汉字");
		}
		if(!iskong(q,w)) {
		if(obj==jb){
			{
			if(year.getText().equals("")){
				JOptionPane.showMessageDialog(this,"学年不能为空");
			}
			else if(term.getText().equals("")){
				try{
					String sql1;
sql1="select c.cno,cn,cs,cp,dno from c,sc where c.cno=sc.cno and sc.sno='"+id+"'and c.cno =any(select cno from t_ime where _year="+year.getText()+")";
					CONN co=new CONN();
					Connection dbConn1=co.CO();//添加数据库连接
					stmt1=(Statement)dbConn1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_READ_ONLY);//可以任意向前后移动游标，ResultSet数据只读
					rs=stmt1.executeQuery(sql1);//executeQuery()方法会把数据库响应的查询结果存放在ResultSet类对象中
					
					
					if(!(rs.next())){
						JOptionPane.showMessageDialog(this,"该学年你未有选课");}
					else {
						sql="select c.cno,cn,cs,cp,dno from c,sc where c.cno=sc.cno and sc.sno='"+id+"'and c.cno =any(select cno from t_ime where _year="+year.getText()+")";	
						K=new xuankxx1(sql);}
					
					rs.close();
					stmt1.close();
				}catch(SQLException e){
					System.out.print("SQL Exception occur.Message is:"+e.getMessage());
				}
			}
			else{	
				if(term.getText().equals("1")||term.getText().equals("2")) {
			
				try{
					String sql1;
sql1="select c.cno,cn,cs,cp,dno from c,sc where c.cno=sc.cno and sc.sno='"+id+"'and c.cno =any(select cno from t_ime where _year="+year.getText()+" and term="+term.getText()+")";
					CONN co=new CONN();
					Connection dbConn1=co.CO();//添加数据库连接
					stmt1=(Statement)dbConn1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_READ_ONLY);//可以任意向前后移动游标，ResultSet数据只读
					rs=stmt1.executeQuery(sql1);//executeQuery()方法会把数据库响应的查询结果存放在ResultSet类对象中
					
					
					if(!(rs.next())){
						JOptionPane.showMessageDialog(this,"该学年学期你未有选课");}
					else {
						sql="select c.cno,cn,cs,cp,dno from c,sc where c.cno=sc.cno and sc.sno='"+id+"'and c.cno =any(select cno from t_ime where _year="+year.getText()+" and term="+term.getText()+")";										
						K=new xuankxx1(sql);}
					
					rs.close();
					stmt1.close();
				}catch(SQLException e){
					System.out.print("SQL Exception occur.Message is:"+e.getMessage());
				}
				}
				else
					JOptionPane.showMessageDialog(this,"学期只能为1或2");
				
			}
			}
		}
		if(obj==jb1){
			if(year.getText().equals("")){
				JOptionPane.showMessageDialog(this,"学年不能为空");
			}
			else if(term.getText().equals("")){
				try{
					String sql1;
sql1="select c.cno,cn,cs,cp,dno from c,sc where cc=0 and c.cno=sc.cno and sc.sno='"+id+"'and c.cno =any(select cno from t_ime where _year="+year.getText()+")";	
					CONN co=new CONN();
					Connection dbConn1=co.CO();//添加数据库连接
					stmt1=(Statement)dbConn1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_READ_ONLY);//可以任意向前后移动游标，ResultSet数据只读
					rs=stmt1.executeQuery(sql1);//executeQuery()方法会把数据库响应的查询结果存放在ResultSet类对象中
					
					
					if(!(rs.next())){
						JOptionPane.showMessageDialog(this,"该学年你未有选课");}
					else {
						sql="select c.cno,cn,cs,cp,dno from c,sc where cc=0 and c.cno=sc.cno and sc.sno='"+id+"'and c.cno =any(select cno from t_ime where _year="+year.getText()+")";	
						K=new xuankxx1(sql);}
					
					rs.close();
					stmt1.close();
				}catch(SQLException e){
					System.out.print("SQL Exception occur.Message is:"+e.getMessage());
				}
				
			}
			else{	
				if(term.getText().equals("1")||term.getText().equals("2")) {
				try{
					String sql1;
sql1="select c.cno,cn,cs,cp,dno from c,sc where cc=0 and c.cno=sc.cno and sc.sno='"+id+"'and c.cno =any(select cno from t_ime where _year="+year.getText()+" and term="+term.getText()+")";										
					CONN co=new CONN();
					Connection dbConn1=co.CO();//添加数据库连接
					stmt1=(Statement)dbConn1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_READ_ONLY);//可以任意向前后移动游标，ResultSet数据只读
					rs=stmt1.executeQuery(sql1);//executeQuery()方法会把数据库响应的查询结果存放在ResultSet类对象中
					
					
					if(!(rs.next())){
						JOptionPane.showMessageDialog(this,"该学年学期你未有选课");}
					else {
						sql="select c.cno,cn,cs,cp,dno from c,sc where cc=0 and c.cno=sc.cno and sc.sno='"+id+"'and c.cno =any(select cno from t_ime where _year="+year.getText()+" and term="+term.getText()+")";										
						K=new xuankxx1(sql);}
					
					rs.close();
					stmt1.close();
				}catch(SQLException e){
					System.out.print("SQL Exception occur.Message is:"+e.getMessage());
				}
			}
				else
					JOptionPane.showMessageDialog(this,"学期只能为1或2");
			
			}
		}
		if(obj==jb2){
			if(year.getText().equals("")){
				JOptionPane.showMessageDialog(this,"学年不能为空");
			}
			else if(term.getText().equals("")){
				try{
					String sql1;
sql1="select c.cno,cn,cs,cp,dno from c,sc where cc=1 and c.cno=sc.cno and sc.sno='"+id+"'and c.cno =any(select cno from t_ime where _year="+year.getText()+")";	
					CONN co=new CONN();
					Connection dbConn1=co.CO();//添加数据库连接
					stmt1=(Statement)dbConn1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_READ_ONLY);//可以任意向前后移动游标，ResultSet数据只读
					rs=stmt1.executeQuery(sql1);//executeQuery()方法会把数据库响应的查询结果存放在ResultSet类对象中
					
					
					if(!(rs.next())){
						JOptionPane.showMessageDialog(this,"该学年你未有选课");}
					else {
						sql="select c.cno,cn,cs,cp,dno from c,sc where cc=1 and c.cno=sc.cno and sc.sno='"+id+"'and c.cno =any(select cno from t_ime where _year="+year.getText()+")";	
						K=new xuankxx1(sql);}
					
					rs.close();
					stmt1.close();
				}catch(SQLException e){
					System.out.print("SQL Exception occur.Message is:"+e.getMessage());
				}
			
			}
			else{		
				if(term.getText().equals("1")||term.getText().equals("2")) {
				try{
					String sql1;
sql1="select c.cno,cn,cs,cp,dno from c,sc where cc=1 and c.cno=sc.cno and sc.sno='"+id+"'and c.cno =any(select cno from t_ime where _year="+year.getText()+" and term="+term.getText()+")";										
					CONN co=new CONN();
					Connection dbConn1=co.CO();//添加数据库连接
					stmt1=(Statement)dbConn1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_READ_ONLY);//可以任意向前后移动游标，ResultSet数据只读
					rs=stmt1.executeQuery(sql1);//executeQuery()方法会把数据库响应的查询结果存放在ResultSet类对象中
					
					
					if(!(rs.next())){
						JOptionPane.showMessageDialog(this,"该学年学期你未有选课");}
					else {
						sql="select c.cno,cn,cs,cp,dno from c,sc where cc=1 and c.cno=sc.cno and sc.sno='"+id+"'and c.cno =any(select cno from t_ime where _year="+year.getText()+" and term="+term.getText()+")";										
						K=new xuankxx1(sql);}
					
					rs.close();
					stmt1.close();
				}catch(SQLException e){
					System.out.print("SQL Exception occur.Message is:"+e.getMessage());
				}
				
				}
				else
					JOptionPane.showMessageDialog(this,"学期只能为1或2");
			
			}
		}
	}
	}
}
class BackgroundPanelxuankxx extends JPanel  
{  
    Image im;  
    public BackgroundPanelxuankxx(Image im)  
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