package Arcade_Core;

public class _021_SecondRightmostZeroBit {
    int secondRightmostZeroBit(int n) {
        // (n|(n+1)) --> flip first left zero
        // ((n|(n+1))+1) --> flip first zero and flip everything (incl.) until second zero
        return ~(n|(n+1)) & ((n|(n+1))+1) ;
    }
}
