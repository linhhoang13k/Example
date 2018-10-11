List<String> newNumeralSystem(char number) {
    List<String> l = new ArrayList();
    for(char i = 'A' ; i <= 'Z' ; i++)
        for(char j = 'A' ; j <= 'Z' ; j++)
            if((i - 'A') + (j - 'A') == (number - 'A') 
               && !l.contains(i + " + " + j) && !l.contains(j + " + " + i))
                l.add(i + " + " + j);
    return l;
}
