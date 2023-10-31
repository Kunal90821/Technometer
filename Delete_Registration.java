import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

class Delete_Reg_Demo extends JFrame implements ActionListener
{
JLabel lmain,l1,l2,l3,l4,l5,l6,l7,l8,img;
JComboBox t1;
JTextField t2,t3,t4,t5,t6,t7,t8;
JButton b1,b2;
Connection con;
PreparedStatement st;
ResultSet rs;
boolean flag=false;
Container c;
int en;
String name,gen,cont,tech,eml,dob,doe;


Delete_Reg_Demo()
{
setTitle("Delete Registration");
setSize(1200,720);
setResizable(false);
setLocationRelativeTo(null);

c=getContentPane();
c.setLayout(null);

ImageIcon im=new ImageIcon("bg.png");
img=new JLabel(im);
img.setBounds(0,0,1200,720);
c.add(img);

Font f1=new Font("Modern No. 20",Font.BOLD,30);
Font f2=new Font("Monotype Corsiva",Font.BOLD,25);
Font f3=new Font("arial",Font.BOLD,15);
Font fb=new Font("Maiandra GD",Font.BOLD,22);

lmain=new JLabel("Delete Registration Details");
lmain.setFont(f1);
lmain.setForeground(Color.WHITE);
lmain.setBounds(450,10,600,45);
img.add(lmain);

l1=new JLabel("Enrollment Number");
l1.setFont(f2);
l1.setForeground(Color.WHITE);
l1.setBounds(80,100,220,20);
img.add(l1);

t1=new JComboBox();
t1.setFont(f3);
t1.addActionListener(this);
t1.setBounds(350,100,260,25);
img.add(t1);

l2=new JLabel("Name");
l2.setFont(f2);
l2.setForeground(Color.WHITE);
l2.setBounds(80,170,150,20);
img.add(l2);

t2=new JTextField();
t2.setFont(f3);
t2.setEditable(false);
t2.setBounds(350,170,200,25);
img.add(t2);

l3=new JLabel("Contact");
l3.setFont(f2);
l3.setForeground(Color.WHITE);
l3.setBounds(80,310,150,30);
img.add(l3);

t3=new JTextField();
t3.setFont(f3);
t3.setEditable(false);
t3.setBounds(350,310,150,25);
img.add(t3);


l4=new JLabel("Gender");
l4.setFont(f2);
l4.setForeground(Color.WHITE);
l4.setBounds(770,170,100,30);
img.add(l4);

t4=new JTextField();
t4.setFont(f3);
t4.setEditable(false);
t4.setBounds(900,170,200,25);
img.add(t4);

l5=new JLabel("Technology");
l5.setFont(f2);
l5.setForeground(Color.WHITE);
l5.setBounds(230,450,150,30);
img.add(l5);

t5=new JTextField();
t5.setFont(f3);
t5.setEditable(false);
t5.setBounds(410,450,200,25);
img.add(t5);

l6=new JLabel("Date of Birth");
l6.setFont(f2);
l6.setForeground(Color.WHITE);
l6.setBounds(80,240,150,30);
img.add(l6);

t7=new JTextField();
t7.setFont(f3);
t7.setEditable(false);
t7.setBounds(350,240,200,25);
img.add(t7);

l7=new JLabel("Date of Examination");
l7.setFont(f2);
l7.setForeground(Color.WHITE);
l7.setBounds(80,380,230,30);
img.add(l7);

t8=new JTextField();
t8.setFont(f3);
t8.setEditable(false);
t8.setBounds(350,380,200,25);
img.add(t8);

l8=new JLabel("Email");
l8.setFont(f2);
l8.setForeground(Color.WHITE);
l8.setBounds(600,310,150,30);
img.add(l8);

t6=new JTextField();
t6.setFont(f3);
t6.setEditable(false);
t6.setBounds(730,310,400,25);
img.add(t6);


b1=new JButton("Delete");
b1.setFont(fb);
b1.addActionListener(this);
b1.setBounds(400,590,150,30);
img.add(b1);

b2=new JButton("Cancel");
b2.setFont(fb);
b2.addActionListener(this);
b2.setBounds(680,590,150,30);
img.add(b2);

try
{
Class.forName("com.mysql.cj.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/technometer","root","");
st=con.prepareStatement("select Enrollment_No from candidate");
rs=st.executeQuery();
t1.addItem("Select an Enrollment Number");
while(rs.next())
{
t1.addItem(String.valueOf(rs.getInt(1)));
}
flag=true;
}
catch(Exception e)
{
System.out.print(e);
}
setVisible(true);
}

public void actionPerformed(ActionEvent ae)
{
if((ae.getSource()==t1) && (flag==true))
{
en=Integer.parseInt((String) t1.getSelectedItem());
try
{
st=con.prepareStatement("select * from candidate where Enrollment_No=?");
st.setInt(1,en);
rs=st.executeQuery();
if(rs.next())
{

name=rs.getString("Name");
cont=rs.getString("Contact");
gen=rs.getString("Gender");
tech=rs.getString("Technology");
dob=rs.getString("DOB");
doe=rs.getString("DOE");
eml=rs.getString("Email");

t2.setText(name);
t3.setText(cont);
t4.setText(gen);
t5.setText(tech);
t6.setText(eml);
t7.setText(dob);
t8.setText(doe);

}
}
catch(Exception e)
{
System.out.print(e);
}
}

else if(ae.getSource()==b2)
{
Admin_Demo ad=new Admin_Demo();
dispose();
}
else if(ae.getSource()==b1)
{
if(t1.getSelectedIndex()!=0)
{

try
{
st=con.prepareStatement("delete from candidate where Enrollment_No=?");
st.setInt(1,en);
st.executeUpdate();
JOptionPane.showMessageDialog(this,"Registration Deleted Successfully");
t2.setText("");
t3.setText("");
t6.setText("");
t4.setText("");
t5.setText("");
t7.setText("");
t8.setText("");
t1.removeItem(t1.getSelectedItem());
t1.setSelectedIndex(0);
}
catch(Exception e)
{
System.out.print(e);
}
}
else
{
JOptionPane.showMessageDialog(this,"Please Select an enrollment number");
}
}
}
}

class Delete_Registration
{
public static void main(String []s)
{
Delete_Reg_Demo dr= new Delete_Reg_Demo();
}
}
