package Aston;

import java.util.stream.IntStream;

public class FizzLambda {

    public static void main(String[] args) {
        FizzBuzz();

    }

    private static void FizzBuzz() {
        //        IntStream fizzStream = IntStream.range(1, 101);
        //        fizzStream.mapToObj(f -> f%3 ==0 ? (f%5 ==0 ? "FizzBuzz":"Fizz") : (f%5 ==0) ? "Buzz": f).forEach(System.out::println);

        IntStream buzzStream = IntStream.range(1, 101);
        buzzStream.mapToObj(f -> f%3 ==0 && f%5==0 ? "FizzBuzz" :
                f%3==0 ? "Fizz" :
                        f%5==0 ? "Buzz" :
                                f)
                .forEach(System.out::println);
    }
}
