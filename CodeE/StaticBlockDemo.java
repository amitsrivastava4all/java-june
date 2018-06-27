class T1 extends Object{
	int ee;
	static T1 e ;
	@Override
	public void finalize(){
		//super.finalize();
		e = this;
		System.out.println("I will call when object is ready to end..."+this);
	}
	static int n;
	{
		System.out.println("Init Block");
	}
	{
		System.out.println("Init Block2");
	}
	static String collectCollegeInfoFromDB(){
		// Talk to DB
		return "SRCC Delhi";
	}
	static{
		//collectCollegeInfoFromDB();
		n = 100;
		System.out.println("I Will Call When Class is Loaded "+n+" "+collectCollegeInfoFromDB());
	}
	static{
		System.out.println("Static Block2");
	}
	int m;  // Instance Var
	T1(){
		m= 100;
		System.out.println("I Will call when Object is Created "+m);
	}
}
public class StaticBlockDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		T1 obj = new T1();
		System.out.println(obj.m);
		obj = null;
		
		System.gc();
		for(int i = 1; i<=10; i++){
			System.out.println("I is "+i);
		}
		
		//T1 obj2 = new T1();
		//T1 obj3 = new T1();
		if(T1.e!=null){
		obj = T1.e;
		System.out.println("ReBorn "+obj.m);
		}
		}

}








