package testrunner;

import testgenerator.TestCase;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import CUT.Driver;

public class TestRunner {
	List<List<List<Double>>> results;
	Set<String> lp;
	List<String> lockPairs;
	Driver cut;
	List<TestCase> testCases;

	public TestRunner(Driver cut, List<TestCase> testCases){
		this.cut = cut;
		this.testCases = testCases;	
		lp = new HashSet<String>();
		lockPairs = new ArrayList<>();
		results = new ArrayList<>();
		runTests();
	}

	public void runTests() {
		Handler handler;
		for(int i = 0; i < testCases.size(); i++) {
			results.add(new ArrayList<>());
			TestCase testCase = testCases.get(i);
			for (int j = 0; j < 4; j++) {
				List<Double> inputs = testCase.getInputs();
				switch((int) testCase.getID()) {
				case 1:
					try {
						handler = cut.test1(inputs.get(0));
						results.get(i).add(handler.getBalances());
						lp.addAll(handler.getLockPairs());
					} catch(Exception e) {
						System.out.println("Exception");
					}
					break;
				case 2:
					try {
						handler = cut.test2(inputs.get(0), inputs.get(1));
						results.get(i).add(handler.getBalances());
						lp.addAll(handler.getLockPairs());
					} catch(Exception e) {
						System.out.println("Exception");
					}
					break;
				case 3:
					try {
						handler = cut.test3(inputs.get(0), inputs.get(1), inputs.get(2));
						results.get(i).add(handler.getBalances());
						lp.addAll(handler.getLockPairs());
					} catch(Exception e) {
						System.out.println("Exception");
					}
					break;
				case 4:
					try {
						handler = cut.test4(inputs.get(0), inputs.get(1));
						results.get(i).add(handler.getBalances());
						lp.addAll(handler.getLockPairs());
					} catch(Exception e) {
						System.out.println("Exception");
					}
					break;
				case 5:
					try {
						handler = cut.test5(inputs.get(0), inputs.get(1), inputs.get(2));
						results.get(i).add(handler.getBalances());
						lp.addAll(handler.getLockPairs());  
					} catch(Exception e) {
						System.out.println("Exception");
					}
					break;
				}
				lockPairs.addAll(lp);
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
