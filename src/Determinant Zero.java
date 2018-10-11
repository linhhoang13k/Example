/*
In linear algebra, the determinant is a useful value that can be computed from the elements of a square matrix. For more information, please visit this page.

Given an integer n, your task is to calculate the total number of 2 × 2 matrices consisting of 4 pairwise distinct integers from 0 to n (both inclusive) with determinant equal to 0. The determinant of a 2 × 2 matrix [[a, b], [c, d]] can be calculated as a * d - b * c.

Example

For n = 6, the output should be
determinantZero(6) = 16

Our goal is to calculate the number of 2 × 2 matrices A = [[a, b], [c, d]] 
where 0 = a, b, c, d = 6, a, b, c, d are pairwise distinct and a * d - b * c = 0.

Here is the list of valid configurations:

[ [ 1, 2 ], [ 3, 6 ] ], det(A) = 1 * 6 - 2 * 3 = 0
[ [ 1, 3 ], [ 2, 6 ] ] ...
[ [ 2, 1 ], [ 6, 3 ] ] ...
[ [ 2, 3 ], [ 4, 6 ] ] ...
[ [ 2, 4 ], [ 3, 6 ] ] ...
[ [ 2, 6 ], [ 1, 3 ] ] ...
[ [ 3, 1 ], [ 6, 2 ] ] ...
[ [ 3, 2 ], [ 6, 4 ] ] ...
[ [ 3, 6 ], [ 1, 2 ] ] ...
[ [ 3, 6 ], [ 2, 4 ] ] ...
[ [ 4, 2 ], [ 6, 3 ] ] ...
[ [ 4, 6 ], [ 2, 3 ] ] ...
[ [ 6, 2 ], [ 3, 1 ] ] ...
[ [ 6, 3 ], [ 2, 1 ] ] ...
[ [ 6, 3 ], [ 4, 2 ] ] ...
[ [ 6, 4 ], [ 3, 2 ] ] ...
Therefore, the answer is 16.

*/

int determinantZero(int n) {
int r=0,a=1;
    for(; a<=n; a++)
    {
        for(int b=1; b<=n; b++)
        {
            for(int c=1; c<=n; c++)
            {
                for(int d=1; d<=n; d++)
                {
                    if( (a*d) - (b*c) ==0  && a!=b && a!=c && a!=d && b!=c && b!=d && c!=d)
                    {
                        
                        r++;
                    }
                }
            }
        }
    }
    return r;
}

