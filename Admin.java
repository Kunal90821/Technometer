import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

class Admin_Demo extends JFrame implements ActionListener, MouseListener
{
JLabel lmain,l1,img1,bg,logout;
JTextArea ta1;
JMenuBar mb;
JMenu m1,m2,m3,m4,m5;
JMenuItem mi1,mi2,mi3,mi4,mi5,mi6,mi7,mi8,mi9,mi10,mi11,mi12;
Container c;

Admin_Demo()
{
setTitle("Admin Account");
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

ImageIcon im1=new ImageIcon("adm_bg.png");
bg=new JLabel(im1);
bg.setBounds(0,0,800,500);
c.add(bg);

ImageIcon im2=new ImageIcon("adm_img.png");
img1=new JLabel(im2);
img1.setBounds(50,50,170,300);
bg.add(img1);

ImageIcon im3=new ImageIcon("logout.png");
logout=new JLabel(im3);
logout.addMouseListener(this);
logout.setBounds(140,350,80,80);
bg.add(logout);

mb=new JMenuBar();
setJMenuBar(mb);

m1=new JMenu("Technology");
m1.setFont(ftmb);
mb.add(m1);

mi1=new JMenuItem("Add New Technology");
mi2=new JMenuItem("Modify Technology");
mi3=new JMenuItem("Delete Technology");

mi1.setFont(ftmi);
mi2.setFont(ftmi);
mi3.setFont(ftmi);

m1.add(mi1);
m1.addSeparator();
m1.add(mi2);
m1.addSeparator();
m1.add(mi3);

m2=new JMenu("Question");
m2.setFont(ftmb);
mb.add(m2);

mi4=new JMenuItem("Add New Question");
mi5=new JMenuItem("Modify Questions");
mi6=new JMenuItem("Delete Questions");


mi4.setFont(ftmi);
mi5.setFont(ftmi);
mi6.setFont(ftmi);

m2.add(mi4);
m2.addSeparator();
m2.add(mi5);
m2.addSeparator();
m2.add(mi6);

m3=new JMenu("Registration");
m3.setFont(ftmb);
mb.add(m3);

mi7=new JMenuItem("Add New Registration");
mi8=new JMenuItem("Modify Registration");
mi9=new JMenuItem("Delete Registration");

mi7.setFont(ftmi);
mi8.setFont(ftmi);
mi9.setFont(ftmi);

m3.add(mi7);
m3.addSeparator();
m3.add(mi8);
m3.addSeparator();
m3.add(mi9);

m4=new JMenu("Exam");
m4.setFont(ftmb);
mb.add(m4);

mi10=new JMenuItem("Examination");
mi11=new JMenuItem("Result");

mi10.setFont(ftmi);
mi11.setFont(ftmi);

m4.add(mi10);
m4.addSeparator();
m4.add(mi11);

m5=new JMenu("Exit");
m5.setFont(ftmb);
mb.add(m5);

mi12=new JMenuItem("Quit");

mi12.setFont(ftmi);

m5.add(mi12);

mi1.addActionListener(this);
mi2.addActionListener(this);
mi3.addActionListener(this);
mi4.addActionListener(this);
mi5.addActionListener(this);
mi6.addActionListener(this);
mi7.addActionListener(this);
mi8.addActionListener(this);
mi9.addActionListener(this);
mi10.addActionListener(this);
mi11.addActionListener(this);
mi12.addActionListener(this);

lmain=new JLabel("Administrator");
lmain.setBounds(450,30,300,30);
lmain.setForeground(new Color(120, 226, 250));
lmain.setFont(ft1);
bg.add(lmain);

l1=new JLabel("Logout");
l1.setBounds(30,350,150,80);
l1.setForeground(Color.RED);
l1.setFont(ft2);
bg.add(l1);

ta1=new JTextArea("There is no substitute for HARD WORK");
ta1.setBounds(500,300,280,70);
ta1.setForeground(Color.WHITE);
ta1.setBackground(new Color(0,0,0,0));
ta1.setEditable(false);
ta1.setLineWrap(true);
ta1.setWrapStyleWord(true);
ta1.setFont(ftta2);
bg.add(ta1);

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
New_Technology_Demo nd = new New_Technology_Demo();
dispose();
}
else if(ae.getSource()==mi2)
{
Modify_Technology_Demo md = new Modify_Technology_Demo();
dispose();
}
else if(ae.getSource()==mi3)
{
Delete_Technology_Demo dt = new Delete_Technology_Demo();
dispose();
}
else if(ae.getSource()==mi4)
{
New_Question_Demo nq = new New_Question_Demo();
dispose();
}
else if(ae.getSource()==mi5)
{
Modify_Question_Demo mq = new Modify_Question_Demo();
dispose();
}
else if(ae.getSource()==mi6)
{
Delete_Question_Demo dq = new Delete_Question_Demo();
dispose();
}
else if(ae.getSource()==mi7)
{
New_Registration_Demo  nr= new New_Registration_Demo();
dispose();
}
else if(ae.getSource()==mi8)
{
Modify_Reg_Demo mr= new Modify_Reg_Demo();
dispose();
}
else if(ae.getSource()==mi9)
{
Delete_Reg_Demo dr= new Delete_Reg_Demo();
dispose();
}
else if(ae.getSource()==mi10)
{
Examination_Demo exd=new Examination_Demo();
dispose();
}
else if(ae.getSource()==mi11)
{
Resultadm_Demo rud=new Resultadm_Demo();
dispose();
}
else if(ae.getSource()==mi12)
{
Login_Demo ld = new Login_Demo();
dispose();
}
}

}
class Admin
{
public static void main(String []s)
{
Admin_Demo ad=new Admin_Demo();
}
}