package SelectionPackage;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Menu extends JFrame implements ActionListener{
	BackgroundPanel pCenter;//创建面板
	CardLayout card=null;//卡片式布局
	JLabel label=null;//创建标签
	JMenuBar bar=new JMenuBar();//菜单栏
	
	//菜单内容创建
	JMenu m1=new JMenu("专业管理");
	JMenuItem add1=new JMenuItem("添加专业");
	JMenuItem update1=new JMenuItem("修改专业");
	JMenuItem delete1=new JMenuItem("删除专业");
	JMenuItem select1=new JMenuItem("查询专业");
	
	JMenu m2=new JMenu("学生管理");
	JMenuItem add2=new JMenuItem("添加学生");
	JMenuItem update2=new JMenuItem("修改学生");
	JMenuItem delete2=new JMenuItem("删除学生");
	JMenuItem select2=new JMenuItem("查询学生");
	
	JMenu m3=new JMenu("教师管理");
	JMenuItem add3=new JMenuItem("添加教师");
	JMenuItem update3=new JMenuItem("修改教师");
	JMenuItem delete3=new JMenuItem("删除教师");
	JMenuItem select3=new JMenuItem("查询教师");
	
	JMenu m4=new JMenu("课程管理");
	JMenuItem add4=new JMenuItem("添加课程");
	JMenuItem update4=new JMenuItem("修改课程");
	JMenuItem delete4=new JMenuItem("删除课程");
	JMenuItem select4=new JMenuItem("查询课程");
	
	JMenu m5=new JMenu("授课关系管理");
	JMenuItem add5=new JMenuItem("添加授课关系");
	JMenuItem delete5=new JMenuItem("删除授课关系");
	JMenuItem select5=new JMenuItem("查询授课关系");
	
	JMenu m6=new JMenu("选课关系管理");
	JMenuItem add6=new JMenuItem("添加选课关系");
	JMenuItem delete6=new JMenuItem("删除选课关系");
	JMenuItem select6=new JMenuItem("查询选课关系");
	
	JMenu m7=new JMenu("教学计划管理");
	JMenuItem add7=new JMenuItem("添加教学计划");
	JMenuItem update7=new JMenuItem("修改教学计划");
	JMenuItem delete7=new JMenuItem("删除教学计划");
	
	JMenu m8=new JMenu("其他功能");
	JMenuItem statistics1=new JMenuItem("统计成绩");
	JMenuItem statistics2=new JMenuItem("统计学生");
	JMenuItem pc1=new JMenuItem("必修课排课");
	
	Font t=new Font("宋体",Font.PLAIN,12);
	
	public Menu(){
		this.setTitle("学生选课管理系统");
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());//窗口外观设置为所用系统平台外观
		}catch(Exception e){
			System.out.println("无法设置外观："+e);
		}
		
		//添加组件
		m1.add(add1);
		m1.add(update1);
		m1.add(delete1);
		m1.add(select1);
		m1.setFont(t);
		bar.add(m1);
		
		m2.add(add2);
		m2.add(update2);
		m2.add(delete2);
		m2.add(select2);
		m2.setFont(t);
		bar.add(m2);
		
		m3.add(add3);
		m3.add(update3);
		m3.add(delete3);
		m3.add(select3);
		m3.setFont(t);
		bar.add(m3);
		
		m4.add(add4);
		m4.add(update4);
		m4.add(delete4);
		m4.add(select4);
		m4.setFont(t);
		bar.add(m4);
		
		m5.add(add5);
		m5.add(delete5);
		m5.add(select5);
		m5.setFont(t);
		bar.add(m5);
		
		m6.add(add6);
		m6.add(delete6);
		m6.add(select6);
		m6.setFont(t);
		bar.add(m6);
		
		m7.add(add7);
		m7.add(update7);
		m7.add(delete7);
		m7.setFont(t);
		bar.add(m7);
		
		m8.add(statistics1);
		m8.add(statistics2);
		m8.add(pc1);
		m8.setFont(t);
		bar.add(m8);
		
		setJMenuBar(bar);
		
		card=new CardLayout();
		pCenter=new BackgroundPanel((new ImageIcon("C:\\Users\\11862\\Pictures\\ZM\\老师好.png")).getImage());

		pCenter.setLayout(card);
		
		label=new JLabel("",JLabel.CENTER);
		label.setFont(new Font("宋体",Font.BOLD,40));
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setForeground(Color.red);
		pCenter.add("欢迎界面",label);
		
		//点击事件
		add1.addActionListener(this);
		update1.addActionListener(this);
		delete1.addActionListener(this);
		select1.addActionListener(this);
		
		add2.addActionListener(this);
		update2.addActionListener(this);
		delete2.addActionListener(this);
		select2.addActionListener(this);
		
		add3.addActionListener(this);
		update3.addActionListener(this);
		delete3.addActionListener(this);
		select3.addActionListener(this);
		
		add4.addActionListener(this);
		update4.addActionListener(this);
		delete4.addActionListener(this);
		select4.addActionListener(this);
		
		add5.addActionListener(this);
		delete5.addActionListener(this);
		select5.addActionListener(this);
		
		add6.addActionListener(this);
		delete6.addActionListener(this);
		select6.addActionListener(this);
		
		add7.addActionListener(this);
		update7.addActionListener(this);
		delete7.addActionListener(this);
		
		statistics1.addActionListener(this);
		statistics2.addActionListener(this);
		pc1.addActionListener(this);
		
		AddD addD=new AddD();
		DelD delD=new DelD();
		SelD selD=new SelD();
		UpdateD updateD=new UpdateD();
		
		AddT addT=new AddT();
		UpdateT updateT=new UpdateT();
		DelT delT=new DelT();
		SelT selT=new SelT();
		
		AddTC addTC=new AddTC();
		DelTC delTC=new DelTC();
		SelTC selTC=new SelTC();
		
		AddSC addSC=new AddSC();
		DelSC delSC=new DelSC();
		SelSC selSC=new SelSC();
		
		AddS addS=new AddS();
		
		AddC addC=new AddC();
		
		AddTP addTP=new AddTP();
		UpdateTP updateTP=new UpdateTP();
		DelTP delTP=new DelTP();
		
		Statistics1 sta1=new Statistics1();
		Statistics2 sta2=new Statistics2();
		PC_cc1 pc1=new PC_cc1();

		
		UpdateS updateS=new UpdateS();
		DelS delS=new DelS();
		SelS selS=new SelS();
			
		
		UpdateC updateC=new UpdateC();
		DelC delC=new DelC();
		SelC selC=new SelC();
		

		
		
		pCenter.add("添加专业界面",addD);
		pCenter.add("删除专业界面",delD);
		pCenter.add("查询专业界面",selD);
		pCenter.add("修改专业界面",updateD);
		
		pCenter.add("添加教师界面",addT);
		pCenter.add("修改教师界面",updateT);
		pCenter.add("删除教师界面",delT);
		pCenter.add("查询教师界面",selT);
		
		pCenter.add("添加授课关系界面",addTC);
		pCenter.add("删除授课关系界面",delTC);
		pCenter.add("查询授课关系界面",selTC);
		
		pCenter.add("添加选课关系界面",addSC);
		pCenter.add("删除选课关系界面",delSC);
		pCenter.add("查询选课关系界面",selSC);
		
		pCenter.add("添加学生界面",addS);
		
		pCenter.add("添加课程界面",addC);
		
		pCenter.add("添加教学计划界面",addTP);
		pCenter.add("修改教学计划界面",updateTP);
		pCenter.add("删除教学计划界面",delTP);
		
		pCenter.add("统计成绩",sta1);
		pCenter.add("统计学生",sta2);
		pCenter.add("必修课排课",pc1);
		
		pCenter.add("修改学生界面",updateS);
		pCenter.add("删除学生界面",delS);
		pCenter.add("查询学生界面",selS);
		
		
		pCenter.add("修改课程界面",updateC);
		pCenter.add("删除课程界面",delC);
		pCenter.add("查询课程界面",selC);
		

		
		add(pCenter,BorderLayout.CENTER);
		validate();
		
		setVisible(true);
		setBounds(400,150,800,500);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置窗体关闭方式
		
		//windows事件监听可以不用设置
		/*addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});*/
		
		validate();
	}
	
	//为菜单添加动作事件
	public void actionPerformed(ActionEvent e){
		Object obj=e.getSource();
		if(obj==add1){
			card.show(pCenter, "添加专业界面");
		}
		if(obj==update1){
			card.show(pCenter, "修改专业界面");
		}
		if(obj==delete1){
			card.show(pCenter, "删除专业界面");
		}
		if(obj==select1){
			card.show(pCenter, "查询专业界面");
		}
		if(obj==add2){
			card.show(pCenter, "添加学生界面");
		}
		if(obj==update2){
			card.show(pCenter, "修改学生界面");
		}
		if(obj==delete2){
			card.show(pCenter, "删除学生界面");
		}
		if(obj==select2){
			card.show(pCenter, "查询学生界面");
		}
		if(obj==add3){
			card.show(pCenter, "添加教师界面");
		}
		if(obj==update3){
			card.show(pCenter, "修改教师界面");
		}
		if(obj==delete3){
			card.show(pCenter, "删除教师界面");
		}
		if(obj==select3){
			card.show(pCenter, "查询教师界面");
		}
		if(obj==add4){
			card.show(pCenter, "添加课程界面");
		}
		if(obj==update4){
			card.show(pCenter, "修改课程界面");
		}
		if(obj==delete4){
			card.show(pCenter, "删除课程界面");
		}
		if(obj==select4){
			card.show(pCenter, "查询课程界面");
		}
		if(obj==add5){
			card.show(pCenter, "添加授课关系界面");
		}
		if(obj==delete5){
			card.show(pCenter, "删除授课关系界面");
		}
		if(obj==select5){
			card.show(pCenter, "查询授课关系界面");
		}
		if(obj==add6){
			card.show(pCenter, "添加选课关系界面");
		}
		if(obj==delete6){
			card.show(pCenter, "删除选课关系界面");
		}
		if(obj==select6){
			card.show(pCenter, "查询选课关系界面");
		}
		if(obj==add7) {
			card.show(pCenter, "添加教学计划界面");
		}
		if(obj==update7) {
			card.show(pCenter, "修改教学计划界面");
		}
		if(obj==delete7) {
			card.show(pCenter,"删除教学计划界面");
		}
		if(obj==statistics1) {
			card.show(pCenter,"统计成绩");
		}
		if(obj==statistics2) {
			card.show(pCenter,"统计学生");
		}
		if(obj==pc1) {
			card.show(pCenter,"必修课排课");
		}
	}
}

class BackgroundPanel extends JPanel  
{  
    Image im;  
    public BackgroundPanel(Image im)  
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