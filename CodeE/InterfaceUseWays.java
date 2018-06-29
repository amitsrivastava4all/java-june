// SAM Interface
@FunctionalInterface
interface I{
	int add(int x, int y);
	//int sub(int x, int y);
}
class I2 implements I{

	@Override
	public int add(int x, int y) {
		// TODO Auto-generated method stub
		return x  + y;
	}
	
}
public class InterfaceUseWays {
	static void print2(){
		//I e =(a,b)->a+b;
		I e = (a,b)->{
			System.out.println("A is "+a+" B is "+b);
			return a + b;
		};
		System.out.println("Lambda "+e.add(1000, 2000));
		
	}
	static void print(){
		I e = new I(){
			@Override
			public int add(int x , int y){
				return x + y;
			}
		};
		
		I2 obj =new I2();
		System.out.println("Anonymous Class Result is "+obj.add(100, 200));
	}
	public static void main(String[] args) {
		print();
		print2();
		
		// TODO Auto-generated method stub

	}

}








