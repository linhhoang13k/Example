import java.util.HashMap;
import java.util.Map;

public class ExploringTheWaters {
    int[] alternatingSums(int[] a) {
        int sum1=0;
        int sum2=0;
        for(int i=0;i<a.length;i++){
            if(i%2==0) sum1+=a[i];
            else sum2+=a[i];
        }
        int[] b={sum1,sum2};
        return b;
    }

    String[] addBorder(String[] picture) {
        String[] p2 = new String[picture.length + 2];
        String g="";
        for (int i = 0; i <picture[0].length()+2; i++) {
            g+='*';
        }
        p2[0]=p2[p2.length-1]=g;
        for (int i = 1; i <p2.length-1; i++){
            p2[i]="*"+picture[i-1]+"*";
        }
        return p2;
    }

    boolean areSimilar(int[] a, int[] b) {
        int l=0;
        int p1=0;
        int p2=0;
        for (int i=0;i<a.length;i++){
            if (a[i]!=b[i]){
                l++;
                if (l==1) p1=i;
                if (l==2) p2=i;
            }
        }
        if ((l==0||l==2)&&(a[p1]==b[p2]&&a[p2]==b[p1])) return true;
        else return false;
    }

    int arrayChange(int[] inputArray) {
        int sum = 0;
        for (int i = 1; i < inputArray.length; i++) {
            if (inputArray[i] <= inputArray[i - 1]) {
                sum += (inputArray[i-1]+1) - inputArray[i];
                inputArray[i] = inputArray[i - 1] + 1;
            }
        }
        return sum;
    }

    boolean palindromeRearranging(String inputString) {
        Map<Character,Integer> map=new HashMap();
        int np=0;
        for (char c:inputString.toCharArray()){
            if (map.isEmpty()) {
                map.put(c, 1);
            } else if (map.get(c) != null) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        if (inputString.length()%2==0){
            for (int i:map.values()){
                if (i%2!=0) return false;
            }
        }
        else {
            for (int i:map.values()){
                if (i%2!=0) np++;
            }
        }
        if (np>1) return false;
        else return true;
    }
}
