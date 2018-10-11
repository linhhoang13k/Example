package tiendm.codefight.challenge.april;

public class CheckWeight {
	
	int checkWeights(int[][] boxes, int packageWeight) {
		int sum = sumWeight(boxes);
		return packageWeight - sum ;
	}
	
	private int sumWeight(int[][] boxes) {
		int sum = 0;
		for(int i=0; i < boxes.length; i++){
			for(int j= boxes[i][0]; j <= boxes[i][1]; j++){
				sum += j;
			}
		}
		return sum;
	}

	public static void main(String[] args) {
		CheckWeight test = new CheckWeight();
		int packageWeight = 10;
		int [][] boxes = {{1, 2}, {3, 4}};
		System.out.println(test.checkWeights(boxes, packageWeight));
	}
}
