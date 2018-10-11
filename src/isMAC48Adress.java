/*isMac48Adress.java
 *codefights
 *Arcade
 *Introduction
 *Eruption of Light
 *#47
 *Created by Ian Feekes December 6th 2017
 */

boolean isMAC48Address(String inputString) 
{
    int timeForHyphen = 0;
    //I like format like this 
    if(inputString.charAt(inputString.length()-1)=='-')return false; 
    for(int i=0;i<inputString.length();i++)
    {
        timeForHyphen++;
        if(timeForHyphen%3==0)
        {
            if(inputString.charAt(i)!='-')
            {
                System.out.println("hyphen found at illegal time...returning false");
                return false;
            }
        }
        else
        {
            int makeItSimple = (int)inputString.charAt(i);
            if((makeItSimple<64)||(makeItSimple>70))
            {
                if((makeItSimple>57)||(makeItSimple<48))
                {
                    System.out.println("illegal ascii character...returning false");
                    return false;
                }
            }
        }
    }
    return true; 
}


