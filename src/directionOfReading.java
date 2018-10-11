int[] directionOfReading(int[] numbers) {
    int[] num = new int[numbers.length];
    for(int i = 0; i < numbers.length ; i++){
        int dir = numbers[i];
        for(int j = numbers.length-1; j >= 0 ;j--){
            int mod = dir % 10;
            num[j] =  (num[j] * 10) + mod;    
            dir /= 10;
        }
    }
    return num;
}


https://codefights.com/tournaments/YhjNaLgZjXdQF7XY2/E
