import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

class Examination_Demo extends JFrame implements ActionListener
{
JLabel l1,l2,l3,l4,l5,l6,l7,img;
JTextField t1,t2,t3,t4,t5,t6;
JComboBox c1;
JButton b1,b2,b3;
Container c;
Font ft1,ft2,ft3;
Connection con;
PreparedStatement st;
ResultSet rs;
boolean flag=false;
int en,techc;
String name,cont,gen,eml,tech,cdt;


Examination_Demo()
{
setTitle("Examination");
setSize(900,600);
setResizable(false);
setDefaultCloseOperation(EXIT_ON_CLOSE);
setLocationRelativeTo(null);

ft1=new Font("Modern No. 20",Font.BOLD,24);
ft2=new Font("timesnewroman",Font.ITALIC,18);
ft3=new Font("Arial",Font.BOLD,20);

c=getContentPane();
c.setLayout(null);

ImageIcon im=new ImageIcon("exmn_bg.jpg");
img=new JLabel(im);
img.setBounds(0,0,900,600);
c.add(img);

l1=new JLabel("Enrollment No.");
l1.setBounds(80,50,200,25);
l1.setForeground(Color.WHITE);
l1.setFont(ft1);
img.add(l1);

c1=new JComboBox();
c1.setBounds(300,50,200,25);
c1.setForeground(Color.BLACK);
c1.addActionListener(this);
c1.addItem("Enrollment Number");
c1.setFont(ft2);
img.add(c1);

l2=new JLabel("Date");
l2.setBounds(600,50,50,25);
l2.setForeground(Color.WHITE);
l2.setFont(ft1);
img.add(l2);

Date date = new Date();
SimpleDateFormat fdt = new SimpleDateFormat("dd/MMM/yyyy");
cdt= fdt.format(date);

t1=new JTextField(cdt);
t1.setBounds(700,50,120,25);
t1.setForeground(Color.BLACK);
t1.setEditable(false);
t1.setFont(ft2);
img.add(t1);

l3=new JLabel("Name");
l3.setBounds(80,125,200,25);
l3.setForeground(Color.WHITE);
l3.setFont(ft1);
img.add(l3);

t2=new JTextField();
t2.setBounds(300,125,200,25);
t2.setFont(ft2);
t2.setForeground(Color.BLACK);
t2.setEditable(false);
img.add(t2);

l4=new JLabel("Contact No.");
l4.setBounds(80,200,200,25);
l4.setForeground(Color.WHITE);
l4.setFont(ft1);
img.add(l4);

t3=new JTextField();
t3.setBounds(300,200,200,25);
t3.setForeground(Color.BLACK);
t3.setFont(ft2);
t3.setEditable(false);
img.add(t3);

l5=new JLabel("Gender");
l5.setBounds(80,275,200,25);
l5.setForeground(Color.WHITE);
l5.setFont(ft1);
img.add(l5);

t4=new JTextField();
t4.setBounds(300,275,200,25);
t4.setFont(ft2);
t4.setForeground(Color.BLACK);
t4.setEditable(false);
img.add(t4);

l6=new JLabel("Email ID");
l6.setBounds(80,350,200,25);
l6.setForeground(Color.WHITE);
l6.setFont(ft1);
img.add(l6);

t5=new JTextField();
t5.setBounds(300,350,300,25);
t5.setFont(ft2);
t5.setForeground(Color.BLACK);
t5.setEditable(false);
img.add(t5);

l7=new JLabel("Technology");
l7.setBounds(80,425,200,25);
l7.setForeground(Color.WHITE);
l7.setFont(ft1);
img.add(l7);

t6=new JTextField();
t6.setBounds(300,425,200,25);
t6.setEditable(false);
t6.setForeground(Color.BLACK);
t6.setFont(ft2);
img.add(t6);

b1=new JButton("Start Exam");
b1.setBounds(120,500,150,30);
b1.setForeground(Color.WHITE);
b1.setBackground(Color.BLACK);
b1.addActionListener(this);
b1.setFont(ft3);
img.add(b1);

b2=new JButton("Edit");
b2.setBounds(375,500,150,30);
b2.setForeground(Color.WHITE);
b2.setBackground(Color.BLACK);
b2.addActionListener(this);
b2.setFont(ft3);
img.add(b2);

b3=new JButton("Close");
b3.setBounds(630,500,150,30);
b3.addActionListener(this);
b3.setForeground(Color.WHITE);
b3.setBackground(Color.BLACK);
b3.setFont(ft3);
img.add(b3);

try
{
Class.forName("com.mysql.cj.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/technometer","root","");
st=con.prepareStatement("select Enrollment_No from candidate where doe=?");
st.setString(1,cdt);
rs=st.executeQuery();
while(rs.next())
{
c1.addItem(String.valueOf(rs.getInt(1)));
}
flag=true;

}
catch(Exception e)
{
}


setVisible(true);
}

public void actionPerformed(ActionEvent ae)
{
if((ae.getSource()==c1) && (flag==true))
{
en=Integer.parseInt((String) c1.getSelectedItem());
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
eml=rs.getString("Email");
tech=rs.getString("Technology");

t2.setText(name);
t3.setText(cont);
t4.setText(gen);
t5.setText(eml);
t6.setText(tech);

st=con.prepareStatement("select * from technology where Tech_name=?");
st.setString(1,tech);
rs=st.executeQuery();
if(rs.next())
{
techc=rs.getInt(1);
}

}
}
catch(Exception e)
{
}
}
else if(ae.getSource()==b1)
{
if(c1.getSelectedIndex()!=0)
{
dispose();
Inst_Demo id=new Inst_Demo(en,techc,tech, cdt);
}
else
{
JOptionPane.showMessageDialog(this,"Please Select an enrollment number");
c1.requestFocus();
}
}
else if(ae.getSource()==b2)
{
dispose();
Modify_Reg_Demo mrd=new Modify_Reg_Demo();
}
else if(ae.getSource()==b3)
{
Admin_Demo ad=new Admin_Demo();
dispose();
}
}
}

class Examination
{
public static void main(String []s)
{
Examination_Demo exd=new Examination_Demo();
}
}