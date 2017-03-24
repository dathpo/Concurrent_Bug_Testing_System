package testrunner;

import java.util.List;

public class Handler {
	
	private List<Double> balances;
	private List<String> lockPairs;

	public Handler(List<Double> balances, List<String> lockPairs) {
		this.balances = balances;
		this.lockPairs = lockPairs;
	}

	public List<String> getLockPairs() {
		return lockPairs;
	}

	public List<Double> getBalances() {
		return balances;
	}

	
	
}
