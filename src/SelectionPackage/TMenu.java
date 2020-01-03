package SelectionPackage;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

public class TMenu extends JFrame implements ActionListener{	
	BackgroundPanelTMenu pCenter;//�������
	CardLayout card=null;//��Ƭʽ����
	JLabel label=null;//������ǩ
	JMenuBar bar=new JMenuBar();//�˵���
	
	JMenu m1=new JMenu("�ɼ�����");
	JMenuItem add1=new JMenuItem("�ɼ����");
	JMenuItem delete1=new JMenuItem("�ɼ�ɾ��");
	JMenuItem select1=new JMenuItem("�ɼ���ѯ");
	
	Font t=new Font("����",Font.PLAIN,12);
	
	String id;
	
	public TMenu(String id1){
		id=id1;
		this.setTitle("��ʦѡ�ι���ϵͳ");
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());//�����������Ϊ����ϵͳƽ̨���
		}catch(Exception e){
			System.out.println("�޷�������ۣ�"+e);
		}
		m1.add(add1);
		m1.add(delete1);
		m1.add(select1);
		m1.setFont(t);
		bar.add(m1);
		
		card=new CardLayout();
		pCenter=new BackgroundPanelTMenu((new ImageIcon("C:\\Users\\11862\\Pictures\\ZM\\��ʦ��.png")).getImage());
		
		pCenter.setLayout(card);
		
		label=new JLabel("",JLabel.CENTER);
		label.setFont(new Font("����",Font.BOLD,40));
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setForeground(Color.red);
		pCenter.add("��ӭ����",label);
		
		add1.addActionListener(this);
		delete1.addActionListener(this);
		select1.addActionListener(this);
		
		setJMenuBar(bar);
		
		TSelSC tSelSC=new TSelSC(id);
		TAddSC tAddSC=new TAddSC(id);
		TDeleteSC tDeleteSC=new TDeleteSC(id);
		
		
		pCenter.add("�ɼ���ѯ����",tSelSC);
		pCenter.add("�ɼ���ֽ���",tAddSC);
		pCenter.add("�ɼ�ɾ������",tDeleteSC);
		
		add(pCenter,BorderLayout.CENTER);
		validate();
		
		setVisible(true);
		setBounds(400,150,800,500);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���ô���رշ�ʽ
		validate();
	}
	
	//Ϊ�˵���Ӷ����¼�
		public void actionPerformed(ActionEvent e){
			Object obj=e.getSource();
			if(obj==add1){
				card.show(pCenter,"�ɼ���ֽ���");
			}
			if(obj==delete1){
				card.show(pCenter,"�ɼ�ɾ������");
			}
			if(obj==select1){
				card.show(pCenter,"�ɼ���ѯ����");
			}
		}
}


class BackgroundPanelTMenu extends JPanel  
{  
    Image im;  
    public BackgroundPanelTMenu(Image im)  
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