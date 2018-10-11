<<<<<<< HEAD
class LongestPalindrome {
    public String longestPalindrome(String s) {
        int low=0, max=0;
        String longestSubstring = null;
        if(s.length()<2){
            return s;
        }
        for(int i=0; i<s.length(); i++){
            int x, y; 
            
            x=i;
            y=i;
            
            while(x>=0 && y<s.length() && s.charAt(x) == s.charAt(y)){
                x--;
                y++;
            }
            if(max<y-x-1){
                low = x+1;
                max = y-x-1;
            }
            
            x=i;
            y=i+1;
            
            while(x>=0 && y<s.length() && s.charAt(x) == s.charAt(y)){
                x--;
                y++;
            }
            if(max<y-x-1){
                low = x+1;
                max = y-x-1;
            }        
        }
        return s.substring(low, low+max);
    }
=======
class LongestPalindrome {
    public String longestPalindrome(String s) {
        int low=0, max=0;
        String longestSubstring = null;
        if(s.length()<2){
            return s;
        }
        for(int i=0; i<s.length(); i++){
            int x, y; 
            
            x=i;
            y=i;
            
            while(x>=0 && y<s.length() && s.charAt(x) == s.charAt(y)){
                x--;
                y++;
            }
            if(max<y-x-1){
                low = x+1;
                max = y-x-1;
            }
            
            x=i;
            y=i+1;
            
            while(x>=0 && y<s.length() && s.charAt(x) == s.charAt(y)){
                x--;
                y++;
            }
            if(max<y-x-1){
                low = x+1;
                max = y-x-1;
            }        
        }
        return s.substring(low, low+max);
    }
>>>>>>> 16693ed2c463e617361e7f7dc0aa21e5ed9bfd31
}