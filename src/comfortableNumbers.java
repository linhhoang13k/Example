/*

Let's say that number a feels comfortable with number b if a ≠ b and b lies in the segment [a - s(a), a + s(a)], where s(x) is the sum of x's digits.

How many pairs (a, b) are there, such that a < b, both a and b lie on the segment [l, r], and each number feels comfortable with the other?

Example

For l = 10 and r = 12, the output should be
comfortableNumbers(l, r) = 2.

Here are all values of s(x) to consider:

s(10) = 1, so 10 is comfortable with 9 and 11;
s(11) = 2, so 11 is comfortable with 9, 10, 12 and 13;
s(12) = 3, so 12 is comfortable with 9, 10, 11, 13, 14 and 15.
Thus, there are 2 pairs of numbers comfortable with each other within the segment [10; 12]: (10, 11) and (11, 12).

*/

int comfortableNumbers(int l, int r) {
    int sum=0,temp;
    ArrayList<String> arr=new ArrayList<>();
    for(int i=l;i<r;i++){
        sum=digitSum(i);
        temp=i+sum;
        if(temp>r)
            temp=r;
        for(int j=i+1;j<=temp;j++){
            String t=i+":"+j;
            int z=j-digitSum(j);
            if(i<z)
                continue;
            if(arr.contains(t)){continue;}
            arr.add(i+":"+j);
        }
    }
    return arr.size();
}
int digitSum(int d){
    int res=d/1000;
    d=d%1000;
    res+=d/100;
    d=d%100;
    res+=(d/10+d%10);
    return res;
}
