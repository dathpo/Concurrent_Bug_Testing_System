package testrunner;

import CUT.Driver;
import testgenerator.TestCase;

import java.util.List;

public class TestRunner {
    List<List<Integer>> results;
    List<String> lockPairs;
    Driver cut;
    TestCase testCase;

    public TestRunner(Driver cut, TestCase testCase){
        this.cut = cut;
        this.testCase = testCase;
    }

    private void runTests() {
        for (int i = 0; i < 5; i++) {
            List<Double> inputs = testCase.getInputs();

            //TODO - use the inputs to make custom cut cases after cut class has been modified and get
        }
    }
    
    public List<List<Integer>> getResults() {
        return results;
    }
    
    public List<String> getLockPairs() {
        return lockPairs;
    }
}
