// https://codefights.com/challenge/2c7Jcq5H2FM9RbQ77/solutions/ECeSzYKNpA69aaeGf
int middleNumber(int n, int m) {
    String a = Integer.toString(n + m);
    for(int i = 0; i < a.length(); i++)
        if(a.charAt(i) % 2 != 0)
            return -1;
    return (n + m) / 2;
}
