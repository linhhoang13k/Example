boolean isGeometricProgression(int[] a) {
           for(int i = 2; i < a.length; i++){
                    if(a[i-1] * a[1] != a[0] * a[i]) return false;
           }
           return true;
}

//Another Solution :

private static boolean isGeometricProgression(int[] sequence) {
        int prog = sequence[1] / sequence[0];
        for (int i = 2; i < sequence.length; i++) {
            if (sequence[i] / sequence[i - 1] != prog || sequence[i] % sequence[i - 1] != 0)
                return false;
        }
        return true;
    }

/*
Given a sequence determine if it’s a geometric progression or not.
Note : A geometric progression is a sequence of numbers where each term after the first is found by multiplying the previous one by a fixed, non-zero number.
Example
For sequence = [1, 4, 16], the output should be
isGeometricProgression(sequence) = true;
For sequence = [2, 4, 8, 17, 34], the output should be
isGeometricProgression(sequence) = false.
Java solution :
*/
