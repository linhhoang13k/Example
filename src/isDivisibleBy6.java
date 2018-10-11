List isDivisibleBy6(String s) {
    List<String> l = new ArrayList();
    for(char c = 48 ; c < 58 ;c++){
        String r = s.replace('*',c);
        if(new BigInteger(r).mod(new BigInteger("6")).signum() == 0) 
            l.add(r);
    }
    return l;
}
/*
A masked number is a string that consists of digits and one asterisk (*) 
that should be replaced by exactly one digit. Given a masked number find 
all the possible options to replace the asterisk with a digit to produce an integer divisible by 6.

For inputString = "1*0", the output should be
isDivisibleBy6(inputString) = ["120", "150", "180"].
*/
