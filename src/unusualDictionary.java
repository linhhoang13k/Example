boolean unusualDictionary(String[] wordList) {
    for(int i = 1; i < wordList.length; i++) {
        String [] str = wordList[i - 1].split(" ");
        String [] st = wordList[i].split(" ");
        if(str[str.length - 1].equals(st[st.length - 1]))
            if(wordList[i - 1].compareTo(wordList[i]) > 0)
                return false;
        if(str[str.length - 1].compareTo(st[st.length - 1]) > 0)
            return false;
    }
    return true;
}
https://codefights.com/tournaments/bz4MGJQgLzMaa2sFJ/C
