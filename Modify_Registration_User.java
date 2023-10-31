import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.util.Date;
import java.text.SimpleDateFormat;

class Modify_Regusr_Demo extends JFrame implements ActionListener,KeyListener,FocusListener
{
JLabel lmain,l1,l2,l3,l4,l5,l6,l7,l8,img;
JComboBox t4,t5;
JTextField t1,t2,t3,t6,t7,t8;
JButton b1,b2;
Connection con;
PreparedStatement st;
ResultSet rs;
boolean flag=false;
Container c;
int en,enr;
String name,gen,cont,tech,dob,doe,eml;
int cddt,cmh,cyr,edt,eyr,bdt,byr;
String eddt,emh,edyr,cdddt,cdmh,cdt,cdyr,bddt,bmh,bdyr;


Modify_Regusr_Demo(int enrol)
{

enr=enrol;

setTitle("Modify Registration");
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

lmain=new JLabel("Modify Registration Details");
lmain.setFont(f1);
lmain.setForeground(Color.WHITE);
lmain.setBounds(450,10,600,45);
img.add(lmain);

l1=new JLabel("Enrollment Number");
l1.setFont(f2);
l1.setForeground(Color.WHITE);
l1.setBounds(80,100,220,20);
img.add(l1);

t1=new JTextField(enr);
t1.setFont(f3);
t1.setEditable(false);
t1.setBounds(350,100,260,25);
img.add(t1);

l2=new JLabel("Name");
l2.setFont(f2);
l2.setForeground(Color.WHITE);
l2.setBounds(80,170,150,20);
img.add(l2);

t2=new JTextField();
t2.setFont(f3);
t2.addKeyListener(this);
t2.setBounds(350,170,200,25);
img.add(t2);

l3=new JLabel("Contact");
l3.setFont(f2);
l3.setForeground(Color.WHITE);
l3.setBounds(80,310,150,30);
img.add(l3);

t3=new JTextField();
t3.setFont(f3);
t3.addKeyListener(this);
t3.addFocusListener(this);
t3.setBounds(350,310,150,25);
img.add(t3);


l4=new JLabel("Gender");
l4.setFont(f2);
l4.setForeground(Color.WHITE);
l4.setBounds(770,170,100,30);
img.add(l4);

t4=new JComboBox();
t4.setFont(f3);
t4.setBounds(900,170,200,25);
img.add(t4);

t4.addItem("Select Gender");
t4.addItem("Male");
t4.addItem("Female");
t4.addItem("Others");

l5=new JLabel("Technology");
l5.setFont(f2);
l5.setForeground(Color.WHITE);
l5.setBounds(230,450,150,30);
img.add(l5);

t5=new JComboBox();
t5.setFont(f3);
t5.setBounds(410,450,200,25);
img.add(t5);

l6=new JLabel("Date of Birth");
l6.setFont(f2);
l6.setForeground(Color.WHITE);
l6.setBounds(80,240,150,30);
img.add(l6);

t7=new JTextField();
t7.setFont(f3);
t7.setBounds(350,240,200,25);
img.add(t7);

l7=new JLabel("Date of Examination");
l7.setFont(f2);
l7.setForeground(Color.WHITE);
l7.setBounds(80,380,230,30);
img.add(l7);


t8=new JTextField();
t8.setFont(f3);
t8.setBounds(350,380,200,25);
img.add(t8);

l8=new JLabel("Email");
l8.setFont(f2);
l8.setForeground(Color.WHITE);
l8.setBounds(600,310,150,30);
img.add(l8);

t6=new JTextField();
t6.setFont(f3);
t6.setBounds(730,310,400,25);
img.add(t6);

b1=new JButton("Update");
b1.setFont(fb);
b1.addActionListener(this);
b1.setBounds(400,590,150,30);
img.add(b1);

b2=new JButton("Cancel");
b2.setFont(fb);
b2.addActionListener(this);
b2.setBounds(680,590,150,30);
img.add(b2);

Date date = new Date();
SimpleDateFormat fdt = new SimpleDateFormat("dd/MMM/yyyy");
cdt= fdt.format(date);

try
{
Class.forName("com.mysql.cj.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/technometer","root","");
st=con.prepareStatement("select Tech_name from Technology");
rs=st.executeQuery();
t5.addItem("Select Technology");
while(rs.next())
{
t5.addItem(rs.getString("Tech_name"));
}

st=con.prepareStatement("select * from candidate where Enrollment_No=?");
st.setInt(1,enr);
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

t1.setText(String.valueOf(enr));
t2.setText(name);
t3.setText(cont);
t4.setSelectedItem(gen);
t5.setSelectedItem(tech);
t6.setText(eml);
t7.setText(dob);
t8.setText(doe);

}

}

catch(Exception e)
{
System.out.print(e);
}

setVisible(true);
t2.requestFocus();
}

