int[] powersOfTwo(int n) {
   ArrayList<Integer> res = new ArrayList();
    int num = 1;
    while(n > 0) {
        if(n % 2 != 0) res.add(num);
        num *= 2;
        n /= 2;
    }
    return res.stream().mapToInt(i->i).toArray(); 
}

/*
Every positive integer can be uniquely represented as a sum of different positive powers of two.

Given a number n, return a sorted array of different powers of two that sum up to n.

For n = 5, the output should be
powersOfTwo(n) = [1, 4].
*/
