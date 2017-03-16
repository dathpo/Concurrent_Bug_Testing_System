package CUT;
import java.text.DecimalFormat;

public class SavingsAccount extends Account {

	private static double intRate;
	
	public SavingsAccount(int acc, double bal, double interest){
		super(acc, bal);
		intRate = interest;
		RunnableInterestRate ir = new RunnableInterestRate(this);
		Thread irt = new Thread(ir);
		irt.setName("Self");
		irt.start();
	}
	
	/*public void setRate(double newRate){
		intRate = newRate;
	}*/
	
	/*public double getRate(){
		return intRate;
	}*/
	
	public void addInterest(){
		DecimalFormat numberFormat = new DecimalFormat("#.00");
		accLock.lock();
		try{
			balance = balance + balance*(intRate/100);
		} finally {
			accLock.unlock();
		}
		System.out.println("Interest added. New account balance = £"+numberFormat.format(balance));
	}
}
