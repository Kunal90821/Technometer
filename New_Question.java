import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

class New_Question_Demo extends JFrame implements ActionListener,KeyListener,FocusListener
{
JLabel lmain,l1,l2,l3,l4,l5,l6,l7,l8,bg,img;
JComboBox t1;
JTextField t2,t3;
JTextArea ta1,ta2,ta3,ta4,ta5;
JButton b1,b2;
Container c;
Connection con;
PreparedStatement st;
ResultSet rs;
boolean flag=false;
int id;
String nm,ques,op1,op2,op3,op4,cop;

New_Question_Demo()
{
setTitle("New Question");
setSize(1200,680);
setResizable(false);
setDefaultCloseOperation(EXIT_ON_CLOSE);
setLocationRelativeTo(null);

c=getContentPane();
c.setLayout(null);

Font f1=new Font("Lucida Calligraphy",Font.BOLD,33);
Font f2=new Font("arial",Font.BOLD,18);
Font f3=new Font("arial",Font.ITALIC,15);

ImageIcon im=new ImageIcon("bgq.jpg");
bg=new JLabel(im);
bg.setBounds(0,0,1200,680);
c.add(bg);

ImageIcon im1=new ImageIcon("q.png");
img=new JLabel(im1);
img.setBounds(850,60,250,210);
bg.add(img);


lmain=new JLabel("New Question Details");
lmain.setFont(f1);
lmain.setForeground(Color.BLACK);
lmain.setBounds(425,25,500,50);
bg.add(lmain);

l1=new JLabel("Technology ID");
l1.setFont(f2);
l1.setForeground(Color.BLACK);
l1.setBounds(80,130,150,30);
bg.add(l1);

t1=new JComboBox();
t1.setFont(f3);
t1.addActionListener(this);
t1.setBounds(280,130,180,25);
bg.add(t1);

l2=new JLabel("Technology Name");
l2.setFont(f2);
l2.setForeground(Color.BLACK);
l2.setBounds(80,200,180,30);
bg.add(l2);

t2=new JTextField();
t2.setFont(f3);
t2.setBounds(280,200,180,25);
t2.setEditable(false);
bg.add(t2);

l3=new JLabel("Question");
l3.setFont(f2);
l3.setForeground(Color.BLACK);
l3.setBounds(130,280,150,30);
bg.add(l3);

ta1=new JTextArea();
ta1.setFont(f3);
ta1.setLineWrap(true);
ta1.setWrapStyleWord(true);
ta1.setBounds(280,280,870,50);
bg.add(ta1);

l4=new JLabel("Option A");
l4.setFont(f2);
l4.setForeground(Color.BLACK);
l4.setBounds(150,360,150,30);
bg.add(l4);

ta2=new JTextArea();
ta2.setFont(f3);
ta2.setLineWrap(true);
ta2.setWrapStyleWord(true);
ta2.setBounds(280,355,300,40);
bg.add(ta2);

l5=new JLabel("Option B");
l5.setFont(f2);
l5.setForeground(Color.BLACK);
l5.setBounds(750,355,150,30);
bg.add(l5);

ta3=new JTextArea();
ta3.setFont(f3);
ta3.setLineWrap(true);
ta3.setWrapStyleWord(true);
ta3.setBounds(850,355,300,40);
bg.add(ta3);

l6=new JLabel("Option C");
l6.setFont(f2);
l6.setForeground(Color.BLACK);
l6.setBounds(150,430,150,30);
bg.add(l6);

ta4=new JTextArea();
ta4.setFont(f3);
ta4.setLineWrap(true);
ta4.setWrapStyleWord(true);
ta4.setBounds(280,430,300,40);
bg.add(ta4);

l7=new JLabel("Option D");
l7.setFont(f2);
l7.setForeground(Color.BLACK);
l7.setBounds(750,440,150,30);
bg.add(l7);

ta5=new JTextArea();
ta5.setFont(f3);
ta5.setLineWrap(true);
ta5.setWrapStyleWord(true);
ta5.setBounds(850,430,300,40);
bg.add(ta5);

l8=new JLabel("Correct Answer");
l8.setFont(f2);
l8.setForeground(Color.BLACK);
l8.setBounds(80,500,150,30);
bg.add(l8);

t3=new JTextField();
t3.setFont(f3);
t3.addKeyListener(this);
t3.addFocusListener(this);
t3.setBounds(280,500,180,25);
bg.add(t3);


b1=new JButton("SAVE");
b1.setFont(f2);
b1.setBounds(400,580,120,30);
b1.addActionListener(this);
bg.add(b1);

b2=new JButton("CANCEL");
b2.setFont(f2);
b2.setBounds(700,580,120,30);
b2.addActionListener(this);
bg.add(b2);

try
{
Class.forName("com.mysql.cj.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/technometer","root","");
st=con.prepareStatement("select Tech_code from technology");
rs=st.executeQuery();
t1.addItem("Select an ID");
while(rs.next())
{
t1.addItem(String.valueOf(rs.getInt("Tech_code")));
}
flag=true;
}
catch(Exception e)
{
System.out.print(e);
}
setVisible(true);
ta1.requestFocus();
}

public void keyPressed(KeyEvent ke)
{
char c=ke.getKeyChar();
if(ke.getSource()==t3)
{
if((c== 'A') ||(c== 'a') || (c== 'B') ||(c== 'b') || (c== 'C') ||(c== 'c') || (c== 'D') ||(c== 'd') || (c=='\b'))
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
cop=t3.getText();
if(cop.length()==1)
{
}
else
{
JOptionPane.showMessageDialog(this,"Please enter a valid option");
t3.requestFocus();
}
}
}

public void focusGained(FocusEvent fe)
{
}

public void actionPerformed(ActionEvent ae)
{
if((ae.getSource()==t1) && (flag==true))
{
id=Integer.parseInt((String) t1.getSelectedItem());
try
{
st=con.prepareStatement("select * from technology where Tech_code=?");
st.setInt(1,id);
rs=st.executeQuery();
if(rs.next())
{
nm=rs.getString(2);
t2.setText(nm);
}
}
catch(Exception e)
{
System.out.print(e);
}
}

else if(ae.getSource()==b2)
{
dispose();
}
else if(ae.getSource()==b1)
{
ques=ta1.getText();
op1=ta2.getText();
op2=ta3.getText();
op3=ta4.getText();
op4=ta5.getText();
cop=t3.getText();

try
{
st=con.prepareStatement("insert into questions values(?,?,?,?,?,?,?,?)");
st.setString(1,ques);
st.setInt(2,id);
st.setString(3,op1);
st.setString(4,op2);
st.setString(5,op3);
st.setString(6,op4);
st.setString(7,cop);
st.setString(8,nm);
st.executeUpdate();
JOptionPane.showMessageDialog(this,"Question Added Successfully");
t2.setText("");
ta1.setText("");
ta2.setText("");
ta3.setText("");
ta4.setText("");
ta5.setText("");
t3.setText("");
ta1.requestFocus();
}
catch(Exception e)
{
System.out.print(e);
}

}

}
}

class New_Question
{
public static void main(String []s)
{
New_Question_Demo nq = new New_Question_Demo();
}
}
