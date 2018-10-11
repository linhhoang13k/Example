package Intro.exploring_the_waters;

public class plaindromeRearranging {

    boolean plaindromeRearranging(String str) {
        int[] charNum = new int[str.length()];
        for (int i = 0; i < str.length(); i++) {
            char letter = str.charAt(i);
            charNum[letter - 'a']++;
        }
        
        int oddNum=0;
        for(int i=0;i<str.length();i++)
        {
            oddNum+=charNum[i]%2;
        }
        return oddNum<=1;
    }

    public static void main(String[] args) {
        System.out.println(new plaindromeRearranging().plaindromeRearranging("aabb"));
    }

}
