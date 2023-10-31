import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.table.*;

class New_Technology_Demo extends JFrame implements ActionListener, KeyListener
{
JLabel lmain,l1,l2,l3,l4,l5,l6,img,bg;
JTextField t1,t2,t3,t4,t5,t6;
JButton b1,b2,b3,b4,b5;
Container c;
Connection con;
PreparedStatement st;
ResultSet rs;
int id,m_marks,p_marks,n_o_q,dur;
String name;
DefaultTableModel model;
JTable jt;
JPanel p,p1;


New_Technology_Demo()
{
setTitle("New Technology");
setSize(1100,720);
setResizable(false);
setDefaultCloseOperation(EXIT_ON_CLOSE);
setLocationRelativeTo(null);

c=getContentPane();
c.setLayout(null);

Font f1=new Font("algerian",Font.BOLD,32);
Font f2=new Font("arial",Font.BOLD,15);
Font fl=new Font("arial",Font.BOLD,17);

p=new JPanel();
p.setLayout(null);
p1=new JPanel();
p1.setLayout(null);

lmain=new JLabel("New Technologies Details");
lmain.setFont(f1);
lmain.setForeground(new Color(227, 214, 213));
lmain.setBounds(340,10,500,50);
c.add(lmain);

l1=new JLabel("Technology ID");
l1.setFont(fl);
l1.setForeground(Color.WHITE);
l1.setBounds(80,100,150,20);
c.add(l1);

t1=new JTextField();
t1.setFont(f2);
t1.setBounds(280,100,150,20);
t1.setForeground(Color.WHITE);
t1.setBackground(Color.BLACK);
t1.setEditable(false);
c.add(t1);

model=new DefaultTableModel();
String heads[]={"Id","Name","N.O.Q","Max. Marks","Pass. Marks","Duration"};
model.setColumnIdentifiers(heads);

jt=new JTable();
jt.setModel(model);

JScrollPane sp=new JScrollPane(jt);
sp.setBounds(0,0,550,450);
p.setBounds(460,90,550,530);
p.setBackground(new Color(0,0,0,0));
p.setVisible(false);
p.add(sp);


ImageIcon im=new ImageIcon("pnl.png");
img=new JLabel(im);
img.setBounds(0,-50,550,530);
p1.setBounds(460,90,550,530);
p1.setVisible(true);
p1.setBackground(new Color(0,0,0,0));
p1.add(img);
c.add(p1);

ImageIcon bimg=new ImageIcon("bg_tech.png");
bg=new JLabel(bimg);
bg.setBounds(0,0,1100,750);
c.add(bg);

l2=new JLabel("Technology Name");
l2.setFont(fl);
l2.setForeground(Color.WHITE);
l2.setBounds(80,170,150,20);
bg.add(l2);

t2=new JTextField();
t2.setFont(f2);
t2.setBounds(280,170,150,20);
t2.addKeyListener(this);
bg.add(t2);

l3=new JLabel("Number Of Question");
l3.setFont(fl);
l3.setForeground(Color.WHITE);
l3.setBounds(80,240,180,20);
bg.add(l3);

t3=new JTextField();
t3.setFont(f2);
t3.setBounds(280,240,150,20);
t3.addKeyListener(this);
bg.add(t3);

l4=new JLabel("Maximum Marks");
l4.setFont(fl);
l4.setForeground(Color.WHITE);
l4.setBounds(80,310,150,20);
bg.add(l4);

t4=new JTextField();
t4.setFont(f2);
t4.setBounds(280,310,150,20);
t4.addKeyListener(this);
bg.add(t4);

l5=new JLabel("Passing Marks");
l5.setFont(fl);
l5.setForeground(Color.WHITE);
l5.setBounds(80,380,150,20);
bg.add(l5);

t5=new JTextField();
t5.setFont(f2);
t5.setBounds(280,380,150,20);
t5.addKeyListener(this);
bg.add(t5);

l6=new JLabel("Duration");
l6.setFont(fl);
l6.setForeground(Color.WHITE);
l6.setBounds(80,450,150,20);
bg.add(l6);

t6=new JTextField();
t6.setFont(f2);
t6.setBounds(280,450,150,20);
t6.addKeyListener(this);
bg.add(t6);

b1=new JButton("Add To Table");
b1.setFont(f2);
b1.setBounds(90,590,150,30);
b1.setBackground(Color.BLACK);
b1.setForeground(Color.WHITE);
b1.addActionListener(this);
bg.add(b1);

b2=new JButton("Cancel");
b2.setFont(f2);
b2.setBounds(290,590,120,30);
b2.setBackground(Color.BLACK);
b2.setForeground(Color.WHITE);
b2.addActionListener(this);
bg.add(b2);

b3=new JButton("Remove From Table");
b3.setFont(f2);
b3.setBounds(0,498,180,30);
b3.setBackground(Color.BLACK);
b3.setForeground(Color.WHITE);
b3.addActionListener(this);
p.add(b3);


b4=new JButton("Submit");
b4.setFont(f2);
b4.setBounds(230,498,120,30);
b4.setBackground(Color.BLACK);
b4.setForeground(Color.WHITE);
b4.addActionListener(this);
p.add(b4);


b5=new JButton("Edit");
b5.setFont(f2);
b5.setBounds(400,498,120,30);
b5.setBackground(Color.BLACK);
b5.setForeground(Color.WHITE);
b5.addActionListener(this);
p.add(b5);

bg.add(p);

try
{
Class.forName("com.mysql.cj.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/technometer","root","");
st=con.prepareStatement("select max(Tech_code) from technology");
rs=st.executeQuery();
rs.next();
id=rs.getInt(1);
if(id==0)
id=1001;
else
id++;
t1.setText(String.valueOf(id));
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
if(ke.getSource()==t3)
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
if(ke.getSource()==t4)
{
if((c>='0' && c<='9') || (c=='\b'))
{
t4.setEditable(true);
}
else
{
t4.setEditable(false);
}
}
if(ke.getSource()==t5)
{
if((c>='0' && c<='9') || (c=='\b'))
{
t5.setEditable(true);
}
else
{
t5.setEditable(false);
}
}
if(ke.getSource()==t6)
{
if((c>='0' && c<='9') || (c=='\b'))
{
t6.setEditable(true);
}
else
{
t6.setEditable(false);
}
}
}
public void keyReleased(KeyEvent ke)
{
}
public void keyTyped(KeyEvent ke)
{
}


public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b1)
{ 
  p1.setVisible(false);
  p.setVisible(true);
  id=Integer.parseInt(t1.getText());
  name=t2.getText();
  n_o_q=Integer.parseInt(t3.getText());
  m_marks=Integer.parseInt(t4.getText());
  p_marks=Integer.parseInt(t5.getText());
  dur=Integer.parseInt(t6.getText());

model.addRow(new Object[]{id,name,n_o_q,m_marks,p_marks,dur});

id++;
t1.setText(String.valueOf(id));
t2.setText("");
t3.setText("");
t4.setText("");
t5.setText("");
t6.setText("");
t2.requestFocus();
}
else if(ae.getSource()==b2)
{
Admin_Demo ad=new Admin_Demo();
dispose();
}
else if(ae.getSource()==b4)
{

int cn=model.getRowCount();
for(int i=0;i<cn;i++)
{
id=Integer.parseInt(model.getValueAt(i,0).toString());
name=model.getValueAt(i,1).toString();
n_o_q=Integer.parseInt(model.getValueAt(i,2).toString());
m_marks=Integer.parseInt(model.getValueAt(i,3).toString());
p_marks=Integer.parseInt(model.getValueAt(i,4).toString());
dur=Integer.parseInt(model.getValueAt(i,5).toString());

try
{
st=con.prepareStatement("insert into technology values(?,?,?,?,?,?)");
st.setInt(1,id);
st.setString(2,name);
st.setInt(3,n_o_q);
st.setInt(4,m_marks);
st.setInt(5,p_marks);
st.setInt(6,dur);
st.executeUpdate();
}
catch(Exception e)
{
System.out.print(e);
}
}
model.setRowCount(0);
JOptionPane.showMessageDialog(this,"All Technologies Added Successfully");

t2.requestFocus();
p.setVisible(false);
p1.setVisible(true);
}
else if(ae.getSource()==b3)
{
int r=jt.getSelectedRow();
if(r>=0)
{
model.removeRow(r);
}
else
{
JOptionPane.showMessageDialog(this,"Please Select a Row");
}
/*int rc=jt.getRowCount();
if(rc<0)
{
p.setVisible(false);
p1.setVisible(true);
}*/
t2.requestFocus();
}

else if(ae.getSource()==b5)
{
int rw=jt.getSelectedRow();
if(rw==0)
{
name=model.getValueAt(rw,1).toString();
n_o_q=Integer.parseInt(model.getValueAt(rw,2).toString());
m_marks=Integer.parseInt(model.getValueAt(rw,3).toString());
p_marks=Integer.parseInt(model.getValueAt(rw,4).toString());
dur=Integer.parseInt(model.getValueAt(rw,5).toString());
t2.setText(name);
t3.setText(String.valueOf(n_o_q));
t4.setText(String.valueOf(m_marks));
t5.setText(String.valueOf(p_marks));
t6.setText(String.valueOf(dur));

model.removeRow(rw);

}
else
{
JOptionPane.showMessageDialog(this,"Please Select a Row");
}
/*int rc=model.getRowCount();
if(rc<0)
{
p.setVisible(false);
p1.setVisible(true);
}*/
t2.requestFocus();
}


}
}

class New_Technology
{
public static void main(String []s)
{
New_Technology_Demo nd = new New_Technology_Demo();
}
}
