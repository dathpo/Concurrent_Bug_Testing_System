package CUT;

import java.util.List;

public class RunnableWithdraw implements Runnable {

	Account account;
	private double withdraw;
	private String id;
	private List<String> locks;

	public RunnableWithdraw(Account accountIn, double withdrawIn, List<String> locks, String id) {
		account = accountIn;
		withdraw = withdrawIn;
		this.id = id; 
		this.locks = locks;
	}

	@Override
	public void run() {
		try{
			account.withdraw(withdraw, locks, id);
		} catch(InterruptedException e){
			System.out.println("Error. Interrupted");
			e.printStackTrace();
		}
	}
}

