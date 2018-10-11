package arcade.mirroLake;

import java.util.*;

/**
 * Created by JavierSainz on 11/29/16.
 */
public class ConstructSquare {
    int constructSquare(String s) {
        HashMap<Character, Integer> lettersMap = new HashMap<>(s.length());
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (lettersMap.containsKey(c)) {
                lettersMap.put(c, lettersMap.get(c) + 1);
            } else {
                lettersMap.put(c, 1);
            }
        }
        ArrayList<Integer> lettersCount =  new ArrayList<>(lettersMap.values());
        Collections.sort(lettersCount);

        int biggestSquare = (int) Math.sqrt(Math.pow(10, s.length()) - 1);
        int lowestSquare = (int) Math.sqrt(Math.pow(10, s.length() - 1));
        for (; biggestSquare >= lowestSquare; biggestSquare--) {
            HashMap<Integer, Integer> numbersMap = new HashMap<>(s.length());
            int number = biggestSquare * biggestSquare;
            while (number > 0) {
                int digit = number % 10;
                if (numbersMap.containsKey(digit)) {
                    numbersMap.put(digit, numbersMap.get(digit) + 1);
                } else {
                    numbersMap.put(digit, 1);
                }
                number /= 10;
            }
            ArrayList<Integer> digestCount =  new ArrayList<>(numbersMap.values());
            Collections.sort(digestCount);
            if (lettersCount.equals(digestCount)) {
                return biggestSquare * biggestSquare;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        System.out.println(new ConstructSquare().constructSquare("aba"));
    }

}
