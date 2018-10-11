class ReverseStringIII {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<words.length; i++){
            String temp= reverse(words[i]);
            sb.append(temp);
            sb.append(" ");
        }
        return sb.toString().trim();
    }
    
    String reverse(String str){
        StringBuffer sb = new StringBuffer(str);
        sb.reverse();
        return new String(sb);
    }
}