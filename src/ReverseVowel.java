/* Write a function that takes a string as input and reverse only the vowels of a string. */
class ReverseVowel{
    public String reverseVowels(String s) {
        char[] str = s.toCharArray();
       
        int left = 0;
        int right = str.length-1;
        while(left<right){
            while(left<right && !isVowel(str[left])){ left++; }
            while(left<right && !isVowel(str[right])){ right--; }
            if(left<right){
                char temp = str[left];
                str[left] = str[right];
                str[right] =temp;
                
                left++;
                right--;
            
            }
        }
        return new String(str);
    }
    
    boolean isVowel(char ch){
        return "aeiouAEIOU".indexOf(ch)>=0;
    }
}