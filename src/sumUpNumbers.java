package in.mkp.basic.level12;

/**
 * Created by mkumar on 3/19/17.
 */
public class SumUpNumbers {

    public static void main(String[] args) {
        SumUpNumbers sumUpNumbers = new SumUpNumbers();
        System.out.println(sumUpNumbers.sumUpNumbers("there are some (12) digits 5566 in this 770 string 239"));

    }

    int sumUpNumbers(String inputString) {
        final String[] tokens = inputString.trim().split(" ");

        int sum = 0;
        for (int i=0; i < tokens.length; ++i) {
            try {
                sum += (int) Double.parseDouble(tokens[i].replaceAll("\\(","").replaceAll("\\)","").trim());
            }
            catch (final Exception e) {
                sum+=0;
            }
        }
        return sum;
    }


}
