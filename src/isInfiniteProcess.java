// 요점은 2가지
// a는 증가하고, b는 감소하는데 서로 만나려면 시작점에서 b가 a보다 커야한다.
// 작으면 무조건 무한루프

// 둘 사이의 거리가 짝수인가? 홀수인가? 이게 중요하다.
// 로직에 따르면 둘 사이의 거리는 2씩 좁혀진다. 따라서 홀수면 못 만나고 
// 짝수라면 언젠가 만나게 된다. 
boolean isInfiniteProcess(int a, int b) {
    return (a > b) ? true : ((a - b) % 2 != 0);
}
