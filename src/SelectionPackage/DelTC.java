package SelectionPackage;

import java.awt.*;

import javax.swing.*;

import java.sql.*;
import java.awt.event.*;

public class DelTC extends JPanel implements ActionListener{
	JTextField Tno=new JTextField(20);//��ʦ�������
	JTextField Cno=new JTextField(20);  //�γ̺������
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
	public DelTC(){
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
				
		box1.add(new JLabel("��ʦ��"));
		box1.add(Tno);
		box2.add(new JLabel("�γ̺�"));
		box2.add(Cno);
		box3.add(jb);
				
		Box boxH=Box.createVerticalBox();
		boxH.add(box1);
		boxH.add(box2);
		boxH.add(box3);
		boxH.add(Box.createVerticalGlue());
				
		BackgroundPanelDelTC jp;//�������
		jp=new BackgroundPanelDelTC((new ImageIcon("C:\\Users\\11862\\Pictures\\ZM\\����.png")).getImage());
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
			sql="select * from TC where tno='"+Tno.getText()+"'and cno='"+Cno.getText()+"'";
			sql1="delete from TC where tno='"+Tno.getText()+"'and cno='"+Cno.getText()+"'";
			String s1=Tno.getText();
			String s2=Cno.getText();
			try{
				CONN co=new CONN();
				Connection dbConn1=co.CO();//������ݿ�����
				stmt=(Statement)dbConn1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);//����������ǰ���ƶ��α꣬ResultSet����ֻ��
				rs=stmt.executeQuery(sql);//executeQuery()����������ݿ���Ӧ�Ĳ�ѯ��������ResultSet�������
				if(Tno.getText().equals("")){//��ʦ�Ų�����Ϊ��ֵ
					JOptionPane.showMessageDialog(this,"��ʦ�Ų���Ϊ��");
				}
				else {
					
					if(!digitCheck(s1)||s1.length()>9) 
						JOptionPane.showMessageDialog(this,"��ʦ�������벻����9λ������");
					    if(Cno.getText().equals("")) {
					    	
					    	JOptionPane.showMessageDialog(this,"�γ̺Ų���Ϊ��");
					    }
				  else{
					  if(!digitCheck(s2)||s2.length()>12) 
							JOptionPane.showMessageDialog(this,"�γ̺������벻����12λ������");
					  else {
					   if(!rs.next()){
						JOptionPane.showMessageDialog(this,"�ڿμ�¼������");
					}
					  else{
						stmt.executeUpdate(sql1);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
						JOptionPane.showMessageDialog(this, "�ڿμ�¼ɾ���ɹ�");
					}
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

class BackgroundPanelDelTC extends JPanel  
{  
    Image im;  
    public BackgroundPanelDelTC(Image im)  
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