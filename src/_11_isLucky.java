package Arcade_Intro;

public class _11_isLucky {
    boolean isLucky(int n) {
        String stringNum = Integer.toString(n);
        return sumOfSubstring(stringNum.substring(0,stringNum.length() / 2)) ==
                sumOfSubstring(stringNum.substring(stringNum.length() / 2));
    }

    private int sumOfSubstring(String s){
        int sum = 0;
        for (char c : s.toCharArray()) {
            sum += Integer.parseInt(String.valueOf(c));
        }
        return sum;
    }

    boolean isLuckyBetter(int n){
        String s = n+""; // Convert it to string.
        int sum = 0;

        // Check if difference of "mirrored" positions is 0.
        for(int i = 0; i < s.length()/2; i++)
            sum+=(s.charAt(i)-s.charAt(s.length()-1-i));
        return sum == 0;
    }
}
