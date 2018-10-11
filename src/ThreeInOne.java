// https://codefights.com/challenge/Zecahnj4aF95yebaw/solutions/CEG6ecnuzouc4eaai
int ThreeInOne(int[] arr, char operator, int second) {
    int a = 0;
    int b = arr.length;
    char c = operator;
    for(int i = 0; i < b; i++) {
        a += arr[i];
    }
    a /= b;
    b = second;
    a = c == '+' ? a + b : c == '-' ? a - b : c == '*' ? a * b : a / b;
    return a;
}
