/*
Given a year, return the century it is in. The first century spans from the year 1 up to and including the year 100, 
the second - from the year 101 up to and including the year 200, etc.
*/

int centuryFromYear(int year) {
    int remainder = year % 100;
    int century = year / 100;
    
    if (remainder == 0) {
        return century;
    }
    else if (remainder <= 100) {
        return century + 1;
    }
    return 1;
}
