package SelectionPackage;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Menu extends JFrame implements ActionListener{
	BackgroundPanel pCenter;//�������
	CardLayout card=null;//��Ƭʽ����
	JLabel label=null;//������ǩ
	JMenuBar bar=new JMenuBar();//�˵���
	
	//�˵����ݴ���
	JMenu m1=new JMenu("רҵ����");
	JMenuItem add1=new JMenuItem("���רҵ");
	JMenuItem update1=new JMenuItem("�޸�רҵ");
	JMenuItem delete1=new JMenuItem("ɾ��רҵ");
	JMenuItem select1=new JMenuItem("��ѯרҵ");
	
	JMenu m2=new JMenu("ѧ������");
	JMenuItem add2=new JMenuItem("���ѧ��");
	JMenuItem update2=new JMenuItem("�޸�ѧ��");
	JMenuItem delete2=new JMenuItem("ɾ��ѧ��");
	JMenuItem select2=new JMenuItem("��ѯѧ��");
	
	JMenu m3=new JMenu("��ʦ����");
	JMenuItem add3=new JMenuItem("��ӽ�ʦ");
	JMenuItem update3=new JMenuItem("�޸Ľ�ʦ");
	JMenuItem delete3=new JMenuItem("ɾ����ʦ");
	JMenuItem select3=new JMenuItem("��ѯ��ʦ");
	
	JMenu m4=new JMenu("�γ̹���");
	JMenuItem add4=new JMenuItem("��ӿγ�");
	JMenuItem update4=new JMenuItem("�޸Ŀγ�");
	JMenuItem delete4=new JMenuItem("ɾ���γ�");
	JMenuItem select4=new JMenuItem("��ѯ�γ�");
	
	JMenu m5=new JMenu("�ڿι�ϵ����");
	JMenuItem add5=new JMenuItem("����ڿι�ϵ");
	JMenuItem delete5=new JMenuItem("ɾ���ڿι�ϵ");
	JMenuItem select5=new JMenuItem("��ѯ�ڿι�ϵ");
	
	JMenu m6=new JMenu("ѡ�ι�ϵ����");
	JMenuItem add6=new JMenuItem("���ѡ�ι�ϵ");
	JMenuItem delete6=new JMenuItem("ɾ��ѡ�ι�ϵ");
	JMenuItem select6=new JMenuItem("��ѯѡ�ι�ϵ");
	
	JMenu m7=new JMenu("��ѧ�ƻ�����");
	JMenuItem add7=new JMenuItem("��ӽ�ѧ�ƻ�");
	JMenuItem update7=new JMenuItem("�޸Ľ�ѧ�ƻ�");
	JMenuItem delete7=new JMenuItem("ɾ����ѧ�ƻ�");
	
	JMenu m8=new JMenu("��������");
	JMenuItem statistics1=new JMenuItem("ͳ�Ƴɼ�");
	JMenuItem statistics2=new JMenuItem("ͳ��ѧ��");
	JMenuItem pc1=new JMenuItem("���޿��ſ�");
	
	Font t=new Font("����",Font.PLAIN,12);
	
	public Menu(){
		this.setTitle("ѧ��ѡ�ι���ϵͳ");
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());//�����������Ϊ����ϵͳƽ̨���
		}catch(Exception e){
			System.out.println("�޷�������ۣ�"+e);
		}
		
		//������
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
		pCenter=new BackgroundPanel((new ImageIcon("C:\\Users\\11862\\Pictures\\ZM\\��ʦ��.png")).getImage());

		pCenter.setLayout(card);
		
		label=new JLabel("",JLabel.CENTER);
		label.setFont(new Font("����",Font.BOLD,40));
		label.setHorizontalTextPosition(SwingConstants.CENTER);
		label.setForeground(Color.red);
		pCenter.add("��ӭ����",label);
		
		//����¼�
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
		

		
		
		pCenter.add("���רҵ����",addD);
		pCenter.add("ɾ��רҵ����",delD);
		pCenter.add("��ѯרҵ����",selD);
		pCenter.add("�޸�רҵ����",updateD);
		
		pCenter.add("��ӽ�ʦ����",addT);
		pCenter.add("�޸Ľ�ʦ����",updateT);
		pCenter.add("ɾ����ʦ����",delT);
		pCenter.add("��ѯ��ʦ����",selT);
		
		pCenter.add("����ڿι�ϵ����",addTC);
		pCenter.add("ɾ���ڿι�ϵ����",delTC);
		pCenter.add("��ѯ�ڿι�ϵ����",selTC);
		
		pCenter.add("���ѡ�ι�ϵ����",addSC);
		pCenter.add("ɾ��ѡ�ι�ϵ����",delSC);
		pCenter.add("��ѯѡ�ι�ϵ����",selSC);
		
		pCenter.add("���ѧ������",addS);
		
		pCenter.add("��ӿγ̽���",addC);
		
		pCenter.add("��ӽ�ѧ�ƻ�����",addTP);
		pCenter.add("�޸Ľ�ѧ�ƻ�����",updateTP);
		pCenter.add("ɾ����ѧ�ƻ�����",delTP);
		
		pCenter.add("ͳ�Ƴɼ�",sta1);
		pCenter.add("ͳ��ѧ��",sta2);
		pCenter.add("���޿��ſ�",pc1);
		
		pCenter.add("�޸�ѧ������",updateS);
		pCenter.add("ɾ��ѧ������",delS);
		pCenter.add("��ѯѧ������",selS);
		
		
		pCenter.add("�޸Ŀγ̽���",updateC);
		pCenter.add("ɾ���γ̽���",delC);
		pCenter.add("��ѯ�γ̽���",selC);
		

		
		add(pCenter,BorderLayout.CENTER);
		validate();
		
		setVisible(true);
		setBounds(400,150,800,500);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//���ô���رշ�ʽ
		
		//windows�¼��������Բ�������
		/*addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(0);
			}
		});*/
		
		validate();
	}
	
	//Ϊ�˵���Ӷ����¼�
	public void actionPerformed(ActionEvent e){
		Object obj=e.getSource();
		if(obj==add1){
			card.show(pCenter, "���רҵ����");
		}
		if(obj==update1){
			card.show(pCenter, "�޸�רҵ����");
		}
		if(obj==delete1){
			card.show(pCenter, "ɾ��רҵ����");
		}
		if(obj==select1){
			card.show(pCenter, "��ѯרҵ����");
		}
		if(obj==add2){
			card.show(pCenter, "���ѧ������");
		}
		if(obj==update2){
			card.show(pCenter, "�޸�ѧ������");
		}
		if(obj==delete2){
			card.show(pCenter, "ɾ��ѧ������");
		}
		if(obj==select2){
			card.show(pCenter, "��ѯѧ������");
		}
		if(obj==add3){
			card.show(pCenter, "��ӽ�ʦ����");
		}
		if(obj==update3){
			card.show(pCenter, "�޸Ľ�ʦ����");
		}
		if(obj==delete3){
			card.show(pCenter, "ɾ����ʦ����");
		}
		if(obj==select3){
			card.show(pCenter, "��ѯ��ʦ����");
		}
		if(obj==add4){
			card.show(pCenter, "��ӿγ̽���");
		}
		if(obj==update4){
			card.show(pCenter, "�޸Ŀγ̽���");
		}
		if(obj==delete4){
			card.show(pCenter, "ɾ���γ̽���");
		}
		if(obj==select4){
			card.show(pCenter, "��ѯ�γ̽���");
		}
		if(obj==add5){
			card.show(pCenter, "����ڿι�ϵ����");
		}
		if(obj==delete5){
			card.show(pCenter, "ɾ���ڿι�ϵ����");
		}
		if(obj==select5){
			card.show(pCenter, "��ѯ�ڿι�ϵ����");
		}
		if(obj==add6){
			card.show(pCenter, "���ѡ�ι�ϵ����");
		}
		if(obj==delete6){
			card.show(pCenter, "ɾ��ѡ�ι�ϵ����");
		}
		if(obj==select6){
			card.show(pCenter, "��ѯѡ�ι�ϵ����");
		}
		if(obj==add7) {
			card.show(pCenter, "��ӽ�ѧ�ƻ�����");
		}
		if(obj==update7) {
			card.show(pCenter, "�޸Ľ�ѧ�ƻ�����");
		}
		if(obj==delete7) {
			card.show(pCenter,"ɾ����ѧ�ƻ�����");
		}
		if(obj==statistics1) {
			card.show(pCenter,"ͳ�Ƴɼ�");
		}
		if(obj==statistics2) {
			card.show(pCenter,"ͳ��ѧ��");
		}
		if(obj==pc1) {
			card.show(pCenter,"���޿��ſ�");
		}
	}
}

class BackgroundPanel extends JPanel  
{  
    Image im;  
    public BackgroundPanel(Image im)  
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