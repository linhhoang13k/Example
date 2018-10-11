boolean isSentencePalindrome(String sentence) {
    sentence = sentence.toLowerCase();
    String newsentence = sentence.replaceAll("[^\\w\\s]","");
    // newsentence = newsentence.trim().replaceAll("\\s{1,}", "");
     newsentence = newsentence.replaceAll("\\s+","");
 
    String word ="";
    String newword ="";
    for(int i=newsentence.length()-1; i>=0; i--)
    {
        newword += newsentence.charAt(i);
    }
    if(newword.equals(newsentence))
    {
       return true;
    }
    else
    {
        return false;
    }
}
