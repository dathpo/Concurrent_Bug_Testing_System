package faultchecker;

import testgenerator.TestCase;
import java.util.ArrayList;
import java.util.List;

public class FaultChecker {
	private List<TestCase> testCases;
	private List<List<List<Double>>> resultsLists;
	
    public FaultChecker(List<TestCase> tcs, List<List<List<Double>>> resultsLists) {
    	this.testCases = tcs;
    	this.resultsLists = resultsLists;
    	checkTestCases();
    }

    public void checkTestCases() {
        if (testCases.size() == resultsLists.size()) {
            for (int i = 0; i < testCases.size(); i++) {
                checkTestCase(testCases.get(i), resultsLists.get(i));
            }
        }
    }

    private void checkTestCase(TestCase tc, List<List<Double>> resultsList) {
    	for (int x = 0; x < tc.getExpectedOutputs().size(); x++){
    		System.out.println(tc.getOutputContext().get(x) + " " + tc.getExpectedOutputs().get(x));
    	}
        List<List<Double>> failures = new ArrayList<>();
        int[] failFreq = {};
        for (List<Double> results: resultsList) {
            if (!results.equals(tc.getExpectedOutputs())) {
                if (!failures.contains(results)) {
                    failures.add(results);
                    int[] failfreq = failFreq;
                    failFreq = new int[failfreq.length + 1];
                    for (int i = 0; i < failfreq.length; i++) {
                        failFreq[i] = failfreq[i];
                    }
                }
                else {
                    failFreq[failures.indexOf(results)]++;
                }
            }
        }
        if (!failures.isEmpty()) {
            System.out.println("TestCase: " + tc.getID());
            System.out.println("Ran " + resultsList.size() + " times, " + failures.size() + " unique failed results found");
            System.out.println("");
            System.out.println("Inputs");
            for (String input:connectToContext(tc.getInputContext(),tc.getInputs())) {
                System.out.println(input);
            }
            System.out.println("Expected Outputs");
            for (String output:connectToContext(tc.getOutputContext(),tc.getExpectedOutputs())) {
                System.out.println(output);
            }
            System.out.println("");
            for (int i = 0; i < failures.size(); i++) {
                System.out.println("Results of Failure No. " + (i + 1));
                System.out.println("This result occurred " + failFreq[i] + " time(s)");
                for (String output:connectToContext(tc.getOutputContext(),failures.get(i))) {
                    System.out.println(output);
                }
                System.out.println("");
            }
            System.out.println("");
            System.out.println("");
            System.out.println("");
            System.out.println("");
        }
    }

    public List<String> connectToContext(List<String> context, List<Double> values) {
        ArrayList<String> list = new ArrayList<>();
        if (context.size() == values.size()) {
            for (int i = 0; i < context.size(); i++) {
                list.add(context.get(i) + ": " + values.get(i));
            }
        }
        return list;
    }
}
