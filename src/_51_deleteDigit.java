package Arcade_Intro;

public class _51_deleteDigit {
    int deleteDigit(int n) {
        String s = Integer.toString(n);

        int maxNumber = Integer.parseInt(s.substring(1));
        for(int i = 1; i < s.length(); i++){
            if(Integer.parseInt(s.substring(0,i) + s.substring(i+1)) > maxNumber)
                maxNumber = Integer.parseInt(s.substring(0,i) + s.substring(i+1));
        }
        return maxNumber;
    }
}
