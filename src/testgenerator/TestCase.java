package testgenerator;

import java.util.List;
import java.util.Set;

public class TestCase {
	private double id;
	private List<Double> inputs;
	private List<Double> expectedOutputs;
	private Set<String> locks;
	private List<String> inputContext;
	private List<String> outputContext;

	public TestCase (double id, List<Double> inputs, List<Double> expectedOutputs, Set<String> locks, List<String> inputContext, List<String> outputContext) {
		this.id = id;
		this.inputs = inputs;
		this.expectedOutputs = expectedOutputs;
		this.locks = locks;
		this.inputContext = inputContext;
		this.outputContext = outputContext;
	}

	public double getID() {
		return id;
	}

	public List<Double> getInputs() {
		return inputs;
	}

	public List<Double> getExpectedOutputs() {
		return expectedOutputs;
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
