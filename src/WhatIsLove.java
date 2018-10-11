/*
This is a reverse challenge, enjoy!

Test 1
Input:
n: 4
Output:
Empty
Expected Output:
"baby"
Console Output:
Empty

nput:
n: 5
Output:
Empty
Expected Output:
"don't"
Console Output:
Empty

https://codefights.com/challenge/fH7stPgyynEgnePNy/solutions
*/

public class WhatIsLove {

  String whatIsLove(int n) {
      return new String[]{"", "what", "is", "love", "baby", "don't", "hurt", "me", "don't", "hurt", "me", "no"}[n%12];
  }

}

