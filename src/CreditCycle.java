package codefights;

import java.util.Date;

/**
 * @author daniel.bubenheim@gmail.com
 */
public class CreditCycle {


    static java.time.LocalDate l,k;

    public static int creditCycle(int y, int m, int d, int c) {

//        System.err.println("input: " + year + ", " + month + ", " + day + ", " + cycleDay   );
//        java.time.LocalDate l = java.time.LocalDate.of(year, month, day);
//        System.err.println("start: " + l);
//        if (cycleDay < day) {
//            java.time.LocalDate k = l.plusDays(day - cycleDay);
//            System.err.println("end: " + k);
//            return java.time.temporal.ChronoUnit.DAYS.between(l, k);
//        }
//        final LocalDate x = l.minusMonths(1).plusDays(cycleDay - day);
//        System.err.println("end: " + x);
//        return java.time.temporal.ChronoUnit.DAYS.between(x, l);

//        l = java.time.LocalDate.of(y, m, d);
//        k = (c < d) ? l.plusDays(d - c) : l.minusMonths(1).plusDays(c - d);
//        return Math.abs(java.time.temporal.ChronoUnit.DAYS.between(k, l));




        return new Date(4,m-1,d-c).getDate();

    }
}
