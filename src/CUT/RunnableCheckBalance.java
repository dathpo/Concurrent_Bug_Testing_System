package CUT;

public class RunnableCheckBalance implements Runnable {

	Account account;

	public RunnableCheckBalance(Account accountIn) {
		account = accountIn;
	}

	@Override
	public void run() {
		account.getBalance();
	}

}
