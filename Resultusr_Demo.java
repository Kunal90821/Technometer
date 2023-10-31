import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

class Resultusr_Demo extends JFrame implements ActionListener
{
JLabel img,lmain,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14;
JButton b1;
Connection con;
PreparedStatement st;
ResultSet rs;
Container c;
int tech,res,en;
String doe,nm,tch;

Resultusr_Demo(int enr)
{
setSize(800,720);
setResizable(false);
setUndecorated(true);
setLocationRelativeTo(null);

c=getContentPane();
c.setLayout(null);

ImageIcon im=new ImageIcon("res_bg.jpg");
img=new JLabel(im);
img.setBounds(0,0,800,720);
c.add(img);

Font f1=new Font("algerian",Font.BOLD,72);
Font f2=new Font("Monotype Corsiva",Font.BOLD,22);
Font f3=new Font("Imprint MT Shadow",Font.BOLD,22);
Font f4=new Font("arial",Font.BOLD,20);

en=enr;

lmain=new JLabel("RESULT");
lmain.setBounds(270,60,300,80);
lmain.setForeground(Color.WHITE);
lmain.setFont(f1);
img.add(lmain);

l1=new JLabel("Enrollment Number");
l1.setBounds(220,170,250,30);
l1.setForeground(Color.WHITE);
l1.setFont(f3);
img.add(l1);

l2=new JLabel("");
l2.setBounds(520,170,250,30);
l2.setForeground(Color.WHITE);
l2.setFont(f2);
img.add(l2);

l3=new JLabel("Student Name");
l3.setBounds(220,225,250,30);
l3.setForeground(Color.WHITE);
l3.setFont(f3);
img.add(l3);

l4=new JLabel("");
l4.setBounds(520,225,250,30);
l4.setForeground(Color.WHITE);
l4.setFont(f2);
img.add(l4);

l5=new JLabel("Technology Code");
l5.setBounds(220,285,250,30);
l5.setForeground(Color.WHITE);
l5.setFont(f3);
img.add(l5);

l6=new JLabel("");
l6.setBounds(520,285,250,30);
l6.setForeground(Color.WHITE);
l6.setFont(f2);
img.add(l6);

l7=new JLabel("Technology Name");
l7.setBounds(220,345,250,30);
l7.setForeground(Color.WHITE);
l7.setFont(f3);
img.add(l7);

l8=new JLabel("");
l8.setBounds(520,345,250,30);
l8.setForeground(Color.WHITE);
l8.setFont(f2);
img.add(l8);

l9=new JLabel("Date Of Examination");
l9.setBounds(220,410,300,30);
l9.setForeground(Color.WHITE);
l9.setFont(f3);
img.add(l9);

l10=new JLabel("");
l10.setBounds(520,410,250,30);
l10.setForeground(Color.WHITE);
l10.setFont(f2);
img.add(l10);

l11=new JLabel("Total Marks");
l11.setBounds(220,475,250,30);
l11.setForeground(Color.WHITE);
l11.setFont(f3);
img.add(l11);

l12=new JLabel("50");
l12.setBounds(520,475,250,30);
l12.setForeground(Color.WHITE);
l12.setFont(f2);
img.add(l12);

l13=new JLabel("Marks Obtained");
l13.setBounds(220,530,250,30);
l13.setForeground(Color.WHITE);
l13.setFont(f3);
img.add(l13);

l14=new JLabel("");
l14.setBounds(520,530,250,30);
l14.setForeground(Color.RED);
l14.setFont(f2);
img.add(l14);

b1=new JButton("CLOSE");
b1.setBounds(320,660,150,30);
b1.setForeground(Color.WHITE);
b1.setBackground(new Color(109,21,248));
b1.addActionListener(this);
b1.setFont(f2);
img.add(b1);

try
{
Class.forName("com.mysql.cj.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/technometer","root","");
st=con.prepareStatement("select * from result where Enrollment_No=?");
st.setInt(1,en);
rs=st.executeQuery();

if(rs.next())
{
tech=rs.getInt(1);
doe=rs.getString(3);
res=rs.getInt(4);

l2.setText(String.valueOf(en));
l6.setText(String.valueOf(tech));
l10.setText(doe);
l14.setText(String.valueOf(res));
}
st=con.prepareStatement("select name,technology from candidate where Enrollment_No=?");
st.setInt(1,en);
rs=st.executeQuery();
if(rs.next())
{
nm=rs.getString("name");
tch=rs.getString("technology");

l4.setText(nm);
l8.setText(tch);
}
}
catch(Exception e)
{
System.out.print(e);
}

setVisible(true);
}
public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b1)
{
Student_Demo sd=new Student_Demo(en);
dispose();
}
}
}
