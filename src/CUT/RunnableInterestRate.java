package CUT;

public class RunnableInterestRate implements Runnable {
	
	SavingsAccount account;
	double interest;
	
	public RunnableInterestRate(SavingsAccount savingsAccount) {
		account = savingsAccount;
	}

	@Override
	public void run() {
		boolean a = true;
		while(a){
		account.addInterest();
		try {
			Thread.currentThread().sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	}

}
