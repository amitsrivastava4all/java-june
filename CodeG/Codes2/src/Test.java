import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.sql.SQLException;
import java.util.Scanner;
class A{
	static{
		System.out.println("A Class Loaded..");
	}
	A(){
		System.out.println("A Class Cons call");
	}
	void setVisible(){
	System.out.println("A Visible");	
	}
}
class B{
	void setVisible(){
		System.out.println("B Visible");	
		}
	B(){
		System.out.println("B Class cons call");
	}
	static{
		System.out.println("B Class Loaded..");
	}
}

class Student {
	void setVisible(){
		System.out.println("Student Visible");	
		}
	int id ;
	String name;
	String address;
	static{
		System.out.println("Student Class Loaded...");
	}
	Student(){
		System.out.println("Student Cons Call");
		id = 1001;
		name = "Ram";
		address= "Delhi";
	}
	@Override
	public int hashCode(){
		return 10;
	}
	@Override
	public String toString() {
		return "Student [id=" + id + ", name=" + name + ", address=" + address + "]";
	}
	
}
public class Test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException, InstantiationException, IllegalAccessException, NoSuchMethodException, SecurityException, IllegalArgumentException, InvocationTargetException {
		// TODO Auto-generated method stub'
		//DD dd = new DD();
		Scanner s = new Scanner(System.in);
		System.out.println("Enter the CLass to Load...");
		String className = s.next();
		Object object = Class.forName(className).newInstance();
		Method method = object.getClass().getDeclaredMethod("setVisible", null);
		method.invoke(object, null);
//		if(className.equals("A")){
//			A obj = new A();
//			
//			//==
//		}
		
//		int x[] = {10,20,30,40};
////		LinkedList<String> l = new LinkedList<String>();
////		//l.add(10);
////		l.add("Amit");
//		Student ram = new Student();
//		ArrayList<String> list = new ArrayList<>();
//		list.add("ram");
//		list.add("ramesh");
//		list.add("shyam");
//		System.out.println(list.toString());
//		System.out.println(ram.toString());
		
		
//		String path = "/Users/amit/Documents/CoreJavaJuneBatch"
//				+ "/TestEngine/src/com/brainmentors/testengine"
//				+ "/question/helper/QuestionUploadHelper.java";
//		int index = path.lastIndexOf("/");
//		System.out.println(index);
//		path = path.substring(index+1);
//		System.out.println("Path is "+path);
		
		/*
		Class.forName("org.postgresql.Driver");
		System.out.println("Driver is Loaded.");
		// jdbc:postgresql://hostname:port/dbname
		Connection con = DriverManager.getConnection("jdbc:postgresql://localhost:5432/test","amit","amit123");
		System.out.println("Connection Created");*/
		

	}

}
