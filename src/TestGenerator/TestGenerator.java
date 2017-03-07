package TestGenerator;

import java.util.ArrayList;
import java.util.List;

//Takes in an instrumented CUT and creates random tests by way of sets of input values.

public class TestGenerator {
	
	Object cut;
	List<Integer> testInputList;
	
	public TestGenerator(Object cut) {
		this.cut = cut;
		testInputList = new ArrayList<Integer>();
		analyze();
		generate();
		
	}

	private void analyze() {
		// TODO Auto-generated method stub
		//cut.instrumentation()
	}
	
	private void generate() {
		// TODO Auto-generated method stub
		
	}
	
	public List<Integer> getTests() {
		return testInputList;
	}

}

//Test generator calls insrumentation() method on the CUT. This returns a list if all methods, the work they do, and the inputs they require.
//Generate will output a set of random numbers that is tied to a set of results for each of those numbers.
