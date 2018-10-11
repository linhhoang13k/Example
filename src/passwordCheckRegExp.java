// Don't copy And Paste Cheater
boolean passwordCheckRegExp(String inputString) {
    String pattern = "(?=.*[A-Z])(?=.*[a-z])(?=.*[0-9]).{5,}";
    return inputString.matches(pattern);
}

/*
A password is complex enough, if it meets all of the following conditions:
its length is at least 5 characters;
it contains at least one capital letter;
it contains at least one small letter;
it contains at least one digit.
Determine whether a given password is complex enough.
Example
For inputString = "my.Password123", the output should be
passwordCheck(inputString) = true;
For inputString = "my.password123", the output should be
passwordCheck(inputString) = false.
*/
