package CUT;
import java.util.List;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Base account object
 */
public class Account {
	protected double balance;
	private int accountNo;
	protected Lock accLock;
	private Condition accCondition;
	boolean accWaiting = true;

	public Account(int accNo, double bal) {
		this.accountNo = accNo;
		balance = bal;
		accLock = new ReentrantLock();
		accCondition = accLock.newCondition();
	}

	public double getBalance() {
		return balance;
	}

	public void printBalance(List<String> locks, String id) {
		// lock 4
		accLock.lock();
		try {
			locks.add(4 + id);
			System.out.println(Thread.currentThread().getName() + " asked for balance in account " + accountNo);
			System.out.println("Balance is: £"+ balance);
		} finally {
			accLock.unlock();
		}
	}


	public int getAccNumber() {
		return accountNo;
	}

	public void deposit(double put, List<String> locks, String id) {
		System.out.println("Balance Before Deposit: £" + balance);
		//lock 1
		accLock.lock();
		try {
			locks.add(1 + id);
			System.out.println(Thread.currentThread().getName() + " attempting deposit.");
			balance = balance + put;
			System.out.println(Thread.currentThread().getName() + "'s Deposit was successful!");
			System.out.println("Balance is now: £" + balance);
			accWaiting = false;
			accCondition.signalAll();
		} finally {
			accLock.unlock();
		}

	}

	public boolean withdraw(double take, List<String> locks, String id) throws InterruptedException {
		System.out.println(Thread.currentThread().getName() + " is attempting a withdrawal.");
		//lock 2
		accLock.lock();
		try {
			locks.add(2 + id);
			System.out.println("Current Balance: £" + balance);
			balance -= take;
			System.out.println("Withdrawal successful. Balance is now: £" + balance);
			return accWaiting;
		} finally {
			accLock.unlock();
		}
	}

	public void transfer(Account recipient, double transferAmount, List<String> locks, String id) {
		System.out.println(Thread.currentThread().getName() + " is attempting to transfer £" + transferAmount
				+ " into account " + accountNo);
		//lock 3
		accLock.lock();
		try {
			locks.add(3 + id);
			balance = balance - transferAmount;
		} finally {
			accLock.unlock();
		}
		recipient.deposit(transferAmount, locks, id);
		System.out.println("Transfer successful.\nBalance is now: £" + balance + " in account " + accountNo);
		System.out.println("Balance is now: £" + recipient.balance + " in account"
				+ recipient.accountNo);
	}
}
