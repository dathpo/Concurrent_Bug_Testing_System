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
		
	}
	
	private void generate() {
		// TODO Auto-generated method stub
		
	}
	
	public List<Integer> getTests() {
		return testInputList;
	}

}
