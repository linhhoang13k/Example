int minimalNumberOfCoins(int[] coins, int price) {
    int sum = 0 , i = coins.length - 1;
    while(price != 0){
        if(price < coins[i]){
            i--;
            continue;
        }
        sum += price / coins[i];
        price = price % coins[i];
        i--;
    }
    return sum;
}
