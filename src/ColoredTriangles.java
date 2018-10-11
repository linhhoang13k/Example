package CodeWars;

//incomplete

public class ColoredTriangles {

   // R R G B R G B B
   //  R B R G B R B
    //  G G B R G G
    //   G R G B G
    //    B B R R
    //     B G R
    //      R B
     //      G

  //  Colour here:            G G        B G        R G        B R
  //  Becomes colour here:     G          R          B          G

    public static void main(String[] args) {
        System.out.println(triangle("BGGGRBB"));
    }

    public static char triangle(final String row) {

        StringBuilder sb = new StringBuilder();

        for (int i = 0; i <= row.length()+1; i++) {
            System.out.println("test 1");
            System.out.println(sb);
            if (row.charAt(i+1) == row.charAt(row.length()-1)) {
                sb.append('G');
                break;
            }
            if (row.charAt(i) == row.charAt(i+1)) {
                sb.append(row.charAt(i));
            } else
                sb.append('R');
        }

        if (sb.length() > 1) {
            System.out.println("test 2");
            triangle(sb.toString());
        } else {
            System.out.println("test 3");
            char c = sb.charAt(0);
            return c;
        }
        System.out.println("test 4");
        return 'c';
    }
}
