import java.util.*;

public class TimeConversion {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String time = in.next();
        if(time.substring(8).equals("AM") && time.substring(0, 2).equals("12")){
            time = "00" + time.substring(2);
        }

        int intVal = Integer.valueOf(time.replace(":", "").substring(0, 6));
        intVal += (time.substring(8).equals("PM") && !time.substring(0, 2).equals("12") ? 120000 : 0);

        time = String.valueOf(intVal);

        while(time.length() <= 5) {
            time = "0" + time;
        }

        System.out.println(time.substring(0, 2) + ":" + time.substring(2, 4) + ":" + time.substring(4));


    }
}
