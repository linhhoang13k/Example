package in.mkp.challenges;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by mkumar on 3/26/17.
 */
public class Validate {

    public static void main(String[] args) {
        Validate validate = new Validate();
        String[][] input1 = new String[][]
                {{"Visa", "4000-0799-2739-8715"},
                        {"Visa", "5000 0000 1234 5678"},
                        {"Visa", "40002847193819287"}};

        String[][] input3 = new String[][]
                {{"Totally Legit Bank", "1234-5678-9010-1110"},
                        {"Discover Card", "622126-103952-1904"}};

        String[][] input4 = new String[][] {{"MasterCard","5101-9352-1234-4448"},
                {"American Express","1234 395478 30498"},
                {"American Express","3948 29384 20390"}};

        String[][] input2 = new String[][]
                {{"JCB", "35410338613198823"},
                        {"Visa", "4981092520862764"},
                        {"Visa", "4819  4184-92350"},
                        {"Laser", "3538387202414492"},
                        {"InterPayment", "6368-10400100 2378121"},
                        {"American Efpress", "374657318671836"},
                        {"JCB", "3539 17 87 927 5 3 7 9 8"},
                        {"Vdsa", "4621524940458296152"},
                        {"American Express", "345435744657539"},
                        {"Mrestro", "5016-20-50-0-8-1-512858-8"},
                        {"JCB", "-345923400569-650"},
                        {"MasterCard", "23321101012755716"},
                        {"Maestro", "67379251529952"},
                        {"Visa", " 5209710602074850"},
                        {"InterPayment", "6369870141342883990"},
                        {"Laser", "67069491660674571"},
                        {"Maestri", "639074222143418"},
                        {"Maestro", "6641120953323"},
                        {"Maestro", "633047943612610"},
                        {"Maestro", "62868503274198"},
                        {"Visa", "4664303698335"},
                        {"Visa", "4130110778954863568"},
                        {"Visa", "42657536792531"},
                        {"American Express", "2555812846969593"},
                        {"Laser", "67097084713302237"},
                        {"JCB", "35371835440442420"},
                        {"Discover Card", "3536241805339576"},
                        {"American Express", "341897336771586"},
                        {"Laser", "5502615546700961"},
                        {"Discover Card", "64795258022225006"},
                        {"JCB", "4773342441027"},
                        {"Laser", "67064613293232406864"},
                        {"Discover Card", "6004952515759546352"}};

        System.out.println(Arrays.toString(validate.validate(input2)));
        //System.out.println(Arrays.toString(validate.validate(input2)));
    }

    boolean[] validate(String[][] listOfNumbers) {
        boolean[] r = new boolean[listOfNumbers.length];
        Map<String, CC> map = init();

        for (int i = 0; i < listOfNumbers.length; ++i) {
            String type = listOfNumbers[i][0];
            String number = replace(listOfNumbers[i][1]);
            if (!map.containsKey(type)) {
                r[i] = false;
                continue;
            }
            if (!validIIN(number)) {
                r[i] = false;
                continue;
            }
            if (!validLen(type, number, map)) {
                r[i] = false;
                continue;
            }
            if (!validStartsWith(type, number, map)) {
                r[i] = false;
                continue;
            }

            r[i] = true;
        }
        return r;
    }

    String replace(String s) {
        return s.replaceAll("-", "").replaceAll(" ", "");
    }

    boolean validIIN(String iin) {
        int len = iin.length();
        int sum = 0;
        for (int i = len - 2, j = 0; i >= 0; --i, ++j) {
            int c = (iin.charAt(i) - '0');
            if (j % 2 == 0) {
                c *= 2;
                if (c > 9) {
                    sum += c % 10;
                    c = c / 10;
                    sum += c % 10;
                }
                else {
                    sum += c;
                }
            }
            else {
                sum += c;
            }
        }
        int x = (sum * 9) % 10;
        return (x == (iin.charAt(len-1) - '0'));
    }

    boolean validStartsWith(String t, String n, Map<String, CC> map) {
        for (String s : map.keySet()) {
            if (!t.equals(s)) {
                CC cc = map.get(s);
                for (String st : cc.startsWith) {
                    if (st.length() > 1) {
                        if (n.startsWith(st)) {
                            return false;
                        }
                    }
                }
            }
        }

        CC cc = map.get(t);
        boolean f = false;
        for (String st : cc.startsWith) {
            if (n.startsWith(st)) {
                f = true;
            }
        }
        return f;

    }

    boolean validLen(String t, String n, Map<String, CC> map) {
        List<Integer> l = Arrays.asList(map.get(t).length);
        if (l.contains(Integer.valueOf(n.length()))) {
            return true;
        }
        return false;
    }

    Map<String, CC> init() {
        Map<String, CC> m = new HashMap<>();

        CC cc = new CC("Visa");
        cc.setLength(13, 16, 19);
        cc.addStartsWith("4");
        m.put(cc.name, cc);

        cc = new CC("MasterCard");
        cc.setLength(16);
        for (int i = 2221; i <= 2720; ++i) {
            cc.addStartsWith("" + i);
        }
        for (int i = 51; i <= 55; ++i) {
            cc.addStartsWith("" + i);
        }
        m.put(cc.name, cc);

        cc = new CC("Maestro");
        cc.setLength(12, 13, 14, 15, 16, 17, 18, 19);
        cc.addStartsWith("50", "56", "57", "58", "6");
        m.put(cc.name, cc);

        cc = new CC("JCB");
        cc.setLength(16);
        for (int i = 3528; i <= 3589; ++i) {
            cc.addStartsWith("" + i);
        }
        m.put(cc.name, cc);

        cc = new CC("Discover Card");
        cc.setLength(16, 19);
        for (int i = 622126; i <= 622925; ++i) {
            cc.addStartsWith("" + i);
        }
        for (int i = 644; i <= 649; ++i) {
            cc.addStartsWith("" + i);
        }
        cc.addStartsWith("" + 6011, "" + 65);
        m.put(cc.name, cc);

        cc = new CC("American Express");
        cc.setLength(15);
        cc.addStartsWith("" + 34, "" + 37);
        m.put(cc.name, cc);

        cc = new CC("Laser");
        cc.setLength(16, 17, 18, 19);
        cc.addStartsWith("" + 6304, "" + 6706, "" + 6771, "" + 6709);
        m.put(cc.name, cc);

        cc = new CC("InterPayment");
        cc.setLength(16, 17, 18, 19);
        cc.addStartsWith("" + 636);
        m.put(cc.name, cc);

        return m;
    }

    class CC {

        final List<String> startsWith = new ArrayList<>();
        String name;
        Integer[] length;

        CC(String n) {
            this.name = n;
        }

        void setLength(final Integer... len) {
            this.length = len;
        }

        void addStartsWith(final String... s) {
            Arrays.stream(s).forEach(str -> this.startsWith.add(str));
        }
    }
}
