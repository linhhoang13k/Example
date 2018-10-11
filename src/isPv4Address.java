/*isPv4Address.java
 *codefights
 *Arcade
 *Introduction
 *Island of Knowledge
 *#21
 *Created by Ian Feekes December 6th 2017
 */

/*Note this code could be made a lot more elegant had I simply used ascii code. You can see my rediculous nested if statement that could have been solved with one condition if I just converted char c to an integer and then used < > operands to condense the statement. Nonetheless it doesn't hurt the run time too much, it's just bad coding practice. I've learned my lesson and if you are using my code as reference for solving codefights then I recommend you don't make my mistakes too. */ 

boolean isIPv4Address(String inputString)
{
    if((inputString.length()>15)||(inputString.length()<7))return false;
    if((inputString.charAt(0)=='.')||(inputString.charAt(inputString.length()-1)=='.'))
    {
        System.out.println("Dot at incorrect place");
        return false;
    }
    int[] num1 = {-1,-1,-1};//new int(-1,-1,-1);
    int[] num2 = {-1,-1,-1}; //new int(-1,-1,-1);
    int[] num3 = {-1,-1,-1};//new int(-1,-1,-1);
    int[] num4 = {-1,-1,-1};
    int index = 0;
    int index1 = 0;
    int index2 = 0;
    int index3 = 0;
    int numDots = 0;
    for(int i=0; i<inputString.length();i++)
    {
        if(doesNotMeetSpecs(inputString.charAt(i))) 
        {
            System.out.println(i);
            System.out.println(inputString.charAt(i));
            System.out.println("bug");
            return false; 
        }
        if(inputString.charAt(i)=='.')
        { 
            numDots++;
        }
        else if(numDots==0)
        {
            if(index>2) return false; 
             num1[index]=Character.getNumericValue(inputString.charAt(i));
             index++; 
        }
        else if(numDots==1)
        {
            if(index1>2) return false; 
            num2[index1]=Character.getNumericValue(inputString.charAt(i));
            index1++;
        }
        else if(numDots==2)
        {
            if(index2>2) return false; 
            num3[index2]=Character.getNumericValue(inputString.charAt(i));
            index2++;
        }
        else if(numDots==3)
        {
            if(index3>2) return false; 
            num4[index3]=Character.getNumericValue(inputString.charAt(i));
            index3++;
        }
    }
    int val1 = processDigits(num1);
    int val2 = processDigits(num2);
    int val3 = processDigits(num3);
    int val4 = processDigits(num4);
    if((val1>255)||(val1<0)) return false;
    if((val2>255)||(val2<0)) 
    {
        System.out.println("val2 doesn't work");
        return false;
    }
    if((val3>255)||(val3<0)) return false;
    if((val4>255)||(val4<0)) return false;
    for(int i=0; i<3; i++)
    {
        System.out.print(num1[i]+" ");
    }
    System.out.println();
    for(int i=0; i<3; i++)
    {
        System.out.print(num2[i]+" ");
    }
    System.out.println();
    for(int i=0; i<3; i++)
    {
        System.out.print(num3[i]+" ");
    }
    System.out.println();
    for(int i=0; i<3; i++)
    {
        System.out.print(num4[i]+" ");
    }
    System.out.println();
    if((index==0)||(index1==0)||(index2==0)||(index3==0)||(index==0)) return false; 
    System.out.println("processed val of 1, 2, 3, 4 respectively "+val1+" "+val2+" "+val3+" "+val4);
    if(numDots>3) return false; 
    return true; 
}

int processDigits(int[] arr)
{
    int totalVal = 0;
    int digitHolder = 1;
    for(int i=arr.length-1;i>=0;i--)
    {
        if(arr[i]>=0)
        {
            totalVal+=arr[i]*digitHolder;
            digitHolder*=10;
        }
    }
    return totalVal;
}

boolean doesNotMeetSpecs(char c)
{
    if(c!='1')
        if(c!='2')
            if(c!='3')
                if(c!='4')
                    if(c!='5')
                        if(c!='6')
                            if(c!='7')
                                if(c!='8')
                                    if(c!='9')
                                        if(c!='0')
                                            if(c!='.') return true;
    return false; 
}


