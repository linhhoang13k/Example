/*
Check if the given string is a correct time representation of the 24-hour clock.

Example

    For time = "13:58", the output should be
    validTime(time) = true;
    For time = "25:51", the output should be
    validTime(time) = false;
    For time = "02:76", the output should be
    validTime(time) = false.

Input/Output

    [execution time limit] 3 seconds (java)

    [input] string time

    A string representing time in HH:MM format. It is guaranteed that the first two characters, as well as the last two characters, are digits.

    [output] boolean

    true if the given representation is correct, false otherwise.
*/

boolean validTime(String time) {
    boolean isValid = true;
    int length = time.length();
    if(length != 5){
        isValid = false;
    }
    if(time.charAt(2) == ':'){
        String parts[] = time.split(":");
        if(Integer.parseInt(parts[0]) >= 24 || Integer.parseInt(parts[1]) > 59){
            isValid = false;
        }
    }
    else{
        isValid = false;
    }
    return isValid;
}

/*
// Regex Solution
boolean validTime(String time){
    return time.matches("(0[0-9]|1[0-9]|2[0-3]):([0-5][0-9])");
}
*/