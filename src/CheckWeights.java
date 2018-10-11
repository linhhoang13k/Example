package in.mkp.challenges;

/**
 * https://codefights.com/challenge/hWKhTrLciWip9D3qZ
 */
public class CheckWeights {

    public static void main(String[] args) {
        CheckWeights checkWeights = new CheckWeights();
        System.out.println(checkWeights.checkWeights(new int[][] {{1,100},{151,163}, {328,572}}, 117406));
    }

    int checkWeights(int[][] boxes, int packageWeight) {
        int sum=0;
        for (int i=0; i < boxes.length; ++i) {
            for (int j=boxes[i][0] ; j <= boxes[i][1]; ++j) {
                sum+=j;
            }
        }
        return packageWeight-sum;
    }

}
