/*
Note: Write a solution with O(n) time complexity and O(1) additional space complexity, since this is what you would be asked to do during a real interview.

Given an array a that contains only numbers in the range from 1 to a.length, find the first duplicate number for which the second occurrence has the minimal index. In other words, if there are more than 1 duplicated numbers, return the number for which the second occurrence has a smaller index than the second occurrence of the other number does. If there are no such elements, return -1.
*/
int firstDuplicate(int[] a) {
    for(int i = 0; i < a.length; i++){
        if(a[Math.abs(a[i])-1] >= 0) a[Math.abs(a[i])-1] *=-1;
        else return Math.abs(a[i]);
    }
    return -1;
}
