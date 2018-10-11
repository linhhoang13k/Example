class LongestCommanPrefix {
    public String longestCommonPrefix(String[] strs) {
        if(strs == null || strs.length == 0)    return "";
    String prefix = strs[0];
    int i = 1;
    while(i < strs.length){
        while(strs[i].indexOf(prefix) != 0)
        {
            System.out.println("strs[i].indexof(pre): "+strs[i].indexOf(prefix));
            prefix = prefix.substring(0,prefix.length()-1);
        }
        i++;
    }
    return prefix;
    }
}