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
	 //�������
	
	CardLayout card=null;//��Ƭʽ����
	JLabel label=null;//������ǩ
	//JMenuBar menubar;
	JMenu xuanke;
	JMenu chaxun;
	JMenuItem xkexx=new JMenuItem("ѡ����Ϣ");
	JMenuItem add1=new JMenuItem("���");
	JMenuItem chax=new JMenuItem("��ѯѡ��");
	JMenuItem tuixuan=new JMenuItem("��ѡ");
	JMenuItem grade=new JMenuItem("���Ƴɼ�");
	JMenuItem allgrade=new JMenuItem("���Ƴɼ�");
	String id;
    public mune(String id1) {
    	this.setTitle("ѧ��ѡ�ι���ϵͳ");
    	pCenter=new BackgroundPanemune((new ImageIcon("C:\\Users\\11862\\Pictures\\ZM\\ͬѧ��.png")).getImage());
    	pCenter1=new JPanel();
    	this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
    	id=id1;
    	card=new CardLayout();
		pCenter.setLayout(card);
    	setSize(500,500);
    	setLocation(100,100);
    	JMenuBar menubar=new JMenuBar();
    	setJMenuBar(menubar);
    	JMenu xuanke=new JMenu("ѡ��");
    	JMenu chaxun=new JMenu("��ѯ");
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
		label.setFont(new Font("����",Font.BOLD,40));
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setForeground(Color.red);
		pCenter.add(label,"��ӭ����");
		AddD1 addD=new AddD1(pCenter1);
    	pCenter.add(addD,"��ѯѡ����Ϣ");
    	tuixuan.addActionListener(this);
    	tuike tui=new tuike(id);
    	pCenter.add(tui,"��ѡ�γ�");
        chax.addActionListener(this);
        tian tian1=new tian(id);
        add1.addActionListener(this);
        pCenter.add(tian1,"���ѡ����Ϣ");
        grade.addActionListener(this);
        onescore one=new onescore(id);
        pCenter.add(one,"���Ƴɼ�");
        allgrade.addActionListener(this);
        allscore1 all=new allscore1(id);
        pCenter.add(all,"���Ƴɼ�");
        xkexx.addActionListener(this);
        xuankxx xkx=new xuankxx(id);
        pCenter.add(xkx,"��ѯ��ѡ�γ�");
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
			card.show(pCenter,"��ѯѡ����Ϣ");
		}
if(e.getSource().equals(add1)) {
			card.show(pCenter,"���ѡ����Ϣ");
		}
if(e.getSource().equals(tuixuan)) {
	card.show(pCenter,"��ѡ�γ�");
}
if(e.getSource().equals(grade)) {
	card.show(pCenter,"���Ƴɼ�");
}
if(e.getSource().equals(allgrade)) {
	card.show(pCenter,"���Ƴɼ�");
}
if(e.getSource().equals(xkexx)) {
	card.show(pCenter,"��ѯ��ѡ�γ�");
}
    }
}
class BackgroundPanemune extends JPanel  
{  
    Image im;  
    public BackgroundPanemune(Image im)  
    {  
        this.im=im;  
        this.setOpaque(true);                    //���ÿؼ���͸��,����false,��ô����͸��
    }  
    //Draw the background again,�̳���Jpanle,��Swing�ؼ���Ҫ�̳�ʵ�ֵķ���,������AWT�е�Paint()
    public void paintComponent(Graphics g)       //��ͼ��,����ɼ�������Java �� java-Graphics 
    {  
        super.paintComponents(g);  
        g.drawImage(im,0,0,this.getWidth(),this.getHeight(),this);  //����ָ��ͼ���е�ǰ���õ�ͼ��ͼ������Ͻ�λ�ڸ�ͼ������������ռ�� (x, y)��ͼ���е�͸�����ز�Ӱ��ô��Ѵ��ڵ�����

    }  
}