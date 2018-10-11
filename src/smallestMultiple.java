int smallestMultiple(int left, int right) {
    for(int i = 1 ; ; i++){
        boolean b = true;
        for(int j = left ; j <= right ;j++){
            if(i % j != 0) b = false;
        }
        if(b == true) return i;
    }
}
/*
Find the smallest integer that is divisible by all integers on a given interval [left, right].

For left = 2 and right = 4, the output should be
smallestMultiple(left, right) = 12.
*/
