package coveragecalculator;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import testgenerator.TestGenerator;

public class CoverageCalculator {
	
	private double coverage;
	private double expectedCoverage = 40;
	private Set<String> lockPairs;
	private Set<String> expectedPairs;
	
	public CoverageCalculator(Set<String> lockPairs, Set<String> expectedPairs) {
		this.lockPairs = lockPairs;
		this.expectedPairs = expectedPairs;
		calculateActualCoverage();
	}

	public double getExpectedCoverage() {
		return expectedCoverage;
	}

	public void calculateActualCoverage() {
		// Calculate coverage here
		coverage = (1.0 * lockPairs.size() / expectedPairs.size()) * 100;
		System.out.println("The coverage expected from running the tests is " + expectedCoverage
				+ "%, the actual coverage is " + coverage + "%.");
		if (coverage < expectedCoverage) {

			System.out
					.println("The tests run do not meet the coverage criteria, more tests should be generated.");
			// set TestGen to create new tests
		} else {
			System.out.println("The tests run meet the coverage criteria, no more tests will be generated.");
		}
	}

	public double getCoverage() {
		return coverage;
	}
}
