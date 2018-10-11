class FindMedianSorttedArrays {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        if(nums1.length > nums2.length){
            return findMedianSortedArrays(nums2, nums1);
        }
        
        int lenX = nums1.length;
        int lenY = nums2.length;

        int low = 0;
        int high = lenX;
         int maxLeftX, maxLeftY, minRightX, minRightY;
        while(low<=high){
            int partitionX = (low+high)/2;
            int partitionY = (lenX +lenY +1)/2 - partitionX;
            
            if(partitionX == 0){
                   maxLeftX = Integer.MIN_VALUE;
            }
            else{
                   maxLeftX = nums1[partitionX -1];
            }
            
            if(partitionY == 0){
                   maxLeftY = Integer.MIN_VALUE;
            }
            else{
                   maxLeftY = nums2[partitionY -1];
            }
             if(partitionX == lenX){
                   minRightX = Integer.MAX_VALUE;
            }
            else{
                   minRightX = nums1[partitionX];
            }
            
            if(partitionY == lenY){
                   minRightY = Integer.MAX_VALUE;
            }
            else{
                   minRightY = nums2[partitionY];
            }
            
            // here is the main
            if(maxLeftX<=minRightY && maxLeftY<=minRightX){
                //correct case
                if((lenX + lenY)%2 == 0){
                    //even length
                   return ((double)Math.max(maxLeftX, maxLeftY)+Math.min(minRightX, minRightY))/2;
                }
                else{
                    //odd length
                     return (double)Math.max(maxLeftX, maxLeftY);
                }
            }
            else if(maxLeftX > minRightY){
                //move towards left in X
                high = partitionX-1;
            }
            else{
                //move towards right in x
                low = partitionX + 1;
            }
        }
        throw new IllegalArgumentException();
    }
}