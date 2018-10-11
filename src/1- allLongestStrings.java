String[] allLongestStrings(String[] inputArray) {
int max = 0,n=0;

for(int i = 0; i < inputArray.length; i++){
    if(inputArray[i].length() > max){
        max = inputArray[i].length();
        n = 0;
    }
    if(inputArray[i].length() == max){
        n++;
    }
}

String [] arr = new String[n];
int j=0;
for(int i = 0; i < inputArray.length; i++){
    if(inputArray[i].length() == max){
        arr[j] = inputArray[i];
        j++;
    }
}
return arr;

}
