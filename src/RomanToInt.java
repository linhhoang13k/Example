class RomanToInt {
    public int value(char r){
        switch(r){
                case 'I':
                       return 1;
                case 'V':
                    return 5;
                    
                case 'X':
                    return 10;
                    
                case 'L':
                    return 50;
                    
                case 'C':
                    return 100;
                    
                case 'D':
                    return 500;
                    
                case 'M':
                    return 1000;
                    
            default:
                return -1;
            }
    }
    public int romanToInt(String s) {
        int result = value(s.charAt(s.length()-1));
        
        for(int i=s.length()-2; i>=0; i--){
            int s1 = value(s.charAt(i));
            int s2 = value(s.charAt(i+1));
            if(s1>=s2){
                result = result+s1;
            }else{
                result = result-s1;
            }
        }
         return result;
    }
}