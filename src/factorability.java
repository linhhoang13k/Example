// https://codefights.com/challenge/9FF8PeFWzyAAdzrzM/solutions/hAGy6JmqBTEmsKwy3
boolean factorability(int a, int b, int c) {
    for(int i = -90; i < 90; i++) {
        for(int j = -90; j < 90; j++) {
            if(i + j == b && i * j == a * c)
                return true;
        }
    }
    return false;
}
