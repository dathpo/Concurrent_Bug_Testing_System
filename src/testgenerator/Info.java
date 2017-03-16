package testgenerator;

import java.util.ArrayList;

public class Info {
	//a list of the equation for each test, eg account balance 1 = input + 100
	//a list of all the lock List<Strings> eg [A1,A2,B1]
	//a list of all names of inputs/outputs, matching up with the input/output
	//lists. eg ["Account 1 Deposit", "Account 2 Withdraw"] ["Account 1 Balance", "Account 2 Balance"]

	private ArrayList<String> equations;
	private ArrayList<String> locks;
	private ArrayList<String> names;	

	public Info(ArrayList<String> equations, ArrayList<String> locks, ArrayList<String> names) {
		this.equations = equations;
		this.locks = locks;
		this.names = names;		
	}	

	public ArrayList<String> getEquations() {
		return equations;
	}

	public ArrayList<String> getLocks() {
		return locks;
	}

	public ArrayList<String> getNames() {
		return names;
	}

}
