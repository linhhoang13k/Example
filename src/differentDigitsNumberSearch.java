int differentDigitsNumberSearch(int[] a) {
    for(int i : a){
        HashSet<Integer> s = new HashSet();
        int cnt = 0, n = i;
        while(n != 0){
            s.add(n % 10);
            n /= 10;	
            cnt++;
        }
        if(cnt == s.size()){	
            return i;
        }
    }
    return -1;
}

/*
Given an array of integers, find the leftmost number that has a decimal representation which 
doesn't contain any digit more than once. If there is no such number, return -1 instead.

For inputArray = [22, 111, 101, 124, 33, 30], the output should be
differentDigitsNumberSearch(inputArray) = 124;
For inputArray = [1111, 404], the output should be
differentDigitsNumberSearch(inputArray) = -1.
*/
