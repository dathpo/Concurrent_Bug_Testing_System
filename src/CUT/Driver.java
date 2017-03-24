package CUT;

import testgenerator.Info;
import testrunner.Handler;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Driver {

	public Driver() {

	}

	public Info analysis(int testNumber) {
		ArrayList<String> equations = new ArrayList<String>();
		Set<String> lockPairs = new HashSet<String>();
		ArrayList<String> inputContext = new ArrayList<String>();
		ArrayList<String> outputContext = new ArrayList<String>();
		
		lockPairs.add("4A 4B");
		lockPairs.add("4B 4A");
		lockPairs.add("4C 1D");
		lockPairs.add("1D 4C");
		lockPairs.add("1E 2F");
		lockPairs.add("2F 1E");
		lockPairs.add("2G 1H");
		lockPairs.add("1H 2G");
		lockPairs.add("3I 1I");
		
		switch(testNumber) {
		case 1:
			equations.add("one");
			inputContext.add("balance1");
			outputContext.add("account1");
			break;
		case 2:
			equations.add("one + two");
			inputContext.add("balance1"); inputContext.add("deposit");
			outputContext.add("account1");
			break;
		case 3:
			equations.add("one + two - three");
			inputContext.add("balance1"); inputContext.add("deposit"); inputContext.add("withdraw");
			outputContext.add("account1");
			break;
		case 4:
			equations.add("0 + one - two");
			inputContext.add("deposit"); inputContext.add("withdraw");
			outputContext.add("account1");
			break;
		case 5:
			equations.add("one - three"); equations.add("two + three");
			inputContext.add("balance1"); inputContext.add("balance2"); inputContext.add("transfer");
			outputContext.add("account1"); outputContext.add("account2");
		}
		return new Info(equations, lockPairs, inputContext, outputContext);
	}

	public Handler test1(double balance) {
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
		List<String> lockPairs = new ArrayList<>();
		for (int i = 0; i < locks.size() - 1; i++) {
			lockPairs.add(locks.get(i) + " " + locks.get(i + 1));
		}
		return new Handler(balances, lockPairs);
	}

	public Handler test2(double balance, double deposit) {
		Account account = new Account(1, balance);
		List<String> locks = new ArrayList<>();
		RunnableCheckBalance cb1 = new RunnableCheckBalance(account, locks, "C");
		Thread tcb1 = new Thread(cb1);
		tcb1.setName("Person 1");
		RunnableDeposit dc = new RunnableDeposit(account, deposit, locks, "D");
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
		balances.add(account.getBalance());List<String> lockPairs = new ArrayList<>();
		for (int i = 0; i < locks.size() - 1; i++) {
			lockPairs.add(locks.get(i) + " " + locks.get(i + 1));
		}
		return new Handler(balances, lockPairs);
	}

	public Handler test3(double balance, double deposit, double withdraw) {
		Account account = new Account(1, balance);
		List<String> locks = new ArrayList<>();
		RunnableDeposit dc = new RunnableDeposit(account, deposit, locks, "E");
		RunnableWithdraw wc = new RunnableWithdraw(account, withdraw, locks, "F");
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
		List<String> lockPairs = new ArrayList<>();
		for (int i = 0; i < locks.size() - 1; i++) {
			lockPairs.add(locks.get(i) + " " + locks.get(i + 1));
		}
		return new Handler(balances, lockPairs);
	}

	public Handler test4(double deposit, double withdraw) {
		Account account = new Account(1, 0);
		List<String> locks = new ArrayList<>();
		RunnableWithdraw wd = new RunnableWithdraw(account, withdraw, locks, "G");
		RunnableDeposit dp = new RunnableDeposit(account, deposit, locks, "H");
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
		List<String> lockPairs = new ArrayList<>();
		for (int i = 0; i < locks.size() - 1; i++) {
			lockPairs.add(locks.get(i) + " " + locks.get(i + 1));
		}
		return new Handler(balances, lockPairs);
	}

	public Handler test5(double balance1, double balance2, double amount) {
		Account account = new Account(1, balance1);
		Account account2 = new Account(2, balance2);
		List<String> locks = new ArrayList<>();
		RunnableTransfer tr = new RunnableTransfer(account, account2, amount, locks, "I");
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
		List<String> lockPairs = new ArrayList<>();
		for (int i = 0; i < locks.size() - 1; i++) {
			lockPairs.add(locks.get(i) + " " + locks.get(i + 1));
		}
		return new Handler(balances, lockPairs);
	}
}
