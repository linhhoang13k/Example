/*
One night you go for a ride on your motorcycle. At 00:00 you start your engine, and the built-in timer automatically begins counting the length of your ride, in minutes. Off you go to explore the neighborhood.

When you finally decide to head back, you realize there's a chance the bridges on your route home are up, leaving you stranded! Unfortunately, you don't have your watch on you and don't know what time it is. All you know thanks to the bike's timer is that n minutes have passed since 00:00.

Using the bike's timer, calculate the current time. Return an answer as the sum of digits that the digital timer in the format hh:mm would show.

Example

    For n = 240, the output should be
    lateRide(n) = 4.

    Since 240 minutes have passed, the current time is 04:00. The digits sum up to 0 + 4 + 0 + 0 = 4, which is the answer.

    For n = 808, the output should be
    lateRide(n) = 14.

    808 minutes mean that it's 13:28 now, so the answer should be 1 + 3 + 2 + 8 = 14.

Input/Output

    [time limit] 3000ms (java)

    [input] integer n

    The duration of your ride, in minutes. It is guaranteed that you've been riding for less than a day (24 hours).

    Constraints:
    0 ≤ n < 60 · 24.

    [output] integer

    The sum of the digits the digital timer would show.


*/

/*
	사실 addTwoDigit하고 똑같은 문제 였는데 아스키 테이블을 고려해줘야 한다는 사실을 까먹어서 오래 걸렸다.

	시간은 n을 60으로 나눈 몫이고 분은 n을 60으로 나누고 남은 나머지다.
	두개를 나란히 이어서 문자열로 만들고,
	char[]로 캐스팅해서 한개씩 떼어다가 더해주면 답이 나온다.
*/

int lateRide(int n) {
    int result = 0;
    String timeStamp = n/60 + "" + n%60 + "";
    char[] temp = timeStamp.toCharArray();
    
    // 아스키 테이블에 유의하라
    for(char each : temp)
        result += (int) (each - 48);
    
    return result;
}

// 이것도 맨 앞의 1번 문제와 비슷한 패턴이라는 사실을 알 수 있다.
// 문제에서 제공하는 타임스탬프는 항상 시간도 2자리
// 분을 나타내는 자리도 2자리 이 두개의 숫자덩어리가 합쳐진 형태를 취한다. 

// 제공하는 int n을 가지고 시간과 분에 맞게 조작한다면 올바른 결과를 얻을 수 있다.
int lateRide(int n) {
    return n/60/10 + n/60%10 + n%60/10 + n%60%10;
}