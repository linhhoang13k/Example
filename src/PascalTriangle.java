package solutions;

import java.math.BigInteger;
import java.util.Arrays;

public class PascalTriangle {

	public static void main(String[] args) {
		System.out.println(new PascalTriangle().Pascal(156,11));
	}

	String Pascal(int n, int p) {
		
		if(n<2 || n>1000000000){
			return "0";
		}
		
		if(p<2 || n>1000000000){
			return "1000";
		}

		
		return Integer.toString(searchInPascalTriangle(n + 1, p));
	}

	int searchInPascalTriangle(int level, int lookFor) {

		int totalAppearances = 0;

		BigInteger[] prevLevel = new BigInteger[] { new BigInteger("1") };

		if (level > 2) {

			int currentLevel = 2;

			while (currentLevel <= level) {
				BigInteger[] newLevel = new BigInteger[currentLevel];
				newLevel[0] = prevLevel[0];
				newLevel[newLevel.length - 1] = prevLevel[prevLevel.length - 1];

				for (int i = 1; i < prevLevel.length; i++) {

					newLevel[i] = prevLevel[i - 1].add(prevLevel[i]);

				}
				
				System.out.println(Arrays.toString(newLevel));
				
				int appearances = searchMultiplesOf(newLevel, lookFor);
				
				System.out.println(appearances);

				totalAppearances += appearances;
				prevLevel = newLevel;
				currentLevel++;
			}
		}

		return totalAppearances;
	}

	int searchMultiplesOf(BigInteger[] row, int n) {
		int appearances = 0;
		for (int i = 0; i < row.length; i++) {
			if (row[i].mod(new BigInteger(n+"")).equals(new BigInteger("0"))) {
				appearances++;
			}
		}
		return appearances;
	}

}
