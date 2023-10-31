import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;

class Delete_Technology_Demo extends JFrame implements ActionListener
{
JLabel lmain,l1,l2,l3,l4,l5,l6,img;
JComboBox t1;
JTextField t2,t3,t4,t5,t6;
JButton b1,b2,b3,b4,b5;
Container c;
Connection con;
PreparedStatement st;
ResultSet rs;
int id,m_marks,p_marks,n_o_q,dur;
String name;
boolean flag=false;

Delete_Technology_Demo()
{
setTitle("Delete Technology");
setSize(540,620);
setResizable(false);
setDefaultCloseOperation(EXIT_ON_CLOSE);
setLocationRelativeTo(null);

c=getContentPane();
c.setLayout(null);

ImageIcon im=new ImageIcon("bg3.png");
img=new JLabel(im);
img.setBounds(0,0,540,620);
c.add(img);

Font f1=new Font("consolas",Font.BOLD,24);
Font f2=new Font("arial",Font.BOLD,15);
Font fl=new Font("arial",Font.BOLD,17);

lmain=new JLabel("Delete Technologies");
lmain.setFont(f1);
lmain.setForeground(Color.BLACK);
lmain.setBounds(140,10,450,40);
img.add(lmain);

l1=new JLabel("Technology ID");
l1.setFont(fl);
l1.setForeground(Color.BLACK);
l1.setBounds(80,100,150,20);
img.add(l1);

t1=new JComboBox();
t1.setFont(f2);
t1.setBounds(280,100,150,20);
t1.addActionListener(this);
img.add(t1);

l2=new JLabel("Technology Name");
l2.setFont(fl);
l2.setForeground(Color.BLACK);
l2.setBounds(80,170,150,20);
img.add(l2);

t2=new JTextField();
t2.setFont(f2);
t2.setBounds(280,170,150,20);
t2.setEditable(false);
img.add(t2);

l3=new JLabel("Number Of Question");
l3.setFont(fl);
l3.setForeground(Color.BLACK);
l3.setBounds(80,240,180,20);
img.add(l3);

t3=new JTextField();
t3.setFont(f2);
t3.setBounds(280,240,150,20);
t3.setEditable(false);
img.add(t3);

l4=new JLabel("Maximum Marks");
l4.setFont(fl);
l4.setForeground(Color.BLACK);
l4.setBounds(80,310,150,20);
img.add(l4);

t4=new JTextField();
t4.setFont(f2);
t4.setBounds(280,310,150,20);
t4.setEditable(false);
img.add(t4);

l5=new JLabel("Passing Marks");
l5.setFont(fl);
l5.setForeground(Color.BLACK);
l5.setBounds(80,380,150,20);
img.add(l5);

t5=new JTextField();
t5.setFont(f2);
t5.setBounds(280,380,150,20);
t5.setEditable(false);
img.add(t5);

l6=new JLabel("Duration");
l6.setFont(fl);
l6.setForeground(Color.BLACK);
l6.setBounds(80,450,150,20);
img.add(l6);

t6=new JTextField();
t6.setFont(f2);
t6.setBounds(280,450,150,20);
t6.setEditable(false);
img.add(t6);

b1=new JButton("Delete");
b1.setFont(f2);
b1.setBounds(90,520,120,30);
b1.setForeground(Color.BLACK);
b1.setBackground(new Color(84,154,218));
b1.addActionListener(this);
img.add(b1);

b2=new JButton("Cancel");
b2.setFont(f2);
b2.setBounds(290,520,120,30);
b2.setForeground(Color.BLACK);
b2.setBackground(new Color(241,139,83));
b2.addActionListener(this);
img.add(b2);

try
{
Class.forName("com.mysql.cj.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/technometer","root","");
st=con.prepareStatement("select tech_code from technology");
rs=st.executeQuery();
t1.addItem("Select an ID");
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
id=Integer.parseInt((String)t1.getSelectedItem());
try
{
st=con.prepareStatement("select * from technology where Tech_code=?");
st.setInt(1,id);
rs=st.executeQuery();
if(rs.next())
{
name=rs.getString(2);
n_o_q=rs.getInt(3);
m_marks=rs.getInt(4);
p_marks=rs.getInt(5);
dur=rs.getInt(6);
t2.setText(name);
t3.setText(String.valueOf(n_o_q));
t4.setText(String.valueOf(m_marks));
t5.setText(String.valueOf(p_marks));
t6.setText(String.valueOf(dur));
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
try
{
st=con.prepareStatement("delete from technology where Tech_code=?");
st.setInt(1,id);
st.executeUpdate();
st=con.prepareStatement("delete from questions where Tech_code=?");
st.setInt(1,id);
st.executeUpdate();
JOptionPane.showMessageDialog(this,"Technology Details Deleted Successfully");
t1.removeItem(t1.getSelectedItem());
t2.setText("");
t3.setText("");
t4.setText("");
t5.setText("");
t6.setText("");
t1.setSelectedIndex(0);
}
catch(Exception e)
{
System.out.print(e);
}
}

}
}

class Delete_Technology
{
public static void main(String []s)
{
Delete_Technology_Demo dt = new Delete_Technology_Demo();
}
}
