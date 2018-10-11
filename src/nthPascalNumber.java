int nthPascalNumber(int n) {
    int[][] a  = new int[n+1][];
    a[1] = new int[1+2];
    a[1][1] = 1;
    List<Integer> l = new ArrayList();
    for (int i = 2; i <= n; i++) {
          a[i] = new int[i+2];
          for (int j = 1; j < a[i].length - 1; j++){
              a[i][j] = a[i-1][j-1] + a[i-1][j];
                l.add(a[i][j]);
          }
    }   
    return l.get(n);
}

/*
Given an integer n, find the nth number in Pascal's Triangle.

For n = 5, the output should be
nthPascalNumber(n) = 2.
The first few lines of the triangle are:
1
1 1
1 2 1
1 3 3 1
1 4 6 4 1
1 5 10 10 5 1
The 5th element is 2.
*/
