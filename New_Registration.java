import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.*;
import org.jdatepicker.*;
import org.jdatepicker.impl.*;
import org.jdatepicker.util.*;

class New_Registration_Demo extends JFrame implements ActionListener,KeyListener,FocusListener
{
JLabel lmain,l1,l2,l3,l4,l5,l6,l7,l8,img;
JComboBox t5,cbg;
JTextField t1,t2,t3,t4,t6;
JButton b1,b2;
Container c;
Connection con;
PreparedStatement st;
ResultSet rs;
boolean flag=false;
int en;
String cont,gen,name,tech,eml,cdt;
int cddt,cmh,cyr,edt,eyr,bdt,byr;
String eddt,emh,edyr,cdddt,cdmh,cdyr,bddt,bmh,bdyr;

UtilDateModel model,model1;
JDatePanelImpl datePanel,datePanel1;
JDatePickerImpl datePicker,datePicker1;
Properties p;

New_Registration_Demo()
{
setTitle("New Registration");
setSize(1200,720);
setResizable(false);
setLocationRelativeTo(null);

c=getContentPane();
c.setLayout(null);

p=new Properties();
p.put("text.today","today");
p.put("text.month","month");
p.put("text.year","year");

model=new UtilDateModel();
model1=new UtilDateModel();

datePanel=new JDatePanelImpl(model,p);
datePanel1=new JDatePanelImpl(model1,p);
datePicker =new JDatePickerImpl(datePanel,new DateComponentFormatter());
datePicker1 =new JDatePickerImpl(datePanel1,new DateComponentFormatter());


ImageIcon im=new ImageIcon("bg.png");
img=new JLabel(im);
img.setBounds(0,0,1200,720);
c.add(img);

Font f1=new Font("forte",Font.BOLD,30);
Font f2=new Font("Lucida Handwriting",Font.BOLD,18);
Font f3=new Font("arial",Font.BOLD,15);
Font fb=new Font("Magneto",Font.BOLD,22);

lmain=new JLabel("New Registration Details");
lmain.setFont(f1);
lmain.setForeground(new Color(255,255,255));
lmain.setBounds(450,10,600,45);
img.add(lmain);

l1=new JLabel("Enrollment Number");
l1.setFont(f2);
l1.setForeground(Color.WHITE);
l1.setBounds(80,100,220,30);
img.add(l1);

t1=new JTextField();
t1.setFont(f3);
t1.setEditable(false);
t1.setBounds(350,100,150,25);
img.add(t1);

l2=new JLabel("Name");
l2.setFont(f2);
l2.setForeground(Color.WHITE);
l2.setBounds(80,170,150,30);
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
l4.setBounds(720,170,100,30);
img.add(l4);

cbg=new JComboBox();
cbg.setFont(f3);
cbg.setBounds(850,170,200,25);
img.add(cbg);

cbg.addItem("Select Gender");
cbg.addItem("Male");
cbg.addItem("Female");
cbg.addItem("Others");

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

datePicker.setBounds(350,240,200,25);
img.add(datePicker);

l7=new JLabel("Date of Examination");
l7.setFont(f2);
l7.setForeground(Color.WHITE);
l7.setBounds(80,380,230,30);
img.add(l7);

datePicker1.setBounds(350,380,200,25);
img.add(datePicker1);

l8=new JLabel("Email");
l8.setFont(f2);
l8.setForeground(Color.WHITE);
l8.setBounds(620,310,150,30);
img.add(l8);

t6=new JTextField();
t6.setFont(f3);
t6.setBounds(750,310,400,25);
img.add(t6);


b1=new JButton("Save");
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
st=con.prepareStatement("select max(Enrollment_No) from candidate");
rs=st.executeQuery();
rs.next();
en=rs.getInt(1);
if(en==0)
en=1001;
else
en++;
t1.setText(String.valueOf(en));

st=con.prepareStatement("select Tech_name from Technology");
rs=st.executeQuery();
t5.addItem("Select Technology");
while(rs.next())
{
t5.addItem(rs.getString("Tech_name"));
}
flag=true;
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
Login_Demo ld=new Login_Demo();
dispose();
}
else if(ae.getSource()==b1)
{
if((cbg.getSelectedIndex()!=0) && (t5.getSelectedIndex()!=0))
{

en=Integer.parseInt(t1.getText());
name=t2.getText();
cont=t3.getText();
gen=(String) cbg.getSelectedItem();
tech=(String) t5.getSelectedItem();
eml=t6.getText();
Date dob= (Date) datePicker.getModel().getValue();
Date doe= (Date) datePicker1.getModel().getValue();
String db=dob.toString();
String de=doe.toString();
db=db.substring(8,10)+"/"+db.substring(4,7)+"/"+db.substring(24);
de=de.substring(8,10)+"/"+de.substring(4,7)+"/"+de.substring(24);

try
{

bddt= db.substring(0,2);
bmh= db.substring(3,6);
bdyr= db.substring(7);

bdt=Integer.parseInt(bddt);
byr=Integer.parseInt(bdyr);

cdddt =cdt.substring(0,2);
cdmh =cdt.substring(3,6);
cdyr =cdt.substring(7);

cddt=Integer.parseInt(cdddt);
cyr=Integer.parseInt(cdyr);

eddt =de.substring(0,2);
emh =de.substring(3,6);
edyr =de.substring(7);

edt=Integer.parseInt(eddt);
eyr=Integer.parseInt(edyr);

}
catch(Exception e)
{
System.out.print(e);
}

if((cyr-byr) >= 15) 
{
if((((edt-cddt) >=1) || (emh.equals(cmh))) && ((eyr-cyr) ==0))
{
try
{
st=con.prepareStatement("insert into candidate values(?,?,?,?,?,?,?,?)");
st.setInt(1,en);
st.setString(2,name);
st.setString(3,cont);
st.setString(4,gen);
st.setString(5,tech);
st.setString(6,db);
st.setString(7,de);
st.setString(8,eml);
st.executeUpdate();
JOptionPane.showMessageDialog(this,"Registration Done Successfully");
st=con.prepareStatement("select max(Enrollment_No) from Candidate");
rs=st.executeQuery();
rs.next();
en=rs.getInt(1);
if(en==0)
en=1001;
else
en++;
t1.setText(String.valueOf(en));
t2.setText("");
t3.setText("");
t6.setText("");
cbg.setSelectedIndex(0);
t5.setSelectedIndex(0);
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
datePicker1.requestFocus();
}
}
else
{
JOptionPane.showMessageDialog(this,"Invalid Date Of Birth");
datePicker.requestFocus();
}
}
else
{
JOptionPane.showMessageDialog(this,"Please Select a value");
}
}
}
}

class New_Registration
{
public static void main(String []s)
{
New_Registration_Demo  nr= new New_Registration_Demo();
}
}
