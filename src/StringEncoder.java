package Aston;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StringEncoder {

    public static void main(String[] args) {
        System.out.println(encoder("1 Hello 23 World! 456"));
    }

    private static String encoder(String input) {
        String str = input.toLowerCase();
        String letters = "abcdefghijklmnopqrstuvwxyz ";
        String code    = "1abc2efg3ijklm4opqrs5uvw yy";
        StringBuilder sb = new StringBuilder();
        List<Integer> numbers = new ArrayList<>();

            for (int i = 0; i < str.length(); i++) {
                try {
                    char strIndex = str.charAt(i);
                    int lettersIndex = letters.indexOf(strIndex);
                    sb.append(code.charAt(lettersIndex));
                } catch (IndexOutOfBoundsException ex) {
                    if ("0123456789".contains(String.valueOf(str.charAt(i)))) {
                        numbers.add(Character.getNumericValue(str.charAt(i)));
                        if (i == str.length()-1 || !"0123456789".contains(String.valueOf(str.charAt(i+1)))) {
                            Collections.reverse(numbers);
                            String listToString = numbers.toString().replaceAll("\\[|\\]", "").replaceAll(", ","");
                            sb.append(listToString);
                            numbers.clear();
                        }
                    } else
                        sb.append(str.charAt(i));
                }
            }
            return sb.toString();
    }
}
