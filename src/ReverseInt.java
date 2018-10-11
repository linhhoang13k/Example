int reverse(int x) {
    int remainder, reversed_number=0, new_number;
    
    while(x!=0)
    {
        remainder = x%10;
        new_number= reversed_number*10 +remainder;
        if((new_number-remainder)/10 != reversed_number)
          {
              return 0;
          }
          reversed_number = new_number;
        x=x/10;
    }
    printf("Reversed Number is %d", reversed_number);
    return reversed_number;
}