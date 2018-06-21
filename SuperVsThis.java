class A{
	int x ; // Instance Variable
	A(){
		// super();
		System.out.println("A Default Cons Call");
	}
	A(int x)   {  // Local Variable X
		this();
		this.x = x;  // Instance Variable = Local Variable
 		System.out.println("A Param Cons Call");
	}
}
class B extends A{
	int x;
	B(){
		super(1000);
		System.out.println("B Default Cons call "+(super.x + this.x));
	}
	B(int x){
		this();
		//super(1000);
		
		this.x = x;  // parent x + child x + local x
		int z = super.x + this.x + x;
		System.out.println("B Param Cons Call "+z);
	}
	
}
public class SuperVsThis {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		B obj = new B(99);

	}

}














