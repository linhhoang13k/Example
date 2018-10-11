package in.mkp.challenges;

/**
 *  https://codefights.com/challenge/NbDwPvtLjfXBB63Wx
 *
 *  I could not solve this challenge, hidden tests were timing out for me. My solution wasn't great for large arrays.
 *  I picked out some solutions that worked and that made sense to me.
 */
public class PairSumOr {


    public static void main(String[] args) {
        PairSumOr pairSumOr = new PairSumOr();
        System.out.println("pairSumOr.pairSumOr(new int[] {5, 4 ,3 ,2 ,1}) = " + pairSumOr.pairSumOr(new int[] {5, 4 ,3 ,2 ,1}));
        System.out.println("pairSumOr.pairSumOr(new int[] {3 ,2 ,1}) = " + pairSumOr.pairSumOr(new int[] {0, 0, 0, 1}));
    }


    /**
     * Main idea:
     *    - Turn each number to binary and let them cram together as if 0's were holes:
     *        [5,4,3,2,1] ==> [101,100,11,10,1] ==>
     *
     *        101                             000
     *        100                             000
     *        011     now the ones fall ==>   001
     *        010                             111
     *        001                             111
     *
     * Implementation:
     *
     * The logic here is, say we have 5 numbers -- 5, 4 , 3 , 2, 1
     * Their binary representations are:
     * 101 (5)
     * 100 (4)
     * 011 (3)
     * 010 (2)
     * 001 (1)
     *
     * Now, lets take bit 0, and iterate through it finding any 1, so we multiply a "1" by length-1 of array, and any
     * subsequent 1 by length-2 and so on.
     *
     * So we find 3 ones in above example for bit 0, we multiply:
     * 1 * (length-1) +
     * 1 * (length-2) +
     * 1 * (length-3)
     *
     * @param a
     * @return
     */
    long pairSumOr(int[] a) {
        long r=0,l;
        for (int i=1; i > 0; i *= 2) {
            l = a.length;
            for(int e : a) {
                r += (e & i) > 0 ? i * --l : 0;
                System.out.println("r = " + r);
            }
        }
        return r;
    }

    /**
     * I did not understand the solution here, I understand the concept, adaptation of the solution above.
     *
     * @param a
     * @return
     */
    long pairSumOr2(int[] a) {
        long ans = 0;  // Initialize result

        // Traverse over all bits
        for (long i = 0; i < 32; i++)
        {
            // Count number of elements with i'th bit set
            long k = 0,arrLength = a.length;  // Initialize the count
            for (int j = 0; j < a.length; j++)
            {
                if( ((a[j]) & (1 << i)) !=0)
                    k++;
            }
            // There are k set bits, means k(k-1)/2 pairs. The formula we used is nCr = (n!)/((n-r)!r!), n=k, r=2
            // Every pair adds 2^i to the answer. Therefore,
            // we add "2^i * [k*(k-1)/2]" to the answer.

            ans += (arrLength-k)<=1L ? (1L<<i) * (arrLength*(arrLength-1L)/2L): (1L<<i) * ( (arrLength*(arrLength-1L)/2L)-(arrLength-k)*(arrLength-k-1L)/2L)  ;
            System.out.println("ans: " + (ans));
        }

        return ans;
    }

    /**
     * My brute-force naive effort.
     *
     * @param arr
     * @return
     */
    long pairSumOr3(int[] arr) {
        long sum=0;
        for (int i=0; i < arr.length-1; ++i)
            for (int j=i+1; j < arr.length; ++j) {
                sum+= arr[i] | arr[j];
            }

        return sum;
    }


}

