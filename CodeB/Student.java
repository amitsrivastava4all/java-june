class Student{
private int rollno;  // private member variables
private String name;
private String phone;
private String course;
private double fees;
private String collegeName;
Student(){
collegeName = "SRCC";
}
Student(int rollno , String name, String phone, String course, double fees){
this(); // Call to the default constructor
this.rollno = rollno + collegeName.length();
this.name = name;
this.phone = phone;
this.course = course;
this.fees = fees;

}
// r, n, p these all called local variables
// scope is with in the function.
public void takeInput(int rollno, String name, String phone , String course , double fees){
//this();
this.rollno = rollno;   // Member Variable Assign Local Variable
this.name = name;
this.phone = phone;
this.course = course;
this.fees =fees;
}
public void print(){
// this
System.out.println("*** Rollno is "+this.rollno);
System.out.println("*** Name is "+name);
System.out.println("*** Phone is "+phone);
System.out.println("*** Course is "+course);
System.out.println("*** Fees is "+fees);
System.out.println("*** CollegeName is "+collegeName);


}
public String getPhone(){
return phone;
}
// Setter
public void setPhone(String phone){
if(phone.equals("420")){
System.out.println("Invalid Phone No ");
return ;
}
this.phone = phone;
}

// public member methods
public static void main(String args[]){
Student ram = new Student();  //x = 10
ram = new Student(1001,"Ram","2222","java",5555); //x=20
//ram.takeInput(1001,"Ram","java","2222",5555);
ram.print();
ram.setPhone("420");
System.out.println("Ram Phone is "+ram.getPhone());
System.out.println("***************************************");
Student shyam = new Student();
shyam.print();
/*
System.out.println("Rollno "+ram.rollno);
System.out.println("Name "+ram.name);
System.out.println("Course "+ram.course);
System.out.println("phone "+ram.phone);
System.out.println("fees "+ram.fees);
*/
/*
ram.rollno = -1001;
ram.name = "Ram Kumar";
ram.course = "B.TECH";
ram.phone = "11222";
ram.fees = -1000.0;
*/
//System.out.println("***************************************");
/*
System.out.println("Rollno "+ram.rollno);
System.out.println("Name "+ram.name);
System.out.println("Course "+ram.course);
System.out.println("phone "+ram.phone);
System.out.println("fees "+ram.fees);
*/
//Student shyam = new Student();
//int x;
}
}