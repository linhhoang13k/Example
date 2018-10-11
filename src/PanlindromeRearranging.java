package com.company.kwonhyunwoo.Intro;

public class PanlindromeRearranging {
    public static void main(String[] args) {
        System.out.println(palindromeRearranging("aabc"));
        System.out.println(palindromeRearranging("aabcc"));
        System.out.println(palindromeRearranging("abbbaabababbbbbaaaaa"));
    }

    static boolean palindromeRearranging(String inputString) {
        int[] checkingPalindrome = new int[26];

        char[] strToChar = inputString.toCharArray();

        for (int i = 0; i < strToChar.length; i++) {
            checkingPalindrome[strToChar[i] - 'a']++;
        }
        // 조금만 더 생각해보면...
        // 길이가 짝수 일 때 만약 홀수개의 문자가 있다면... 무조건 2개 이상이게 된다. "aabc" "bc" "aaaabc" 등등..
        // 홀수 일 때에도 홀수개의 문자가 2개 이상이면 panlindrome이 성립하지 않는다.

        int numOfOdd = 0;
        for (int i : checkingPalindrome) {
            if (i % 2 == 1) numOfOdd++;
        }
        return numOfOdd <= 1;

//        switch (inputString.length() % 2) {
//            case 0: // 문자길이가 짝수인 경우
//                for (int element : checkingPalindrome) if (element % 2 == 1) return false;
//                break;
//            case 1: // 문자길이가 홀수인 경우
//                boolean isOdd = false;
//                for (int element : checkingPalindrome)
//                    if (element % 2 == 1) {
//                        if (!isOdd) {
//                            isOdd = true;
//                            continue;
//                        }
//                        return false;
//
//                    }
//                if (!isOdd) return false;
//                break;
//        }
//        return true;
    }
}
