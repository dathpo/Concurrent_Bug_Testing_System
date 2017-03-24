package faultchecker;

import testgenerator.TestCase;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jordan on 24/03/2017.
 */
public class FaultCheckerChecker {
    public static void main(String[] args) {
        List<TestCase> tcs = new ArrayList<>();
        List<Double> op = new ArrayList<>();
        op.add(1.0);
        op.add(2.0);
        List<Double> fakeop = new ArrayList<>();
        fakeop.add(1.0);
        fakeop.add(1.0);
        List<String> opc = new ArrayList<>();
        opc.add("num1");
        opc.add("num2");
        List<Double> fakeop2 = new ArrayList<>();
        fakeop2.add(2.0);
        fakeop2.add(2.0);
        tcs.add(new TestCase(1.1, new ArrayList<>(), op, new ArrayList<>(), new ArrayList<>(), opc));
        List<List<List<Double>>> rsL = new ArrayList<>();
        rsL.add(new ArrayList<>());
        rsL.get(0).add(op);
        rsL.get(0).add(fakeop);
        rsL.get(0).add(fakeop);
        rsL.get(0).add(fakeop2);
        FaultChecker fc = new FaultChecker(tcs, rsL);
    }
}
