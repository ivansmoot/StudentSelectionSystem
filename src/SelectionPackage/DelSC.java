package SelectionPackage;

import java.awt.*;

import javax.swing.*;

import java.sql.*;
import java.awt.event.*;

public class DelSC extends JPanel implements ActionListener{
	JTextField Sno=new JTextField(20);//רҵ���������
	JTextField Cno=new JTextField(20);  //�γ̺������
	JTextField Sy=new JTextField(20);//ѧ��
	JTextField Term=new JTextField(20);//ѧ��
	JButton jb=new JButton("ɾ��");//ɾ����ť
	//������������
	boolean digitCheck(String input) {
	    for(int i = 0; i < input.length(); i++) {
	        char c = input.charAt(i);
	        if( (c < '0' || c > '9') ) {
	        return false;
	        }
	    }
	    return true;
	}
	
	//�������
	public DelSC(){
		try{
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());//�����������Ϊ����ϵͳƽ̨���
		}catch(Exception e){
			System.out.println("�޷�������ۣ�"+e);
		}

		jb.addActionListener(this); //Ϊ��ť�����¼�
		
		//�������Ͱ�ť����BOX�������
		Box box1=Box.createHorizontalBox();
		Box box2=Box.createHorizontalBox();
		Box box3=Box.createHorizontalBox();
		Box box4=Box.createHorizontalBox();
		Box box5=Box.createHorizontalBox();
		
		
		
		box1.add(new JLabel("ѧ��"));
		box1.add(Sno);
		box2.add(new JLabel("�γ̺�"));
		box2.add(Cno);
		box3.add(new JLabel("ѧ��"));
		box3.add(Sy);
		box4.add(new JLabel("ѧ��"));
		box4.add(Term);
		box5.add(jb);
		
		Box boxH=Box.createVerticalBox();
		boxH.add(box1);
		boxH.add(box2);
		boxH.add(box3);
		boxH.add(box4);
		boxH.add(box5);
		boxH.add(Box.createVerticalGlue());
				
		BackgroundPanelDelSC jp;//�������
		jp=new BackgroundPanelDelSC((new ImageIcon("C:\\Users\\11862\\Pictures\\ZM\\����.png")).getImage());
		jp.add(boxH);
		setLayout(new BorderLayout()); //�߿򲼾�
		add(jp,BorderLayout.CENTER);
		validate();
	}
	
	//�����¼�ִ��
	public void actionPerformed(ActionEvent c){
		Object obj=c.getSource();
		if(obj==jb){
			Statement stmt=null;//�����ӿ�
			ResultSet rs=null; //�������ؽ��
			String sql,sql1;
			sql="select * from SC where sno='"+Sno.getText()+"'and cno='"+Cno.getText()+"'and sy='"+Sy.getText()+"'and term='"+Term.getText()+"'";
			sql1="delete from SC where sno='"+Sno.getText()+"'and cno='"+Cno.getText()+"'";
			String s1=Sno.getText();
			String s2=Cno.getText();
			try{
				CONN co=new CONN();
				Connection dbConn1=co.CO();//������ݿ�����
				stmt=(Statement)dbConn1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);//����������ǰ���ƶ��α꣬ResultSet����ֻ��
				rs=stmt.executeQuery(sql);//executeQuery()����������ݿ���Ӧ�Ĳ�ѯ��������ResultSet�������
				if(Sno.getText().equals("")){//ѧ�Ų�����Ϊ��ֵ
					JOptionPane.showMessageDialog(this,"ѧ�Ų���Ϊ��");
				}
				else {
					if(!digitCheck(s1)||s1.length()>7) {
						JOptionPane.showMessageDialog(this,"ѧ�������벻����7λ������");
					}
					    if(Cno.getText().equals("")) {
					    	
					    	JOptionPane.showMessageDialog(this,"�γ̺Ų���Ϊ��");
					    }
				  else{
					  if(!digitCheck(s2)||s2.length()>12) {
							JOptionPane.showMessageDialog(this,"�γ̺������벻����12λ������");
					  }
					   if(!rs.next()){
						JOptionPane.showMessageDialog(this,"ѡ�μ�¼������");
					}
					  else{
						stmt.executeUpdate(sql1);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
						JOptionPane.showMessageDialog(this, "ѡ�μ�¼ɾ���ɹ�");
					}
				}
			}
				rs.close();
				stmt.close();
			}catch(SQLException e){
				System.out.print("SQL Exception occur.Message is:"+e.getMessage());
			}
		}
	}
}

class BackgroundPanelDelSC extends JPanel  
{  
    Image im;  
    public BackgroundPanelDelSC(Image im)  
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