import java.util.regex.Pattern;

public class EruptionOfLight {
    boolean isBeautifulString(String inputString) {
        int pom = Integer.MAX_VALUE;
        int sum;
        for (char a = 'a'; a <= 'z'; a++) {
            sum = 0;
            for (int o = 0; o < inputString.length(); o++) {
                if (inputString.charAt(o) == a) {
                    sum++;
                }
            }
            if (sum > pom) return false;
            pom = sum;
        }
        return true;
    }

    String findEmailDomain(String address) {
        int i = address.length() - 1;
        String s = "";
        while (address.charAt(i) != '@') {
            i--;
        }
        for (int k = i + 1; k < address.length(); k++) {
            s += address.charAt(k);
        }
        return s;
    }

    String buildPalindrome(String st) {
        int pom = 0;
        for (int i = 0; i < st.length() - 1; i++) {
            pom = i;
            if (st.charAt(i) == st.charAt(st.length() - 1)) break;
            else pom = st.length() - 1;
        }
        String c = st.substring(pom);
        for (int j = 1; j <= (c.length() - 1) / 2; j++) {
            if (c.charAt(j) != c.charAt(c.length() - 1 - j)) {
                for (int i = pom + 1; i < st.length() - 1; i++) {
                    pom = i;
                    if (st.charAt(i) == st.charAt(st.length() - 1)) break;
                    else pom = st.length() - 1;

                }
                c = st.substring(pom);
                j = 0;
            }
        }
        for (int i = pom - 1; i >= 0; i--) {
            st += st.charAt(i);
        }
        return st;
    }

    int electionsWinners(int[] votes, int k) {
        int max = Integer.MIN_VALUE;
        int id = 0;
        int tmp = k;
        int ile = 0;
        int m = 0;
        for (int i = 0; i < votes.length; i++) {
            if (votes[i] > max) {
                max = votes[i];
                id = i;
                m = 1;
            } else if (votes[i] == max) m++;
        }
        for (int i = 0; i < votes.length; i++) {
            if (i != id) {
                k = k - (max - votes[i] - 1);
                if (votes[i] + tmp > max) ile++;
            }
        }
        if (m > 1 && tmp > 0 || m == 1) ile++;
        return ile;
    }

    boolean isMAC48Address(String inputString) {
        Pattern compiledPattern = Pattern.compile("([A-F0-9]{2}[-]){5}([A-F0-9]{2})");
        return compiledPattern.matcher(inputString).matches();
    }
}
