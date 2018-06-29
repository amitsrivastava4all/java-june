import java.util.Scanner;

class A1{
	int x = 100;
	void show(){
		System.out.println("A1 Show...");
	}
}
class B1 extends A1{
	int x = 200;
	@Override
	void show(){
		System.out.println("B1 Show...");
	}
}

class X1
{
	int x;
	X1(){
		x = 100;
	}
}
class X2 extends X1{
	int x;
	X2(){
		x = 200;
	}
}
class X3 extends X2{
	int x ;
	X3(){
		x = 300;
		int z  = ((X1)this).x + ((X2)this).x + this.x;
		System.out.println("Z is "+z);
	}
}

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		A1 obj = new B1();
		obj.show();
		System.out.println(obj.x);
		//X3 obj = new X3();
//		Scanner s = new Scanner(System.in);
//		System.out.println("Enter the Id");
//		int id = s.nextInt();  // 1000\n
//		System.out.println("Enter the Name");
//		s.nextLine();
//		String name  = s.nextLine();
//		System.out.println("Id "+id+" name "+name);
//		s.close();

	}

}
