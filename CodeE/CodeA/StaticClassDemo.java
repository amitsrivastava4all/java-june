// Composition
class A{
	private int x;
	private class D{
		
	}
	static class B{
		static void print(){
			System.out.println("B Print...");
		}
	}
}
class ITStudent{
	int x = 20;
	ITStudent(){
		System.out.println("IT Student...");
		//ITCourse course = new ITCourse();
	}
	class Course{
		int x = 30;
	}
	
	class ITCourse extends Course{
		int x = 10;
		void show(){
			class SpecialCourse{
				SpecialCourse(){
					System.out.println("Special Course Cons");
				}
			}
			SpecialCourse s = new SpecialCourse();
			int z = ITStudent.this.x + this.x + super.x;
			System.out.println("IT Course Show.. "+z);
		}
		
		ITCourse(){
			System.out.println("IT Course...");
		}
	}
}
class Student
{
	Course course;
	Student(Course course){
		System.out.println("Student .....");
		this.course = course;
	}
	public void finalize(){
		System.out.println("Student Bye Bye...");
	}
	Student(){
		
		System.out.println("Student...");
		//course = new Course();
	}
}
class Course{
	public void finalize(){
		System.out.println("Course Bye Bye...");
	}
	Course(){
		System.out.println("Course ....");
	}
}


class Employee{
	class Dept{
		
	}
	class Cab{
		
	}
	class Account{
		
	}
}
class Insurance{
	
}
public class StaticClassDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//ITStudent s = new ITStudent();
		//ITStudent.ITCourse c =  s.new ITCourse();
		A.B.print();
		ITStudent.ITCourse x = new ITStudent().new ITCourse();
		x.show();
		//ITStudent s = new ITStudent();
//		Course course = new Course();
//		Student student = new Student(course);
//		student = null;
//		System.gc();
//		for(int i = 1; i<=10; i++){
//			System.out.println("I is "+i);
//		}

	}

}
