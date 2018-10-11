/*

Find the number of ways to express n as sum of some (at least two) consecutive positive integers.

Example

For n = 9, the output should be
isSumOfConsecutive2(n) = 2.

There are two ways to represent n = 9: 2 + 3 + 4 = 9 and 4 + 5 = 9.

For n = 8, the output should be
isSumOfConsecutive2(n) = 0.

There are no ways to represent n = 8.

*/

int isSumOfConsecutive2(int n) {
    int total=0;
    int count=0;
    for(int i=2;i<n/2;i++){
        for(int j=1;j<n;j++){
            for(int k=0,q=j;k<i;k++,q++)
                total=total+q;
            if(total==n)
                count++;
            total=0;
        }
    }
    return count;
}
