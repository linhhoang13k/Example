// https://codefights.com/challenge/JfhxWo2wWrcZGSpsF/solutions/64RnDmSb5xLv6MCPa
int NumOfWords(String s) {
    int a = 0;
    int b = s.length() - 1;
    if(s.length() > 1)
        if(Character.isLetter(s.charAt(b)))
            a++;
    for(int i = 0; i < b; i++) {
        if(Character.isLetter(s.charAt(i)) && (Character.isLetter(s.charAt(i + 1)) == false))
            a++;
    }
    return a;
}
