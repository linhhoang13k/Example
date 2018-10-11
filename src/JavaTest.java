/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package firstDuplicate;

/**
 *
 * @author wii64
 */
public class JavaTest {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[] arreglo = {2, 1, 3, 5, 3, 2};
        firstDuplicate(arreglo);

        
    }

    static int firstDuplicate(int[] a) {
        int result = -1;
        int lowIndex = 2147483647;
        int longitud = a.length;
        int incremento = 1;
        int numero = 0;
        int numero2 = 0;
        int j = 0;
        //short inicial = 0;
        //
        //System.out.println("Valor del arreglo: " + a.length);
        for (int i = 0; i < longitud; i++) {

            //j = i+1;
            //i += incremento;
            numero = a[i];
            //System.out.print("i:"+ i +" a[i]:"+numero);
            //System.out.println("Estoy entrando con valor en i: " + i);
            for (j = i + 1; j < longitud; j++) //while(j<longitud)
            {
                //numero = a[i];

                numero2 = a[j];
                //System.out.print("j:"+ j +" a[j]:"+numero2);
                //System.out.println("Esto tiene valor j: " + j);

                if (numero == numero2) {
                    //System.out.println("Hubo coincidencia");

                    if (j < lowIndex) {
                        //System.out.println("Entre a dar respuesta");
                        lowIndex = j; //lowindex = j ?
                        result = numero;//(short)a[j]; // correcto
                        //System.out.println("Esto vale ahora low: " + lowIndex);
                        //System.out.println("esto vale numero: " + numero);
                        //mejora par evitar el time limit exceeded on test 21
                        //no buscar ese numero más
                        break;
                    }
                    else
                        break;
                }
                //j++;
                //j= j + 1;
            }
            //i+=incremento;
        }
        //System.out.println("Esto imprimo de salida: "+result);
        return result;
    }

}
