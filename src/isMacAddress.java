import java.io.*;

class myCode
{
    public static void main (String[] args) throws java.lang.Exception
    {
        isMAC48Address("not a MAC-48 address");
    }
    
    public static boolean isMAC48Address(String inputString) {
        if(!checkSixGroups(inputString))
            System.out.println("failed!");
        return true;
    }
    
    
     public static boolean checkSixGroups(String inputString){
         if(inputString.length()!=17)
             return false;
         for(int i=0; i<5;i++){
         if(inputString.indexOf("-")!=2 )
             return false;
            if(!CheckHexadecimal(inputString.substring(0,inputString.indexOf("-"))))
                return false;
         inputString=inputString.substring(inputString.indexOf("-")+1,inputString.length());
             
         }
         if(!CheckHexadecimal(inputString))
                return false;
         return true;
     }
    
    
    public static boolean CheckHexadecimal(String input){
        if(input.length()!=2)
             return false;
        String hexdecimalIntoString= "0123456789abcdefABCDEF";
        
        if( hexdecimalIntoString.indexOf(input.substring(0,1)) ==-1 ||
           hexdecimalIntoString.indexOf(input.substring(1,2))==-1 )
            return false;
        return true;
    }
    
}