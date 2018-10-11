/* Code Fights: Google
You have two integer arrays, a and b, and an integer target value v. Determine whether there is a pair of numbers, where one number is taken from a and the other from b, that can be added together to get a sum of v. Return true if such a pair exists, otherwise return false.
*/

boolean sumOfTwo(int[] a, int[] b, int v) {
 
  HashSet hs = new HashSet();
  for(int i=0; i<b.length; i++){
    hs.add(b[i]);
  }
  for(int i=0; i<a.length; i++){
    if(hs.contains(v-a[i])){
      return true;
    }
  }
  return false;
}
