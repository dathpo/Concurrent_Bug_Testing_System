package testgenerator;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import CUT.Driver;
//Takes in an instrumented CUT and creates random tests by way of sets of input values.
public class TestGenerator {

	Driver cut;
	Info info;
	List<TestCase> testInputList;
	List<Double> inputs;
	List<Double> expectedOutputs;    
	List<String> equations;
	List<String> locks;
	List<String> names;

	public TestGenerator(Driver cut) {
		this.cut = cut;
		testInputList = new ArrayList<TestCase>();
		analyze();
		generate();

	}
	private void analyze() {
		// TODO Auto-generated method stub
		//cut.instrumentation()
		info = cut.analysis(1);
		equations = info.getEquations();
		locks = info.getLocks();
		names = info.getNames();
	}

	private void generate() {
		inputs = new ArrayList<Double>();
		expectedOutputs = new ArrayList<Double>();
		Random random = new Random(0);
		double input = random.nextInt(100000) + 1;
		inputs.add(input);
		expectedOutputs.add(input);
		expectedOutputs.add(input);

		testInputList.add(new TestCase(0, inputs, null, locks, null, null));
	}

	public List<TestCase> getTests() {
		return testInputList;
	}
}
//Test generator calls () method on the CUT. This returns a list if all methods, the work they do (including all locks), and the inputs they require.
//Generate will output a set of random numbers that is tied to a set of results for each of those numbers.