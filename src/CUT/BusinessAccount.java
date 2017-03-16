package CUT;

public class BusinessAccount extends SavingsAccount {

	private static double minimum;

	public BusinessAccount(int acc, double bal, double interest, double minBal) {
		super(acc, bal, interest);
		minimum = minBal;
	}

	/*public void setMinBalance(double minBal) {
		minimum = minBal;
	}*/

	/*public double getMinBalance() {
		return minimum;
	}*/
	
	@Override
	public boolean withdraw(double take) throws InterruptedException {
		if(balance - take >= minimum){
		return super.withdraw(take);
		} else {
			System.out.println("Withdraw failed. Cannot go below minimum amount");
			return false;
		}
	}

}
