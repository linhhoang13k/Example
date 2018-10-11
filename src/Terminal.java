package Testing;
import java.io.IOException;
import java.lang.*;
/**
 * Created by tranpham on 3/26/18.
 */
public class Terminal {
    public static void main(String[] agrs){
        Runtime runtime = Runtime.getRuntime();
        try {
            runtime.exec("sw_vers");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
