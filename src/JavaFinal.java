/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rotateImage;

/**
 *
 * @author wii64
 */
public class JavaFinal {
    public static void main(String arg[]){
        int[][] a = {{1,2,3},{4,5,6},{7,8,9}};//[[1,2,3],[4,5,6],[7,8,9]];
        
        //System.out.println(a[0][1]);
        RotateImage ri = new RotateImage();
        ri.rotateImage(a);
    }
}
