
// 쉬운 문제
// 삼항 연산자로도 풀어보자.
int extraNumber(int a, int b, int c) {
    if (a == b)
        return c;
    else if (a == c)
        return b;
    else 
        return a;
}

// 삼항 연산자 버전 
int extraNumber(int a, int b, int c) {
    return (a == b) ? c : 
           (a == c) ? b : a;
}
