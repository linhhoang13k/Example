// https://codefights.com/challenge/6PwhS4Nm9iBjSW2oM/solutions/6nr3D5CKpodGLAceK
int StickOrChopsticks(String thing, int n) {
    if(thing.startsWith("s")) {
        if((n % 2 == 0) == false) {
        n = -1;
        }
        else {
            n = n / 2;
        }
    }
    else {
        n = n * 2;
    }
    return n;
}
