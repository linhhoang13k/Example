// https://codefights.com/challenge/S8ErLGALGXkZgNTan/solutions/E5yAk3xpqvXv3jGJo
int unshift(String n) {
    String a = "!@#$%^&*()";
    String b = "";
    for(int i = 0; i < n.length(); i++) {
        for(int j = 0; j < a.length(); j++) {
            if(n.charAt(i) == a.charAt(j)) {
                if(j + 1 == 10) 
                   b += 0;
                else
                    b += j + 1;
            }
        }
    }
    return Integer.parseInt(b);
}
