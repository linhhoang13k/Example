int[] primeFactors(int n) {
   ArrayList<Integer> str = new ArrayList();
   for (int i = 2; n > 1; i++) {
        while (n % i == 0) {
            str.add(i);
            n /= i;
        }
    }
    return str.stream().mapToInt(i->i).toArray();
}

/*
Write an algorithm that constructs an array of non unique prime factors of a number n.

For n = 100, the output should be
primeFactors(n) = [2, 2, 5, 5].
*/
