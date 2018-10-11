int stringsConstruction(String a, String b) {
    List<Character> l = new ArrayList<Character>();
    for(int i = 0 ; i < b.length() ; i++)
        l.add(b.charAt(i));
    int c = 0 , f = 0;
    while(l.size() != 0){
        for(int i = 0 ; i < a.length() ; i++){
            if(l.contains(a.charAt(i)))
                l.remove(new Character(a.charAt(i)));
            else{
                f = 1;
                break;
            }
        }
        if(f == 1)
            break;
        c++;
    }
    return c;
}
