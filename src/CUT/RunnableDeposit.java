package CUT;

import java.util.List;

public class RunnableDeposit implements Runnable {

	Account account;
	private double deposit;
	private List<String> locks;
	private String id;

	public RunnableDeposit(Account accountIn, double depositIn, List<String> locks, String id) {
		account = accountIn;
		deposit = depositIn;
		this.id = id;
		this.locks = locks;
	}

	@Override
	public void run() {
		account.deposit(deposit, locks, id);
	}

}
