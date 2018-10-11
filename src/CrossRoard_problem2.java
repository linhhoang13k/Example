/**
Given integers a and b, determine whether the following pseudocode results in an infinite loop

while a is not equal to b do
  increase a by 1
  decrease b by 1
Assume that the program is executed on a virtual machine which can store arbitrary long numbers and execute forever.
**/



boolean isInfiniteProcess(int a, int b) {
    if(a==b) return false;
while(a != b && b>=0){
                  a++;
                  b--;
                if(a==b) return false;
        } 
                
            return true;
}
