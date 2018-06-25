package com.brainmentors.quiz.student;
import java.util.Scanner;

//import java.lang.*;
import com.brainmentors.quiz.course.CourseDetails;

//abstract class A{
//	private A(){
//		
//	}
//	A(int x){
//		this();
//	}
//}
//class B extends A{
//	B(){
//		super(100);
//	}
//}


public class Login {
public static void main(String[] args) {
	
	String words = "Hello How are You Iam Fine\n nhjgdjgfjkfd \n gfhtfyhtfhfghf";
	Scanner q = new Scanner(words);
	int count = 0;
	while(q.hasNextLine()){
		System.out.println(q.nextLine());
		count++;
	}
	System.out.println("Count is "+count);
	
//	Scanner s = new Scanner(System.in);
//	
//	System.out.println("Enter the Duration of the Course");
//	int courseDur = s.nextInt();
//	System.out.println("Enter the Course Name");
//	//String course = s.next();
//	s.nextLine();
//	String course = s.nextLine();
//	System.out.println("Course is "+course);
//	System.out.println("Course Dur is "+courseDur);
//	s.close();
	Scanner w = new Scanner(System.in);
	System.out.println("Enter the Teacher Name");
	String teacherName =  w.next();
	System.out.println("Teacher Name is "+teacherName);
	//Scanner s  = new Scanner(System.in);
	//System s = new System();
	//System.in;
	CourseDetails courseDetails = new CourseDetails();
	System.out.println(courseDetails.getName());
}
}
