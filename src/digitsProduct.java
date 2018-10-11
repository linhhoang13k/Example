package in.mkp.basic.level12;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mkumar on 3/24/17.
 */
public class DigitsProduct {

    public static void main(String[] args) {
        DigitsProduct digitsProduct = new DigitsProduct();
        System.out.println("digitsProduct.digitsProduct(450) = " + digitsProduct.digitsProduct(450));
    }

    int digitsProduct(int product) {
        final List<Integer> factors = new ArrayList<>();

        for (int i=2; i < product; ++i) {
            if ((product % i) == 0 && i < 10) {
                factors.add(i);
            }
        }

        return 0;
    }
}
