class IsPowerOfFour {
    public boolean isPowerOfFour(int num) {
      if(num==0){
            return false;
        }
        while(num%4==0){
            num=num/4;
        }
        if(num==1){
            return true;
        }
        return false;
    }   
    
}