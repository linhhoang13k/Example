public class WeirdSum {
    public static int weirdSum(String s) {
        int sum = 0;

        while(s.length() > 1){
            sum += Integer.valueOf(s.substring(0, 1)) *Integer.valueOf(s.substring(1, 2));
            s = s.substring(1, s.length());
        }

        return sum;
    }
}

