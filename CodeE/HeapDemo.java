import java.util.ArrayList;

class Emp{
	long id ;
	String name;
	double salary;
	Emp(long id , String name, double salary){
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
}
public class HeapDemo {

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
		ArrayList l = new ArrayList();
		System.out.println("Heap Demo Start...");
		long i = 1;
		while(true){
			Emp e = new Emp(i,"Ram"+i,9999);
			Thread.sleep(200);
			l.add(e);
			i++;
		}

	}

}








