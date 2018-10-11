// https://codefights.com/challenge/AbjRNeAzSbRnMbK6j/solutions/hT5yjw6iEuu5uQ3kb
String countDown(int n) {
    String a = "";
    if(n % 3 != 0) {
        return "-1";
    }
    for(int i = 0; i < 3; i++) {
        a += n - i;
    }
    for(int i = 5; i < n; i--) {
        a += n - i;
        if(i % 3 == 0) {
            i += 6;   
        }
    }
    return a;
}
