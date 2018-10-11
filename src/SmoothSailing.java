import java.util.ArrayList;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class SmoothSailing {
    String[] allLongestStrings(String[] inputArray) {
        int max=0;
        int licz=0;
        int i=0;
        for (String s: inputArray){
            if (s.length()>max) {
                max=s.length();
                licz=1;
            }
            else if (s.length()==max)licz++;
        }
        String[] out=new String[licz];
        for (String s: inputArray){
            if (s.length()==max) {
                out[i]=s;
                i++;
            }
        }
        return out;
    }

    int commonCharacterCount(String s1, String s2) {
        Map<Character, Integer> w1 = new TreeMap<>();
        Map<Character, Integer> w2 = new TreeMap<>();
        int wynik=0;

        for (char c: s1.toCharArray()){
            if (w1.isEmpty()){
                w1.put(c,1);
            }
            else if (w1.get(c)!=null){
                w1.put(c,w1.get(c)+1);
            }
            else {
                w1.put(c,1);
            }
        }
        for (char c: s2.toCharArray()){
            if (w2.isEmpty()){
                w2.put(c,1);
            }
            else if (w2.get(c)!=null){
                w2.put(c,w2.get(c)+1);
            }
            else {
                w2.put(c,1);
            }
        }

        for (char c:w1.keySet()){
            if (w2.get(c)!=null){
                wynik+=Math.min(w1.get(c),w2.get(c));
            }
        }
        return wynik;
    }

    boolean isLucky(int n) {
        if ((""+n).toCharArray().length%2!=0) return false;
        int sum1=0;
        int sum2=0;
        for (int i=0;i<(""+n).toCharArray().length/2;i++){
            sum1+=Integer.parseInt(String.valueOf((""+n).charAt(i)));
            sum2+=Integer.parseInt(String.valueOf((""+n).charAt((""+n).toCharArray().length-1-i)));
        }
        if (sum1!=sum2 ) return false;
        else return true;
    }

    int[] sortByHeight(int[] a) {
        int p=-2;
        int tmp;
        boolean f=true;
        while (f){
            f=false;
            p=-2;
            for (int j=0;j<a.length;j++){
                if (p==-2&&a[j]>-1) p=j;
                else if (a[j]!=-1){
                    if (a[p]>a[j]){
                        f=true;
                        tmp=a[p];
                        a[p]=a[j];
                        a[j]=tmp;
                    }
                    p=j;
                }
            }
        }
        return a;
    }

    String reverseParentheses(String s) {
        int dl=0;
        int kt;
        int p=0;
        int k=0;

        ArrayList<Character> list=new ArrayList<>();
        for (char c: s.toCharArray()){
            list.add(c);
            if (c=='(') dl++;
        }
        for (int i=0;i<dl;i++){
            kt=0;
            for (int j=0;j<list.size();j++){
                if (list.get(j)=='(') kt++;
                if (kt==dl-i) {
                    p=j;
                    while (list.get(j)!=')') j++;
                    k=j;
                    break;
                }
            }
            int a=1;
            for (int l=p+1;l<p+1+(k-p-1)/2;l++){
                Collections.swap(list,l, k-a);
                a++;
            }
            list.remove(k);
            list.remove(p);
        }
        String wynik=new String();
        for (char c:list) wynik+=c;
        return wynik;
    }
}
