package com.taidev198.game.CodingInterview.String;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StringInterview1 {

    static String cipher26(String message) {
        StringBuilder tmp = new StringBuilder();
        int value = message.charAt(0)-'a';
        tmp.append((char)(value+'a'));
        for(int i =1; i< message.length();i++){
            int temp = message.charAt(i)-'a';
            for (int j = 0; j < 26; j++) {
                if ((value + j) % 26 ==temp){
                    System.out.println(j);
                    tmp.append((char) (j+'a'));
                    value += (j);
                    break;
                }
            }
        }
        return tmp.toString();
    }

    static String stolenLunch(String note) {

        int n = note.length();
        if(n == 0) return "";
        char[] tmp = note.toCharArray();
        for(int i=0; i< tmp.length;i++){
            if(tmp[i] <='9' && tmp[i] >='0')
                tmp[i] = (char)((tmp[i] -'0') + 'a');
            else if(tmp[i] <='j' && tmp[i] >='a')
                tmp[i] = (char)((tmp[i] -'a') + '0');
        }
        return new String(tmp);
    }

    static boolean higherVersion(String ver1, String ver2) {

        int index1 =ver1.indexOf(".");
        int index2 =ver2.indexOf(".");
        int j=0;
        int i=0;
        while(index1< ver1.length()){
            if(Integer.valueOf(ver1.substring(j,index1)) > Integer.valueOf(ver2.substring(i,index2)))
                return true;
            j = index1+1;
            i=index2+1;
            index1 =ver1.indexOf(".",j);
            index2 =ver2.indexOf(".",i);
            if(index1 ==-1 && index2==-1){
                if(Integer.valueOf(ver1.substring(j,ver1.length())) > Integer.valueOf(ver2.substring(i,ver2.length())))
                    return true;
                break;
            }

        }
        return false;
    }

    static String decipher(String cipher) {

        StringBuilder ans = new StringBuilder();
        int value =0;
        for(int i=0; i< cipher.length();i++){
            value = value*10+ (cipher.charAt(i)-'0');
            if(value >=97 && value<=122){
                ans.append((char)value);
                value=0;
            }

        }
        return ans.toString();
    }

    static int squareDigitsSequence(int a0) {

        List<Integer> list = new ArrayList<>();
        list.add(a0);
        int value = sumOfSquare(a0);
        while(!list.contains(value)){
            list.add(value);
            value = sumOfSquare(value);
        }
        return list.size();

    }
    static int sumOfSquare(int a){
        if(a< 10) return a*a;
        return (a%10)*(a%10) + sumOfSquare(a/10);
    }
    static int fibonacciIndex(int n) {
        int a=0;
        int b=1;
        int c= a+b;
        int ans =0;
        while((int)Math.log10(c)!= n-1) {
            ++ans;
            a=b;
            b=c;
            c= a+b;
        }
        return ans;
    }


    static int rounders(int n) {

        int pow= 10;
        int lv = (int)Math.log10(n);

        while(n % (int)Math.pow(10,lv) != 0){
            if(n % pow >=5) n +=(pow- (n%pow));
            else n -=(n%pow);
            pow*=10;
        }
        return n;
    }

    static boolean higherVersion1(String ver1, String ver2) {
        String[] tmp = ver1.split("\\.");
        String[] tmp1 = ver2.split("\\.");
        if (tmp.length ==0)
            return Integer.valueOf(ver1) > Integer.valueOf(ver2);
        for (int i = 0; i < tmp.length; i++) {
            if (Integer.valueOf(tmp[i]) < Integer.valueOf(tmp1[i])) return  false;
            else if (Integer.valueOf(tmp[i]) >Integer.valueOf(tmp1[i])) return  true;

        }
        System.out.println(tmp.length);
        return  false;
    }


   static String[] uncommonFromSentences(String A, String B) {

        String[] strA = A.split(" ");
        String[] strB = B.split(" ");
        List<String> listA  = Arrays.asList(strA);
        List<String> listB  = Arrays.asList(strB);

        String[] ans = new String[strA.length + strB.length];
        int j=0;
        for(int i =0; i<strA.length ;i++){
            int index = listA.lastIndexOf(strA[i]);
            if(index == i && !listB.contains(strA[i])){
                ans[j++] = strA[i];
            }
        }
        if(listA.indexOf(strA[strA.length-1]) != strA.length -1)
            j--;

        for(int i =0; i<strB.length ;i++){
            int index = listB.lastIndexOf(strB[i]);
            if(index ==i && !listA.contains(strB[i])){
                ans[j++] = strB[i];
            }
        }
        if(listB.indexOf(strB[strB.length-1]) != strB.length -1)
            j--;
        if (j == -1) return  new String[0];
        return Arrays.copyOfRange(ans, 0,j);
    }
    static int reverse(int x) {
        String tmp = Integer.toString(x);
        if(x < 0)
            tmp = tmp.substring(1, tmp.length());
        char[] temp = tmp.toCharArray();
        for(int i=0;i<temp.length/2; i++){
            char ch = temp[i];
            temp[i] = temp[ temp.length - i -1];
            temp[ temp.length -i -1] = ch;
        }

        return (int) (x<0? new BigInteger(new String(temp)).longValue()*(-1)< Integer.MAX_VALUE?new BigInteger(new String(temp)).longValue()*(-1) :0
                        : new BigInteger(new String(temp)).longValue()< Integer.MAX_VALUE? new BigInteger(new String(temp)).longValue():0);

    }

    static String classifyStrings(String s) {
        String vowels = "ueoai";
        int n = s.length();
        if(n == 1) return "good";
        boolean notConseccutiveVowels = false;
        boolean notConseccutiveConstants = false;
        boolean hasOnlyVowel = true;
        boolean hasOnlyConstant = true;
        for (int i = 0; i < n; i++) {
            if (Character.toString(s.charAt(i)).matches("[aeiou]*")){
                hasOnlyConstant = false;
                hasOnlyVowel = true;
                int j = i+1;
                int count =1;
                while(j < n && Character.toString(s.charAt(j++)).matches("[aeiou]*"))
                    count ++;
                if(count ==3)
                    return "bad";
                else notConseccutiveVowels = true;
                i=j-1;
            }else if (!Character.toString(s.charAt(i)).matches("[aeiou]*")){
                int j = i+1;
                hasOnlyConstant = true;
                hasOnlyVowel =false;
                int count =1;
                while(j < n && !Character.toString(s.charAt(j++)).matches("[aeiou]*"))
                    count ++;
                if(count ==5)
                    return "bad";
                else notConseccutiveConstants = true;
                i = j-1;
            }
        }
        if (hasOnlyConstant || hasOnlyVowel)
            return "good";
        if(notConseccutiveConstants && notConseccutiveVowels)
            return "good";
        return "mixed";

    }


    static boolean beautifulText(String inputString, int l, int r) {
        int len = inputString.length();
        if(len < l) return false;
        String[] strArray = inputString.split(" ");
        int temp = 0;
        int speed = 1;
        for(int i=0; i< strArray.length-1; i++){
            temp += (strArray[i].length());
            if (i > 0)
            temp ++;
            boolean isOk = true;
            for(int j = i+1 ; j < strArray.length ; j+=speed){
                int newLineLength = 0;
                if(j+speed >= strArray.length){
                    isOk = false;
                    break;
                }

                for(int k = j ;k< j+speed ;k++){
                    newLineLength += strArray[k].length();
                }
                newLineLength += (speed - 1);
                if(newLineLength!= temp || (newLineLength <l ||  newLineLength >r)){
                    isOk = false;
                    break;
                }
            }
            if(isOk && temp >=l &&  temp <=r)
                return true;
            speed ++;
        }
        return false;
    }

    public static void main(String...args){
        //System.out.println(Integer.MAX_VALUE);

        //System.out.println(Arrays.toString(uncommonFromSentences("s z z z s", "s z ejt")));
        System.out.println(beautifulText( "Look at this example of a correct text", 5, 15));
    }
}
