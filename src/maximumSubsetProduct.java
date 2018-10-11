int maximumSubsetProduct(int[] a) {
         int count = 0;
         int min = Integer.MIN_VALUE; 
         for (int i : a)
                if (i < 0) {
                          count++;
                          if (i > min) min = i;
                } 
         return count % 2 == 0 || a.length < 2 ? 1 : min;
}

/*
In this problem, the product of the elements of an arbitrary array x is expressed as p(x).

You are given an array of integers a. Any array that you can obtain from a by removing some elements (possibly none, but not all) is denoted as s. Among all such arrays s, what is the maximum possible value of p(s)? Since the answer could potentially be very large, return the value of p(a) / p(s) instead.

Example

For a = [1, 2, -2, -3, 3, 5], the output should be
maximumSubsetProduct(a) = 1.
Consider s = a (no elements were removed from the original array): p(s) = 1 · 2 · (-2) · (-3) · 3 · 5 = 180. There is no other s that has elements with a product larger than that. In this case, p(a) = p(s), therefore p(a) / p(s) = 1.

For a = [10, -10], the output should be
maximumSubsetProduct(a) = -10.
p(a) = -100. For s = [10], p(s) = 10. p(s) cannot be any larger. Thus, the answer is p(a) / p(s) = -100 / 10 = -10.
*/
