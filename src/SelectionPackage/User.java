package SelectionPackage;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.sql.*;

public class User extends JFrame{
	private JLabel Account,Password;
	private JTextField AccountField;//用户名输入框
	private JPasswordField PasswordField;//密码输入框
	private JButton LoginButton,LogoutButton;//登入登出按钮
	JRadioButton s1;//单选框
	JRadioButton s2;//单选框
	JRadioButton s3;//单选框
	//登录窗口
	public User(){
		super("学生选课系统登录");
		BackgroundPanel1 pCenter=new BackgroundPanel1((
				new ImageIcon("C:\\Users\\11862\\Pictures\\ZM\\登录界面.jpg")).getImage());//创建面板
		pCenter.setLayout(null);
		
		Account=new JLabel("用户名:");
		Password=new JLabel("  密码:");
		AccountField=new JTextField(18);
		PasswordField=new JPasswordField(18);
		LoginButton=new JButton("登录");
		LogoutButton=new JButton("退出");
		s1=new JRadioButton("学生",true);
		s2=new JRadioButton("管理员");
		s3=new JRadioButton("教师");
		s1.setContentAreaFilled(false);
		s2.setContentAreaFilled(false);
		s3.setContentAreaFilled(false);
		ButtonGroup g=new ButtonGroup();
		g.add(s1);
		g.add(s2);
		g.add(s3);
		Account.setBounds(620, 150, 100, 100);
		Password.setBounds(620, 180, 100, 100);
		LoginButton.setBounds(620, 290, 60, 30);
		LogoutButton.setBounds(700, 290, 60, 30);
		AccountField.setBounds(680,190,100,20);
		PasswordField.setBounds(680,220,100,20);
		s1.setBounds(600,250,70,30);
		s2.setBounds(680,250,70,30);
		s3.setBounds(760,250,70,30);
		//设置登录方法
		LOGIN I=new LOGIN();
		LOGOUT O=new LOGOUT();
		LoginButton.addActionListener(I);
		LogoutButton.addActionListener(O);
		//添加组件
		pCenter.add(Account);
		pCenter.add(AccountField);
		pCenter.add(Password);
		pCenter.add(PasswordField);
		pCenter.add(LoginButton);
		pCenter.add(LogoutButton);
		pCenter.add(s1);
		pCenter.add(s2);
		pCenter.add(s3);
		
		//面板设置
		this.getContentPane().add(pCenter);
		validate();
		setBounds(500,250,1000,500);//起点x,起点y,长,宽
		setVisible(true);
		setResizable(false);//自由改变大小
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//结束程序
	}
	public static void main(String[] args){
		User l=new User( );
	}
	//按钮登录方法
	private class LOGIN implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if(AccountField.getText().equals("")||PasswordField.getText().equals("")){
				JOptionPane.showMessageDialog(User.this, "用户名密码不能为空");
			}
			else{
				if(s2.isSelected()){
				Statement st=null;
				ResultSet re=null;
				String sql;
				sql="select * from M where Username='"+AccountField.getText()+"'";
				try{
					CONN co=new CONN();
					Connection dbConn1=co.CO();//添加数据库连接
					st=(Statement)dbConn1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
					re=st.executeQuery(sql);
					if(re.next()){
						String xm=re.getString("password");
						if(PasswordField.getText().equals(xm.trim())){JOptionPane.showMessageDialog(User.this,"登录成功");
						dispose();
						new Menu();
						}
						else{JOptionPane.showMessageDialog(User.this,"密码错误");}	
					}
					else{JOptionPane.showMessageDialog(User.this,"用户名错误");}
					re.close();
					st.close();
				}
					catch(SQLException e){
						JOptionPane.showMessageDialog(User.this,"SQL Exception Occur Message is "+e.getMessage());
					}
				}
				else if(s1.isSelected()){
					if(AccountField.getText().equals("")||PasswordField.getText().equals("")){
						JOptionPane.showMessageDialog(User.this, "用户名密码不能为空");
					}
					else{
						String id;
						id=AccountField.getText();
						Statement st=null;
						ResultSet re=null;
						String sql;
						sql="select * from s where sno='"+AccountField.getText()+"'";
						try{
							String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";//加载JDBC驱动
							String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=StudentSelectionSystem";//连接服务器
							String userName="sa";//用户名
							String userPassword="miss1186285865";//密码
							Connection dbConn1=null;
							try{
								Class.forName(driverName);
								dbConn1=DriverManager.getConnection(dbURL,userName,userPassword);
								System.out.println("Connection Successfully");
							}catch(Exception e){
								e.printStackTrace();
							}
							//添加数据库连接
							st=(Statement)dbConn1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
							re=st.executeQuery(sql);
							if(re.next()){
								String xm=re.getString("sp");
								if(PasswordField.getText().equals(xm.trim())){JOptionPane.showMessageDialog(User.this,"登录成功");
								dispose();
							new mune(id);
								}
								else{JOptionPane.showMessageDialog(User.this,"密码错误");}	
							}
							else{JOptionPane.showMessageDialog(User.this,"用户名错误");}
							re.close();
							st.close();
						}
							catch(SQLException e){
								JOptionPane.showMessageDialog(User.this,"SQL Exception Occur Message is "+e.getMessage());
							}
						}
				}
				else if(s3.isSelected()){
					if(AccountField.getText().equals("")||PasswordField.getText().equals("")){
						JOptionPane.showMessageDialog(User.this, "用户名密码不能为空");
					}
					else{
						String id;
						id=AccountField.getText();
						Statement st=null;
						ResultSet re=null;
						String sql;
						sql="select * from t where tno='"+AccountField.getText()+"'";
						try{
							String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";//加载JDBC驱动
							String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=StudentSelectionSystem";//连接服务器
							String userName="sa";//用户名
							String userPassword="miss1186285865";//密码
							Connection dbConn1=null;
							try{
								Class.forName(driverName);
								dbConn1=DriverManager.getConnection(dbURL,userName,userPassword);
								System.out.println("Connection Successfully");
							}catch(Exception e){
								e.printStackTrace();
							}
							//添加数据库连接
							st=(Statement)dbConn1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
							re=st.executeQuery(sql);
							if(re.next()){
								String xm=re.getString("tp");
								if(PasswordField.getText().equals(xm.trim())){JOptionPane.showMessageDialog(User.this,"登录成功");
								dispose();
								new TMenu(id);
								}
								else{JOptionPane.showMessageDialog(User.this,"密码错误");}	
							}
							else{JOptionPane.showMessageDialog(User.this,"用户名错误");}
							re.close();
							st.close();
						}
							catch(SQLException e){
								JOptionPane.showMessageDialog(User.this,"SQL Exception Occur Message is "+e.getMessage());
							}
						}
				}
			}
			}
		}
	//按钮退出方法
	private class LOGOUT implements ActionListener{
		public void actionPerformed(ActionEvent even){
			System.exit(0);
		}
	}
}
class BackgroundPanel1 extends JPanel  
{  
    Image im;  
    public BackgroundPanel1(Image im)  
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
