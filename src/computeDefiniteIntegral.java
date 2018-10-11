double computeDefiniteIntegral(int l, int r, int[] p) {
    double result = 0.0;
    double num = l;
    double num2 = r;
    for (int i = 0; i < p.length; i++) {
        result += p[i] * (num2 - num) / (i + 1);
        num *= l;
        num2 *= r;
    }
    return result;
}

/*
Given integers l and r, and a polynomial f(x) = P[0] + P[1] * x + P[2] * x2 + ..., 
find the value of definite integral of f(x) over the interval [l, r].

For l = -1, r = 2 and p = [0, 0, 0, 1], the output should be
computeDefiniteIntegral(l, r, p) = 3.75.
f(x) = x3, so its indefenite integral is x4/4. Thus, the answer is 24/4 - (-1)4/4 = 3.75.
*/
