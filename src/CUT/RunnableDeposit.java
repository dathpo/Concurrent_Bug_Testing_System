package CUT;

public class RunnableDeposit implements Runnable {

	Account account;
	private double deposit;

	public RunnableDeposit(Account accountIn, double depositIn) {
		account = accountIn;
		deposit = depositIn;
	}

	@Override
	public void run() {
		account.deposit(deposit);
	}

}
