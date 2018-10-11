import java.util.*;

public class Rotate {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] line = in.nextLine().split(" ");
        int l0 = Integer.parseInt(line[0]), l1 = Integer.parseInt(line[1]);

        int[] arr = new int[l0], arr2 = new int[l0];
        for(int i = 0; i < l0; i++){
            arr[i] = in.nextInt();
        }

        for(int i = 0; i < l0; i++){
            arr2[i] = arr[(i + l1) % l0];
            System.out.print(arr2[i] + " ");
        }
    }
}
