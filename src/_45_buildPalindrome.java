package Arcade_Intro;


public class _45_buildPalindrome {
    String buildPalindrome(String st) {
        String reverse = new StringBuffer(st).reverse().toString();

        // If already palindrome
        if(st.equals(reverse)){
            return st;
        }

        int depth = 0;
        for(int i = 1; i < st.length(); i++){
            String first = st.substring(st.length()-i);
            String second = reverse.substring(0,i);
            if(first.equals(second))
                depth = i;
        }
        return st + reverse.substring(depth);
    }
}
