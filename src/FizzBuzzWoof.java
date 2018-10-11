package Other;

public class FizzBuzzWoof {

    public static void main(String[] args) {
        FizzBuzzWoof(1000);
    }

    private static void FizzBuzzWoof(int n) {
        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();
            if(i%3 == 0) {
                sb.append("Fizz");
            }
            if(i%5 == 0) {
                sb.append("Buzz");
            }
            if(i%7 == 0) {
                sb.append("Woof");
            }
            if(i%3 != 0 && i%5 != 0 && i%7 != 0) {
                sb.append(i);
            }
            System.out.println(sb.toString());
        }
    }
}
