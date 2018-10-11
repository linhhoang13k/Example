
// 사실 마지막줄은 ==  쓰면 안된다.
boolean arithmeticExpression(int A, int B, int C) {
    return (A + B == C) ? true :
           (A - B == C) ? true :
           (A * B == C) ? true :
    ((float)A / B == C) ? true : false;
    // float자료형 보다는 BigDecimal을 사용해야 한다.
}
