/*
Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

Note:

The number of elements initialized in nums1 and nums2 are m and n respectively.
You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
Example:

Input:
nums1 = [1,2,3,0,0,0], m = 3
nums2 = [2,5,6],       n = 3

Output: [1,2,2,3,5,6]
*/

class SortedMerge {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int indexA = m-1;
        int indexB = n-1;
        int mergedIndex = m+n-1;
        
        while(indexB>=0){
            if(indexA>=0 && nums1[indexA]> nums2[indexB]){
                nums1[mergedIndex] = nums1[indexA];
                indexA--;
            }else{
                nums1[mergedIndex] = nums2[indexB];
                indexB--;
            }
            mergedIndex--;
        }
    }
}