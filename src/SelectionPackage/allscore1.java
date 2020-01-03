package SelectionPackage;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.awt.event.*;
public  class allscore1 extends JPanel implements ActionListener  {
	JTextField year=new JTextField(20);//课程号;
	JTextField term=new JTextField(20);//课程名;
	JButton jb=new JButton("查找");
	JPanel jp;
	String id;
	JLabel a=new JLabel("查询所有成绩");
	public allscore1(String id1){
		id=id1;
		jb.addActionListener(this);
		Box box0=Box.createHorizontalBox();
		Box box1=Box.createHorizontalBox();
		Box box2=Box.createHorizontalBox();
		Box box3=Box.createHorizontalBox();
		box0.add(a);
		box1.add(new JLabel("学年",JLabel.CENTER));
		box1.add(year);
		box2.add(new JLabel("学期",JLabel.CENTER));
		box2.add(term);
		box3.add(jb);
		
		Box boxH=Box.createVerticalBox();
		boxH.add(box0);
		boxH.add(box1);
		boxH.add(box2);
		boxH.add(box3);
		boxH.add(Box.createVerticalGlue());
		BackgroundPanelallscore1 jp=new BackgroundPanelallscore1((new ImageIcon("C:\\Users\\11862\\Pictures\\ZM\\该查成绩了.png")).getImage());
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
		ResultSet rs=null; //声明返回结果
		String sql=null;
		String sql1;
		ResultSet rs1=null;
		allscore K;
		Statement stmt1=null;
		if(obj==jb){
	    String q=year.getText();
		String w=term.getText();
		//System.out.println(iskong(q,w));
		//&&!term.getText().equals("")
		//&&!(year.getText().equals("")||term.getText().equals(""))
		//(!(isChineseChar(q))&&!cno.getText().equals("")) 
		if(iskong(q,w)) 
			JOptionPane.showMessageDialog(this,"学年和学期不能输入汉字");
		}
		if(!iskong(year.getText(),term.getText())){
			//System.out.println(year.getText().equals(""));
			if(year.getText().equals("")){
				JOptionPane.showMessageDialog(this,"学年不能为空");
			}
			else if(term.getText().equals("")){
				try{
					String q1=year.getText();
					String w1=term.getText();
sql1="select * from sc where sno= '"+id+"' and cno=any( select cno from t_ime where _year= "+year.getText()+")";
					CONN co=new CONN();
					Connection dbConn1=co.CO();//添加数据库连接
					stmt1=(Statement)dbConn1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
							ResultSet.CONCUR_READ_ONLY);//可以任意向前后移动游标，ResultSet数据只读
					rs1=stmt1.executeQuery(sql1);//executeQuery()方法会把数据库响应的查询结果存放在ResultSet类对象中
					if(!(isChineseChar(q1)&&isChineseChar(w1))) {
						JOptionPane.showMessageDialog(this,"学年和学期不能输入汉字");
					}
					else {
					if(!(rs1.next())){
						JOptionPane.showMessageDialog(this,"学年不存在");}
					else {
						sql="select c.cno,cn,cs,score from c,sc where c.cno=sc.cno and sc.sno='"+id+"' and c.cno =any(select cno from t_ime where  _year="+year.getText()+")";				
						K=new allscore(sql);}
					}
					rs1.close();
					stmt1.close();
				}catch(SQLException e){
					System.out.print("SQL Exception occur.Message is:"+e.getMessage());
				}
			}
			else{
				if(term.getText().equals("1")||term.getText().equals("2")) {
				try{
					String sql2="select term from t_ime where _year="+year.getText();
					sql1="select * from sc where sno= '"+id+"' and cno=any( select cno from t_ime where _year= "+year.getText()+" and term="+term.getText()+")";
										CONN co=new CONN();
										Connection dbConn1=co.CO();//添加数据库连接
										stmt=(Statement)dbConn1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
												ResultSet.CONCUR_READ_ONLY);
										stmt1=(Statement)dbConn1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
												ResultSet.CONCUR_READ_ONLY);//可以任意向前后移动游标，ResultSet数据只读
										rs1=stmt1.executeQuery(sql1);//executeQuery()方法会把数据库响应的查询结果存放在ResultSet类对象中
										rs=stmt.executeQuery(sql2);
										String q2=year.getText();
										String w2=term.getText();
										if(!(isChineseChar(q2)&&isChineseChar(w2))) {
											JOptionPane.showMessageDialog(this,"学年和学期不能输入汉字");
										}
										else {
										if(!rs.next()) {
											JOptionPane.showMessageDialog(this,"学年输入不对(整数数字且和不能超过当前年和不能低于2000)");
										}//!(cn.getText().equals(rs.getString("cn").trim()))
										else {
											String s;
											s=""+rs.getInt("term");
											System.out.println(term.getText());
											System.out.println(rs.getInt("term"));
											if(!(term.getText().equals(s)))
												JOptionPane.showMessageDialog(this,"学期输入不对(整数数字1或2)");
											else {
												if(!(rs1.next())){
													JOptionPane.showMessageDialog(this,"该学年学期没有成绩");}
												else {
													sql="select c.cno,cn,cs,score from c,sc where c.cno=sc.cno and sc.sno='"+id+"'and c.cno =any(select cno from t_ime where _year="+year.getText()+" and term="+term.getText()+")";						
													K=new allscore(sql);
												}
											}
										}
										}
										
										rs1.close();
										stmt1.close();
									}catch(SQLException e){
										System.out.print("SQL Exception occur.Message is:"+e.getMessage());
									}
				}
				else {
					JOptionPane.showMessageDialog(this,"学期输入不对(整数数字1或2)");
				}
					
				
			}
		}
			
		}
	}
	
class BackgroundPanelallscore1 extends JPanel  
{  
    Image im;  
    public BackgroundPanelallscore1(Image im)  
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
	
