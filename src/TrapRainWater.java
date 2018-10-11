/*
Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.


The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped. Thanks Marcos for contributing this image!

Example:

Input: [0,1,0,2,1,0,1,3,2,1,2,1]
Output: 6
*/

class TrapRainWater {
    public int trap(int[] height) {
         int left = 0;
        int right = height.length-1;
        int sum = 0;
        while(left+1<right){
            if(height[left]<=height[left+1]) {
                left++;
                continue;
            }
            if(height[right]<=height[right-1]){
                right--;
                continue;
            }
            int bar = Math.min(height[left],height[right]);
            for(int i = left+1;i<right;i++){
                if(bar>height[i]){
                    sum+=bar-height[i];
                    height[i]=bar;
                }
            }
        }
        return sum;
    }
}