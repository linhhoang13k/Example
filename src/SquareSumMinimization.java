/*
Given a sorted array of integers A, find such an integer x that ?(A[i] - x)2 over all i has the minimum possible value. If there are several possible answers, output the smallest one.

Example

For A = [2, 4, 7], the output should be
squaresSumMinimization(A) = 4.

*/

int squaresSumMinimization(int[] A) {

    int sum=0;
    int min =1000;
    int minnum=0;
    for(int j=-25; j<25; j++)
    {
    for(int i=0; i<A.length; i++)
    {
        sum+= Math.pow( (A[i]-j),(double)2 );
    }
        if(sum<min)
        {
            min = sum;
            minnum=j;
        }
        sum=0;
    }
    return minnum;
}
