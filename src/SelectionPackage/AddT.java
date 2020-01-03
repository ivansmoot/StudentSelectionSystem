package SelectionPackage;

import java.awt.*;

import javax.swing.*;

import java.sql.*;
import java.awt.event.*;

public class AddT extends JPanel implements ActionListener{
	
	JTextField Tno=new JTextField(20); //教师号输入框
	JTextField Tn=new JTextField(20);  //姓名输入框
	JTextField Tsex=new JTextField(20);  //性别输入框
	JTextField Ty=new JTextField(20);  //入职年输入框
	JTextField Dn=new JTextField(20);  //专业名称输入框
	JButton jb=new JButton("录入"); //录入按钮 
	
	//组件设置
	public AddT(){
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
		Box box5=Box.createHorizontalBox();
		Box box6=Box.createHorizontalBox();
		
		box1.add(new JLabel("教师号"));
		box1.add(Tno);
		box2.add(new JLabel("姓名"));
		box2.add(Tn);
		box3.add(new JLabel("性别"));
		box3.add(Tsex);
		box4.add(new JLabel("入职年"));
		box4.add(Ty);
		box5.add(new JLabel("专业名称"));
		box5.add(Dn);
		box6.add(jb);
		
		Box boxH=Box.createVerticalBox();
		boxH.add(box1);
		boxH.add(box2);
		boxH.add(box3);
		boxH.add(box4);
		boxH.add(box5);
		boxH.add(box6);
		boxH.add(Box.createVerticalGlue());
		
		BackgroundPanelAddT pCenter;//创建面板
		pCenter=new BackgroundPanelAddT((new ImageIcon("C:\\Users\\11862\\Pictures\\ZM\\加老师.png")).getImage());
		pCenter.add(boxH);
		setLayout(new BorderLayout()); //边框布局
		add(pCenter,BorderLayout.CENTER);
		validate();
	}
	public boolean checkname(String name){ 
		int n = 0; 
	for(int k = 0; k < name.length(); k++) 
	{
		n = (int)name.charAt(k);
	if(!(19968 <= n && n <40869)) 
	{ 
		return false; 
		} 
	}
	return true; 
	}
	
	//动作事件执行
	public void actionPerformed(ActionEvent c){ 
		Object obj=c.getSource();
		if(obj==jb){
			
			Statement stmt=null;//创建接口
			ResultSet rs=null; //声明返回结果
			String sql,sql1,sql4;
			sql="select * from T where tno='"+Tno.getText()+"'";  
			sql4="select * from D where dn='"+Dn.getText()+"'";  
			boolean TnoB,TnB,TsexB,TyB,DnB;
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
				
				
				if(Dn.getText().equals("")){//专业名称不可以为空值
						JOptionPane.showMessageDialog(this,"专业名称不能为空");
						DnB=false;
				}
				else{
					byte[] b=Dn.getText().getBytes();
					if(b.length>15){
							JOptionPane.showMessageDialog(this,"专业名称过长");
							DnB=false;
					}
					else{
						int i=Dn.getText().length();
						int num1=0;
						for(int j=0;j<i;j++){
							if(Dn.getText().charAt(j)>='0'&&Dn.getText().charAt(j)<='9'){
								num1++;
							}
						}
						if(num1==i){
								JOptionPane.showMessageDialog(this,"专业名称不能为纯数字");
								DnB=false;
						}
						else{
							ResultSet rs4=null; //声明返回结果
							rs4=stmt.executeQuery(sql4);//executeQuery()方法会把数据库响应的查询结果存放在ResultSet类对象中
							if(!rs4.next()){
								JOptionPane.showMessageDialog(this,"专业不存在");
								DnB=false;
							}
							else{
								DnB=true;
							}
						}
					}
				}
				
				if(Tn.getText().equals("")){
					TnB=true;
				}
				else{
					if(Tn.getText().length()>4||Tn.getText().length()<2){
						JOptionPane.showMessageDialog(this,"姓名为2至4个汉字");
						TnB=false;
					}
					else{
						if(!checkname(Tn.getText())){
							JOptionPane.showMessageDialog(this,"姓名必须为汉字");
							TnB=false;
						}
						else{
							TnB=true;
						}
					}
				}
				
				if(Tsex.getText().equals("")){
					TsexB=true;
				}
				else{
					if(Tsex.getText().length()!=1){
						JOptionPane.showMessageDialog(this,"姓别只能是男/女");
						TsexB=false;
					}
					else{
						if(Tsex.getText().charAt(0)!='男'&&Tsex.getText().charAt(0)!='女'){
							JOptionPane.showMessageDialog(this,"姓别只能是男/女");
							TsexB=false;
						}
						else{
							TsexB=true;
						}
					}
				}
				
				if(Ty.getText().equals("")){
					TyB=true;
				}
				else{
					if(Ty.getText().length()!=4){
						JOptionPane.showMessageDialog(this,"入职年必须是4位");
						TyB=false;
					}
					else{
						int i = Integer.parseInt(Ty.getText());
						if(!(i>=2000&&i<=2018)){
							JOptionPane.showMessageDialog(this,"入职年在2000到2018");
							TyB=false;
						}
						else{
							TyB=true;
						}
					}
				}
						
				if(TnoB&&DnB&&TsexB&&TyB){
					String sql2="select * from D where dn='"+Dn.getText()+"'";  
					rs=stmt.executeQuery(sql2);//executeQuery()方法会把数据库响应的查询结果存放在ResultSet类对象中
					rs.next();
					String sql3=rs.getString("dno");
					System.out.println(sql3);
					sql1="insert into T values('"+Tno.getText()+"','"+Tn.getText()+"','"+Tsex.getText()+"','"+Ty.getText()+"','00000000','"+sql3+"')";
					stmt.executeUpdate(sql1);//executeUpdate()方法用于执行 INSERT、UPDATE 或 DELETE 语句以及 SQL DDL（数据定义语言）语句
					JOptionPane.showMessageDialog(this, "教师添加成功");
				}
				rs.close();
				stmt.close();
			}catch(SQLException e){
				System.out.print("SQL Exception occur.Message is:"+e.getMessage());
			}
		}
	}
}

class BackgroundPanelAddT extends JPanel  
{  
    Image im;  
    public BackgroundPanelAddT(Image im)  
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
