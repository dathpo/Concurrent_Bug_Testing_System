package main;

import testgenerator.TestGenerator;

import CUT.Driver;
import testrunner.TestRunner;
import coveragecalculator.CoverageCalculator;
import faultchecker.FaultChecker;

public class Main {
	double speed;

	public static void main(String[] args) {
		Driver cut = new Driver();
		TestGenerator testGen = new TestGenerator(cut);
		TestRunner testRunner = new TestRunner(cut, testGen.getTests());
		CoverageCalculator covCalc = new CoverageCalculator(testRunner.getLockPairs(), testGen.getLocks());
		FaultChecker fc = new FaultChecker(testGen.getTests(), testRunner.getResults());
	}

}
