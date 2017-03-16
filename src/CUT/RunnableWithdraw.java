package CUT;

public class RunnableWithdraw implements Runnable {

	Account account;
	private double withdraw;

	public RunnableWithdraw(Account accountIn, double withdrawIn) {
		account = accountIn;
		withdraw = withdrawIn;
	}

	@Override
	public void run() {
		try{
			account.withdraw(withdraw);
		} catch(InterruptedException e){
			System.out.println("Error. Interrupted");
			e.printStackTrace();
		}
	}
}

