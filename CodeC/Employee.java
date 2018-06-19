
public class Employee {
	private int id;
	private String name;
	private double salary;
	private String companyName;
	public void printSalarySlip(){
		System.out.println("Id "+id);
		System.out.println("Name "+name);
		System.out.println("Salary "+salary);
		System.out.println("Hra "+hra());
		System.out.println("Da "+da());
		System.out.println("Ta "+ta());
		System.out.println("PF "+pf());
		System.out.println("GS "+gs());
		System.out.println("NS "+ns());
	}
	double ns(){
		return gs() - tax();
	}
	double tax(){
		double grossSalary = gs();
		if(grossSalary<=300000 && grossSalary>=200000 ){
			return 0.10;
		}
		else
		if(grossSalary>300000 && grossSalary<=500000){
			return 0.20;
		}
		else
		if(grossSalary>500000 ){
			return 0.30;
		}
		return 0.0;
	}
	double gs(){
		return salary + hra() + da() + ta() - pf();
	}
	double pf(){
		return salary * 0.05;
	}
	double ta(){
		return salary * 0.10;
	}
	double hra(){
		return salary * 0.30;
	}
	double da(){
	return salary * 0.20;
	}
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getCompanyName() {
		return companyName;
	}
	public void setCompanyName(String companyName) {
		this.companyName = companyName;
	}
	Employee(int id, String name, double salary){
		this();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	Employee(){
		companyName = "TCS";
		
	}

}
