boolean coolString(String s) {
    int x = 0, y =0;
    for( int i = 0; i < s.length(); ++i ) {
        if( Character.isLowerCase(s.charAt(i))) {
            ++x;
            y = 0;
        }
        else if( Character.isUpperCase(s.charAt(i))) {
            y++;
            x = 0;
        }
        else return false;
        
        if( x == 2 || y == 2 ) return false;
        
    }
    
    return true;
}

/*
Let's call a string cool if it is formed only by Latin letters and no two lowercase 
and no two uppercase letters are in adjacent positions. Given a string, check if it is cool.

For inputString = "aQwFdA", the output should be
coolString(inputString) = true;
For inputString = "aAA", the output should be
coolString(inputString) = false;
For inputString = "q q", the output should be
coolString(inputString) = false.
*/
