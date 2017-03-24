package main;

import testgenerator.TestCase;
import testgenerator.TestGenerator;

import java.util.ArrayList;
import java.util.List;

import CUT.Driver;
import testrunner.TestRunner;
import coveragecalculator.CoverageCalculator;
import faultchecker.FaultChecker;

public class Main {
	double speed;

	public static void main(String[] args) {
		Driver cut = new Driver();
		TestGenerator testGen = new TestGenerator(cut);
		/*
		List<TestCase> testCases = new ArrayList<>();
		List<Double> inputs = new ArrayList<>();
		List<Double> expectedOutputs = new ArrayList<>();
		List<String> locks = new ArrayList<>();
		List<String> inputContext = new ArrayList<>();
		List<String> outputContext = new ArrayList<>();
		inputs.add(100.0); inputs.add(200.0); inputs.add(50.0); 
		expectedOutputs.add(50.0);
		expectedOutputs.add(250.0);
		locks.add("3A"); locks.add("1A");
		inputContext.add("balance1"); inputContext.add("balance2"); inputContext.add("transfer");
		outputContext.add("account1");  outputContext.add("account2");

		TestCase testCase1 = new TestCase(3.0, inputs, expectedOutputs, locks, inputContext, outputContext);
		testCases.add(testCase1);
		
		TestRunner testRunner = new TestRunner(cut, testCases);
		*/
		TestRunner testRunner = new TestRunner(cut, testGen.getTests());
		CoverageCalculator covCalc = new CoverageCalculator(testRunner.getLockPairs(), testGen.getLocks());
		FaultChecker fc = new FaultChecker(testGen.getTests(), testRunner.getResults());
	}

}
