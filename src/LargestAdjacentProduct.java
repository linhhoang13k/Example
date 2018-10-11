/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package codefightsprojects.Intro.bEdgeOfTheOcean;

/**
 * Task: Given an array of integers, find the pair of adjacent elements
 * that has the largest product and return that product.
 * @author Kepler
 */
public class LargestAdjacentProduct {
    int adjacentElementsProduct(int[] inputArray) {
        int largestProduct = inputArray[0] * inputArray[1];
        int size = inputArray.length;
        for(int j = 0; j < size; j++){
            if(inputArray[j] != inputArray[size-1]){
                if(largestProduct < (inputArray[j]*inputArray[j + 1])){
                    largestProduct = inputArray[j]*inputArray[j + 1];
                }
            }
            System.out.println(largestProduct);
        }
        return largestProduct;
    }
}
