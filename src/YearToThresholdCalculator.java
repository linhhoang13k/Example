package exercise31;

public class YearToThresholdCalculator {
	
	public int depositProfit(int deposit, int rate, int threshold) {
		
		int years = 0;
		double percent = rateConvert(rate);
		
		double balance = deposit;
		
		while (balance < threshold) {
			double profit = calculateProfit(balance, percent);
			balance += profit;
			years++;
		}
		return years;
	}

	public double rateConvert(int rate) {
		double percent = rate /100.0;
		return percent;
	}

	public double calculateProfit(double balance, double percent) {
		double profit = balance * percent;
		return profit;
	}

}

