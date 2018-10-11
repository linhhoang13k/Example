package in.mkp.challenges;

/**
 * Created by mkumar on 3/24/17.
 */
public class ConsecutiveBit {

    public static void main(String[] args) {
        ConsecutiveBit consecutiveBit = new ConsecutiveBit();
        System.out.println("consecutiveBit.consecutiveBit(4541097) = " + consecutiveBit.consecutiveBit(4541097));
    }

    boolean consecutiveBit(int num) {
        String binary = Integer.toBinaryString(num);
        char last = '0';
        for (int i=0; i < binary.length(); ++i) {
            if (binary.charAt(i) == '1' && last == '1') return true;
            last = binary.charAt(i);
        }
        return false;
    }

}
