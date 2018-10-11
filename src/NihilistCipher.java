public class NihilistCipher{
  int[] nihilistCipher(String plaintext, String keyword, int row, int column) {
    char[][] poly = new char[5][5];
    Set<Character> keys = new HashSet<>();
    int a = 0, b = 0;
    for (int i = 0; i < keyword.length() && i/5 < 5; i++){
        b = i%5;
        a = i/5;
        poly[a][b] = keyword.charAt(i);
        keys.add(keyword.charAt(i));
    }
    for (char x : "abcdefghijklmnopqrstuvwxyz".toCharArray()){
        if (keys.contains(x)) continue;
        if (++b >= 5){
            a++ ;
            b = 0;
        }
        if (a > 4){
             break;
        }
        poly[a][b] = x;
    }
    Map<Character, Integer> map = new WeakHashMap<>();
    for (int i = 0; i < 5; i++){
        for (int j = 0; j < 5; j++){
            map.put(poly[i][j], (i+1)*10+(j+1));
        }
    }
    int nKey = keyword.length();
    int nPla = plaintext.length();
    int max = Math.max(nKey, nPla);
    if (nKey > nPla){
        while(max > plaintext.length()){
            plaintext += plaintext;
        }
        plaintext = plaintext.substring(0,max);
    }else if ( nKey < nPla){
        while(max > keyword.length()){
            keyword += keyword;
        }
        keyword = keyword.substring(0,max);
    }
    int[] res = new int[max];
    int tVal = row * 10 + column;
    for(int i = 0; i < max; i++){
        char kChar = keyword.charAt(i);
        char pChar = plaintext.charAt(i);
        Integer kVal = map.get(kChar);
        Integer pVal = map.get(pChar);
        if (kVal == null){
            kVal = tVal;
        }
        if (pVal == null){
            pVal = tVal;
        }
        res[i] = pVal + kVal;
    }
    return res;
  }

}
