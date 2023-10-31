import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;

class Exam_Demo extends JFrame implements ActionListener, ItemListener
{
JLabel img,enm,entm,tcnm,technm,dd,dt,totaltm,totm,elapsd,qn,t1,l2,cdt,ttm,ltm;
JTextArea l1;
JSeparator sep;
JRadioButton op1,op2,op3,op4;
JButton b1,b2,b3,b4;
Container c;
int en,tech,rand,scr=0,ind=0,min=00,sec=00;
String exmdt;
Connection con;
PreparedStatement st;
ResultSet rs;
String sop,tchnm,ques,opa,opb,opc,opd,cop;
String pcop,pques,popa,popb,popc,popd,psop;
Timer time;


Exam_Demo(int enr, int techcode, String tch, String exdt)
{
setSize(1200,650);
setResizable(false);
setUndecorated(true);
setLocationRelativeTo(null);

c=getContentPane();
c.setLayout(null);

ImageIcon im=new ImageIcon("exm_bg.jpg");
img=new JLabel(im);
img.setBounds(0,0,1200,650);
c.add(img);

Font f1=new Font("algerian",Font.BOLD,22);
Font f2=new Font("arial",Font.BOLD,18);
Font f3=new Font("arial",Font.BOLD,15);
Font f4=new Font("arial",Font.BOLD,20);
Font f5=new Font("Monotype Corsiva",Font.BOLD,22);
Font f6=new Font("forte",Font.BOLD,20);

en=enr;
tech=techcode;
tchnm=tch;
exmdt=exdt;

enm=new JLabel("Enrollment Number :");
enm.setBounds(50,50,250,35);
enm.setForeground(new Color(196, 18, 196));
enm.setFont(f1);
img.add(enm);

entm=new JLabel(String.valueOf(en));
entm.setBounds(350,50,80,35);
entm.setForeground(Color.BLACK);
entm.setFont(f5);
img.add(entm);

tcnm=new JLabel("Technology :");
tcnm.setBounds(50,100,200,35);
tcnm.setForeground(new Color(196, 18, 196));
tcnm.setFont(f1);
img.add(tcnm);

technm=new JLabel(tchnm);
technm.setBounds(350,100,50,35);
technm.setForeground(Color.BLACK);
technm.setFont(f5);
img.add(technm);

dt=new JLabel("Date :");
dt.setBounds(550,50,80,35);
dt.setForeground(new Color(196, 18, 196));
dt.setFont(f1);
img.add(dt);


SimpleDateFormat dformat=new SimpleDateFormat("dd/MMM/YYYY");
Date date=new Date();

cdt=new JLabel(dformat.format(date));
cdt.setBounds(650,50,120,30);
cdt.setFont(f5);
img.add(cdt);

totaltm=new JLabel("Duration :");
totaltm.setBounds(900,50,150,35);
totaltm.setForeground(new Color(196, 18, 196));
totaltm.setFont(f1);
img.add(totaltm);

totm=new JLabel("30 mins");
totm.setBounds(1100,50,80,35);
totm.setFont(f5);
img.add(totm);

elapsd=new JLabel("Elapsed Time :");
elapsd.setBounds(900,100,200,35);
elapsd.setForeground(new Color(196, 18, 196));
elapsd.setFont(f1);
img.add(elapsd);

ttm=new JLabel("");
ttm.setBounds(1100,100,30,30);
ttm.setForeground(Color.RED);
ttm.setFont(f5);
img.add(ttm);

dd=new JLabel(":");
dd.setBounds(1120,100,10,30);
dd.setForeground(Color.RED);
dd.setFont(f5);
img.add(dd);

ltm=new JLabel("");
ltm.setBounds(1135,100,30,30);
ltm.setForeground(Color.RED);
ltm.setFont(f5);
img.add(ltm);


time=new Timer(1000,new ActionListener() {

public void actionPerformed(ActionEvent ae)
{
ltm.setText(String.valueOf(sec));
ttm.setText(String.valueOf(min));

if(sec==60)
{
sec=00;
min++;
if(min==30)
{
time.stop();
try
{
st=con.prepareStatement("insert into result values(?,?,?,?)");
st.setInt(1,tech);
st.setInt(2,en);
st.setString(3,exmdt);
st.setInt(4,scr);
st.executeUpdate();

st=con.prepareStatement("update candidate set exam='Yes' where enrollment_no=?");
st.setInt(1,en);
st.executeUpdate();

}
catch(Exception e)
{
System.out.print(e);
}
b2.setEnabled(false);
JOptionPane.showMessageDialog(null,"Your Time is Over");
dispose();
Resultusr_Demo rud=new Resultusr_Demo(en);
}
}
sec++;
}
}); 
time.start();

sep=new JSeparator();
sep.setOrientation(SwingConstants.HORIZONTAL);
sep.setBounds(0,150,1200,20);
sep.setForeground(Color.BLACK);
img.add(sep); 


qn=new JLabel("");
qn.setBounds(120,195,30,35);
qn.setFont(f2);
img.add(qn);

l1=new JTextArea("");
l1.setBackground(new Color(0,0,0,0));
l1.setEditable(false);
l1.setLineWrap(true);
l1.setOpaque(false);
l1.setWrapStyleWord(true);
l1.setBounds(150,200,550,40);
l1.setFont(f2);
img.add(l1);

op1=new JRadioButton("");
op1.setBounds(180,270,800,40);
op1.setBackground(new Color(0,0,0,0));
op1.setOpaque(false);
op1.setFont(f3);
op1.addItemListener(this);
img.add(op1);

op2=new JRadioButton("");
op2.setBounds(180,340,800,40);
op2.setOpaque(false);
op2.setBackground(new Color(0,0,0,0));
op2.setFont(f3);
op2.addItemListener(this);
img.add(op2);

op3=new JRadioButton("");
op3.setBounds(180,410,800,40);
op3.setBackground(new Color(0,0,0,0));
op3.setOpaque(false);
op3.setFont(f3);
op3.addItemListener(this);
img.add(op3);

op4=new JRadioButton("");
op4.setBounds(180,480,800,40);
op4.setBackground(new Color(0,0,0,0));
op4.setOpaque(false);
op4.setFont(f3);
op4.addItemListener(this);
img.add(op4);

ButtonGroup grp=new ButtonGroup();
grp.add(op1);
grp.add(op2);
grp.add(op3);
grp.add(op4);

l2=new JLabel("Answer :");
l2.setBounds(180,550,80,20);
l2.setFont(f2);
img.add(l2);

t1=new JLabel();
t1.setBounds(270,550,100,20);
t1.setFont(f4);
t1.setForeground(Color.RED);
img.add(t1);

b1=new JButton("Previous");
b1.setBounds(200,600,150,30);
b1.setBackground(new Color(242, 73, 242));
b1.setFont(f6);
b1.addActionListener(this);
img.add(b1);

b2=new JButton("Next");
b2.setBounds(450,600,150,30);
b2.setBackground(new Color(242, 73, 242));
b2.setFont(f6);
b2.addActionListener(this);
img.add(b2);

b3=new JButton("Submit");
b3.setBounds(700,600,150,30);
b3.setBackground(new Color(242, 73, 242));
b3.setEnabled(false);
b3.setFont(f6);
b3.addActionListener(this);
img.add(b3);

b4=new JButton("End");
b4.setBounds(950,600,150,30);
b4.setBackground(new Color(242, 73, 242));
b4.addActionListener(this);
b4.setFont(f6);
img.add(b4);

try
{
Class.forName("com.mysql.cj.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/technometer","root","");
st=con.prepareStatement("select * from questions where Tech_code=? limit 25");
st.setInt(1,tech);
rs=st.executeQuery();

while(rs.next())
{

ques=rs.getString(1);
opa=rs.getString(3);
opb=rs.getString(4);
opc=rs.getString(5);
opd=rs.getString(6);
cop=rs.getString(7);

l1.setText(ques);
op1.setText(opa);
op2.setText(opb);
op3.setText(opc);
op4.setText(opd);
ind++;
qn.setText(String.valueOf(ind));
break;
}
}

catch (Exception e)
{
System.out.print(e);
}

if(ind==1)
{
b1.setEnabled(false);
}

setVisible(true);
}


public void itemStateChanged(ItemEvent ie)
{

if(ie.getSource()==op1)
{
sop="A";
t1.setText(String.valueOf(sop));
}
else if(ie.getSource()==op2)
{
sop="B";
t1.setText(String.valueOf(sop));
}
else if(ie.getSource()==op3)
{
sop="C";
t1.setText(String.valueOf(sop));
}
else if(ie.getSource()==op4)
{
sop="D";
t1.setText(String.valueOf(sop));
}

op1.setForeground(Color.BLACK);
op2.setForeground(Color.BLACK);
op3.setForeground(Color.BLACK);
op4.setForeground(Color.BLACK);
}

public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b1)
{
if(psop.equalsIgnoreCase(pcop))
{
scr-=2;

ind--;

if(ind==1)
{
b1.setEnabled(false);
}
else
{
b1.setEnabled(true);
}
if(ind <= 25)
{
b2.setEnabled(true);
b3.setEnabled(false);
}
else
{
b2.setEnabled(false);
b3.setEnabled(true);

}


}


if(opa.equalsIgnoreCase(psop))
{
op1.setSelected(true);
}
if(opb.equalsIgnoreCase(psop))
{
op2.setSelected(true);
}
if(opc.equalsIgnoreCase(psop))
{
op3.setSelected(true);
}
if(opd.equalsIgnoreCase(psop))
{
op4.setSelected(true);
}

qn.setText(String.valueOf(ind));


l1.setText(pques);
op1.setText(popa);
op2.setText(popb);
op3.setText(popc);
op4.setText(popd);

b1.setEnabled(false);

}

