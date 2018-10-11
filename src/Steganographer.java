package steganographer;

public class Steganographer {

    public String steganographer(long[][] rgba_arr, int code) {

        String binaryCode = convertCode(code);
        String binaryNumber = "";

        printBinary(binaryCode);

        for (int i = 0; i < rgba_arr.length; i++) {
            for (int j = 0; j < rgba_arr[0].length; j++) {
                long item = rgba_arr[i][j];
                binaryNumber = convertToBinary(item);
                printBinary(binaryNumber);
            }
            decifrate(binaryCode, binaryNumber);
            System.out.println();
        }

        return "";
    }

    private String decifrate(String binaryCode, String binaryLine) {
        int columns = getNumberColumns(binaryCode);



        return "";
    }

    private int getNumberColumns(String binaryCode) {

        int count = 0;
        for ( int i = 4; i > 0 ; i--) {
            if (binaryCode.charAt(binaryCode.length() - i) == '1')
                count++;
        }

        return count;
    }

    private String convertToBinary(long item) {

        String binaryNumber = "";
        long maxValue = 0x8000000000000000L;

        for (int i = 64; i > 0; i--) {

            if ((maxValue & item) == 0) {
                binaryNumber += "0";
            } else {
                binaryNumber += "1";
            }

            maxValue = (maxValue >>> 1);
        }

        return binaryNumber;
    }

    private String convertCode(int code) {
        String binaryNumber = "";
        int maxValue = 0x80000000;

        for (int i = 32; i > 0; i--) {

            if ((maxValue & code) == 0) {
                binaryNumber += "0";
            } else {
                binaryNumber += "1";
            }

            maxValue = (maxValue >>> 1);
        }

        return binaryNumber;
    }

    private void printBinary(String binaryNumber) {
        for (int i = 0; i < binaryNumber.length(); i++) {
            if ( i % 8 == 0) {
                System.out.print("|");
            }

            System.out.print(binaryNumber.charAt(i));
        }

        System.out.println();
    }
}
