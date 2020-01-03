package SelectionPackage;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;

import javax.swing.*;
import javax.swing.table.*;
import javax.swing.border.BevelBorder;

public class mune extends JFrame implements ActionListener {
	 BackgroundPanemune pCenter;
	 JPanel pCenter1;
	 //创建面板
	
	CardLayout card=null;//卡片式布局
	JLabel label=null;//创建标签
	//JMenuBar menubar;
	JMenu xuanke;
	JMenu chaxun;
	JMenuItem xkexx=new JMenuItem("选课信息");
	JMenuItem add1=new JMenuItem("添加");
	JMenuItem chax=new JMenuItem("查询选课");
	JMenuItem tuixuan=new JMenuItem("退选");
	JMenuItem grade=new JMenuItem("单科成绩");
	JMenuItem allgrade=new JMenuItem("各科成绩");
	String id;
    public mune(String id1) {
    	this.setTitle("学生选课管理系统");
    	pCenter=new BackgroundPanemune((new ImageIcon("C:\\Users\\11862\\Pictures\\ZM\\同学好.png")).getImage());
    	pCenter1=new JPanel();
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    	id=id1;
    	card=new CardLayout();
		pCenter.setLayout(card);
    	setSize(500,500);
    	setLocation(100,100);
    	JMenuBar menubar=new JMenuBar();
    	setJMenuBar(menubar);
    	JMenu xuanke=new JMenu("选课");
    	JMenu chaxun=new JMenu("查询");
    	menubar.add(xuanke);
    	menubar.add(chaxun);
    	xuanke.add(add1);
    	xuanke.add(tuixuan);
    	xuanke.add(chax);
    	chaxun.add(allgrade);
    	chaxun.add(grade);
    	chaxun.add(xkexx);
    	//this.setLayout(null);
    	JButton n=new JButton();
    	setJMenuBar(menubar);
    	//this.getContentPane().add(menubar,BorderLayout.NORTH);
    	this.getContentPane().add(pCenter,BorderLayout.CENTER);
    	this.getContentPane().add(pCenter1,BorderLayout.SOUTH);
    	//pCenter1.setBounds(400,500,400,400);
        label=new JLabel("",JLabel.CENTER);
		label.setFont(new Font("宋体",Font.BOLD,40));
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setForeground(Color.red);
		pCenter.add(label,"欢迎界面");
		AddD1 addD=new AddD1(pCenter1);
    	pCenter.add(addD,"查询选课信息");
    	tuixuan.addActionListener(this);
    	tuike tui=new tuike(id);
    	pCenter.add(tui,"退选课程");
        chax.addActionListener(this);
        tian tian1=new tian(id);
        add1.addActionListener(this);
        pCenter.add(tian1,"添加选课信息");
        grade.addActionListener(this);
        onescore one=new onescore(id);
        pCenter.add(one,"单科成绩");
        allgrade.addActionListener(this);
        allscore1 all=new allscore1(id);
        pCenter.add(all,"各科成绩");
        xkexx.addActionListener(this);
        xuankxx xkx=new xuankxx(id);
        pCenter.add(xkx,"查询已选课程");
    	setVisible(true);
    	validate();
    	//this.setSize(800,800);
    	//this. pack();
    	setBounds(400,150,800,500);
    }
    	
    
    public static void main(String[] args){
		
	}
    public void actionPerformed(ActionEvent e){
		
		if(e.getSource().equals(chax)) {
			card.show(pCenter,"查询选课信息");
		}
if(e.getSource().equals(add1)) {
			card.show(pCenter,"添加选课信息");
		}
if(e.getSource().equals(tuixuan)) {
	card.show(pCenter,"退选课程");
}
if(e.getSource().equals(grade)) {
	card.show(pCenter,"单科成绩");
}
if(e.getSource().equals(allgrade)) {
	card.show(pCenter,"各科成绩");
}
if(e.getSource().equals(xkexx)) {
	card.show(pCenter,"查询已选课程");
}
    }
}
class BackgroundPanemune extends JPanel  
{  
    Image im;  
    public BackgroundPanemune(Image im)  
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