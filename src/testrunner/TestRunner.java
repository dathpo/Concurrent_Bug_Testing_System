package testrunner;

import CUT.Driver;
import testgenerator.TestCase;

import java.util.List;

public class TestRunner {
	List<List<List<Double>>> results;
	List<List<String>> lockPairs;
	Driver cut;
	List<TestCase> testCases;

	public TestRunner(Driver cut, List<TestCase> testCases){
		this.cut = cut;
		this.testCases = testCases;
	}

	public void runTests() {
		for(int i = 0; i < testCases.size(); i++) {
			TestCase testCase = testCases.get(i);
			for (int j = 0; j < 5; j++) {
				List<Double> inputs = testCase.getInputs();
				switch(testCase.getID()) {
				case 1: results.get(i).add(cut.test1(testCase.getInputs().get(0)));
				lockPairs.get(i).addAll(testCase.getLocks());
				break;
				case 2: results.get(i).add(cut.test2(testCase.getInputs().get(0), testCase.getInputs().get(1)));
				break;
				case 3: results.get(i).add(cut.test3(testCase.getInputs().get(0), testCase.getInputs().get(1), testCase.getInputs().get(2)));
				break;
				case 4: results.get(i).add(cut.test4(testCase.getInputs().get(0), testCase.getInputs().get(1), testCase.getInputs().get(2), testCase.getInputs().get(3)));
				break;
				case 5: results.get(i).add(cut.test5(testCase.getInputs().get(0), testCase.getInputs().get(1), testCase.getInputs().get(2)));
				break;
				case 6: results.get(i).add(cut.test6(testCase.getInputs().get(0), testCase.getInputs().get(1), testCase.getInputs().get(2)));         	
				}

				//TODO - use the inputs to make custom cut cases after cut class has been modified and get
			}
		}

	}

	public List<List<List<Double>>> getResults() {
		return results;
	}

	public List<String> getLockPairs() {
		return lockPairs;
	}
}