else if(ae.getSource()==b2)
{
if(sop.equalsIgnoreCase(cop))
{
scr=scr+2;

}

ind++;
qn.setText(String.valueOf(ind));

b1.setEnabled(true);

op1.setSelected(false);
op2.setSelected(false);
op3.setSelected(false);
op4.setSelected(false);

pques=ques;
popa=opa;
popb=opb;
popc=opc;
popd=opd;
pcop=cop;
psop=sop;

try
{
while(rs.next())
{

ques=rs.getString(1);
opa=rs.getString(3);
opb=rs.getString(4);
opc=rs.getString(5);
opd=rs.getString(6);
cop=rs.getString(7);

l1.setText(ques);
op1.setText(opa);
op2.setText(opb);
op3.setText(opc);
op4.setText(opd);


break;
}
}
catch(Exception e)
{
System.out.print(e);
}


if(ind ==25)
{
if(sop.equalsIgnoreCase(cop))
{
scr+=2;
}
b2.setEnabled(false);
b3.setEnabled(true);
}
else
{
b2.setEnabled(true);
b3.setEnabled(false);

}
}

else if(ae.getSource()==b3)
{
try
{
st=con.prepareStatement("insert into result values(?,?,?,?)");
st.setInt(1,tech);
st.setInt(2,en);
st.setString(3,exmdt);
st.setInt(4,scr);
st.executeUpdate();

st=con.prepareStatement("update candidate set exam='Yes' where enrollment_no=?");
st.setInt(1,en);
st.executeUpdate();
}
catch(Exception e)
{
System.out.print(e);
}
dispose();
Resultusr_Demo rud=new Resultusr_Demo(en);
}
else if(ae.getSource()==b4)
{
dispose();
Examination_User_Demo exd=new Examination_User_Demo(en);
}

}
}
/*class Exam
{
public static void main(String []s)
{
//Exam_Demo ed=new Exam_Demo();
}
}*/