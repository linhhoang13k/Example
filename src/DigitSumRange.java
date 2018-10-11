public class DigitSumRange {

    public static int digitSumRange(int a, int b) {
        int sum = 0;
        for(int i = 0; i < 12; i++)
            sum += getSum(i);

        return sum;
    }
    
    private static int getSum(int a){
        int sum = 0;
        while (a > 0){
            sum += (a % 10);
            a /= 10;
        }

        return sum;
    }

}
