package interviewpractice.commonTechniquesBasic;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * @author benmakusha
 */
public class ProductExceptSelfTest {

    private ProductExceptSelf product = new ProductExceptSelf();

    private int[] inputArray = new int[] {1, 2, 3, 4};
    private int modulo = 12;
    private int[] inputArray2 = new int[] {52, 40, 2, 78, 49, 70, 39, 26,
            58, 58, 52, 93, 80, 64, 33, 72, 29, 17, 81, 83, 48, 9, 49, 82,
            67, 76, 54, 64, 6, 48, 16, 82, 67, 56, 32, 98, 14, 47, 48, 26,
            56, 54, 80, 13, 32, 18, 4, 73, 45, 65};
    private int modulo2 = 530;

    @Test
    public void testProductExceptSelf() {
        int result = product.productExceptSelf(inputArray, modulo);
        assertEquals(2, result);
    }

    @Test
    public void testProductExceptSelfTwo() {
        int result = product.productExceptSelf(inputArray2, modulo2);
        assertEquals(220, result);
    }
}