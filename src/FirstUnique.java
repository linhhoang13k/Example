/*
  Given a string, find the first non-repeating character in it and return it's index. If it doesn't exist, return -1.
*/

class FirstUnique {
    public int firstUniqChar(String s) {
        int[] arr = new int[26];
        for(int i=0; i<s.length(); i++){
            int ch = s.charAt(i)-'a';
            arr[ch]++;
        }
        for(int i=0; i<s.length(); i++){
            int ch = s.charAt(i)-'a';
            if(arr[ch]==1){
                return i;
            }
        }
        return -1;
    }
}