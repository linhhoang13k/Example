boolean regularBracketSequence1(String s) {
    int avg = 0;
    for(int i=0;i<sequence.length();i++){
        if(sequence.charAt(i)== '('){
            avg++;
        }else if(sequence.charAt(i)== ')'){
            avg--;
        }
        if(diff<0){
            return false;
        }
    }
    return avg == 0;
}
/*
For a string consisting of only '('s and ')'s, determine if it is a regular bracket sequence or not.

For sequence = "()()", the output should be
regularBracketSequence1(sequence) = true.

We could insert (1 + 2) * (2 + 4) which is a valid arithmetic expression, so the answer is true.
*/
