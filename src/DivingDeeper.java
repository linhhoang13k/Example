import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DivingDeeper {
    int[] extractEachKth(int[] inputArray, int k) {
        ArrayList<Integer> list = new ArrayList();

        for (int i = 0; i < inputArray.length; i++) {
            if ((i + 1) % k != 0) {
                list.add(inputArray[i]);
            }
        }

        int[] a = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            a[i] = list.get(i);
        }
        return a;
    }

    char firstDigit(String inputString) {
        char a = 0;
        for (char c : inputString.toCharArray()) {
            if (Character.isDigit(c)) {
                a = c;
                break;
            }
        }
        return a;
    }

    int differentSymbolsNaive(String s) {
        Map<Character, Integer> map = new HashMap();
        for (char c : s.toCharArray()) {
            if (map.isEmpty()) {
                map.put(c, 1);
            } else if (map.get(c) != null) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        return map.size();
    }

    int arrayMaxConsecutiveSum(int[] inputArray, int k) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= inputArray.length - k; i++) {
            for (int j = i; j < i + k; j++) {
                sum += inputArray[j];
            }
            if (sum > max) max = sum;
            sum = 0;
        }
        return max;
    }
}
