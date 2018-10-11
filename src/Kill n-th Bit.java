int killKthBit(int n, int k) {
  return tooglebinarywise(n, k) ;
}

//There is an Error in this which will let it fail one test.
//Doing it BitWise is faster and more effiecent, this was just
//a different approach i wanted to try and which works
int decodewithString(int n, int k){
  if (k>=n)
      return 0;
  if ((n==1 && k== 1) || (n==2 && k==2))
      return 0;
    
  //Convert Integer to String and make it an Array
  String s = Integer.toString(n,2);
  String[] binary = s.split("");

  //Start from the end and move K-Steps to the Start
  //Reverse Moving since Bits start from the right to left
  //Set the k-bit from right to left to 0;
  for(int i = binary.length-1; i > 0; i--){
   k--;
   if(k==0){
    binary[i] = "0";
   }   
  }
   
  //Clear String and get Values from ArrayString
  //parse the String in a Integer of Type Binary
  s = "";
  for(int i = 0;i < binary.length; i++){
    s+= binary[i];  
  }
  n = Integer.parseInt(s, 2);

  return n;
}

int tooglebinarywise(int n, int k) {
 return n ^ (1<<k-1);  
}

int unsetbinarywise(int n, int k){
  return n & ~(1<<k-1);  
}
