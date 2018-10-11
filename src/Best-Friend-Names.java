/**   
 *  One of your friends noticed that you could enumerate the alphabet and sum the letters of your name to get a number.
 *  For example, if your name is Diego, your number would be 4 + 9 + 5 + 7 + 15 = 40.
 *  She also notices that most names have different numbers, but there are some names that have the same sum, like Bob and Dan. Your friend is convinced that if two people have the same same sum, they are destined to be best friends.
 *  Now, your friend doesn't like adding too much, and has asked you to write a function that takes two names and tells if they are destined to be best friends or not.
 *  Note that names can contain spaces, that should be ignored.
 * 
 *  Example
 *  For name1 = "Bob" and name2 = "Dan", the output should be
 *  bestFriendNames(name1, name2) = true.
 *
 *  Input/Output
 *
 *  [time limit] 3000ms (java)
 *  
 *  [input] string name1
 *  
 *  Name of the first person.
 *
 *  Guaranteed constraints:
 *  1 ≤ name1.length ≤ 1000.
 *  
 *  [input] string name2
 *
 *  Name of the second person.
 *  
 *  Guaranteed constraints:
 *  1 ≤ name2.length ≤ 1000.
 *  
 *  [output] boolean
 *
 *  True if both names have the same sum, false otherwise.
 */

boolean bestFriendNames(String name1, String name2) {
    return calculateNumber(cleanString(name1)) == calculateNumber(cleanString(name2))? true : false;
}

String cleanString(String s) {
    return s.toLowerCase().trim().replace(" ", "");
}

int calculateNumber(String s) {
    int n = 0;
    for(int i = 0; i < s.length(); i++)
        n += (int) s.charAt(i) - 96;
    return n;
}

/**
 *  32/32
 *  All tests passed
 *  Sample tests: 16/16
 *  Hidden tests: 16/16
 *  Score: 300/300
 **/