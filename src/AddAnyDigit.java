/*
	다빈이형과 내 풀이를 조합해서 이론상 몇 자리수가 들어오더라도 
	각각의 숫자를 더해 내놓는 함수를 작성해 보았다.
	스트링을 1번만 사용하기는 하지만 분명히 스트링을 사용하지 않아도
	함수를 작성할 수 있는 어떤 방법이 있을 것이다.
	그걸 찾아야한다.  
*/

public static int addAnyDigit (int n){
	int result = 0;
	int digitLength = String(n).length();

	for (int i=0; i<digitLength; i++) {
		result += n/(int)Math.pow(10 , digitLength-i-1)
	}
	result += n%10;

	return result;
}
