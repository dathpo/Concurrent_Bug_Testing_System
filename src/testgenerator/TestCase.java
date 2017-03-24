package testgenerator;

import java.util.List;

public class TestCase {
	private double id;
	private List<Double> inputs;
	private List<Double> expectedOutputs;
	private List<String> locks;
	private List<String> inputContext;
	private List<String> outputContext;

	public TestCase (double id, List<Double> inputs, List<Double> expectedOutputs, List<String> locks, List<String> inputContext, List<String> outputContext) {
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

	public List<String> getLocks() {
		return locks;
	}

	public List<String> getInputContext() {
		return inputContext;
	}

	public List<String> getOutputContext() {
		return outputContext;
	}
}
