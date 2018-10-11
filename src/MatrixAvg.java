
public class MatrixAvg {
	public static void matrixAvg(int matrix[][]){
		int draws = 0;
		int wins = 0;
		int av=matrix[0].length;
		for (int i =0;i< matrix[0].length;i++){
			if(matrix[1][i] ==0){
				draws ++;
			}else if(matrix[1][i]!= -1){
				wins+=matrix[0][i];
			}
		}
		System.out.println(wins);
		System.out.println(draws);
		System.out.println("Avrg -> " +(double)wins /(av - draws));
	}
	public static void main(String[] args) {
		int [][]matrix = {{5,6,7,6,0},{-1,1,1,1,0}};
		matrixAvg(matrix);
	}

}
