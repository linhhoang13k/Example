package Arcade_Intro;

public class _56_digitsProduct {
    int digitsProduct(int product) {
        if(product == 0) return 10;
       if(product < 10) return product;

       String solution = "";
       for(int i = 9; i > 1; i--){
           while(product % i == 0) {
               product /= i;
               solution = (char)('0' + i) + solution;
           }
       }
       return product == 1 ? Integer.parseInt(solution) : -1;
    }
}