public void keyPressed(KeyEvent ke)
{
char c=ke.getKeyChar();
if(ke.getSource()==t2)
{
if((c>='a' && c<='z') || (c>='A' && c<='Z') || (c==' ') || (c=='\b'))
{
t2.setEditable(true);
}
else
{
t2.setEditable(false);
}
}
else if(ke.getSource()==t3)
{
if((c>='0' && c<='9') || (c=='\b'))
{
t3.setEditable(true);
}
else
{
t3.setEditable(false);
}
}
}

public void keyReleased(KeyEvent ke)
{
}

public void keyTyped(KeyEvent ke)
{
}

public void focusLost(FocusEvent fe)
{
if(fe.getSource()==t3)
{
cont=t3.getText();
if(cont.length()==10)
{
}
else
{
JOptionPane.showMessageDialog(this,"Please enter valid number");
t3.requestFocus();
}
}
}

public void focusGained(FocusEvent fe)
{
}


public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b2)
{
Student_Demo sd=new Student_Demo(enr);
dispose();
}
else if(ae.getSource()==b1)
{
name=t2.getText();
cont=t3.getText();
gen=(String) t4.getSelectedItem();
tech=(String) t5.getSelectedItem();
eml=t6.getText();
dob=t7.getText();
doe=t8.getText();

bddt= dob.substring(0,2);
bmh= dob.substring(3,6);
bdyr= dob.substring(7);

bdt=Integer.parseInt(bddt);
byr=Integer.parseInt(bdyr);

cdddt =cdt.substring(0,2);
cdmh =cdt.substring(3,6);
cdyr =cdt.substring(7);

cddt=Integer.parseInt(cdddt);
cyr=Integer.parseInt(cdyr);

eddt =doe.substring(0,2);
emh =doe.substring(3,6);
edyr =doe.substring(7);

edt=Integer.parseInt(eddt);
eyr=Integer.parseInt(edyr);

if((cyr-byr) >= 15) 
{
if((((edt-cddt) >=1) || (emh.equals(cmh))) && ((eyr-cyr) ==0))
{
try
{
st=con.prepareStatement("update candidate set Name=?,Contact=?,Gender=?,Technology=?,DOB=?,DOE=?,Email=? where Enrollment_No=?");
st.setString(1,name);
st.setString(2,cont);
st.setString(3,gen);
st.setString(4,tech);
st.setString(5,dob);
st.setString(6,doe);
st.setString(7,eml);
st.setInt(8,enr);
st.executeUpdate();
JOptionPane.showMessageDialog(this,"Registration Updated Successfully");
t2.requestFocus();
}
catch(Exception e)
{
System.out.print(e);
}
}
else
{
JOptionPane.showMessageDialog(this,"Invalid Date Of Examination");
t8.requestFocus();
}
}
else
{
JOptionPane.showMessageDialog(this,"Invalid Date Of Birth");
t7.requestFocus();
}

}
}
}

class Modify_Registration_User
{
public static void main(String []s)
{
//Modify_Regusr_Demo musr= new Modify_Regusr_Demo();
}
}
