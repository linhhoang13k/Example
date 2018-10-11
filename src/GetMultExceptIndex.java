package com.iub.coding.practice.CodeName47;

public class GetMultExceptIndex {

	public static void main(String[] args) {

		int[] data = { 1, 2, 0, 4 };

		getMult(data, 0, 1, false);

		for (int i = 0; i < data.length; i++)
			System.out.print(data[i]);
	}

	public static int getMult(int[] data, int index, int mult, boolean isZero) {

		if (index == data.length) {
			return mult;
		}

		

		if (data[index] != 0)
			mult = mult * data[index];
		else if(isZero && data[index] == 0)
			mult = 0;
		else
			isZero = true;

		mult = getMult(data, index + 1, mult, isZero);

		System.out.println(mult);

		if (data[index] != 0 && !isZero)
			data[index] = mult / data[index];
		else if(data[index] == 0){
			data[index] = mult;
			return 0;
		}
		else if (isZero)
			data[index] = 0;

		return mult;
	}
}
