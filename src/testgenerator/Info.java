package testgenerator;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class Info {
	private ArrayList<String> equations;
	private Set<String> locks;
	private ArrayList<String> inputContext;
	private ArrayList<String> outputContext;

	public Info(ArrayList<String> equations, Set<String> locks, ArrayList<String> inputContext, ArrayList<String> outputContext) {
		this.equations = equations;
		this.locks = locks;
		this.inputContext = inputContext;
		this.outputContext = outputContext;
	}	

	public ArrayList<String> getEquations() {
		return equations;
	}

	public Set<String> getLocks() {
		return locks;
	}

	public List<String> getInputContext() {
		return inputContext;
	}

	public List<String> getOutputContext() {
		return outputContext;
	}

}
