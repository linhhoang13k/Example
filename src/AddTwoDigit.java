/*
    1116 CodeFight Arcade
    You are given a two-digit integer n. Return the sum of its digits.
    Example
    For n = 29, the output should be
    addTwoDigits(n) = 11.
    Input/Output
    •   [time limit] 3000ms (java)
    •   [input] integer n
    A positive two-digit integer.
    Constraints:
    10 ≤ n ≤ 99.
    •   [output] integer
    The sum of the first and second digits of the input number.
*/

//  Solution

/*
    현업에서 만든 함수라면 일단 보호절로 숫자가 아닌 경우(48~57번 테이블에 대응하는 숫자가 안보임) 이를 막아주는 보호절이 필요하다.
    If(each < 48 && each > 57) return assert();
    이렇게 막아주는 보호절이 필요하다.
*/
int addTwoDigits(int n) {
    int result = 0;
    char[] charArr;
    String argTemp;
    // int를 읽어들여서 스트링으로 바꿔주는 함수 String.ValueOf(int arg)
    argTemp = String.valueOf(n);
    // String을 읽어들여서 Char[]로 바꿔주는 함수 String.toCharArray()
    charArr = argTemp.toCharArray();
    
    for (char each : charArr)
        result += (int) (each - 48);
    // 숫자는 48번이 0이고, 9는 57번이다. 기억하자.
    return result;
}

/*
    사실 함수 이름에서 알 수 있듯이 입력값이 10 =< n =< 99로 정의되기 때문에 
    무조건 두자리인 경우만 생각한다면 한 줄로 끝낼수 있는 문제다.

    10으로 나눈 몫과 10으로 나눈 나머지를 더하면, 두자리 자연수를 입력받는
    조건하에 다음은 언제나 참이다. 
*/
int addTwoDigits(int n) {
    return n/10 + n%10;
}