import static java.lang.System.out;
import static java.lang.Math.abs;
//class Q{
//	//int length;
//	int length(){
//		return 0;
//	}
//}
//Q obj = new Q();
//obj.length()
//obj.length;
final class Validation{
	private Validation(){}
	
	static boolean isValidMobileNumber(String mobileNumber){
//		int x[] = new int[10];
//		System.out.println(x.length);
//		System.out.println(mobileNumber.length());
		if(mobileNumber.length()==10){
		for(int i = 0; i<mobileNumber.length(); i++){
			char singleChar = mobileNumber.charAt(i); // arr[i]
			if(!Character.isDigit(singleChar)){
				return false;
			}
		}
		}
		else{
		return false;
		}
		return true;
	}
	
	static boolean isBlank(String str){
		if(str==null){
			return true;
		}
		if(str!=null && str.trim().length()==0){
			return true;
		}
		return false;
		
	}
}
public class StaticMethodsDemo {

	public static void main(String[] args) {
		abs(-99);
		out.println(Validation.isValidMobileNumber("7878AAQQ")?"Valid ":"Not Valid");
		//Validation v = new Validation();
		String name = "         Amit      Srivastava        ";
		out.println("["+name+"]");
		out.println("["+name.trim()+"]");
		
		String result =Validation.isBlank(name)?"Blank":"Not Blank";
		System.out.println(result);
		
		
		
		
		// TODO Auto-generated method stub

	}

}
