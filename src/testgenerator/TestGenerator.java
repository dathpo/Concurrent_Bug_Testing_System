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
		for(int i = 0; i < 6; i++) {
			analyze(i);
			generate(i);
		}
	}
	private void analyze(int index) {
		// TODO Auto-generated method stub
		//cut.instrumentation()		
		info = cut.analysis(index);
		equations = info.getEquations();
		locks = info.getLocks();
		names = info.getNames();		
	}

	public void generate(int index) {
		inputs = new ArrayList<Double>();
		expectedOutputs = new ArrayList<Double>();
		Random random = new Random(0);
		double balance = random.nextInt(100000) + 1;
		inputs.add(balance);

		for(String n: info.getNames()) {
			if(n == "balance") {				
				expectedOutputs.add(balance);
			}
			if(n == "deposit") {
				double deposit = random.nextInt(100000) + 1;
				inputs.add(deposit);
				expectedOutputs.add(deposit + balance);
			}
			if(n == "withdraw" || n == "standingOrder") {
				double withdraw = random.nextInt(100000) + 1;
				inputs.add(withdraw);
				expectedOutputs.add(balance - withdraw);
			}
			if(n == "transfer") {
				double transfer = random.nextInt(100000) + 1;
				inputs.add(transfer);
				expectedOutputs.add(balance - transfer);
				double balance2 = random.nextInt(100000) + 1;
				inputs.add(balance2);
				expectedOutputs.add(balance + transfer);
			}			
		}

		testInputList.add(new TestCase(index, inputs, expectedOutputs, locks, null, null));
	}

	public List<TestCase> getTests() {
		return testInputList;
	}
}
//Test generator calls () method on the CUT. This returns a list if all methods, the work they do (including all locks), and the inputs they require.
//Generate will output a set of random numbers that is tied to a set of results for each of those numbers.