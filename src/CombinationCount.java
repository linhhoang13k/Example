int combinationCount(int[] array1, int[] array2, int[] array3) {

   Arrays.sort(array1);
   Arrays.sort(array2);
   Arrays.sort(array3);
   int length = array1.length;
   int counts = 0; 

   for(int first = 0; first < length; first++){
      int currentFirstElement = array1[first];
      int indexToStartInSecond = getIndex(array2,currentFirstElement);
      if(indexToStartInSecond == -1){
          break;
      }
      for(int second = indexToStartInSecond; second < length; second++){
          int currentSecondElement = array2[second];
          int indexToStartInThird = getIndex(array3, currentSecondElement);
          if(indexToStartInThird == -1){
              break;
          }
          counts += length - indexToStartInThird;
      }
       
   }
    
   
   return counts;
   
}

    public static int binarySearch(int[] arr, int  lowerBoundNum){
        int length = arr.length;
        int first = 0;
        int last = arr.length -1;
        int middle =  (first+last)/2;
        while( first <= last){
            if(arr[middle] >= lowerBoundNum){
               last = middle - 1;
            }
            else if(arr[middle] < lowerBoundNum){
                first = middle + 1;
            }
            middle = (first + last)/2;
        }

       return middle;
    }


    public static int givenIndexToSearch(int[] arr, int indexToStart, int bound){
        int indextoreturn = -1;
        while(indexToStart < arr.length && arr[indexToStart] <= bound){
            indexToStart++;
        }
        if(indextoreturn == arr.length){
            return indexToStart - 1;
        }
        return indexToStart;
    }

	
public static int getIndex(int arr[], int currentElementArray){
    if(arr[arr.length-1] <= currentElementArray){
        return -1;
    }
    return givenIndexToSearch(arr, binarySearch(arr, currentElementArray), currentElementArray);
}