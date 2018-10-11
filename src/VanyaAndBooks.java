package challenge;

/**
 * Created by JavierSainz on 1/26/17.
 * Vanya got an important task — he should enumerate the books in the library and label each book with its number. Each of the n books should be assigned with a number from 1 to n. Naturally, each book should have a unique number.
 * <p>
 * Vanya wants to know how many digits he will have to write down as he labels the books. Your task is to help him!
 * <p>
 * Example
 * <p>
 * For n = 13, the output should be
 * VanyaAndBook1s(n) = 17.
 * <p>
 * The books should be labeled with numbers 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, which totals to 17 digits.
 * <p>
 * Input/Output
 * <p>
 * [time limit] 3000ms (java)
 * [input] integer n
 * <p>
 * The number of books in the library.
 * <p>
 * Constraints:
 * 1 ≤ n ≤ 10^8.
 * <p>
 * [output] integer
 * <p>
 * The number of digits that Vasya needs to write down in order to label all the books.
 */
public class VanyaAndBooks {
    int c, p = 1;

    int VanyaAndBook1s(int n) {
        for (; n >= p; p *= 10)
            c += n - p + 1;
        return c;
    }

    int VanyaAndBook1sClean(int n) {
        int count = 0;
        for (int pow = 1; pow <= n; pow *= 10) {
            count += n - pow + 1;
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(new VanyaAndBooks().VanyaAndBook1s(100));
    }


}
