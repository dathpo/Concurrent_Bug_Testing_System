package testgenerator;

import java.util.ArrayList;
import java.util.List;

public class Info {
	//a list of the equation for each test, eg account balance 1 = input + 100
	//a list of all the lock List<Strings> eg [A1,A2,B1]
	//a list of all names of inputs/outputs, matching up with the input/output
	//lists. eg ["Account 1 Deposit", "Account 2 Withdraw"] ["Account 1 Balance", "Account 2 Balance"]

	private ArrayList<String> equations;
	private ArrayList<String> locks;
	private ArrayList<String> inputContext;
	private ArrayList<String> outputContext;

	public Info(ArrayList<String> equations, ArrayList<String> locks, ArrayList<String> inputContext, ArrayList<String> outputContext) {
		this.equations = equations;
		this.locks = locks;
		this.inputContext = inputContext;
		this.outputContext = outputContext;
	}	

	public ArrayList<String> getEquations() {
		return equations;
	}

	public ArrayList<String> getLocks() {
		return locks;
	}

	public List<String> getInputContext() {
		return inputContext;
	}

	public List<String> getOutputContext() {
		return outputContext;
	}

}
