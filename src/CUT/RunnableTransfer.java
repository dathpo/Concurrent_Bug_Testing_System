package CUT;

import java.util.List;

public class RunnableTransfer implements Runnable {

	Account host;
	Account recipient;
	double transferAmount;
	private List<String> locks;
	private String id;
	
	public RunnableTransfer(Account host, Account recipient, double transferAmount, List<String> locks, String id)
	{
		this.host = host;
		this.recipient = recipient;
		this.transferAmount = transferAmount;
		this.id = id;
		this.locks = locks;
	}
	
	@Override
	public void run() {
		host.transfer(recipient, transferAmount, locks, id);
	}

}
