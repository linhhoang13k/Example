class ArrangingCoins {
    public int arrangeCoins(int n) {
        int count = 0;
        int index = 0;
        while(n>0){
            index++;
            if(n>=index){
            n = n-index;
                count++;
            }else{
                return count;
            }
            
        }
        return count;
    }
}