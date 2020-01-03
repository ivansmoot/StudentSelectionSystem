package SelectionPackage;

import java.awt.*;

import javax.swing.*;

import java.sql.*;
import java.awt.event.*;
public class UpdateTP extends JPanel implements ActionListener {

	JTextField Sy=new JTextField(20); //学年
	JTextField Term=new JTextField(20);  //学期
	JTextField Sy1=new JTextField(20); //年级
	JTextField Dno=new JTextField(20); //专业
	JTextField Cno=new JTextField(20);  //课程
	JTextField Cp4=new JTextField(20);//每周课时
	JButton jb=new JButton("修改"); //修改按钮
	
	public UpdateTP() {
		
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
		Box box7=Box.createHorizontalBox();
		
		box1.add(new JLabel("学年"));
		box1.add(Sy);
		box2.add(new JLabel("学期"));
		box2.add(Term);
		box3.add(new JLabel("年级"));
		box3.add(Sy1);
		box4.add(new JLabel("专业"));
		box4.add(Dno);
		box5.add(new JLabel("课程"));
		box5.add(Cno);
		box6.add(new JLabel("新的每周课时"));
		box6.add(Cp4);
		box7.add(jb);
		
		Box boxH=Box.createVerticalBox();
		boxH.add(box1);
		boxH.add(box2);
		boxH.add(box3);
		boxH.add(box4);
		boxH.add(box5);
		boxH.add(box6);
		boxH.add(box7);
		
boxH.add(Box.createVerticalGlue());
		
		BackgroundPanelUpdateTP jp;//创建面板
		jp=new BackgroundPanelUpdateTP((new ImageIcon("C:\\Users\\11862\\Pictures\\ZM\\背景.png")).getImage());
		jp.add(boxH);
		setLayout(new BorderLayout()); //边框布局
		add(jp,BorderLayout.CENTER);
		validate();
	}
	
	public void actionPerformed(ActionEvent c){ 
		
		Object obj=c.getSource();
		if(obj==jb) {
			
			Statement stmt=null;//创建接口
			ResultSet rs=null; //声明返回结果
			String sql,sql1;
			
			sql1="select * from TP where sy='"+Sy.getText()+"' and term='"+Term.getText()+"' and sy1='"+Sy1.getText()+"' and dno='"+Dno.getText()+"' and cno='"+Cno.getText()+"'";
		    sql="update TP set cp4='"+Cp4.getText()+"' where sy='"+Sy.getText()+"' and term='"+Term.getText()+"' and sy1='"+Sy1.getText()+"' and dno='"+Dno.getText()+"' and cno='"+Cno.getText()+"'";
		
		    try{
				CONN co=new CONN();
				Connection dbConn1=co.CO();//娣诲姞鏁版嵁搴撹繛鎺�
				stmt=(Statement)dbConn1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);//鍙互浠绘剰鍚戝墠鍚庣Щ鍔ㄦ父鏍囷紝ResultSet鏁版嵁鍙
				
				rs=stmt.executeQuery(sql1);
			   
			    
			    if(Sy.getText().equals("")||Term.getText().equals("")||Dno.getText().equals("")||Cno.getText().equals("")){ //涓撲笟浠ｇ爜涓嶅彲浠ヤ负绌哄��
					JOptionPane.showMessageDialog(this,"学年、学期、年级、专业、课程不能为空");
				}
			    else {
			    	if(!(Term.getText().equals("1")||Term.getText().equals("2")))
						JOptionPane.showMessageDialog(this,"学期仅为1或2");
					if(!rs.next()){
						JOptionPane.showMessageDialog(this,"该记录不存在");
					}
					else{
						stmt.executeUpdate(sql);//executeUpdate()鏂规硶鐢ㄤ簬鎵ц INSERT銆乁PDATE 鎴� DELETE 璇彞浠ュ強 SQL DDL锛堟暟鎹畾涔夎瑷�锛夎鍙�
						JOptionPane.showMessageDialog(this, "教学计划修改成功");
					}
					
			}
			    rs.close();
				
				stmt.close();
		    }
		    catch(SQLException e){
				System.out.print("SQL Exception occur.Message is:"+e.getMessage());
			}
		}
	}
}
class BackgroundPanelUpdateTP extends JPanel  
{  
    Image im;  
    public BackgroundPanelUpdateTP(Image im)  
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