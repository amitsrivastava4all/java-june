class T{
	private int salary;
	
	public int getSalary() {
		return salary;
	}
	@Deprecated
	public void setSalary(int salary) {
		this.salary = salary;
	}

	T(int salary){
		if(salary>0){
		this.salary = salary;
		System.out.println("Salary Taken "+this.salary);
		}
		else{
			System.out.println("Invalid Salary");
		}
	}
}
public class SetterGetterDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int exp = 10;
		T obj  = new T(11199);
		if(exp>=10){
			obj.setSalary(20000);
			System.out.println(obj.getSalary());
		}
		
	}

}
