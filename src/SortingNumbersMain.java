package com.sample.sortinnumbers;

public class SortingNumbersMain {
	/**
	 * There are trees between them which cannot be moved. 
	 * Your task is to rearrange the people by their heights in a non-descending order 
	 * without moving the trees 
	 */
	
	public static int[] sortPeople(int []people){
		//bubble sort implementation 
		for(int i=0;i<people.length-1;i++){
			for(int j=i+1;j<people.length;j++){
				if (people[i] > people[j] && people[i] != -1 && people[j] !=-1 ){
					people[i] = people[i] ^ people[j];
					people[j] = people[j] ^ people[i];
					people[i] = people[i] ^ people[j];
				}
			}
		}
		
		return people;
	}
	public static void main(String[] args) {
		// initialization of the array
		int []people = {-1, 150, 190, 170, -1, -1, 160, 180};
		people = sortPeople(people);
		for(int i=0; i<people.length;i++){
			System.out.println(people[i]);
		}
	}

}
