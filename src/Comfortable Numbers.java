int comfortableNumbers(int L, int R) {
    
    int n=0;
    int num=0;
    int sum =0;
    int border = 0;
    for(int i=L; i<=R; i++)
    {
            num = i;
            while (num > 0) {
            sum = sum + num % 10;
            num = num / 10;
        }
        
        System.out.println("I is "+i);
        System.out.println("Sum is "+sum);
        border = i+sum;
        System.out.println("border is "+border);
        sum=0;
         System.out.println(border);
        for(int j=(i+1); j<=border; j++)
        {
            
         if(j>R || j>border )
         {
             break;
         }
            System.out.print("("+i +"," );
            System.out.println(j + ")");
            n++;
            
        }
    }
  
    
    
    return n;
}
