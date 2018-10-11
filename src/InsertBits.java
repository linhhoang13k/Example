package interviewpractice.bits;

/**
 * @author benmakusha
 */
public class InsertBits {

    public int insertBits(int n, int a, int b, int k) {
        String binOfN = Integer.toBinaryString(n);
        String binOfK = Integer.toBinaryString(k);

        if (binOfN.length() == 1) {
            binOfN = "0000" + binOfN;
        }

        int binLen = binOfN.length();

        if (b < binLen) {
            int firstSubStringIndex = binOfN.length() - a;
            int secSubStringIndex = binOfN.length() - b;

            if (binOfN.length() > 4) {
                if (b == binLen - 1 && binOfK.equals("0")) {
                    binOfN = binOfK;
                } else
                    binOfN = binOfN.substring(0, secSubStringIndex) +
                            binOfK + binOfN.substring(firstSubStringIndex, binOfN.length());
            } else {
                binOfN = binOfN.substring(0, secSubStringIndex - 1) +
                        binOfK + binOfN.substring(firstSubStringIndex, binOfN.length());
            }

            return binaryToInteger(binOfN);
        }
        return 0;
    }

    public String intToBinary(int n) {
        String s = "";
        while (n > 0) {
            s = ( (n % 2) == 0 ? "0" : "1") + s;
            n = n / 2;
        }
        if (s.length() < 4) {
            s = "0000" + s;
        }
        return s;
    }

    public int binaryToInteger(String bin) {
        char[] numbers = bin.toCharArray();
        int result = 0;
        for (int index = numbers.length - 1; index >= 0; index--) {
            if (numbers[index] == '1') {
                result += Math.pow(2, (numbers.length - index - 1));
            }
        }
        return result;
    }
}
