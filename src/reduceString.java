String reduceString(String s) {
    int left = 0 , right = 0 , len = s.length();
    String r ="";
    for(int i=0 , j = s.length()-1 ; i < j ; i++ , j--){
        if(s.charAt(i) == s.charAt(j)){
            left++;
            right++;
        }else{
            break;
        }
    }
    for(int i = left ; i < len - right ;i++){
        r += s.charAt(i);
    }
    System.out.println(r + " " + left + " " + right);
    return r.length() == 1 ? "" : r;
}

/*
You are given a string. Remove its first and last characters until the string is empty 
or the first and the last characters are not equal. Output the resulting string.


For inputString = "abacaba", the output should be
reduceString(inputString) = "".

Explanation: "bacab" -> "aca" -> "c" -> "".

For inputString = "12133221", the output should be
reduceString(inputString) = "1332".
*/
