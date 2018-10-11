int phoneCall(int min1, int min2_10, int min11, int s) {
    if(s-min1>=0){
        int firstMin = s-min1;
        if(firstMin-(9*min2_10)>=0){
            int secondMin = firstMin-(9*min2_10);
            if(secondMin-min11>=0){
                int thirdMin = secondMin/min11;
                return 10 + thirdMin;
            }else
                return 10;
        }else 
            return firstMin/min2_10+1;
    }else
        return 0;
}
