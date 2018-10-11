int squareDigitsSequence(int a0) {
    ArrayList al = new ArrayList();
    int temp = a0;
    int ans = 0;
    while(ans != a0){
        ans = 0;
        while(temp > 0){
            ans += (temp % 10) * (temp % 10);
            temp /= 10;
        }
        temp = ans;
        if(al.contains(ans))
            return al.size()+2;
        al.add(ans);
    }
    return al.size()+1;
}
