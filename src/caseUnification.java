String caseUnification(String s) {
    char[] ch = s.toCharArray();
    int count = 0;
    for(int i = 0 ; i < ch.length ; i++){
        if(Character.isLowerCase(ch[i])) count++;
        if(Character.isUpperCase(ch[i])) count--;
    }
    if(count < 0) return s.toUpperCase();
    else return s.toLowerCase();
}

/*
Given an initial string, switch case of the minimal possible number of letters 
to make the whole string written in the upper case or in the lower case.

For inputString = "Aba", the output should be
caseUnification(inputString) = "aba";
For inputString = "ABa", the output should be
caseUnification(inputString) = "ABA".

= > https://codefights.com/tournaments/gp4iidZELqnn6cjLy/I
*/
