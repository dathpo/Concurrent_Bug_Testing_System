package testgenerator;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Set;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import CUT.Driver;

public class TestGenerator {

	Driver cut;
	Info info;
	List<TestCase> testCaseList;
	List<Double> inputs;
	List<Double> expectedOutputs;    
	List<String> equations;
	Set<String> locks;
	List<String> inputContext;
	List<String> outputContext;

	public TestGenerator(Driver cut) {
		this.cut = cut;
		testCaseList = new ArrayList<TestCase>();
		for(int i = 1; i < 6; i++) {
			analyze(i);
			generate(i);
		}
	}
	private void analyze(int index) {
		info = cut.analysis(index);
		equations = info.getEquations();
		locks = info.getLocks();
		inputContext = info.getInputContext();
		outputContext = info.getOutputContext();
	}

	private void generate(int index) {
		ScriptEngineManager mgr = new ScriptEngineManager();
		ScriptEngine engine = mgr.getEngineByName("JavaScript");
		
		for(int i = 0; i < 10; i++){
			inputs = new ArrayList<Double>();
			
			for(int j = 0; j < inputContext.size(); j++){
				Random random = new Random();
				double newInput = random.nextInt(1000);
				inputs.add(newInput);
			}
			for(int k = 0; k < outputContext.size(); k++){
				engine.put("one", inputs.get(0));
				if(inputs.size() > 1){
					engine.put("two", inputs.get(1));
				}
				if(inputs.size() > 2){
					engine.put("three", inputs.get(2));
				}
				if(inputs.size() > 3){
					engine.put("four", inputs.get(3));
				}
				
				expectedOutputs = new ArrayList<Double>();
				for(int l = 0; l < equations.size(); l++)
				{	
					String equation = equations.get(l);
					try {
						expectedOutputs.add((Double) engine.eval(equation));
					} catch (ScriptException e) {
						e.printStackTrace();
					}
				}
			}
			double ii = i;
			double testIndex = index + (ii/10);
			testCaseList.add(new TestCase(testIndex, inputs, expectedOutputs, locks, inputContext, outputContext));
		
		}
	}

	public List<TestCase> getTests() {
		return testCaseList;
	}
	
	public Set<String> getLocks() {
		return locks;
	}
}