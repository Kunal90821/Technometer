import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;

class Student_Demo extends JFrame implements ActionListener, MouseListener
{
JLabel lmain,l1,img1,bg,logout;
JTextArea ta1,ta2;
JMenuBar mb;
JMenu m1,m2,m3;
JMenuItem mi1,mi2,mi3,mi4,mi5;
Container c;
int enrol;
Connection con;
PreparedStatement st;
ResultSet rs;
String doe,cdt;

Student_Demo(int en)
{
enrol=en;

setTitle("Student Account");
setSize(800,500);
setResizable(false);
setDefaultCloseOperation(EXIT_ON_CLOSE);
setLocationRelativeTo(null);

c=getContentPane();
c.setLayout(null);

Font ft1=new Font("Georgia",Font.BOLD,32);
Font ft2=new Font("Times New Roman",Font.BOLD,26);
Font ftmb=new Font("Franklin Gothic",Font.BOLD,15);
Font ftmi=new Font("Consolas",Font.BOLD,17);
Font ftta=new Font("Modern No. 20",Font.BOLD,18);
Font ftta2=new Font("Matura MT Script Capitals",Font.BOLD,20);

ImageIcon im1=new ImageIcon("stu_bg.png");
bg=new JLabel(im1);
bg.setBounds(0,0,800,500);
c.add(bg);

ImageIcon im2=new ImageIcon("usr_img.png");
img1=new JLabel(im2);
img1.setBounds(500,90,170,300);
bg.add(img1);

ImageIcon im3=new ImageIcon("logout.png");
logout=new JLabel(im3);
logout.addMouseListener(this);
logout.setBounds(680,350,80,80);
bg.add(logout);

mb=new JMenuBar();
setJMenuBar(mb);

m1=new JMenu("Edit");
m1.setFont(ftmb);
mb.add(m1);

mi1=new JMenuItem("Modify Registration");
mi2=new JMenuItem("Delete Registration");

mi1.setFont(ftmi);
mi2.setFont(ftmi);

m1.add(mi1);
m1.addSeparator();
m1.add(mi2);

m2=new JMenu("Exam");
m2.setFont(ftmb);
mb.add(m2);

mi3=new JMenuItem("Examination");
mi4=new JMenuItem("Result");
mi4.setEnabled(false);

mi3.setFont(ftmi);
mi4.setFont(ftmi);

m2.add(mi3);
m2.addSeparator();
m2.add(mi4);

m3=new JMenu("Exit");
m3.setFont(ftmb);
mb.add(m3);

mi5=new JMenuItem("Quit");
mi5.setFont(ftmi);

m3.add(mi5);

mi1.addActionListener(this);
mi2.addActionListener(this);
mi3.addActionListener(this);
mi4.addActionListener(this);
mi5.addActionListener(this);

lmain=new JLabel("");
lmain.setBounds(120,30,300,30);
lmain.setForeground(new Color(97, 14, 117));
lmain.setFont(ft1);
bg.add(lmain);

l1=new JLabel("Logout");
l1.setBounds(590,350,150,80);
l1.setForeground(Color.RED);
l1.setFont(ft2);
bg.add(l1);

ta1=new JTextArea("Technometer is a cost-effective, scalable way to convert traditional pen and paper based exams to paperless mode. It can simplify overall examination management and result in generation activity.");
ta1.setBounds(50,120,350,120);
ta1.setForeground(Color.WHITE);
ta1.setBackground(new Color(0,0,0,0));
ta1.setEditable(false);
ta1.setLineWrap(true);
ta1.setWrapStyleWord(true);
ta1.setFont(ftta);
bg.add(ta1);

ta2=new JTextArea("Mistakes are proof that you are trying");
ta2.setBounds(50,300,280,70);
ta2.setForeground(Color.BLACK);
ta2.setBackground(new Color(0,0,0,0));
ta2.setEditable(false);
ta2.setLineWrap(true);
ta2.setWrapStyleWord(true);
ta2.setFont(ftta2);
bg.add(ta2);

Date date = new Date();
SimpleDateFormat fdt = new SimpleDateFormat("dd/MMM/yyyy");
cdt= fdt.format(date);

try
{
Class.forName("com.mysql.cj.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/technometer","root","");
st=con.prepareStatement("select doe,name from candidate where Enrollment_No=?");
st.setInt(1,enrol);
rs=st.executeQuery();
if(rs.next())
{
doe=rs.getString(1);
lmain.setText(rs.getString(2));
}
st=con.prepareStatement("select * from result where Enrollment_No=?");
st.setInt(1,enrol);
rs=st.executeQuery();
if(rs.next())
{
mi4.setEnabled(true);
}
else
{
mi4.setEnabled(false);
}
}
catch(Exception e)
{
System.out.print(e);
}

if(doe.equalsIgnoreCase(cdt))
{
mi3.setEnabled(true);
}
else
{
mi3.setEnabled(false);
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
if(me.getSource()==logout)
{
Login_Demo ld=new Login_Demo();
dispose();
}
}
public void mouseEntered(MouseEvent me)
{
}
public void mouseExited(MouseEvent me)
{
}

public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==mi1)
{
Modify_Regusr_Demo mr= new Modify_Regusr_Demo(enrol);
dispose();
}
else if(ae.getSource()==mi2)
{
Delete_Regusr_Demo dr= new Delete_Regusr_Demo(enrol);
dispose();
}
else if(ae.getSource()==mi3)
{
Examination_User_Demo exd=new Examination_User_Demo(enrol);
dispose();
}
else if(ae.getSource()==mi4)
{
Resultusr_Demo rud=new Resultusr_Demo(enrol);
dispose();
}
else if(ae.getSource()==mi5)
{
dispose();
}
}

}
class Student
{
public static void main(String []s)
{
Student_Demo sd=new Student_Demo(1023);
}
}