package Arcade_Core;

public class _026_CountSumOfTwoRepresentations2 {
    int countSumOfTwoRepresentations2(int n, int l, int r) {
        if(l > n || 2*r < n) return 0;
        int sum = 0;
        for(int i = l; i <= (n-i); i++){
            if(n-i <= r && n-i >= l)
                sum++;
        }
        return sum;
    }
}
