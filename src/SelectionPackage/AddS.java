package SelectionPackage;

import java.awt.*;

import javax.swing.*;

import java.sql.*;
import java.awt.event.*;


public class AddS extends JPanel implements ActionListener{
	
	JTextField Sno=new JTextField(20); //ѧ��ѧ�������
	JTextField sn=new JTextField(20);  //ѧ���������������
	JTextField ssex=new JTextField(20); //ѧ���Ա������
	JTextField sy=new JTextField(20); //ѧ����ѧ���
	JTextField sp=new JTextField(20); //ѧ����¼����
	JTextField dno=new JTextField(20); //רҵ����
	JButton jb=new JButton("¼��"); //¼�밴ť
	
	//�������
	public AddS(){
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
		Box box6=Box.createHorizontalBox();
		Box box7=Box.createHorizontalBox();
		
		box1.add(new JLabel("ѧ��ѧ��"));
		box1.add(Sno);
		box2.add(new JLabel("ѧ������"));
		box2.add(sn);
		box3.add(new JLabel("�Ա�"));
		box3.add(ssex);
		box4.add(new JLabel("ѧ����ѧ���"));
		box4.add(sy);
		box5.add(new JLabel("ѧ����¼����"));
		box5.add(sp);
		box6.add(new JLabel("רҵ����"));
		box6.add(dno);
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
		
		BackgroundPanelAddS jp;//�������
		jp=new BackgroundPanelAddS((new ImageIcon("C:\\Users\\11862\\Pictures\\ZM\\��ѧ��.png")).getImage());
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
			sql="     select * from S where sno=' "+Sno.getText()+" '    ";
			sql1="insert into S values('"+Sno.getText()+"','"+sn.getText()+"','"+ssex.getText()+"','"+sy.getText()+"','"+sp.getText()+"','"+dno.getText()+"')";
			try{
				Connection dbConn1=CONN.CO();//������ݿ�����
				stmt=(Statement)dbConn1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,
						ResultSet.CONCUR_READ_ONLY);//����������ǰ���ƶ��α꣬ResultSet����ֻ��
				rs=stmt.executeQuery(sql);//executeQuery()����������ݿ���Ӧ�Ĳ�ѯ��������ResultSet�������
				if(Sno.getText().equals("")){ //ѧ��ѧ�Ų�����Ϊ��ֵ
					JOptionPane.showMessageDialog(this,"ѧ��ѧ�Ų���Ϊ��");
				}
				else{
					if(sp.getText().equals("")){//ѧ�����벻����Ϊ��ֵ
						JOptionPane.showMessageDialog(this,"ѧ�����벻��Ϊ��");
					}
					else{
						if(rs.next()){
							JOptionPane.showMessageDialog(this,"ѧ���Ѵ���");
						}
						else{
							stmt.executeUpdate(sql1);//executeUpdate()��������ִ�� INSERT��UPDATE �� DELETE ����Լ� SQL DDL�����ݶ������ԣ����
							JOptionPane.showMessageDialog(this, "ѧ����ӳɹ�");
						}
					}
				}
				rs.close();
				stmt.close();
			}catch(SQLException e){
				System.out.print("SQL?Exception?occur.Message?is:"+e.getMessage());
			}
		}
	}
}

class BackgroundPanelAddS extends JPanel  
{  
    Image im;  
    public BackgroundPanelAddS(Image im)  
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