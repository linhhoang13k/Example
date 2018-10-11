/*Given a year,return the century it is in. 
The first century spans from the year 1 up to and including the year 100, 
the second - from the year 101 up to and including the year 200, etc.

>[time limit] 3000ms (java)
>[input] integer year
    A positive integer, designating the year.
    Guaranteed constraints:
    1 ≤ year ≤ 2005.
>[output] integer
    The number of the century the year is in.
*/


int centuryFromYear(int year) {
    int century = 0;
    if(year % 100 != 0){
        century = (year / 100) + 1;
    }
    else{
        century = year / 100;
    }
    
    return century;
}