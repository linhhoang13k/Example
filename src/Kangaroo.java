// https://codefights.com/challenge/YnLdEszR6HCb2cPvT/solutions/aB3wRLZEi8YoRGRy8
int kangaroo(int A, int B, int C) {
    int largest2 = B - A;
    int largest3 = C - B;
    int largest = largest2;
    if(largest2 < largest3) {
        largest = largest3;
    }
    return largest - 1;
}
