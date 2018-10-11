/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication1;

/**
 *
 * @author BigBoss
 */
public class JavaApplication1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {       
        long startTime = System.currentTimeMillis();
        long endTime = System.currentTimeMillis();
        long duration = (endTime - startTime);         
        System.out.print("\n And this is the Time it took to calculate in s: " + duration + "\n");
    }    
}
