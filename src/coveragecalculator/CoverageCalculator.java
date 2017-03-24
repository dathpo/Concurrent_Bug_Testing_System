package coveragecalculator;

import java.util.ArrayList;
import java.util.List;

import testgenerator.TestGenerator;

public class CoverageCalculator {
	
	private double coverage;
	private double expectedCoverage = 60;
	private TestGenerator testGen;
	private List<String> lockPairs;
	
	
	public CoverageCalculator(List<String> lockPairs, List<String> locks) {
		this.lockPairs = lockPairs;
	}

	public double getExpectedCoverage() {
		return expectedCoverage;
	}

	public void calculateActualCoverage(List<String> locks) {
		// Calculate coverage here
		List<String> expectedPairs = new ArrayList<>();
		for (String lock1 : locks) {
			for (String lock2 : locks) {
				if (!lock1.equals(lock2) && checkFeasibility(lock1, lock2)) {
					expectedPairs.add(lock1 + " " + lock2);
				}
			}
		}

		int occurredPairs = 0;
		for (String pair : expectedPairs) {
			if (pairs.contains(pair)) {
				occurredPairs++;
			}
		}

		coverage = (occurredPairs / expectedPairs.size()) * 100;

		System.out.println("The coverage expected from running the tests is " + expectedCoverage
				+ "%, the actual coverage is " + coverage + "%.");
		if (coverage < expectedCoverage) {

			System.out
					.println("The tests run do not meet the coverage criteria, more tests will be generated and run.");
			// set TestGen to create new tests
			testGen.generate(0); /* what index? */
		} else {
			System.out.println("The tests run meet the coverage criteria, no more tests will be generated.");
		}
	}

	private boolean checkFeasibility(String lock1, String lock2) {
		if (lock1.endsWith(lock2.substring(1))) {
			int pos1 = Integer.parseInt(lock1.substring(0, 1));
			int pos2 = Integer.parseInt(lock2.substring(0, 1));
			if (pos1 > pos2) {
				return false;
			}
		}
		return true;
	}

	public double getCoverage() {
		return coverage;
	}
}
