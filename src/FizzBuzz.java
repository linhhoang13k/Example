package Other;

public class FizzBuzz {
    public static void main(String[] args) {
        int max = 100;
        fizzBuzz(100);
    }
    private static void fizzBuzz(int max){

        for (int i = 0; i < max ; i++) {
            if (i % 15 == 0) {
                System.out.println("FizzBuzz");
            } else if (i%3 == 0) {
                System.out.println("Buzz");
            } else if (i%5 == 0) {
                System.out.println("Fizz");
            } else
                System.out.println(i);
        }
    }
}

