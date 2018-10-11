package CodeFight;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by tranpham on 3/14/18.
 */
public class Tournament10Min {
    //only true if d is a power of 2
    public int mod(int a, int d){
        return a & (d-1);
    }

    public void permuteDotInString(String s){
        StringBuffer buff = new StringBuffer();
        permuteDotInStringHelper(s, buff,1);
    }

    private void permuteDotInStringHelper(String s, StringBuffer dotString, int idx){
        if (idx>=s.length())
            return;
        for(int i=idx;i<s.length();i++){
            dotString.insert(idx,".");
            System.out.println(s.toString());
            permuteDotInStringHelper(s,dotString,i+1);
            dotString.deleteCharAt(idx);
        }
    }

    public int gcd(int a, int b) {
        while (a > 0) {
            int tmp = a;
            a = b % a;
            b = tmp;
        }
        return b;
    }
    String htmlEndTagByStartTag(String startTag) {
        Matcher matcher= Pattern.compile("<[a-zA-Z][a-zA-Z0-9]*\\b").matcher(startTag);
        if(matcher.find()){
            return "</"+startTag.substring(matcher.start()+1,matcher.end());
        }
        return "";
    }


    public boolean higherVersion(String ver1, String ver2) {
        String[] arrV1= ver1.split("\\.");
        String[] arrV2= ver2.split("\\.");
        for(int i=0;i<arrV1.length;i++){
            int n1=Integer.parseInt(arrV1[i]);
            int n2=Integer.parseInt(arrV2[i]);
            if(n1>n2){
                return true;
            }
        }

        return false;
    }

    public int firstMultiple(int[] divisors, int start) {
        int com = divisors[0];
        for(int i=1;i<divisors.length;i++){
            com = smalessCommonDiv(com,divisors[i]);
        }

        int step = com;
        while(com<start)
            com+=step;
        return com;
    }

    int smalessCommonDiv(int a, int b){
        if(a<b)
            return smalessCommonDiv(b,a);

        for(int i=1;i<=b;i++)
            if(a*i%b==0)
                return a*i;

        return -1;
    }

    public String[] unusualLexOrder(String[] words) {
        Arrays.sort(words,(str1,str2)->{
            return reverse(str1).compareTo(reverse(str2));
        });
        return words;
    }

    String reverse(String string){
        StringBuffer buff = new StringBuffer();
        buff.append(string);
        return buff.reverse().toString();
    }

    public boolean robotWalk(int[] a) {

        return true;
    }

    public int maxSubmatrixSum(int[][] matrix, int n, int m) {

        int result = 0;
        for (int i = 0; i + n <= matrix.length; i++) {
            for (int j = 0; j + n <= matrix[0].length; j++) {
                int sum = 0;
                for (int x = 0; x < n; x++) {
                    for (int y = 0; y < m; y++) {
                        sum += matrix[i + x][j + y];
                    }
                }
                if (i == 0 && j == 0 || sum > result) {
                    result = sum;
                }
            }
        }

        return result;
    }

    public int[][] spiralNumbers(int n) {
        int[][] direction ={{0,1},{1,0},{0,-1},{-1,0}};
        int nextDirect=0;
        int curRow=0,curCol=0;
        int[][] res= new int[n][n];
        for(int i=1;i<=n*n;i++){
            res[curRow][curCol]=i;
            if(curCol+direction[nextDirect][1]<0 || curCol+direction[nextDirect][1]>=n
                    || curRow+direction[nextDirect][0]<0 || curRow+direction[nextDirect][0]>=n
                    ||res[curRow+direction[nextDirect][0]][curCol+direction[nextDirect][1]]!=0){
                        nextDirect=(nextDirect+1)%4;

            }
            curRow+=direction[nextDirect][0];
            curCol+=direction[nextDirect][1];
        }
        return res;
    }

    public int electionsWinners(int[] votes, int k) {
        int res=0;
        int max= Arrays.stream(votes).max().getAsInt();
        for(int i=0;i<votes.length;i++){
            if(votes[i]+k>max)
                res++;
        }
        return res;
    }

    public ArrayList<Integer> cyclicQueue(String[] commands) {
        final int maxSize = 10;
        int[] myQueue = new int[maxSize];
        ArrayList<Integer> answer = new ArrayList<>();
        int head = 0;
        int tail = 0;
        int sum = 0;

        for (int i = 0; i < commands.length; i++) {
            if (commands[i].equals("-")) {
                sum -= myQueue[head];
                head = (head + 1) % maxSize;
            }
            else {
                int value = 0;

                value = Integer.parseInt(commands[i].substring(1));
                sum += value;
                myQueue[tail] = value;
                tail = (tail + 1) % maxSize;
            }
            answer.add(sum);
        }

        return answer;
    }

    public int maximizeNumberRoundness(int n) {
        int tmp = n;
        int zeros = 0;
        while (tmp != 0) {
            if (tmp % 10 == 0) {
                zeros++;
            }
            tmp /= 10;
        }
        int result = zeros;
        while (n != 0) {
            if (n % 10 == 0) {
                result--;
            }
            n /= 10;
        }
        return result;
    }
/*
* A pattern can be represented as a string containing lowercase English letters and special characters: question marks and asterisks. Each question mark should be replaced by exactly one letter, and each asterisk should be replaced by zero or more letters (possibly different).

A string of letters matches a pattern if question marks and asterisks in the latter can be replaced by letters in such a way that pattern will become equal to a given string.

Does a given string match a given pattern?

Example

For input = "abacaba" and pattern = "?*b?", the output should be
patternMatching(input, pattern) = true;
For input = "abacaba" and pattern = "?*ca?", the output should be
patternMatching(input, pattern) = false.
Input/Output

[execution time limit] 3 seconds (java)

[input] string input

A string of lowercase Latin letters.

Guaranteed constraints:
1 ≤ input.length ≤ 10.

[input] string pattern

A string of lowercase Latin letters, question marks and asterisks.

Guaranteed constraints:
4 ≤ pattern.length ≤ 10.

[output] boolean

true if input string matches pattern, false otherwise.
* */
    public boolean patternMatching(String input, String pattern) {

        boolean[][] dp = new boolean[input.length() + 1][pattern.length() + 1];

        dp[0][0] = true;
        for (int i = 0; i <= input.length(); i++) {
            for (int j = 0; j < pattern.length(); j++) {
      //...
                if (i < input.length()
                        && (input.charAt(i) == pattern.charAt(j) || pattern.charAt(j) == '?')) {
                    dp[i + 1][j + 1] = true;
                }
                if (pattern.charAt(j) == '*') {
                    for (int k = 0; i + k <= input.length(); k++) {
                        dp[i + k][j + 1] = true;
                    }
                }
            }
        }

        return dp[input.length()][pattern.length()];
    }

    /*
    the first 5 digits are initially given;
for i > 4, a[i] = (a[i - 5] + a[i - 4] + a[i - 3] + a[i - 2] + a[i - 1]) % 10, i.e. each element starting with the fifth is the sum of the previous five elements modulo 10.
    *def sequenceElement(a, n):
    i = 0
    cur = tuple(a)
    seen = {}
    while cur not in seen:
        seen[cur] = i
        a.append(sum(a[-5:]) % 10)
        cur = tuple(a[-5:])

    if n < len(a):
        return a[n]

    a = a[seen[cur]:-5]
    return a[(n - seen[cur]) % len(a)]

    * */
}
