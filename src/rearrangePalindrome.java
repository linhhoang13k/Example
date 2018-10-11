// Given a string, find out if its characters can be rearranged to form a
// palindrome.

boolean palindromeRearranging(String inputString) {
    int[] AlphArr = new int[26];
    int same = 0;
    for(int i = 0; i < inputString.length(); i++) {
        AlphArr[inputString.charAt(i) - 'a']++;
    }

    for(int i = 0; i < 26; i++) {
        if(AlphArr[i] % 2 == 1)
            same++;
    }
    if(same % 2 == inputString.length() % 2 && same < 2)
        return true;
    else
        return false;
}
