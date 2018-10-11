package tiendm.codefight.challenge.sep;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ProductionSeriesInfo {
	String[] productionSeriesInfo(int ingredients, int recipe1, int recipe2, int[] productionSeries) {
		int sum = 0;
		int[] recipe = { 0, recipe1, recipe2 };
		for (int i : productionSeries) {
			if (i == 1 || i == 2) {
				sum += recipe[i];
			} else {
				sum += i;
			}
		}
		if (ingredients == sum) {
			return new String[] { "Ok" };
		} else if (ingredients < sum) {
			return new String[] { "Out of ingredients!", String.format("Missing %d ingredients", sum - ingredients) };
		}
		int x = ingredients / sum - 1;
		if (x == 0) {
			return new String[] { "Ok" };
		}
		return new String[] { "Ok", String.format("Ingredients for %d more series", x) };
	}

	public static void main(String[] args) {
		ProductionSeriesInfo p = new ProductionSeriesInfo();
		System.out.println(p);
	}
}
