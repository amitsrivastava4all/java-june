import java.sql.SQLException;
import java.util.ArrayList;

class Student {
	int id ;
	String name;
	String address;
	Student(){
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

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		// TODO Auto-generated method stub'
		int x[] = {10,20,30,40};
//		LinkedList<String> l = new LinkedList<String>();
//		//l.add(10);
//		l.add("Amit");
		Student ram = new Student();
		ArrayList<String> list = new ArrayList<>();
		list.add("ram");
		list.add("ramesh");
		list.add("shyam");
		System.out.println(list.toString());
		System.out.println(ram.toString());
		
		
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
