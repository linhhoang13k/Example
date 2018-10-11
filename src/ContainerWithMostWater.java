/*
The intuition behind this approach is that the area formed between the lines will always be limited by the height of the shorter line.
Further, the farther the lines, the more will be the area obtained.

We take two pointers, one at the beginning and one at the end of the array constituting the length of the lines. 
Futher, we maintain a variable maxareamaxarea to store the maximum area obtained till now. 
At every step, we find out the area formed between them, update maxareamaxarea and move the pointer pointing to the shorter line towards the other end by one step.
Complexity Analysis
Time complexity : O(n). Single pass.
Space complexity : O(1). Constant space is used.
*/
class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int res, max=0, high=height.length-1, low=0 ;
        while(low<high){
                //res = (j-i)*Math.min(height[i-1], height[j-1]);
                max = Math.max(max, (high-low)*Math.min(height[low], height[high]));
                if(height[low]<height[high]){
                    low++;
                }else{
                    high--;
                }
            }
        return max;
    }
}
