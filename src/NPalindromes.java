// https://codefights.com/challenge/YS85uiDMg7ucZNYQF/solutions/zzuAoJnPbz6tcrMn3
int n;
int NPalindromes(String s) {
    for(int i = 0; i < s.length(); i++) {
        for(int j = i + 2; j < s.length() + 1; j++) {
            String a = s.substring(i, j);
            String b = new StringBuffer(a).reverse().toString();
            if(a.equals(b))
                n++;
        }
    }
    return n;
}
