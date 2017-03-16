package CUT;

public class RunnableTransfer implements Runnable {

	Account host;
	Account recipient;
	double transferAmount;
	
	public RunnableTransfer(Account host, Account recipient, double transferAmount)
	{
		this.host = host;
		this.recipient = recipient;
		this.transferAmount = transferAmount;
	}
	
	@Override
	public void run() {
		host.transfer(recipient, transferAmount);
	}

}
