//final class Q{

class Q{
	private final void show(){
		System.out.println("Q show...");
	}
	void print(){
		System.out.println("Q Print...");
	}
	
}
class T extends Q{
	//@Override
	void show(){
		System.out.println("I Override show...");
	}
	@Override
	void print(){
		System.out.println("Override print..");
	}
	
}
 class FinalA{
	private final int MAX ;  
	FinalA(){
		MAX =100;
	}
	void show(){
		final int Q = 100;
		//MAX = 200;
		System.out.println("Inside Show "+MAX);
	}
}
public class UseOfFinalDemo {

	public static void main(String[] args) {
		FinalA e = new FinalA();
		FinalA e2 = new FinalA();
//		e.show();
//		e.show();
//		e.show();
		
		final double PI = 3.14;
		//PI = 22.11;
		//PI++;
		//String w ;
		//Math m;
		//System 
		
		// TODO Auto-generated method stub

	}

}







