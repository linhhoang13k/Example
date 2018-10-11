int differentValuesInMultiplicationTable2(int n, int m) {
    List<Integer> str = new ArrayList<Integer>();
    for (int i = 1; i <= n; ++i)
        for (int j = 1; j <= m; ++j)
            if (!str.contains(i * j))
                str.add(i * j);
    return str.size();
}

/*
Define a multiplication table of size n by m as follows: such table consists of n rows and m columns. 
Cell on the intersection of the ith row and the jth column (i, j > 0) contains the value of i * j.

Given integers n and m, find the number of different values that are found in the table.

For n = 3 and m = 2, the output should be
differentValuesInMultiplicationTable2(n, m) = 5.
*/
