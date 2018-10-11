boolean cyclicSequence(int[] sequence) {
    for (int i = 0; i < a.length; i++) {
        int j = i;
        for (int k = 1; k <= a.length; k++) {
            if (k == a.length) return true;
            if (a[(j + 1) % a.length] <= a[j]) break;
                j = (j + 1) % a.length;
            }
    }
    return false;
}

/*
Given a sequence, check whether it is cyclic increasing.

Note : A sequence a1, a2, …, 
an is called cyclic increasing if for some i (1 ≤ i ≤ n), ai, ai + 1, …, an, a1, a2, …, ai - 1 is an increasing sequence.

For sequence = [5, 9, 1, 2, 4], the output should be
cyclicSequence(sequence) = true.

Increasing sequence can be started from number 1.

For sequence = [1, 3, 2], the output should be
cyclicSequence(sequence) = false.
*/
