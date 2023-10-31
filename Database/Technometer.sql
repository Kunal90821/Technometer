-- MySQL dump 10.13  Distrib 8.0.21, for Win64 (x86_64)
--
-- Host: localhost    Database: technometer
-- ------------------------------------------------------
-- Server version	8.0.21

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `admin`
--

DROP TABLE IF EXISTS `admin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `admin` (
  `admin` varchar(30) NOT NULL,
  `admin_pass` varchar(50) NOT NULL,
  PRIMARY KEY (`admin`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `admin`
--

LOCK TABLES `admin` WRITE;
/*!40000 ALTER TABLE `admin` DISABLE KEYS */;
INSERT INTO `admin` VALUES ('Admin_1','adm@kunal'),('Admin_2','adm@vishal'),('Admin_3','adm@nishita');
/*!40000 ALTER TABLE `admin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `candidate`
--

DROP TABLE IF EXISTS `candidate`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `candidate` (
  `Enrollment_No` int NOT NULL,
  `Name` varchar(30) NOT NULL,
  `Contact` varchar(10) NOT NULL,
  `Gender` varchar(20) NOT NULL,
  `Technology` varchar(30) NOT NULL,
  `DOB` varchar(11) NOT NULL,
  `DOE` varchar(11) NOT NULL,
  `Email` varchar(50) NOT NULL,
  PRIMARY KEY (`Enrollment_No`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `candidate`
--

LOCK TABLES `candidate` WRITE;
/*!40000 ALTER TABLE `candidate` DISABLE KEYS */;
INSERT INTO `candidate` VALUES (1001,'Aakash','9054753210','Male','C','10/Oct/2001','20/Mar/2021','Aakash123@gmail.com'),(1002,'Siya','8545682211','Female','C','17/Jul/2002','21/Mar/2021','Siyaxyz@gmail.com'),(1003,'Aditi','9045328899','Female','C','12/Jan/2002','20/Mar/2021','Aditi345@gmail.com'),(1004,'Aashu','8456123755','Male','C','22/Jan/2001','21/Mar/2021','Aashu555@gmail.com'),(1005,'Deepak','7546892310','Male','C++','08/May/2001','22/Mar/2021','Deepak422@gmail.com'),(1006,'Vishakha','8754961230','Female','C++','05/Nov/2002','21/Mar/2021','Vishakha500@gmail.com'),(1007,'Rishabh','9987564412','Male','C++','20/Apr/2001','22/Mar/2021','RishabhABC@gmail.com'),(1008,'Meera','8894659241','Female','C++','29/Jun/2001','23/Mar/2021','Meera029@gmail.com'),(1009,'Siddharth','8754632514','Male','JAVA','02/Aug/2001','22/Mar/2021','Sidd123@gmail.com'),(1010,'Rahul','9988456621','Male','JAVA','08/Dec/2002','22/Mar/2021','Rahul909@gmail.com'),(1011,'Devang','8945665547','Male','JAVA','18/Sep/2001','21/Mar/2021','Devang1AB@gmail.com'),(1012,'Karan','8794556621','Male','JAVA','14/Mar/2001','20/Mar/2021','Karan789@gmail.com'),(1013,'Nivedita','9568471535','Female','JAVA','24/Jan/2000','23/Mar/2021','Nivedita666@gmail.com'),(1014,'Anant','9876543210','Male','HTML','22/May/2002','23/Mar/2021','Anant432@gmail.com'),(1015,'Yash','9874561230','Male','HTML','20/Aug/2002','21/Mar/2021','Yash987@gmail.com'),(1016,'Yogita','8956741236','Female','HTML','17/Nov/2002','20/Mar/2021','Yogita444@gmail.com'),(1017,'Shloka','8745662211','Male','C#','25/Dec/2001','23/Mar/2021','Shlok321@gmail.com'),(1018,'Harsh','8866541239','Male','C#','17/Oct/2000','24/Mar/2021','Harsh333@gmail.com'),(1019,'Punit','8956741233','Male','C#','25/Jul/2000','24/Mar/2021','Punit786@gmail.com'),(1020,'Muskan','7400125633','Female','Python','09/Dec/2000','23/Mar/2021','Muskan009@gmail.com'),(1021,'Preeti','8500123400','Female','Python','12/Sep/2000','20/Mar/2021','Preeti222@gmail.com'),(1022,'Vanshika','9501200015','Female','Python','20/May/2002','24/Mar/2021','Vanshika654@gmail.com');
/*!40000 ALTER TABLE `candidate` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `questions`
--

DROP TABLE IF EXISTS `questions`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `questions` (
  `question` varchar(500) NOT NULL,
  `Tech_code` varchar(30) NOT NULL,
  `Option_1` varchar(100) NOT NULL,
  `Option_2` varchar(100) NOT NULL,
  `Option_3` varchar(100) NOT NULL,
  `Option_4` varchar(100) NOT NULL,
  `Correct_Option` varchar(30) NOT NULL,
  `Tech_name` varchar(30) NOT NULL,
  PRIMARY KEY (`question`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `questions`
--

LOCK TABLES `questions` WRITE;
/*!40000 ALTER TABLE `questions` DISABLE KEYS */;
INSERT INTO `questions` VALUES ('A C program is a combination of.?\n','1001','Statements','Function','Variables','All of the above','D','C'),('C language is used in the development of .?\n','1001','Databases','Graphic applications','Word Processors','All of the above','D','C'),('C language was invented in the year.?\n','1001','1999','1978','1972','1975','C','C'),('BCPL Language is also called..?\n','1001','C language','B language','D language','None','D','C'),(' C is _______ type of programming language.?\n','1001','Object Oriented',' Procedural','Bit level language','Functional','B','C'),('C is which level language ?','1001','Low level','High level','Low + High','None','B','C'),('Who invented C language ?','1001','Charles Babbage','Steve Jobs','Denis Ritchie','Grahambel','C','C'),('C language is a successor to which language ?','1001','FORTRAN ','D language','BASIC','B language','D','C'),('Single Line Comment // is also called.? \n','1001','C++ Style Comment','Java Style Comment','PHP Style Comment','All the above','D','C'),('What is an Identifier in C Language.?\n','1001','Name of a Function or Variable','Name of a Macros','Name of Structure or Union','All the above','D','C'),('What is the number of characters used to distinguish Identifier or Names of Functions and Global variables.?','1001','31','32','33','28','A','C'),('An Identifier can start with.?\n\n','1001','Alphabet','Underscore ( _ ) sign','Any character can be typed on a keyboard','Option A & Option B','D','C'),(' What are the types of Constants in C Language.?','1001','Primary Constants','Secondary Constants','Basic Constants and Advanced Constants','Primary Constants and Secondary Constants','D','C'),('Find an integer constant.','1001','3.147','34','\"125\"','None','B','C'),('Operator % in C Language is called.\n','1001','Percentage Operator','Quotient Operator','Modulus','None','C','C'),('Output of an arithmetic expression with integers and real numbers is ___ by default.?\n ','1001','Integer','Real number',' Depends on the numbers used in the expression.','None of the above','B','C'),(' Choose a syntax for C Ternary Operator from the list .\n','1001','condition ? expression1 : expression2','condition : expression1 ? expression2',' condition ? expression1 < expression2','condition < expression1 ? expression2','A','C'),(' Choose a statement to use C If Else statement.\n','1001',' else if is compulsory to use with if statement.',' else is compulsory to use with if statement.','else or else if is optional with if statement.','None of above','C','C'),('Identify wrong C Keywords below.','1001','auto, double, int, struct','break, else, long, switch','case, enum, register, typedef',' char, extern, intern, return','D','C'),('Size of a Turbo C C++ compiler is.?\n\n','1001','16 bit','32 bit','64 bit','128 bit','A','C'),('Size of float, double and long double in Bytes are.?\n','1001','4, 8, 16',' 4, 8, 10','2, 4, 6','2, 6, 8','B','C'),(' Range of float variable is.?\n','1001',' -3.2e38 to +3.2e38','-3.8e32 to +3.8e32',' -3.4e34 to +3.4e34',' -3.4e38 to +3.4e38','D','C'),('What are the Types of Arrays.?\n\n','1001','int, long, float, double',' struct, enum','char',' All the above','D','C'),('A function which calls itself is called a ___ function.\n\n\n','1001','Self Function','Auto Function','Recursive Function','None of the above','C','C'),('How many values can a C Function return at a time.?\n','1001',' Only One Value',' Maximum of two values','Maximum of three values','Maximum of four values','A','C'),('Which of the following is the correct syntax of including a user defined header files in C++?\n','1002','#include <userdefined.h>',' #include <userdefined>','#include “userdefined”\r\n',' #include [userdefined]','C','C++'),('Which of the following is called address operator?\n','1002','*','&','_\r\n',' %','B','C++'),(' Which of the following escape sequence represents tab?\n','1002',' \\t',' \\t\\r',' \\b\r\n\r\n',' \\a','A','C++'),(' Who created C++?\n','1002','Bjarne Stroustrup',' Dennis Ritchie',' Ken Thompson',' Steve Jobs','A','C++'),('Which of the following is called extraction/get from operator?\n','1002','<<','>>','>','<','B','C++'),('Wrapping data and its related functionality into a single entity is known as _____________\n','1002','Abstraction','Encapsulation','polymorphism','Inherritence','B','C++'),('Which concept allows you to reuse the written code? ','1002',' Encapsulation',' Abstraction','Inherritence',' Polymorphism','C','C++'),(' C++ is ______________\n','1002','procedural programming language',' object oriented programming language',' functional programming language\r\n','both procedural and object oriented programming language','D','C++'),('Which of the following is not a fundamental type is not present in C but present in C++?\n','1002','int','float','bool','void','C','C++'),(' What is the size of a boolean variable in C++ ?\n','1002','1 bit','1 byte','4 byte','2 byte','A','C++'),('Which of the following is C++ equivalent for scanf()?\n','1002','cin','cout','print','input','A','C++'),(' Which of the following is an exit-controlled loop?\n ','1002','for','while','do-while','None of the above','C','C++'),(' Which of the following class allows to declare only one object of  it ?\n','1002','Abstract class','Virtual class','Singleton class\r\n','Friend class','C','C++'),('Which of the following is not a type of Constructor?\n','1002','Friend constructor','Copy constructor',' Default constructor','Parameterized constructor','A','C++'),('Out of the following, which is not a member of the class ?','1002','Static function',' Friend function\n',' Constant function',' Virtual function\r\n','B','C++'),(' What is the other name used for functions inside a class?\n','1002','Member variables',' Member functions','Class functions',' Class variables','B','C++'),('How many types of polymorphism are there in C++?\n','1002','1','2','3','4','B','C++'),('Which of the following is an abstract data type?\n','1002','int','float','class','double','C','C++'),('Which of the following approach is used by C++?\n','1002','Top-down',' Bottom-up','Left-right','Right-left','B','C++'),(' Which of the following is the scope resolution operator in c++ ?\n','1002','  .',' *',' ::',' ~','C','C++'),('Which of the following cannot be used with the virtual keyword ?\n','1002','class','memeber function',' Constructors','Destructors','C','C++'),('Which of the following is not a type of inheritance?','1002','multiple','multilevel','distributive','hierarchical','C','C++'),(' Which members are inherited but are not accessible in any case?','1002','Private',' Public\n',' Protected',' Both private and protected','A','C++'),(' What is the other name of compile-time polymorphism?\n','1002',' Static polymorphism','Dynamic polymorphism','Executing polymorphism','None of the above','A','C++'),(' Which of the following cannot be a friend?\n','1002','Function','Class','Object','Operator function','C','C++'),('Which of the following option leads to the portability and security of Java?\n','1003','Bytecode is executed by JVM','The applet makes the Java code secure and portable','Use of exception handling\r\n','Dynamic binding between objects','A','JAVA'),(' Which of the following is not a Java features?\n','1003','Dynamic','Architecture Neutral','Use of pointers\r\n','Object-oriented','C','JAVA'),('The \\u0021 article referred to as a\n','1003','Unicode escape sequence','Octal escape','Hexadecimal\r\n','Line feed','A','JAVA'),('_____ is used to find and fix bugs in the Java programs.\n','1003','JVM','JRE','JDK\r\n','JDB','D','JAVA'),(' What is the return type of the hashCode() method in the Object class?\n','1003','Object','int','long\r\n','void','B','JAVA'),('What does the expression float a = 35 / 0 return?\n','1003','0','Not a Number','Infinity\r\n','Run time exception','C','JAVA'),('Evaluate the following Java expression, if x=3, y=5, and z=10:\n++z + y - y + z + x++\n','1003','24','23','20','25','A','JAVA'),('Which of the following tool is used to generate API documentation in HTML format from doc comments in source code?\n\n','1003','javap tool','javaw command','Javadoc tool\r\n','javah command\r\n','C','JAVA'),('Which of the following creates a List of 3 visible items and multiple selections abled?\n\n','1003','new List(false, 3)','new List(3, true)','new List(true, 3)\r\n','new List(3, false)','B','JAVA'),('Which of the following for loop declaration is not valid?\n','1003','for ( int i = 99; i >= 0; i / 9 )','for ( int i = 7; i <= 77; i += 7 )','for ( int i = 20; i >= 2; - -i )\r\n','for ( int i = 2; i <= 20; i = 2* i )','A','JAVA'),('Which method of the Class.class is used to determine the name of a class represented by the class object as a String?\n\n','1003','getClass()','intern()','getName()\r\n','toString()','C','JAVA'),('In which process, a local variable has the same name as one of the instance variables?\n','1003','Serialization','Variable Shadowing','Abstraction\r\n','Multi-threading','B','JAVA'),(' Which of the following is true about the anonymous inner class?\n','1003','It has only methods','Objects can\'t be created','It has a fixed class name\r\n','It has no class name','D','JAVA'),(' Which package contains the Random class?\n','1003','java.util package','java.lang package','java.awt package\r\n','java.io package','A','JAVA'),('What do you mean by nameless objects?\n','1003','An object created by using the new keyword.','An object of a superclass created in the subclass','An object without having any name but having a reference.\r\n','An object that has no reference.','D','JAVA'),(' An interface with no fields or methods is known as a ______.\n\n','1003','Runnable Interface','Marker Interface\r\n','Abstract Interface\r\n','CharSequence Interface','B','JAVA'),('Which of the following is an immediate subclass of the Panel class?\n\n','1003','Applet class','Window class','Frame class\r\n','Dialog class','A','JAVA'),('Which option is false about the final keyword?\n\n','1003','A final method cannot be overridden in its subclasses','A final class cannot be extended.','A final class cannot extend other classes.\r\n\r\n','A final method can be inherited','C','JAVA'),('Which of these classes are the direct subclasses of the Throwable class?\n\n','1003','RuntimeException and Error class','Exception and VirtualMachineError class','Error and Exception class\r\n','IOException and VirtualMachineError class','C','JAVA'),('What do you mean by chained exceptions in Java?\n','1003','Exceptions occurred by the VirtualMachineError','An exception caused by other exceptions','Exceptions occur in chains with discarding the debugging information\r\n','None of the above','B','JAVA'),(' In which memory a String is stored, when we create a string using new operator?\n','1003','Stack','String memory','Heap memory\r\n','Random storage space','C','JAVA'),('What is the use of the intern() method?\n','1003','It returns the existing string from memory','It creates a new string in the database','It modifies the existing string in the database\r\n','None of the above','A','JAVA'),(' Which of the following is a marker interface?\n','1003','Runnable interface','Remote interface','Readable interface\r\n','Result interface','B','JAVA'),(' Which of the following is a reserved keyword in Java?\n','1003','object','strictfp','main\r\n','system','B','JAVA'),(' Which keyword is used for accessing the features of a package?\n','1003','package','import','extends\r\n','export','B','JAVA'),(' HTML stands for -\n\n','1004','HighText Machine Language','HyperText and links Markup Language','HyperText Markup Language\r\n','\r\nNone of these','C','HTML'),(' The correct sequence of HTML tags for starting a webpage is -\n','1004','Head, Title, HTML, body','HTML, Body, Title, Head','HTML, Head, Title, Body\r\n','Head, HTML, Title, Body','D','HTML'),('Which of the following element is responsible for making the text bold in HTML?\n','1004','<pre>','<a>','<b>\r\n','<br>','C','HTML'),(' Which of the following tag is used for inserting the largest heading in HTML?\n\n','1004','<h3>','<h1>','<h5>\r\n','<h6>','B','HTML'),('Which of the following tag is used to insert a line-break in HTML?\n\n','1004','<br>','<a>','<pre>\r\n\r\n','<b','A','HTML'),('How to create an unordered list (a list with the list items in bullets) in HTML?\n\n','1004','<ul>','<ol>','<li>\r\n\r\n','<i>','A','HTML'),(' Which character is used to represent the closing of a tag in HTML?\n','1004','  \\','  !','  /','  .','C','HTML'),(' How to create a hyperlink in HTML?\n','1004','<a href = \"www.javatpoint.com\"> javaTpoint.com </a>','<a url = \"www.javatpoint.com\" javaTpoint.com /a>','<a link = \"www.javatpoint.com\"> javaTpoint.com </a>\r\n','<a> www.javatpoint.com <javaTpoint.com /a>','A','HTML'),(' How to create an ordered list (a list with the list items in numbers) in HTML?\n','1004','<ul>','<ol>','<li>\r\n','<i>','B','HTML'),('Which of the following element is responsible for making the text italic in HTML?\n\n','1004','<i>','<italic>','<it>\r\n','<pre>','A','HTML'),(' How to insert an image in HTML?\n\n','1004','<img href = \"jtp.png\" />','<img url = \"jtp.png\" />','<img link = \"jtp.png\" />\r\n','<img src = \"jtp.png\" />','D','HTML'),(' How to add a background color in HTML?\n\n','1004','<marquee bg color: \"red\">','<marquee bg-color = \"red\">','<marquee bgcolor = \"red\">\r\n','<marquee color = \"red\">','C','HTML'),(' <input> is -\n\n','1004','a format tag.','an empty tag.','All of the above\r\n','None of the above','B','HTML'),(' Which of the following tag is used to make the underlined text?\n','1004','<i>','<ul>','<u>\r\n','<pre>','C','HTML'),(' How to create a checkbox in HTML?\n\n','1004','<input type = \"checkbox\">','<input type = \"button\">','<checkbox>\r\n','<input type = \"check\">','A','HTML'),('Which of the following tag is used to define options in a drop-down selection list?\n','1004','<select>','<list>','<dropdown>\r\n','<option>','D','HTML'),('HTML tags are enclosed in-\n','1004','# and #','{ and }','! and ?\r\n','< and >','D','HTML'),('Which of the following tag is used to add rows in the table?\n\n','1004','<td> and </td>','<th> and </th>','<tr> and </tr>\r\n','None of the above','C','HTML'),(' The <hr> tag in HTML is used for -\n','1004','new line','vertical ruler','new paragraph\r\n','horizontal ruler','D','HTML'),('Which of the following attribute is used to provide a unique name to an element?\n\n','1004','class','id','type\r\n','None of the above','B','HTML'),(' Which of the following HTML tag is used to display the text with scrolling effect?\n\n','1004','<marquee>','<scroll>','<div>\r\n','None of the above','A','HTML'),(' Which of the following HTML tag is the special formatting tag?\n','1004','<p>','<b>','<pre>\r\n','None of the above','C','HTML'),(' Which of the following is the correct way to send mail in HTML?','1004','<a href = \"mailto: xy@y\">','<a href = \"xy@y\">','<mail xy@y</mail>\r\n','None of the above','A','HTML'),(' Which of the following is the container for <tr>, <th>, and <td> ?\n\n','1004','<data>','<table>','<group>\r\n\r\n','All of the above','B','HTML'),(' How to insert a background image in HTML?\n','1004','<body background = \"img.png\">','<img background = \"img.png\">','<bg-image = \"img.png\">\r\n','None of the above','A','HTML'),('How many Bytes are stored by ‘Long’ Data type in C# .net?','1005',' 8',' 4',' 2',' 1','A','C#'),(' Choose “.NET class” name from which data type “UInt” is derived?\n','1005',' System.Int16','System.UInt32',' System.UInt64\r\n','System.UInt16','B','C#'),('Correct Declaration of Values to variables ‘a’ and ‘b’?\n','1005',' int a = 32, b = 40.6;',' int a = 42; b = 40;',' int a = 32; int b = 40;\r\n',' int a = b = 42;','C','C#'),(' Arrange the following data type in order of increasing magnitude sbyte, short, long, int.\n','1005',' long < short < int < sbyte','sbyte < short < int < long',' short < sbyte < int < long\r\n','short < int < sbyte < long','B','C#'),('Which data type should be more preferred for storing a simple number like 35 to improve execution speed of a program?\n\n','1005','sbyte','short','int','long','A','C#'),('Correct way to assign values to variable ‘c’ when int a=12, float b=3.5, int c;\n','1005',' c = a + b;',' c = a + int(float(b));',' c = a + convert.ToInt32(b);\r\n',' c = int(a + b);','C','C#'),(' Select a convenient declaration and initialization of a floating point number:\n','1005',' float somevariable = 12.502D',' float somevariable = (Double) 12.502D','float somevariable = (float) 12.502D\r\n','float somevariable = (Decimal)12.502D','C','C#'),(' Number of digits upto which precision value of float data type is valid?\n','1005','Upto 6 digit',' Upto 8 digit',' Upto 9 digit',' Upto 7 digit','D','C#'),('Valid Size of float data type is? \n','1005',' 10 Bytes','6 Bytes',' 4 Bytes\r\n','8 Bytes','C','C#'),(' Minimum and Maximum range of values supported by ‘float’ data type are?\n','1005','1.5 * 10-40 to 3.4 * 1038',' 1.5 * 10-45 to 3.4 * 1030',' 1.5 * 10-45 to 3.4 * 1038','1.5 * 10-45 to 3.4 * 1037','C','C#'),(' The Default value of Boolean Data Type is?\n','1005','0','True','False','1','C','C#'),(' What is the Size of ‘Char’ datatype?\n','1005','8 bit','12 bit','16 bit','20 bit','C','C#'),('Which is the String method used to compare two strings with each other?\n','1005',' Compare To()','Compare()','Copy()\r\n','ConCat()','B','C#'),(' Correct statement about strings are?','1005','a string is created on the stack','a string is primitive in nature',' a string created on heap\r\n','created of string on a stack or on a heap depends on the length of the string','C','C#'),('Verbatim string literal is better used for?','1005','Convenience and better readability of strings when string text consist of backlash characters','Used to initialize multi-line strings',' To embed a quotation mark by using double quotation marks inside a verbatim string\r\n','All of the mentioned','D','C#'),(' Why strings are of reference type in C#.NET?\n','1005','To create string on stack','To reduce the size of string','To overcome problem of stackoverflow',' None of the mentioned','B','C#'),('Storage location used by computer memory to store data for usage by an application is?','1005','Pointers',' Constants',' Variable\r\n','None of the mentioned','C','C#'),(' What is the need for ‘Conversion of data type’ in C#?\n','1005','To store a value of one data type into a variable of another data type','To get desired data','To prevent situations of runtime error during change or conversion of data type\r\n',' None of the mentioned','C','C#'),(' Types of ‘Data Conversion’ in C#?','1005','Implicit Conversion',' Explicit Conversion\n',' Implicit Conversion and Explicit Conversion\r\n',' None of the mentioned\r\n','B','C#'),(' ‘Implicit Conversion’ follows the order of conversion as per compatibility of data type as:','1005','float < char < int','char < int < float',' int < char < float\r\n','float < int < char\r\n','B','C#'),(' The subset of ‘int’ data type is __________\n','1005','long, ulong, ushort','long, ulong, uint','long, float, double\r\n',' long, float, ushort','C','C#'),(' Type of Conversion in which compiler is unable to convert the data type implicitly is?\n','1005','ushort to long','int to uint',' ushort to long\r\n','byte to decimal','B','C#'),(' Disadvantages of Explicit Conversion are?\n','1005','Makes program memory heavier','Results in loss of data',' Potentially Unsafe\r\n',' None of the mentioned','B','C#'),(' Correct order of priorities are:\n','1005','‘/’ > ‘%’ > ‘*’ > ‘+’','‘/’ > ‘*’ > ‘%’ > ‘+’',' ‘*’ > ‘/’ > ‘%’ > ‘+’\r\n',' ‘%’ > ‘*’ > ‘/’ > ‘+’','C','C#'),(' Which of the following is/are not Relational operators in C#.NET?\n','1005',' >=','<>=','Not','<=','B','C#'),('What is the maximum possible length of an identifier?\n\n','1006','16','32','64','None of these','D','Python'),('Who developed the Python language?\n\n','1006','Zim Den','Guido van Rossum','Niene Stom','Wick van Rossum','B','Python'),('In which year was the Python language developed?\n\n','1006','1995','1972','1981','1989','D','Python'),('In which language is Python written?','1006','English','PHP','C\r\n','All of the above','B','Python'),(' Which one of the following is the correct extension of the Python file ?','1006','.py','.python','.p\r\n','None of these','A','Python'),('In which year was the Python 3.0 version developed?\n\n','1006','2008','2000','2010\r\n\r\n','2005','A','Python'),(' What do we use to define a block of code in Python language?\n\n','1006','Key','Brackets','Indentation\r\n','None of these','C','Python'),(' Which character is used in Python to make a single line comment?\n\n','1006','  /','  //','  #\r\n','  !','C','Python'),(' Which of the following statements is correct regarding the object-oriented programming concept in Python?\n','1006','Classes are real-world entities while objects are not real','Objects are real-world entities while classes are not real','Both objects and classes are real-world entities\r\n','All of the above','B','Python'),('What is the method inside the class in python language?\n\n','1006','Object','Function','Attribute\r\n','Argument','B','Python'),('Which of the following declarations is incorrect?\n\n','1006','_x = 2','__x = 3','__xyz__ = 5\r\n','None of these','D','Python'),('Why does the name of local variables start with an underscore discouraged?\n\n','1006','To identify the variable','It confuses the interpreter','It indicates a private variable of a class\r\n','None of these','C','Python'),('Which of the following is not a keyword in Python language?\n\n','1006','val','raise','try\r\n','with','A','Python'),('Which of the following statements is correct for variable names in Python language?\n\n','1006','All variable names must begin with an underscore.','Unlimited length','The variable name length is a maximum of 2.\r\n','All of the above','B','Python'),(' Which of the following declarations is incorrect in python language?\n\nx_y_z_p = 5,000,000','1006','xyzp = 5,000,000','x y z p = 5000 6000 7000 8000','x,y,z,p = 5000, 6000, 7000, 8000\r\n','x_y_z_p = 5,000,000','B','Python'),('Which of the following words cannot be a variable in python language?\n\n','1006','_val','val','try\r\n','_try_','C','Python'),('Which of the following operators is the correct option for power(ab)?\n','1006','a ^ b','a**b','a ^ ^ b\r\n','a ^ * b','B','Python'),('Which of the following precedence order is correct in Python?\n','1006','Parentheses, Exponential, Multiplication, Division, Addition, Subtraction','Multiplication, Division, Addition, Subtraction, Parentheses, Exponential','Division, Multiplication, Addition, Subtraction, Parentheses, Exponential\r\n','Exponential, Parentheses, Multiplication, Division, Addition, Subtraction','A','Python'),(' Which one of the following has the same precedence level?\n\n','1006','Division, Power, Multiplication, Addition and Subtraction','Division and Multiplication','Subtraction and Division\r\n','Power and Division','B','Python'),('Which one of the following has the highest precedence in the expression?\n','1006','Division','Subtraction','Power\r\n','Parentheses','D','Python'),(' Which of the following functions is a built-in function in python language?\n\n','1006','val()','print()','println()\r\n','None of these','B','Python'),(' Study the following function:\nround(4.576)  \nWhat will be the output of this function?\n5','1006',' 4',' 6',' 576',' 5','D','Python'),('Study the following function:\nall([2,4,0,6])  \nWhat will be the output of this function?','1006','False','True','0','Invalid code','A','Python'),(' Study the following function:\nany([5>8, 6>3, 3>1])  \nWhat will be the output of this code?','1006','False','Ture','Invalid code\r\n','None of these','B','Python'),(' Study the following statement:\n>>>\"a\"+\"bc\"  \nWhat will be the output of this statement?','1006','a+bc','abc','a bc','a ','B','Python');
/*!40000 ALTER TABLE `questions` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `result`
--

DROP TABLE IF EXISTS `result`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `result` (
  `Tech_code` int NOT NULL,
  `Enrollment_No` int NOT NULL,
  `D_O_E` varchar(15) NOT NULL,
  `Result` int NOT NULL,
  PRIMARY KEY (`Tech_code`,`Enrollment_No`,`Result`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `result`
--

LOCK TABLES `result` WRITE;
/*!40000 ALTER TABLE `result` DISABLE KEYS */;
/*!40000 ALTER TABLE `result` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `technology`
--

DROP TABLE IF EXISTS `technology`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `technology` (
  `Tech_code` int NOT NULL,
  `Tech_name` varchar(40) NOT NULL,
  `N_O_Q` int NOT NULL,
  `Max_marks` int NOT NULL,
  `Pass_marks` int NOT NULL,
  `Duration` int NOT NULL,
  PRIMARY KEY (`Tech_code`)
) ENGINE=MyISAM DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `technology`
--

LOCK TABLES `technology` WRITE;
/*!40000 ALTER TABLE `technology` DISABLE KEYS */;
INSERT INTO `technology` VALUES (1002,'C++',25,50,12,30),(1001,'C',25,50,12,30),(1003,'JAVA',25,50,12,30),(1004,'HTML',25,50,12,30),(1005,'C#',25,50,12,30),(1006,'Python',25,50,12,30);
/*!40000 ALTER TABLE `technology` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2021-03-21 20:42:25
