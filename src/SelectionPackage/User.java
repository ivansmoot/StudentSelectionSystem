package SelectionPackage;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import java.sql.*;

public class User extends JFrame{
	private JLabel Account,Password;
	private JTextField AccountField;//�û��������
	private JPasswordField PasswordField;//���������
	private JButton LoginButton,LogoutButton;//����ǳ���ť
	JRadioButton s1;//��ѡ��
	JRadioButton s2;//��ѡ��
	JRadioButton s3;//��ѡ��
	//��¼����
	public User(){
		super("ѧ��ѡ��ϵͳ��¼");
		BackgroundPanel1 pCenter=new BackgroundPanel1((
				new ImageIcon("C:\\Users\\11862\\Pictures\\ZM\\��¼����.jpg")).getImage());//�������
		pCenter.setLayout(null);
		
		Account=new JLabel("�û���:");
		Password=new JLabel("  ����:");
		AccountField=new JTextField(18);
		PasswordField=new JPasswordField(18);
		LoginButton=new JButton("��¼");
		LogoutButton=new JButton("�˳�");
		s1=new JRadioButton("ѧ��",true);
		s2=new JRadioButton("����Ա");
		s3=new JRadioButton("��ʦ");
		s1.setContentAreaFilled(false);
		s2.setContentAreaFilled(false);
		s3.setContentAreaFilled(false);
		ButtonGroup g=new ButtonGroup();
		g.add(s1);
		g.add(s2);
		g.add(s3);
		Account.setBounds(620, 150, 100, 100);
		Password.setBounds(620, 180, 100, 100);
		LoginButton.setBounds(620, 290, 60, 30);
		LogoutButton.setBounds(700, 290, 60, 30);
		AccountField.setBounds(680,190,100,20);
		PasswordField.setBounds(680,220,100,20);
		s1.setBounds(600,250,70,30);
		s2.setBounds(680,250,70,30);
		s3.setBounds(760,250,70,30);
		//���õ�¼����
		LOGIN I=new LOGIN();
		LOGOUT O=new LOGOUT();
		LoginButton.addActionListener(I);
		LogoutButton.addActionListener(O);
		//������
		pCenter.add(Account);
		pCenter.add(AccountField);
		pCenter.add(Password);
		pCenter.add(PasswordField);
		pCenter.add(LoginButton);
		pCenter.add(LogoutButton);
		pCenter.add(s1);
		pCenter.add(s2);
		pCenter.add(s3);
		
		//�������
		this.getContentPane().add(pCenter);
		validate();
		setBounds(500,250,1000,500);//���x,���y,��,��
		setVisible(true);
		setResizable(false);//���ɸı��С
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//��������
	}
	public static void main(String[] args){
		User l=new User( );
	}
	//��ť��¼����
	private class LOGIN implements ActionListener{
		public void actionPerformed(ActionEvent event){
			if(AccountField.getText().equals("")||PasswordField.getText().equals("")){
				JOptionPane.showMessageDialog(User.this, "�û������벻��Ϊ��");
			}
			else{
				if(s2.isSelected()){
				Statement st=null;
				ResultSet re=null;
				String sql;
				sql="select * from M where Username='"+AccountField.getText()+"'";
				try{
					CONN co=new CONN();
					Connection dbConn1=co.CO();//������ݿ�����
					st=(Statement)dbConn1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
					re=st.executeQuery(sql);
					if(re.next()){
						String xm=re.getString("password");
						if(PasswordField.getText().equals(xm.trim())){JOptionPane.showMessageDialog(User.this,"��¼�ɹ�");
						dispose();
						new Menu();
						}
						else{JOptionPane.showMessageDialog(User.this,"�������");}	
					}
					else{JOptionPane.showMessageDialog(User.this,"�û�������");}
					re.close();
					st.close();
				}
					catch(SQLException e){
						JOptionPane.showMessageDialog(User.this,"SQL Exception Occur Message is "+e.getMessage());
					}
				}
				else if(s1.isSelected()){
					if(AccountField.getText().equals("")||PasswordField.getText().equals("")){
						JOptionPane.showMessageDialog(User.this, "�û������벻��Ϊ��");
					}
					else{
						String id;
						id=AccountField.getText();
						Statement st=null;
						ResultSet re=null;
						String sql;
						sql="select * from s where sno='"+AccountField.getText()+"'";
						try{
							String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";//����JDBC����
							String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=StudentSelectionSystem";//���ӷ�����
							String userName="sa";//�û���
							String userPassword="miss1186285865";//����
							Connection dbConn1=null;
							try{
								Class.forName(driverName);
								dbConn1=DriverManager.getConnection(dbURL,userName,userPassword);
								System.out.println("Connection Successfully");
							}catch(Exception e){
								e.printStackTrace();
							}
							//������ݿ�����
							st=(Statement)dbConn1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
							re=st.executeQuery(sql);
							if(re.next()){
								String xm=re.getString("sp");
								if(PasswordField.getText().equals(xm.trim())){JOptionPane.showMessageDialog(User.this,"��¼�ɹ�");
								dispose();
							new mune(id);
								}
								else{JOptionPane.showMessageDialog(User.this,"�������");}	
							}
							else{JOptionPane.showMessageDialog(User.this,"�û�������");}
							re.close();
							st.close();
						}
							catch(SQLException e){
								JOptionPane.showMessageDialog(User.this,"SQL Exception Occur Message is "+e.getMessage());
							}
						}
				}
				else if(s3.isSelected()){
					if(AccountField.getText().equals("")||PasswordField.getText().equals("")){
						JOptionPane.showMessageDialog(User.this, "�û������벻��Ϊ��");
					}
					else{
						String id;
						id=AccountField.getText();
						Statement st=null;
						ResultSet re=null;
						String sql;
						sql="select * from t where tno='"+AccountField.getText()+"'";
						try{
							String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";//����JDBC����
							String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=StudentSelectionSystem";//���ӷ�����
							String userName="sa";//�û���
							String userPassword="miss1186285865";//����
							Connection dbConn1=null;
							try{
								Class.forName(driverName);
								dbConn1=DriverManager.getConnection(dbURL,userName,userPassword);
								System.out.println("Connection Successfully");
							}catch(Exception e){
								e.printStackTrace();
							}
							//������ݿ�����
							st=(Statement)dbConn1.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE,ResultSet.CONCUR_READ_ONLY);
							re=st.executeQuery(sql);
							if(re.next()){
								String xm=re.getString("tp");
								if(PasswordField.getText().equals(xm.trim())){JOptionPane.showMessageDialog(User.this,"��¼�ɹ�");
								dispose();
								new TMenu(id);
								}
								else{JOptionPane.showMessageDialog(User.this,"�������");}	
							}
							else{JOptionPane.showMessageDialog(User.this,"�û�������");}
							re.close();
							st.close();
						}
							catch(SQLException e){
								JOptionPane.showMessageDialog(User.this,"SQL Exception Occur Message is "+e.getMessage());
							}
						}
				}
			}
			}
		}
	//��ť�˳�����
	private class LOGOUT implements ActionListener{
		public void actionPerformed(ActionEvent even){
			System.exit(0);
		}
	}
}
class BackgroundPanel1 extends JPanel  
{  
    Image im;  
    public BackgroundPanel1(Image im)  
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
