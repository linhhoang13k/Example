boolean rightTriangle(int[] s) {
  Arrays.sort(s);
  return s[0]*s[0]+s[1]*s[1] == s[2]*s[2];
}

/*
For a given triangle determine if it is a right triangle.

Note : A triangle is called right if it has a right (i.e. 90 degrees) angle.

For sides = [3, 5, 4], the output should be
rightTriangle(sides) = true.
*/
