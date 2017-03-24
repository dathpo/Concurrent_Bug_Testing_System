package CUT;

import testgenerator.Info;

import java.util.ArrayList;
import java.util.List;

public class Driver {

	public Driver() {

	}

	public Info analysis(int testNumber) {
		ArrayList<String> equations = new ArrayList<String>();
		ArrayList<String> locks = new ArrayList<String>();
		ArrayList<String> inputContext = new ArrayList<String>();
		ArrayList<String> outputContext = new ArrayList<String>();

		switch(testNumber) {
		case 1:
			equations.add("balance1");
			locks.add("5A"); locks.add("5B");
			inputContext.add("balance1");
			inputContext.add("balance2");
			outputContext.add("account1");
			break;
		case 2:
			equations.add("balance + deposit");
			locks.add("5A"); locks.add("1B");
			inputContext.add("balance"); inputContext.add("deposit");
			outputContext.add("account1");
			break;
		case 3:
			equations.add("balance + deposit - withdraw");
			locks.add("1A"); locks.add("2B");
			inputContext.add("deposit"); inputContext.add("withdraw");
			outputContext.add("account1");
			break;
		case 4:
			equations.add("balance - withdraw - standingOrder");
			locks.add("1A"); locks.add("2B"); locks.add("3C");
			inputContext.add("deposit"); inputContext.add("withdraw"); inputContext.add("standingOrder");
			outputContext.add("account1");
			break;
		case 5:
			equations.add("balance + deposit");
			locks.add("2A"); locks.add("1B");
			inputContext.add("withdraw"); inputContext.add("deposit");
			outputContext.add("account1");
			break;
		case 6:
			equations.add("balance - transfer"); equations.add("balance + transfer");
			locks.add("4A"); locks.add("1A");
			inputContext.add("transfer");
			outputContext.add("account1");  outputContext.add("account2");
		}
		//a list of the equation for each test, eg account balance 1 = input + 100
		//a list of all the lock List<Strings> eg [A1,A2,B1]
		//a list of all names of inputs/outputs, matching up with the input/output
		//lists. eg ["Account 1 Deposit", "Account 2 Withdraw"] ["Account 1 Balance", "Account 2 Balance"]
		return new Info(equations, locks, inputContext, outputContext);
	}

	public ArrayList<Double> test1(double balance) {
		Account account = new Account(1, balance);
		List<String> locks = new ArrayList<>();		
		RunnableCheckBalance cb1 = new RunnableCheckBalance(account, locks, "A");
		RunnableCheckBalance cb2 = new RunnableCheckBalance(account, locks, "B");
		Thread tcb1 = new Thread(cb1);
		Thread tcb2 = new Thread(cb2);
		tcb1.setName("Person 1");
		tcb2.setName("Person 2");
		tcb1.start();
		tcb2.start();
		try {
			tcb1.join();
			tcb2.join();
		}
		catch(InterruptedException ie) {

		}
		ArrayList<Double> balances = new ArrayList<Double>();
		balances.add(account.getBalance());
		return balances;
	}

	public ArrayList<Double> test2(double balance, double deposit) {
		Account account = new Account(1, balance);
		List<String> locks = new ArrayList<>();
		RunnableCheckBalance cb1 = new RunnableCheckBalance(account, locks, "A");
		Thread tcb1 = new Thread(cb1);
		tcb1.setName("Person 1");
		RunnableDeposit dc = new RunnableDeposit(account, deposit, locks, "B");
		Thread tdc = new Thread(dc);
		tdc.setName("Person 1");
		tcb1.start();
		tdc.start();
		try {
			tcb1.join();
			tdc.join();
		}
		catch(InterruptedException ie) {

		}
		ArrayList<Double> balances = new ArrayList<Double>();
		balances.add(account.getBalance());
		return balances;
	}

	public ArrayList<Double> test3(double balance, double deposit, double withdraw) {
		Account account = new Account(1, balance);
		List<String> locks = new ArrayList<>();
		RunnableDeposit dc = new RunnableDeposit(account, deposit, locks, "A");
		RunnableWithdraw wc = new RunnableWithdraw(account, withdraw, locks, "B");
		Thread tdc = new Thread(dc);
		Thread twc = new Thread(wc);
		tdc.setName("Person 1");
		twc.setName("Person 2");
		twc.start();
		tdc.start();
		try {
			tdc.join();
			twc.join();
		}
		catch(InterruptedException ie) {

		}
		ArrayList<Double> balances = new ArrayList<Double>();
		balances.add(account.getBalance());
		return balances;
	}

	public ArrayList<Double> test4(double balance, double deposit, double withdraw, double standingOrder) {
		Account account = new Account(1, 0);
		List<String> locks = new ArrayList<>();
		RunnableDeposit dc = new RunnableDeposit(account, deposit, locks,"A");
		RunnableWithdraw wc = new RunnableWithdraw(account, withdraw, locks, "B");
		RunnableStandingOrder so = new RunnableStandingOrder(account, standingOrder, 1000, locks, "C");
		Thread tdc = new Thread(dc);
		Thread twc = new Thread(wc);
		Thread tso = new Thread(so);
		tdc.setName("Person 1");
		twc.setName("Person 2");
		tso.setName("Bank Employee");
		tdc.start();
		twc.start();
		tso.start();
		try {
			tdc.join();
			twc.join();
			tso.join();
		}
		catch(InterruptedException ie) {

		}
		ArrayList<Double> balances = new ArrayList<Double>();
		balances.add(account.getBalance());
		return balances;
	}

	public ArrayList<Double> test5(double balance, double withdraw, double deposit) {
		Account account = new Account(1, balance);
		List<String> locks = new ArrayList<>();
		RunnableWithdraw wd = new RunnableWithdraw(account, withdraw, locks, "A");
		RunnableDeposit dp = new RunnableDeposit(account, deposit, locks, "B");
		Thread tdp = new Thread(dp);
		Thread twd = new Thread(wd);
		tdp.setName("Person 2");
		twd.setName("Person 1");
		twd.start();
		tdp.start();
		try {
			twd.join();
			tdp.join();
		}
		catch(InterruptedException ie) {

		}
		ArrayList<Double> balances = new ArrayList<Double>();
		balances.add(account.getBalance());
		return balances;
	}

	public ArrayList<Double> test6(double balance1, double balance2, double amount) {
		Account account = new Account(1, balance1);
		Account account2 = new Account(2, balance2);
		List<String> locks = new ArrayList<>();
		RunnableTransfer tr = new RunnableTransfer(account2, account, amount, locks, "A");
		Thread ttr = new Thread(tr);
		ttr.setName("Employee 1");
		ttr.start();
		try {
			ttr.join();
		}
		catch(InterruptedException ie) {

		}
		ArrayList<Double> balances = new ArrayList<Double>();
		balances.add(account.getBalance());
		balances.add(account2.getBalance());
		return balances;
	}
}
