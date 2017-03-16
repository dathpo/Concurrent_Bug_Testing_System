package testgenerator;

import java.util.List;

public class TestCase {
    int id;
    List<Integer> inputs;
    List<Integer> expectedOutputs;
    List<String> locks;
    
    public TestCase (int id, List<Integer> inputs, List<Integer> expectedOutputs, List<String> locks) {
        this.id = id;
        this.inputs = inputs;
        this.expectedOutputs = expectedOutputs;
        this.locks = locks;
    }
    
    public int getID() {
        return id;
    }
    
    public List<Integer> getInputs() {
        return inputs;
    }
    
    public List<Integer> getExpectedOutputs() {
        return expectedOutputs;
    }
    
    public List<String> getLocks() {
        return locks;
    }
}
