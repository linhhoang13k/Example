package CodeWars;

//incomplete

public class Walk {

//    true, TenMinWalk.isValid(new char[] {'n','s','n','s','n','s','n','s','n','s'}));
//    false, TenMinWalk.isValid(new char[] {'w','e','w','e','w','e','w','e','w','e','w','e'}));
//    false, TenMinWalk.isValid(new char[] {'w'}));
//    false", false, TenMinWalk.isValid(new char[] {'n','n','n','s','n','s','n','s','n','s'}));

    public static void main(String[] args) {

        System.out.println(valid(new char[]{'w','e','w','e','w','e','w','e','w','e','w','e'}));
    }
        public static boolean valid(char[] walk) {
            int pointNS = 0;
            int pointWE = 0;

            for (int i = 0; i < walk.length; i++) {
                if (walk[i] == 'n') {
                    pointNS += 1;
                } else if (walk[i] == 's') {
                    pointNS -= 1;
                } else if (walk[i] == 'w') {
                    pointWE += 1;
                } else if (walk[i] == 'e') {
                    pointWE -= 1;
                }
            if (pointNS == 0 && pointWE == 0 && walk.length == 10)
                return true;
            } return false;
        }
}
