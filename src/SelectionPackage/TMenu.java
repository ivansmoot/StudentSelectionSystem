package SelectionPackage;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class TMenu extends JFrame implements ActionListener{	
	BackgroundPanelTMenu pCenter;//创建面板
	CardLayout card=null;//卡片式布局
	JLabel label=null;//创建标签
	JMenuBar bar=new JMenuBar();//菜单栏
	
	JMenu m1=new JMenu("成绩管理");
	JMenuItem add1=new JMenuItem("成绩打分");
	JMenuItem delete1=new JMenuItem("成绩删除");
	JMenuItem select1=new JMenuItem("成绩查询");
	
	Font t=new Font("宋体",Font.PLAIN,12);
	
	String id;
	
	public TMenu(String id1){
		id=id1;
		this.setTitle("教师选课管理系统");
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());//窗口外观设置为所用系统平台外观
		}catch(Exception e){
			System.out.println("无法设置外观："+e);
		}
		m1.add(add1);
		m1.add(delete1);
		m1.add(select1);
		m1.setFont(t);
		bar.add(m1);
		
		card=new CardLayout();
		pCenter=new BackgroundPanelTMenu((new ImageIcon("C:\\Users\\11862\\Pictures\\ZM\\老师好.png")).getImage());
		
		pCenter.setLayout(card);
		
		label=new JLabel("",JLabel.CENTER);
		label.setFont(new Font("宋体",Font.BOLD,40));
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setForeground(Color.red);
		pCenter.add("欢迎界面",label);
		
		add1.addActionListener(this);
		delete1.addActionListener(this);
		select1.addActionListener(this);
		
		setJMenuBar(bar);
		
		TSelSC tSelSC=new TSelSC(id);
		TAddSC tAddSC=new TAddSC(id);
		TDeleteSC tDeleteSC=new TDeleteSC(id);
		
		
		pCenter.add("成绩查询界面",tSelSC);
		pCenter.add("成绩打分界面",tAddSC);
		pCenter.add("成绩删除界面",tDeleteSC);
		
		add(pCenter,BorderLayout.CENTER);
		validate();
		
		setVisible(true);
		setBounds(400,150,800,500);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//设置窗体关闭方式
		validate();
	}
	
	//为菜单添加动作事件
		public void actionPerformed(ActionEvent e){
			Object obj=e.getSource();
			if(obj==add1){
				card.show(pCenter,"成绩打分界面");
			}
			if(obj==delete1){
				card.show(pCenter,"成绩删除界面");
			}
			if(obj==select1){
				card.show(pCenter,"成绩查询界面");
			}
		}
}


class BackgroundPanelTMenu extends JPanel  
{  
    Image im;  
    public BackgroundPanelTMenu(Image im)  
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