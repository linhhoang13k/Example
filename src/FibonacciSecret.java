//String of charsAt fib nums, no spaces    
public class FibonacciSecret {

    String fibonacciSecret(String message) {
        //remove spaces
        char[] charArray = new char[message.length()];
        for (int i = 0, j = 0; i < message.length(); i++) {
            if (message.charAt(i) != ' ') {
                charArray[j] = message.charAt(i);
                j++;
            }
        }
        message = String.valueOf(charArray);

        char[] chars = new char[message.length()];
        int[] arr = new int[message.length()];
        arr[0] = 0;
        arr[1] = 1;
        arr[2] = 1;
        chars[0] = message.charAt(0);
        chars[1] = message.charAt(1);
        int numHits = 0;

        //getfibonacci vals and corresponding chars
        for (int i = 2; arr[i] < message.length(); i++) {
            chars[i] = message.charAt(arr[i]);
            numHits = i + 1;
            arr[i + 1] = arr[i] + arr[i - 1];
        }

        //place a dash between them (this should be moved into one of the above loops...)
        char[] ch2 = new char[chars.length * 2];
        for (int inc = 0, i = 0; i < chars.length * 2; inc++, i += 2) {
            ch2[i] = chars[inc];
            ch2[i + 1] = '-';
        }

        String ret = String.valueOf(ch2).substring(0, numHits * 2 - 1).toUpperCase();

        //remove possible extra chars at end
        for (int i = 0; i < 2; i++) {
            if (ret.charAt(ret.length() - 1) > 122 || ret.charAt(ret.length() - 1) < 48) {
                ret = ret.substring(0, ret.length() - 2);
            }
        }
        return ret;
    }
}
