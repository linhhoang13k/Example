public class HammingWeight {
    // you need to treat n as an unsigned value
    public int hammingWeight(int n) {
        int count = 0;
        String bin = Integer.toBinaryString(n);
        for(int i=0; i<bin.length(); i++){
            if(bin.charAt(i)=='1'){
                count++;
            }
        }
        return count;
    }
}