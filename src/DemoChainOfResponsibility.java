package ChainOfResponsibility;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by tranpham on 8/8/17.
 */
public class DemoChainOfResponsibility {


    public static void main(String[] args){
//        int[] test=primeBinaryDigitSum(3982,2752513,4);
        int amount = 1287;
        BaseHandler rootHandler = new Dollar100Handler();
        rootHandler.setNextHandler(new Dollar50Handler());
        rootHandler.setNextHandler(new Dollar20Handler());
        rootHandler.setNextHandler(new Dollar10Handler());
        rootHandler.setNextHandler(new Dollar5Handler());
        rootHandler.setNextHandler(new Dollar2Handler());
        rootHandler.setNextHandler(new Dollar1Handler());
        rootHandler.handle(amount);
    }



    static int[] primeBinaryDigitSum(int rangeStart, int rangeEnd, int sum) {
        ArrayList<Integer> res= new ArrayList<Integer>();
        int numbers[]=new int[rangeEnd+1];
        for(int i=2;i<=rangeEnd;i++){
            if(i>2 && i%2==0 )
                continue;
            if(numbers[i]!=-1){
                //i is prime
                if(i>=rangeStart && isEqualSumBinary(i,sum))
                    res.add(i);
                //remove other multiplication of i
                for(int j=i*i;j<=rangeEnd && j>=0;j=j+i)
                {
                    try {
                        numbers[j] = -1;
                    }
                    catch (Exception ex)
                    {

                    }
                }
            }
        }
        // for(int i=rangeStart;i<=rangeEnd;i++){
        //     if(isPrime(i)&&isEqualSumBinary(i,sum)){
        //         res.add(i);
        //     }
        // }
        int[] returnRes = new int[res.size()];
        for(int i=0;i<res.size();i++)
            returnRes[i]=(int)res.get(i);

        return returnRes;
    }
    static boolean isEqualSumBinary(int n,int expected_sum){
        int sum=0;
        while(n>0){
            sum+=n%2;
            n=n/2;
            if(sum>expected_sum)
                return false;
        }
        return sum==expected_sum;
    }
}
