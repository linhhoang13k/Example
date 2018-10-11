nt magicalWell(int a, int b, int n) {
    
    int money = 0;
    while(n > 0) {
        money += a*b;
        a++;
        b++;
        n--;
    }
    
    return money;
}
