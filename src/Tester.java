public class Tester {
	
	public static void main(String[] args) {
		StringsRearrangement sR = new StringsRearrangement();
		String[] inputArray = new String[] {"ab", "bb", "aa"};
		System.out.println(sR.stringsRearrangement(inputArray));
//		System.out.println("Compatibility Testing: ");
//		for(int c = 1; c < inputArray.length; c++)
//			System.out.println(inputArray[c - 1] + " " + inputArray[c] + ":\t" + sR.isCompatible(inputArray[c], inputArray[c-1]));
	}
}
