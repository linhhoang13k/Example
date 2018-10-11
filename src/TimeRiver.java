package evg.codefights.core;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;
import java.util.stream.*;

public class TimeRiver {

    public static void main(String[] args) {
        System.out.println(new TimeRiver().holiday(3, "Wednesday", "November", 2016));
        System.out.println(new TimeRiver().holiday(5, "Thursday", "November", 2016));
    }

    boolean validTime(String time) {
        String[] s = time.split(":");
        int hours = Integer.parseInt(s[0]);
        int minutes = Integer.parseInt(s[1]);
        return hours >= 0 && hours < 24 && minutes >= 0 && minutes < 60;
    }

    int[] videoPart(String part, String total) {
        String[] s = part.split(":");
        String[] t = total.split(":");

        int sumPart = Integer.parseInt(s[0]) * 60 * 60 + Integer.parseInt(s[1]) * 60 + Integer.parseInt(s[2]);
        int sumTot = Integer.parseInt(t[0]) * 60 * 60 + Integer.parseInt(t[1]) * 60 + Integer.parseInt(t[2]);
        int gcd = gcd(sumPart, sumTot);

        return new int[]{sumPart / gcd, sumTot / gcd};
    }

    int gcd(int a, int b) {
        int t;
        while (b != 0) {
            t = a;
            a = b;
            b = t % b;
        }
        return a;
    }

    int dayOfWeek(String birthdayDate) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy");
        LocalDate parse = LocalDate.parse(birthdayDate, formatter);
        String str = birthdayDate.substring(0, birthdayDate.length() - 4);
        int year = parse.getYear();
        DayOfWeek dayOfWeek = parse.getDayOfWeek();
        boolean leapYear = parse.isLeapYear() && parse.getMonthValue() == 2 && parse.getDayOfMonth() == 29;
        int res = 0;
        while (true) {
            int add = leapYear ? 4 : 1;
            parse = LocalDate.parse(str + (year + res + add), formatter);
            if (dayOfWeek == parse.getDayOfWeek()) {
                return res + add;
            }
            res += add;
        }
    }

    String curiousClock(String someTime, String leavingTime) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm");
        LocalDateTime date1 = LocalDateTime.parse(someTime, formatter);
        LocalDateTime date2 = LocalDateTime.parse(leavingTime, formatter);
        Duration duration = Duration.between(date2, date1);
        LocalDateTime res = date1.plus(duration);
        return formatter.format(res);
    }

    int newYearCelebrations(String takeOffTime, int[] minutes) {
        int h1 = Integer.parseInt(takeOffTime.substring(0, 2));
        int hours = h1 != 0 ? h1 : 24;
        int min = Integer.parseInt(takeOffTime.substring(3));
        int timeInMin = hours * 60 + min;
        int dayInMin = 60 * 24;
        int result = 0;
        int i = 0;
        while (i < minutes.length) {
            int stopTime = timeInMin + (i == 0 ? minutes[i] : minutes[i] - minutes[i - 1]);
            if (timeInMin <= dayInMin && stopTime >= dayInMin) {
                result++;
            }
            timeInMin = stopTime - 60;
            i++;
        }
        return timeInMin <= dayInMin ? result + 1 : result;
    }

    String regularMonths(String currMonth) {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MM-yyyy");
        LocalDate date = LocalDate.parse("01-" + currMonth, formatter);
        while (true) {
            date = date.plusMonths(1);
            if (date.getDayOfWeek() == DayOfWeek.MONDAY) {
                return String.format("%tm-%tY", date, date);
            }
        }
    }

    int missedClasses(int year, int[] daysOfTheWeek, String[] holidays) {
        Set<Integer> set = IntStream.of(daysOfTheWeek).boxed().collect(Collectors.toSet());
        int result = 0;
        for (String s: holidays) {
            int month = Integer.parseInt(s.substring(0, 2));
            int day = Integer.parseInt(s.substring(3));
            int y = year;
            if (month < 9) {
                y++;
            }
            LocalDate date = LocalDate.of(y, month, day);
            if (set.contains(date.getDayOfWeek().getValue())) {
                result++;
            }
        }
        return result;
    }

    int holiday(int x, String weekDay, String month, int yearNumber) {
        List<String> months = Stream.of("", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December").collect(Collectors.toList());
        List<String> days = Stream.of("", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday", "Sunday").collect(Collectors.toList());
        int day = days.indexOf(weekDay);
        int mon = months.indexOf(month);

        LocalDate date = LocalDate.of(yearNumber, mon, 1);
        DayOfWeek dayOfWeek = date.getDayOfWeek();
        int addDays = (day + 7 - dayOfWeek.getValue()) % 7;
        date = date.plusDays(addDays);
        int curMonth = date.getMonthValue();
        int i = 1;
        while (curMonth == date.getMonthValue() && i <= x) {
            if (i == x) {
                return date.getDayOfMonth();
            }
            i++;
            date = date.plusWeeks(1);
        }
        return -1;
    }

}
