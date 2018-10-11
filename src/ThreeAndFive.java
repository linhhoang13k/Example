package Aston;

public class ThreeAndFive {

//    For 1-100 inclusive, write an algorithm that will print out a String equation of the sum
//    of all numbers disivible by 3 & 5
//    i.e  "3+5+... +100=2418"

    public static void main(String[] args) {
        System.out.println(solution(100));
        }
    public static String solution (int number) {
        StringBuilder sb = new StringBuilder();
        int sum = 0;

        for (int i=1; i<=number; i++) {
            if (i%3==0 || i%5==0) {
                sum+=i;
            sb.append("+").append(i);
            } }
        sb.deleteCharAt(0);
        sb.append("=").append(sum);
            return sb.toString();
        }
    }




