package Arcade_Intro;

public class _41_digitDegree {
    int digitDegree(int n) {
        if(n<10)return 0;

        // Otherwise calculate sum and call recursively.
        int sum = 0;
        for(char c : Integer.toString(n).toCharArray()){
            sum += Integer.valueOf(String.valueOf(c));
        }
        return 1 + digitDegree(sum);
    }

}
