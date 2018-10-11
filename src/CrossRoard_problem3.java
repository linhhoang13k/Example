/**
Consider an arithmetic expression of the form A#B=C. Check whether it is possible to replace # 
with one of the four signs: +, -, * or / to obtain a correct expression.
**/
bool arithmeticExpression(int A, int B, int C) {
if((A+B == C) || (A-B == C) || (A*B == C) || A%B == 0 ) return true;
return false;
}