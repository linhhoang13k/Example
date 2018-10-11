"""
charactersRearrangement
Daniel Cox

https://codefights.com/challenge/d3pnAhF9bdoT4pmsC

Given two strings, check whether it is possible to rearrange characters of the first string in such way that it will become equal to the second one.

Example

For string1 = "abcd" and string2 = "cbad", the output should be
charactersRearrangement(string1, string2) = true;
For string1 = "a" and string2 = "b", the output should be
charactersRearrangement(string1, string2) = false.
"""
boolean charactersRearrangement(String string1, String string2) {
    char[] s1 = string1.toCharArray();
    char[] s2 = string2.toCharArray();
    HashMap<Character,Integer> map = new HashMap<>();
    for(char x : s1){
        if(map.containsKey(x)){
            map.put(x,map.get(x)+1);
        }
        else{map.put(x,1);}
    }
    for(char y : s2){
        if(map.containsKey(y)){
            if(map.get(y)>1){
                map.put(y,map.get(y)-1);
            }
            else{map.remove(y);}
        }
        else{return false;}
    }
    if(!map.isEmpty()){
        return false;
    }
    return true;
 }
