package testrunner;

import testgenerator.TestCase;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import CUT.Driver;

public class TestRunner {
	List<List<List<Double>>> results;
	Set<String> lockPairs;
	Driver cut;
	List<TestCase> testCases;
	int iterations;

	public TestRunner(Driver cut, List<TestCase> testCases, int iterations){
		this.cut = cut;
		this.testCases = testCases;
		this.iterations = iterations;
		lockPairs = new HashSet<>();
		results = new ArrayList<>();
		runTests();
	}

	public void runTests() {
		Handler handler;
		for(int i = 0; i < testCases.size(); i++) {
			results.add(new ArrayList<>());
			TestCase testCase = testCases.get(i);
			for (int j = 0; j < iterations; j++) {
				List<Double> inputs = testCase.getInputs();
				switch((int) testCase.getID()) {
				case 1:
					try {
						handler = cut.test1(inputs.get(0));
						results.get(i).add(handler.getBalances());
						lockPairs.addAll(handler.getLockPairs());
					} catch(Exception e) {
						System.out.println("Exception");
					}
					break;
				case 2:
					try {
						handler = cut.test2(inputs.get(0), inputs.get(1));
						results.get(i).add(handler.getBalances());
						lockPairs.addAll(handler.getLockPairs());
					} catch(Exception e) {
						System.out.println("Exception");
					}
					break;
				case 3:
					try {
						handler = cut.test3(inputs.get(0), inputs.get(1), inputs.get(2));
						results.get(i).add(handler.getBalances());
						lockPairs.addAll(handler.getLockPairs());
					} catch(Exception e) {
						System.out.println("Exception");
					}
					break;
				case 4:
					try {
						handler = cut.test4(inputs.get(0), inputs.get(1));
						results.get(i).add(handler.getBalances());
						lockPairs.addAll(handler.getLockPairs());
					} catch(Exception e) {
						System.out.println("Exception");
					}
					break;
				case 5:
					try {
						handler = cut.test5(inputs.get(0), inputs.get(1), inputs.get(2));
						results.get(i).add(handler.getBalances());
						lockPairs.addAll(handler.getLockPairs());  
					} catch(Exception e) {
						System.out.println("Exception");
					}
					break;
				}
				//TODO - use the inputs to make custom cut cases after cut class has been modified and get
			}
		}

	}

	public List<List<List<Double>>> getResults() {
		return results;
	}

	public Set<String> getLockPairs() {
		return lockPairs;
	}
}
