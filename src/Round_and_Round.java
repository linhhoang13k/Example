// https://codefights.com/challenge/4kTs8etaaLh3cpPS4/solutions/JKTPAx4FXYPD2nvqD
int Round_and_Round(int n, int a, int b) {
    for(int i = 0; i < Math.abs(b); i++) {
        if(b < 0)
            a--;
        else
            a++;
        if(a == n + 1)
            a = 1;
        if(a == 0)
            a = n;
    }
    return a;
}
