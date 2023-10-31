import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import javax.swing.table.*;

class Resultadm_Demo extends JFrame implements ActionListener
{
JLabel img,lmain;
JButton b1;
Connection con;
PreparedStatement st;
ResultSet rs;
Container c;
int tech,res,en,tm=30;
String doe,nm,tch;
DefaultTableModel model;
JTable jt;

Resultadm_Demo()
{
setSize(1200,720);
setResizable(false);
setUndecorated(true);
setLocationRelativeTo(null);

c=getContentPane();
c.setLayout(null);

ImageIcon im=new ImageIcon("resadm_bg.jpg");
img=new JLabel(im);
img.setBounds(0,0,1200,720);
c.add(img);

Font f1=new Font("algerian",Font.BOLD,72);
Font f2=new Font("Monotype Corsiva",Font.BOLD,18);
Font f3=new Font("Imprint MT Shadow",Font.BOLD,22);

lmain=new JLabel("RESULT");
lmain.setBounds(500,40,300,80);
lmain.setForeground(Color.WHITE);
lmain.setFont(f1);
img.add(lmain);


model=new DefaultTableModel();
String heads[]={"ID","Name","Tech_code","Tech_name","DOE","Total","Marks Obt."};
model.setColumnIdentifiers(heads);


jt=new JTable();
jt.setFont(f2);
jt.setModel(model);

JTableHeader tblhr = jt.getTableHeader();
tblhr.setFont(f3);

JScrollPane sp=new JScrollPane(jt);
sp.setBounds(150,145,900,430);
img.add(sp);


b1=new JButton("CLOSE");
b1.setBounds(525,660,150,30);
b1.setForeground(Color.WHITE);
b1.setBackground(new Color(109,21,248));
b1.addActionListener(this);
b1.setFont(f2);
img.add(b1);

try
{
Class.forName("com.mysql.cj.jdbc.Driver");
con=DriverManager.getConnection("jdbc:mysql://localhost/technometer","root","");
st=con.prepareStatement("select * from result");
rs=st.executeQuery();

while(rs.next())
{
tech=rs.getInt(1);
en=rs.getInt(2);
doe=rs.getString(3);
res=rs.getInt(4);

st=con.prepareStatement("select name,technology from candidate where Exam='Yes'");
rs=st.executeQuery();
while (rs.next())
{
nm=rs.getString("name");
tch=rs.getString("technology");

model.addRow(new Object[]{en,nm,tech,tch,doe,tm,res});

}
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
Admin_Demo ad=new Admin_Demo();
dispose();
}
}
}
