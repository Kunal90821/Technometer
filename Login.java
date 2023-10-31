import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

class Login_Demo extends JFrame implements ActionListener, MouseListener
{
JLabel lmain,lm1,pnl1_bg,pnl2_bg,limg1,limg2,limg3,limg4,limg5,limg6,lm2,lm3,lm4,lm6,la1,la2,la3,ls1,ls2,ls3,bg,quit,qt2;
JTextField ta1,ts1;
JTextArea tpnl,lm5;
JPasswordField ta2,ts2;
JButton ba1,ba2,bs1,bs2;
Container c;
JPanel p1,p2,p3;
Connection con;
PreparedStatement st;
ResultSet rs;
int en;
String sname,spw,nmad,pwad,pwd,pws;

Login_Demo()
{
setTitle("Technometer");
setSize(1200,700);
setResizable(false);
setDefaultCloseOperation(EXIT_ON_CLOSE);
setLocationRelativeTo(null);

c=getContentPane();
c.setLayout(null);


Font fmain=new Font("Showcard Gothic",Font.BOLD,72);
Font fm1=new Font("Monotype Corsiva",Font.BOLD,28);
Font ft1=new Font("Lucida Handwriting",Font.BOLD,28);
Font ft2=new Font("Magneto",Font.BOLD,28);
Font ft3=new Font("consolas",Font.BOLD,28);

/*Main Frame*/


ImageIcon im1=new ImageIcon("lgn_bg.png");
bg=new JLabel(im1);
bg.setBounds(0,0,1200,730);
c.add(bg);



lmain=new JLabel("Technometer");
lmain.setBounds(620,35,700,80);
lmain.setForeground(Color.WHITE);
lmain.setFont(fmain);
bg.add(lmain);

lm1=new JLabel("Welcome,");
lm1.setBounds(50,150,110,30);
lm1.setForeground(Color.WHITE);
lm1.setFont(fm1);
bg.add(lm1);

lm2=new JLabel("Login as :");
lm2.setBounds(120,190,110,30);
lm2.setForeground(Color.RED);
lm2.setFont(fm1);
bg.add(lm2);

ImageIcon im2=new ImageIcon("login_admin.png");
limg1=new JLabel(im2);
limg1.setBounds(30,270,220,150);
limg1.addMouseListener(this);
bg.add(limg1);

lm3=new JLabel("Administrator");
lm3.setBounds(50,430,160,30);
lm3.setForeground(new Color(37, 189, 219));
lm3.setFont(fm1);
bg.add(lm3);

ImageIcon im3=new ImageIcon("sprtrvl.png");
limg2=new JLabel(im3);
limg2.setBounds(270,245,30,260);
bg.add(limg2);

ImageIcon im4=new ImageIcon("login_user.png");
limg3=new JLabel(im4);
limg3.setBounds(270,270,220,150);
limg3.addMouseListener(this);
bg.add(limg3);

lm4=new JLabel("Student");
lm4.setBounds(330,430,110,30);
lm4.setForeground(new Color(37, 189, 219));
lm4.setFont(fm1);
bg.add(lm4);

ImageIcon im5=new ImageIcon("sprtrhl.png");
limg4=new JLabel(im5);
limg4.setBounds(10,475,460,30);
bg.add(limg4);

lm5=new JTextArea("Not, Registered yet ?");
lm5.setBounds(50,525,250,80);
lm5.setOpaque(false);
lm5.setLineWrap(true);
lm5.setWrapStyleWord(true);
lm5.setBackground(new Color(0,0,0,0));
lm5.setForeground(Color.RED);
lm5.setFont(fm1);
bg.add(lm5);

ImageIcon im6=new ImageIcon("adduser.png");
limg5=new JLabel(im6);
limg5.setBounds(300,480,220,150);
limg5.addMouseListener(this);
bg.add(limg5);

lm6=new JLabel("Sign Up");
lm6.setBounds(355,625,150,30);
lm6.setForeground(new Color(37, 189, 219));
lm6.setFont(fm1);
bg.add(lm6);


ImageIcon qt1=new ImageIcon("logout.png");
quit=new JLabel(qt1);
quit.addMouseListener(this);
quit.setBounds(140,580,80,80);
bg.add(quit);

qt2=new JLabel("Exit");
qt2.setBounds(50,580,250,80);
qt2.setForeground(new Color(37, 189, 219));
qt2.setFont(fm1);
bg.add(qt2);

//Login as an admin

p1=new JPanel();
p1.setLayout(null);
p1.setBounds(550,150,600,450);
bg.add(p1);
p1.setVisible(false);

ImageIcon im7=new ImageIcon("loginpnl1_bg.png");
pnl1_bg=new JLabel(im7);
pnl1_bg.setBounds(0,0,600,450);
p1.add(pnl1_bg);

la1=new JLabel("Login as Administrator");
la1.setFont(ft1);
la1.setForeground(Color.WHITE);
la1.setBounds(20,50,400,40);
pnl1_bg.add(la1);

la2=new JLabel("Admin Name");
la2.setFont(ft2);
la2.setForeground(Color.WHITE);
la2.setBounds(50,220,250,30);
pnl1_bg.add(la2);

ta1=new JTextField();
ta1.setFont(ft3);
ta1.setBounds(350,220,200,35);
pnl1_bg.add(ta1);

la3=new JLabel("Password");
la3.setForeground(Color.WHITE);
la3.setFont(ft2);
la3.setBounds(50,290,200,30);
pnl1_bg.add(la3);

ta2=new JPasswordField();
ta2.setFont(ft3);
ta2.setBounds(350,290,200,30);
pnl1_bg.add(ta2);

ba1=new JButton("Submit");
ba1.setBackground(Color.BLACK);
ba1.setForeground(Color.WHITE);
ba1.setFont(ft2);
ba1.addActionListener(this);
ba1.setBounds(80,360,150,35);
pnl1_bg.add(ba1);

ba2=new JButton("Close");
ba2.setBackground(Color.BLACK);
ba2.setForeground(Color.WHITE);
ba2.setFont(ft2);
ba2.addActionListener(this);
ba2.setBounds(360,360,150,35);
pnl1_bg.add(ba2);


//Login as a student

p2=new JPanel();
p2.setBounds(550,150,600,450);
p2.setLayout(null);
bg.add(p2);
p2.setVisible(false);

ImageIcon im8=new ImageIcon("loginpnl2_bg.png");
pnl2_bg=new JLabel(im8);
pnl2_bg.setBounds(0,0,600,450);
p2.add(pnl2_bg);

ls1=new JLabel("Login as Student");
ls1.setFont(ft1);
ls1.setForeground(Color.WHITE);
ls1.setBounds(20,50,400,40);
pnl2_bg.add(ls1);

ls2=new JLabel("Student's Name");
ls2.setForeground(Color.WHITE);
ls2.setFont(ft2);
ls2.setBounds(50,220,250,30);
pnl2_bg.add(ls2);

ts1=new JTextField();
ts1.setFont(ft3);
ts1.setBounds(350,220,200,35);
pnl2_bg.add(ts1);

ls3=new JLabel("Password");
ls3.setForeground(Color.WHITE);
ls3.setFont(ft2);
ls3.setBounds(50,290,200,30);
pnl2_bg.add(ls3);

ts2=new JPasswordField();
ts2.setFont(ft3);
ts2.setBounds(350,290,200,30);
pnl2_bg.add(ts2);

ImageIcon im9=new ImageIcon("hint.png");
limg6=new JLabel(im9);
limg6.setBounds(550,270,50,50);
limg6.addMouseListener(this);
pnl2_bg.add(limg6);

bs1=new JButton("Submit");
bs1.setBackground(Color.BLACK);
bs1.setFont(ft2);
bs1.setForeground(Color.WHITE);
bs1.addActionListener(this);
bs1.setBounds(80,360,150,35);
pnl2_bg.add(bs1);

bs2=new JButton("Close");
bs2.setBackground(Color.BLACK);
bs2.setForeground(Color.WHITE);
bs2.setFont(ft2);
bs2.addActionListener(this);
bs2.setBounds(360,360,150,35);
pnl2_bg.add(bs2);

p3=new JPanel();
p3.setLayout(null);
p3.setBounds(270,140,250,65);
pnl2_bg.add(p3);
p3.setVisible(false);

tpnl=new JTextArea("Enter first four alphabet of your name and year of birth in password. If your name consists of less than 4 alphabets then enter your full name and year of birth.");
tpnl.setLineWrap(true);
tpnl.setWrapStyleWord(true);
tpnl.setBounds(0,0,250,65);
p3.add(tpnl);

try
{
Class.forName("com.mysql.cj.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/technometer","root","");
}
catch(Exception e)
{
System.out.print(e);
}

setVisible(true);
}
public void mousePressed(MouseEvent me)
{
}
public void mouseReleased(MouseEvent me)
{
}
public void mouseClicked(MouseEvent me)
{
if(me.getSource()==limg1)
{
p2.setVisible(false);
p1.setVisible(true);
}
if(me.getSource()==limg3)
{
p1.setVisible(false);
p2.setVisible(true);
}
if(me.getSource()==limg5)
{
New_Registration_Demo nd=new New_Registration_Demo();
dispose();
}
if(me.getSource()==quit)
{
dispose();
}
}
public void mouseEntered(MouseEvent me)
{
if(me.getSource()==limg6)
{
p3.setVisible(true);
}
}
public void mouseExited(MouseEvent me)
{
if(me.getSource()==limg6)
{
p3.setVisible(false);
}

}

public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==ba2)
{
p1.setVisible(false);
}
else if(ae.getSource()==bs2)
{
p2.setVisible(false);
}
else if(ae.getSource()==ba1)
{
nmad=ta1.getText();
pwad=ta2.getText();

try
{
st=con.prepareStatement("select admin_pass from admin where admin=?");
st.setString(1,nmad);
rs=st.executeQuery();
if(rs.next())
{
pwd=rs.getString("admin_pass");

if(pwad.equals(pwd))
{
Admin_Demo ad=new Admin_Demo();
dispose();
}
else
{
JOptionPane.showMessageDialog(this,"Invalid Password");
}

}
else
{
JOptionPane.showMessageDialog(this,"Invalid Username");
}
}
catch(Exception e)
{
System.out.print(e);
}

}
else if(ae.getSource()==bs1)
{
sname=ts1.getText();
spw=ts2.getText();

try
{
st=con.prepareStatement("select dob,enrollment_no from candidate where name=?");
st.setString(1,sname);
rs=st.executeQuery();
if(rs.next())
{
en=rs.getInt("Enrollment_No");
String dob=rs.getString("DOB");
if(sname.length()>=4)
{
String sn=sname.substring(0,4);
pws= sn.toUpperCase() +dob.substring(7);
}
else
{
pws= sname.toUpperCase() +dob.substring(7);
}
if(spw.equals(pws))
{
Student_Demo sd=new Student_Demo(en);
dispose();
}
else
{
JOptionPane.showMessageDialog(this,"Invalid Password");
}
}
else
{
JOptionPane.showMessageDialog(this,"Invalid Username");
}
}
catch(Exception e)
{
System.out.print(e);
}
}
else if(ae.getSource()==ba2)
{
pnl1_bg.setVisible(false);
}
else if(ae.getSource()==bs2)
{
pnl2_bg.setVisible(false);
}




}

}

class Login
{
public static void main(String []s)
{
Login_Demo ld=new Login_Demo();
}
}