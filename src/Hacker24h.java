package Testing;

import CodeFight.Node;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by tranpham on 12/14/17.
 */
public class Hacker24h {

    public String[] extractLink(String[] htmls){
        String[] res = new String[htmls.length];
        int i=0;
        for(String str:htmls){
            String link="(?<=href=\")[^>]";
            String pat ="<a\\b.*href=\"([^\"]*)\"[^>]*>(?:<[a-z][a-z0-9]*\\b[^>]*>)*([^<]*)<";
            Matcher matcher = Pattern.compile(link).matcher(str);
            if(matcher.find()){
                res[i++]=matcher.group(0).toString()+","+matcher.group(1);
            }
        }
        return res;
    }
    public static void main(String[] agrs){
        BigInteger num = new BigInteger("1209802183");

    }

    public static int factoral(int n){
        long fact=1;
        for (int i = 1; i <= n; i++)
            fact = (fact*i)%1000000000;
        return (int)fact;
    }

    static long longestSequence(long[] a) {
        //  Return the length of the longest possible sequence of moves.
        long sum = 0;
        for(int i=0;i<a.length;i++){
            sum += largestPrimeFactor(a[i]);
        }
        return sum;
    }

    public static long largestPrimeFactor(long number) {
        long i;
        long sum=1;
        long copyOfInput = number;
        if(new BigInteger(number+"").isProbablePrime(5))
            return number+1;

        for (i = 2; i <= copyOfInput; i++) {
            if (copyOfInput % i == 0) {
                sum=1+i*sum;
                copyOfInput /= i; i--;
            }
        }
        return sum;
    }
    public static long primeFactors(long n)
    {
        // Print the number of 2s that divide n
        long sum=1;
        while (n%2==0)
        {
            sum=1+2*sum;
            n /= 2;
        }

        // n must be odd at this point.  So we can
        // skip one element (Note i = i +2)
        for (int i = 3; i <= Math.sqrt(n); i+= 2)
        {
            // While i divides n, print i and divide n
            while (n%i == 0)
            {
                sum=1+i*sum;
                n /= i;
            }
        }

        // This condition is to handle the case whien
        // n is a prime number greater than 2
        if (n > 2)
            return 1+n*sum;
        return sum;
    }

    static long longestSequence(ArrayList<Long> a){
        long sum=1;
        for(int i=0;i<=a.size();i++){
            sum=1+a.get(i)*sum;
        }
        return sum;//1+2*(1+3*1)
    }


    class Node {
        Integer data;
        Node nextNode;
        public Node(Integer t){
            data = t;
        }
    }
}
