package CUT;

import java.util.List;

public class RunnableStandingOrder implements Runnable {

	Account account;
	double withdraw;
	private int standingMax;
	private List<String> locks;
	private String id;

	public RunnableStandingOrder(Account accountIn, double d, int max, List<String> locks, String id) {
		account = accountIn;
		withdraw = d;
		standingMax = max;
		this.id = id;
		this.locks = locks;
	}

	@Override
	public void run() {
		try {
			account.withdrawStanding(withdraw,standingMax, locks, id);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
