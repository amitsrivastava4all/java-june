class Loan{
	void applyForLoan(){
		System.out.println("Apply For Loan");
	}
	void score(){
		System.out.println("Score Compute");
	}
	void emi(){
		System.out.println("EMI For 12 Months");
	}
}
class HomeLoan extends Loan
{
	@Override
	void emi(){
		System.out.println("Home Loan EMI For Long Period");
	}
	void lessRisk(){
		System.out.println("Sell Property for High Returns...");
	}
}
class AutoLoan extends Loan{
	@Override
	void emi(){
		System.out.println("Auto Loan EMI For Less Period");
	}
	void highRisk(){
		System.out.println("Low Value of Cars So More Risk");
	}
}
class LoanCaller{
	// Upcasting
	void callMe(Loan loan){
		double x = 90.20;
		int y = (int)x;
		loan.applyForLoan();
		loan.score();
		loan.emi();
		if(loan instanceof HomeLoan){
			double w = 90.20;
			//int w1 = (int) w;
			HomeLoan homeLoan = (HomeLoan)loan;  // Downcasting
			homeLoan.lessRisk();
		}
		else
		if(loan instanceof AutoLoan){	
			AutoLoan autoLoan = (AutoLoan) loan; // Downcasting
			autoLoan.highRisk();
		}
	}
}
public class LoanDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LoanCaller loanCaller = new LoanCaller();
		loanCaller.callMe(new HomeLoan());
		loanCaller.callMe(new AutoLoan());
//		Loan homeLoan = new HomeLoan(); //Upcasting
//		//HomeLoan homeLoan = new HomeLoan();
//		homeLoan.applyForLoan();
//		homeLoan.score();
//		homeLoan.emi();
//		HomeLoan  obj2 =  (HomeLoan)homeLoan; //Downcasting
//		obj2.lessRisk();
//		//homeLoan.lessRisk();
////		// TODO Auto-generated method stub
////				AutoLoan autoLoan = new AutoLoan();
////				autoLoan.applyForLoan();
////				autoLoan.score();
////				autoLoan.emi();
////				autoLoan.highRisk();


	}

}









