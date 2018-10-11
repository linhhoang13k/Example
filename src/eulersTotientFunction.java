package codefights;

/**
 * @author daniel.bubenheim@gmail.com
 */
public class EulersTotientFunction {

    public static void main(final String[] args) {
        eulersTotientFunction(1);
        eulersTotientFunction(2);
        eulersTotientFunction(3);
        eulersTotientFunction(4);
        eulersTotientFunction(5);
        eulersTotientFunction(6);
        eulersTotientFunction(7);
        eulersTotientFunction(8);
        eulersTotientFunction(9);
        eulersTotientFunction(10);
        eulersTotientFunction(11);
        eulersTotientFunction(12);
        eulersTotientFunction(13);
        eulersTotientFunction(14);
        eulersTotientFunction(15);
    }

    public static int eulersTotientFunction(int n) {
        StringBuilder sb = new StringBuilder();
        sb.append("n: ");
        sb.append(n);
        sb.append(", ");
        int divisor = 2;
        int result = n;

        while (divisor * divisor <= n) {
            if (n % divisor == 0) {
                while (n % divisor == 0) {
                    n /= divisor;
                }
                result -= result / divisor;
            }
            divisor++;
        }

        sb.append("result: ");
        sb.append(result);
        sb.append(", ");
        sb.append("n (end): ");
        sb.append(n);
        sb.append(", ");
        sb.append("divisor: ");
        sb.append(divisor);
        sb.append(", ");
        if (n > 1) {
            result -= n > 5 ? n / divisor - 1 : n / divisor;
            //result < 4 ? divisor - (result % divisor) : 1;
            //result < 4 ?  -1 : result % 2 == 0 ? 3 : 1;
        }
        sb.append("final: ");
        sb.append(result);
        sb.append("\n");
        System.out.println(sb.toString());

//        sb.
//
//        List<String> l = new ArrayList<>();
//        l.toArray(new String[]{});

        return result;
    }
}
