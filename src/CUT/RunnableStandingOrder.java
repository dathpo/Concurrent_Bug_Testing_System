package CUT;

public class RunnableStandingOrder implements Runnable {

	Account account;
	double withdraw;
	private int standingMax;

	public RunnableStandingOrder(Account accountIn, double d, int max) {
		account = accountIn;
		withdraw = d;
		standingMax = max;
	}

	@Override
	public void run() {
		try {
			account.withdrawStanding(withdraw,standingMax);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
