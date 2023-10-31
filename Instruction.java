import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

class Inst_Demo extends JFrame implements ActionListener
{
JLabel lmain,l1,l2,l3,l4,l5,bg;
JButton b1,b2;
Font ftm,ft1,ft2;
Container c;
int en,techc;
String exmdt,tchname;

Inst_Demo(int enr, int tech, String technm, String exdt)
{
setUndecorated(true);
setSize(1200,500);
setResizable(false);
setLocationRelativeTo(null);

en=enr;
techc=tech;
tchname=technm;
exmdt=exdt;

c=getContentPane();
c.setLayout(null);

ftm=new Font("Old English Text MT",Font.BOLD,60);
ft1=new Font("TimesNewRoman",Font.BOLD,18);
ft2=new Font("arial",Font.BOLD,20);

ImageIcon bimg=new ImageIcon("inst_bg.jpg");
bg=new JLabel(bimg);
bg.setBounds(0,0,1200,500);
c.add(bg);

lmain=new JLabel("Instructions");
lmain.setBounds(35,50,400,50);
lmain.setForeground(Color.RED);
lmain.setFont(ftm);
bg.add(lmain);

l1=new JLabel("1. The examination will comprise of Objective type Multiple Choice Questions (MCQs).");
l1.setBounds(70,150,900,25);
l1.setForeground(Color.WHITE);
l1.setFont(ft1);
bg.add(l1);

l2=new JLabel("2. All questions are compulsory and each carries One mark.");
l2.setBounds(70,200,700,25);
l2.setForeground(Color.WHITE);
l2.setFont(ft1);
bg.add(l2);

l3=new JLabel("3. The examination does not require using any paper, pen, pencil and calculator.");
l3.setBounds(70,250,700,25);
l3.setForeground(Color.WHITE);
l3.setFont(ft1);
bg.add(l3);

l4=new JLabel("4. Each student will get questions and answers in different order selected randomly from a fixed Question Databank.");
l4.setBounds(70,300,1050,25);
l4.setForeground(Color.WHITE);
l4.setFont(ft1);
bg.add(l4);

l5=new JLabel("5. There will be NO NEGATIVE MARKING for the wrong answers.");
l5.setBounds(70,350,700,25);
l5.setForeground(Color.WHITE);
l5.setFont(ft1);
bg.add(l5);

b1=new JButton("Start Exam");
b1.setBounds(380,420,150,25);
b1.setFont(ft2);
b1.setBackground(Color.BLACK);
b1.setForeground(Color.WHITE);
b1.addActionListener(this);
bg.add(b1);

b2=new JButton("Exit");
b2.setBounds(700,420,100,25);
b2.setForeground(Color.WHITE);
b2.setBackground(Color.BLACK);
b2.setFont(ft2);
b2.addActionListener(this);
bg.add(b2);

setVisible(true);
}

public void actionPerformed(ActionEvent ae)
{
if(ae.getSource()==b2)
{
Student_Demo sd=new Student_Demo(en);
dispose();
}
else if(ae.getSource()==b1)
{
Exam_Demo ed=new Exam_Demo(en,techc,tchname, exmdt);
dispose();
}
}

}
class Instruction
{
public static void main(String []s)
{
//Inst_Demo id=new Inst_Demo();
}
}