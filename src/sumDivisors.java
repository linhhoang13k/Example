int sumDivisors(int number) {

 
    int sum=0;
    for(int i=1; i<=number; i++)
    {
        if(number%i!=0)
        {
            continue;
        }
        else
        {
        if(!isPrime(i) && number%i==0)
        {
            sum+= i;
        }
        }
    }
    return sum;
    
}


boolean isPrime(int num)
    {
        if (num < 2) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;
        for (int i = 3; i * i <= num; i += 2)
            if (num % i == 0) return false;
        return true;
    }