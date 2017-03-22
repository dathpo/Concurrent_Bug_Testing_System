package faultchecker;

import testgenerator.TestCase;
import java.util.ArrayList;
import java.util.List;

public class FaultChecker {
    public FaultChecker() {

    }

    public void checkTestCases(List<TestCase> tcs, List<List<List<Double>>> resultsLists) {
        if (tcs.size() == resultsLists.size()) {
            for (int i = 0; i < tcs.size(); i++) {
                checkTestCase(tcs.get(i), resultsLists.get(i));
            }
        }
    }

    public void checkTestCase(TestCase tc, List<List<Double>> resultsList) {
        List<List<Double>> failures = new ArrayList<>();
        for (List<Double> results: resultsList) {
            if (!results.equals(tc.getExpectedOutputs()) && !failures.contains(results)) {
                failures.add(results);
            }
        }
        if (!failures.isEmpty()) {
            System.out.println("TestCase: " + tc.getID());
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
                System.out.println("Results of Failure No. " + i);
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
