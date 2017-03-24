package CUT;

import java.util.List;

public class RunnableCheckBalance implements Runnable {

	Account account;
	private List<String> locks;
	private String id;
	
	public RunnableCheckBalance(Account accountIn, List<String> locks, String id) {
		account = accountIn;
		this.id = id;
		this.locks = locks;
	}

	@Override
	public void run() {
		account.printBalance(locks, id);
	}

}
