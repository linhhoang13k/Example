class ReverseString {
    public String reverseStringI(String s) {
        char[] str = s.toCharArray();
        int left = 0;
        int right = str.length-1;
        
        while(left<right){
            char temp = str[left];
            str[left] = str[right];
            str[right] = temp;
            
            left++;
            right--;
        }
        return new String(str);
    }

     public String reverseStringII(String s) {
     StringBuffer strbuf = new StringBuffer();
        strbuf.append(s);
        strbuf.reverse();
        return new String(strbuf);
    }
}