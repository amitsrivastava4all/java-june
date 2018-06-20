class Account{
	int id;
	String name;
	double balance;
	/*Account(){
		balance = 1000;
		System.out.println("Account Class Default Cons Call");
	}*/
	Account(double balance){
		this.balance = balance;
		System.out.println("Account Class Param Cons Call");
	}
	void roi(){
		System.out.println("Generic ROI 3%");
	}
	void withDraw(){
		System.out.println("Account WithDraw...");
	}
	void deposit(){
		System.out.println("Account Deposit...");
	}
	
}
class SavingAccount extends Account {
	SavingAccount(){
		super(3000);
		System.out.println("saving account default cons ");
	}
	//@Override
	void limit(){
		System.out.println("WithDraw with Limit");
	}
}
class CurrentAccount extends Account{
	CurrentAccount(){
		super(2000);
		// super(); Parent Default Cons call (Implicit Super call
		System.out.println("Current Account default cons call");
	}
	void roi(int x){
		System.out.println("ROI Overloading...");
	}
	@Override
	void roi(){
		super.roi();
		double i = balance * 0.06;
		System.out.println("U Pay ROI 6% "+i);
	}
void odLimit(){
	System.out.println("Can WithDraw Beyond...");	
	}
	
}
public class ISADemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int x;
		SavingAccount savingAccount  = new SavingAccount() ;
		savingAccount.deposit();
		savingAccount.withDraw();
		savingAccount.limit();
		savingAccount.roi();
		System.out.println("*********************************");
		CurrentAccount ca = new CurrentAccount();
		ca.withDraw();
		ca.deposit();
		ca.odLimit();
		ca.roi();
		ca.roi(100);

	}

}











