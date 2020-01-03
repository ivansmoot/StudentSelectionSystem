package SelectionPackage;

import java.awt.*;

import javax.swing.*;

import java.sql.*;
import java.awt.event.*;

public class AddTP extends JPanel implements ActionListener{
	
	JTextField Sy=new JTextField(20); //学年
	JTextField Term=new JTextField(20);  //学期
	JTextField Sy1=new JTextField(20); //年级
	JTextField Dno=new JTextField(20); //专业
	JTextField Cno=new JTextField(20);  //课程号
	
	JTextField Cs=new JTextField(20); //学分
	JTextField Cp=new JTextField(20);  //总学时
	JTextField Cp1=new JTextField(20); //理论教学学时
	JTextField Cp2=new JTextField(20);  //实验或实践学时
	JTextField Cp3=new JTextField(20); //上机学时
	JTextField Cp4=new JTextField(20);  //每周学时
	JButton jb=new JButton("保存"); //保存按钮
	
	//缁勪欢璁剧疆
	public AddTP(){
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());//绐楀彛澶栬璁剧疆涓烘墍鐢ㄧ郴缁熷钩鍙板瑙�
		}catch(Exception e){
			System.out.println("无法设置外观"+e);
		}

		jb.addActionListener(this); //涓烘寜閽缃簨浠�
		
		//灏嗚緭鍏ユ鍜屾寜閽斁鍏OX缁勪欢瀹瑰櫒
		Box box1=Box.createHorizontalBox();
		Box box2=Box.createHorizontalBox();
		Box box3=Box.createHorizontalBox();
		Box box4=Box.createHorizontalBox();
		Box box5=Box.createHorizontalBox();
		Box box6=Box.createHorizontalBox();
		Box box7=Box.createHorizontalBox();
		Box box8=Box.createHorizontalBox();
		Box box9=Box.createHorizontalBox();
		Box box10=Box.createHorizontalBox();
		Box box11=Box.createHorizontalBox();
		Box box12=Box.createHorizontalBox();
		
		
		box1.add(new JLabel("学年"));
		box1.add(Sy);
		box2.add(new JLabel("学期"));
		box2.add(Term);
		box3.add(new JLabel("年级"));
		box3.add(Sy1);
		box4.add(new JLabel("专业"));
		box4.add(Dno);
		box5.add(new JLabel("课程号"));
		box5.add(Cno);
		box6.add(new JLabel("学分"));
		box6.add(Cs);
		box7.add(new JLabel("学时"));
		box7.add(Cp);
		box8.add(new JLabel("理论教学学时"));
		box8.add(Cp1);
		box9.add(new JLabel("实践或实验学时"));
		box9.add(Cp2);
		box10.add(new JLabel("上机学时"));
		box10.add(Cp3);
		box11.add(new JLabel("每周学时"));
		box11.add(Cp4);
		box12.add(jb);
		
		Box boxH=Box.createVerticalBox();
		boxH.add(box1);
		boxH.add(box2);
		boxH.add(box3);
		boxH.add(box4);
		boxH.add(box5);
		boxH.add(box6);
		boxH.add(box7);
		boxH.add(box8);
		boxH.add(box9);
		boxH.add(box10);
		boxH.add(box11);
		boxH.add(box12);
		boxH.add(Box.createVerticalGlue());
		
		BackgroundPanelAddTP jp;//创建面板
		jp=new BackgroundPanelAddTP((new ImageIcon("C:\\Users\\11862\\Pictures\\ZM\\背景.png")).getImage());
		jp.add(boxH);
		setLayout(new BorderLayout()); //杈规甯冨眬
		add(jp,BorderLayout.CENTER);
		validate();
	}
	
	//鍔ㄤ綔浜嬩欢鎵ц
	public void actionPerformed(ActionEvent c){ 
		Object obj=c.getSource();
		if(obj==jb){
			
			Statement stmt=null, stmt1=null;//鍒涘缓鎺ュ彛
			ResultSet rs=null,rs1=null; //澹版槑杩斿洖缁撴灉
			String sql,sql1,sql2,sql3,sql4;
			sql1="select * from C where cno='"+Cno.getText()+"' and dno='"+Dno.getText()+"'and cc=1";
			sql2="select * from TP where sy='"+Sy.getText()+"' and term='"+Term.getText()+"' and sy1='"+Sy1.getText()+"' and  dno='"+Dno.getText()+"' and cno='"+Cno.getText()+"'";
			
			sql="insert into TP values('"+Sy.getText()+"','"+Term.getText()+"','"+Sy1.getText()+"','"+Dno.getText()+"','"+Cno.getText()+"','"+Cs.getText()+"','"+Cp.getText()+"','"+Cp1.getText()+"','"+Cp2.getText()+"','"+Cp3.getText()+"','"+Cp4.getText()+"')";
			//触发器
			sql3=
					"	create Trigger TP_CT_insert" + 
					"	on TP" + 
					"	for insert" + 
					"	as" + 
					"	 begin" + 
					"	  insert into CTimetable(sy,term,sy1,dno,cno) select sy,term,sy1,dno,cno from inserted where dno='"+Dno.getText()+"' and sy1='"+Sy1.getText()+"';" + 
					"	 " + 
					"	  end" 
				;
			sql4="drop trigger TP_CT_insert";
			try{
				CONN co=new CONN();
				Connection dbConn1=co.CO();//娣诲姞鏁版嵁搴撹繛鎺�
				stmt=(Statement)dbConn1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);//鍙互浠绘剰鍚戝墠鍚庣Щ鍔ㄦ父鏍囷紝ResultSet鏁版嵁鍙
				stmt1=(Statement)dbConn1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);
				rs=stmt.executeQuery(sql2);//executeQuery()鏂规硶浼氭妸鏁版嵁搴撳搷搴旂殑鏌ヨ缁撴灉瀛樻斁鍦≧esultSet绫诲璞′腑
				rs1=stmt1.executeQuery(sql1);
				
				if(Sy.getText().equals("")||Term.getText().equals("")||Sy1.getText().equals("")||Dno.getText().equals("")||Cno.getText().equals("")){ //涓撲笟浠ｇ爜涓嶅彲浠ヤ负绌哄��
					JOptionPane.showMessageDialog(this,"学年、学期、年级、专业、课程号不能为空");
				}
				else{
					if(!(Term.getText().equals("1")||Term.getText().equals("2")))
						JOptionPane.showMessageDialog(this,"学期仅为1或2");
					if(Cs.getText().equals("")||Cp.getText().equals("")||Cp4.getText().equals("")){//涓撲笟鍚嶇О涓嶅彲浠ヤ负绌哄��
						JOptionPane.showMessageDialog(this,"学分、学时，每周学时不能为空");
					}
					else {
						if(!rs1.next()) {
							JOptionPane.showMessageDialog(this,"专业与课程不对应或该课程不是必修课");
						}
					
					else{
						if(rs.next()){
							JOptionPane.showMessageDialog(this,"该记录已存在");
						}
						else{
							stmt.executeUpdate(sql3);
							stmt.executeUpdate(sql);//executeUpdate()鏂规硶鐢ㄤ簬鎵ц INSERT銆乁PDATE 鎴� DELETE 璇彞浠ュ強 SQL DDL锛堟暟鎹畾涔夎瑷�锛夎鍙�
							stmt.executeUpdate(sql4);
							JOptionPane.showMessageDialog(this, "教学计划添加成功");
						}
					
					}
				}
				
				}
				rs.close();
				rs1.close();
				stmt.close();
			}catch(SQLException e){
				System.out.print("SQL Exception occur.Message is:"+e.getMessage());
			}
		}
	}
}

class BackgroundPanelAddTP extends JPanel  
{  
    Image im;  
    public BackgroundPanelAddTP(Image im)  
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