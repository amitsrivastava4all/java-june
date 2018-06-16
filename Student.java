class Student{
int rollno;
String name;
String phone;
String course;
double fees;
public static void main(String args[]){
Student ram = new Student();
System.out.println("Rollno "+ram.rollno);
System.out.println("Name "+ram.name);
System.out.println("Course "+ram.course);
System.out.println("phone "+ram.phone);
System.out.println("fees "+ram.fees);
ram.rollno = -1001;
ram.name = "Ram Kumar";
ram.course = "B.TECH";
ram.phone = "11222";
ram.fees = -1000.0;
System.out.println("***************************************");
System.out.println("Rollno "+ram.rollno);
System.out.println("Name "+ram.name);
System.out.println("Course "+ram.course);
System.out.println("phone "+ram.phone);
System.out.println("fees "+ram.fees);
//Student shyam = new Student();
//int x;
}
}