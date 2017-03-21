package CUT;

import java.util.ArrayList;

import testgenerator.Info;

public class Driver {

	public Driver() {

	}

	public Info analysis(int testNumber) {
		ArrayList<String> equations = new ArrayList<String>();
		ArrayList<String> locks = new ArrayList<String>();
		ArrayList<String> names = new ArrayList<String>();

		/*
		Account account = new Account(1, 0);
		Account account2 = new Account(2, 100);
		RunnableTransfer tr = new RunnableTransfer(account2, account, 100.00);
		Thread ttr = new Thread(tr);
		ttr.setName("Employee 1");
		ttr.start();
		 */
		switch(testNumber) {
		case 1: names.add("balance"); names.add("balance");
		break;
		case 2: locks.add("A1"); names.add("balance"); names.add("depostit1");
		break;
		case 3: locks.add("A1"); locks.add("B2"); names.add("deposit"); names.add("withdraw");
		break;
		case 4: locks.add("A1"); locks.add("B2"); locks.add("C3"); names.add("deposit"); names.add("withdraw"); names.add("standingOrder");
		break;
		case 5: locks.add("A2"); locks.add("B1"); names.add("withdraw"); names.add("deposit");
		break;
		case 6: locks.add("A4"); names.add("transfer");
		}
		//a list of the equation for each test, eg account balance 1 = input + 100
		//a list of all the lock List<Strings> eg [A1,A2,B1]
		//a list of all names of inputs/outputs, matching up with the input/output
		//lists. eg ["Account 1 Deposit", "Account 2 Withdraw"] ["Account 1 Balance", "Account 2 Balance"]
		return new Info(equations, locks, names);
	}

	public void test1() {
		Account account = new Account(1, 500.00);
		RunnableCheckBalance cb1 = new RunnableCheckBalance(account);
		Thread tcb1 = new Thread(cb1);
		Thread tcb2 = new Thread(cb1);
		tcb1.setName("Person 1");
		tcb2.setName("Person 2");
		tcb1.start();
		tcb2.start();
	}

	public void test2() {
		Account account = new Account(1, 0);
		RunnableCheckBalance cb1 = new RunnableCheckBalance(account);
		Thread tcb1 = new Thread(cb1);
		tcb1.setName("Person 1");
		RunnableDeposit dc = new RunnableDeposit(account, 100.00);
		Thread tdc = new Thread(dc);
		tdc.setName("Person 1");
		tcb1.start();
		tdc.start();
	}

	public void test3() {
		Account account = new Account(1, 10.00);
		RunnableDeposit dc = new RunnableDeposit(account, 100.00);
		RunnableWithdraw wc = new RunnableWithdraw(account, 50.00);
		Thread tdc = new Thread(dc);
		Thread twc = new Thread(wc);
		tdc.setName("Person 1");
		twc.setName("Person 2");
		twc.start();
		tdc.start();
	}

	public void test4() {
		Account account = new Account(1, 0);
		RunnableDeposit dc = new RunnableDeposit(account, 100.00);
		RunnableWithdraw wc = new RunnableWithdraw(account, 50.00);
		RunnableStandingOrder so = new RunnableStandingOrder(account, 50.00, 1000);
		Thread tdc = new Thread(dc);
		Thread twc = new Thread(wc);
		Thread tso = new Thread(so);
		tdc.setName("Person 1");
		twc.setName("Person 2");
		tso.setName("Bank Employee");
		tdc.start();
		twc.start();
		tso.start();
	}

	public void test5() {
		Account account = new Account(1, 0);
		RunnableWithdraw wd = new RunnableWithdraw(account, 50.00);
		RunnableDeposit dp = new RunnableDeposit(account, 40.00);
		Thread tdp = new Thread(dp);
		Thread twd = new Thread(wd);
		tdp.setName("Person 2");
		twd.setName("Person 1");
		twd.start();
		tdp.start();
	}

	public void test6() {
		Account account = new Account(1, 0);
		Account account2 = new Account(2, 100);
		RunnableTransfer tr = new RunnableTransfer(account2, account, 100.00);
		Thread ttr = new Thread(tr);
		ttr.setName("Employee 1");
		ttr.start();

	}

	public void test7() {
		SavingsAccount savingsAccount = new SavingsAccount(1,100,05);

	}

	public void test8() {
		BusinessAccount businessAccount = new BusinessAccount(1,100,00.01,50);
		RunnableWithdraw wd = new RunnableWithdraw(businessAccount, 100.00);
		Thread twd = new Thread(wd);
		twd.setName("Business Man");
		twd.start();
	}
}
