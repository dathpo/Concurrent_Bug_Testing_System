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
        boolean pass = true;
        if (testCases.size() == resultsLists.size()) {
            for (int i = 0; i < testCases.size(); i++) {
                if (!checkTestCase(testCases.get(i), resultsLists.get(i))) {
                    pass = false;
                }
            }
        }
        if (pass) {
            System.out.println("All tests passed!");
        }
    }

    private boolean checkTestCase(TestCase tc, List<List<Double>> resultsList) {
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
                    failFreq[failFreq.length - 1] = 1;
                }
                else {
                    failFreq[failures.indexOf(results)]++;
                }
            }
        }
        int failTimes = 0;
        for (int i = 0; i < failFreq.length; i++) {
            failTimes += failFreq[i];
        }
        if (!failures.isEmpty()) {
            System.out.println("TestCase: " + tc.getID());
            System.out.println("Ran " + resultsList.size() + " times. " + failTimes + " failure(s). " + failures.size() + " unique failed result(s) found");
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
        }
        return (failTimes == 0);
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
