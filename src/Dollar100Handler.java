package ChainOfResponsibility;

/**
 * Created by tranpham on 8/8/17.
 */
public class Dollar100Handler extends BaseHandler {

    public void handle(int amount) {
        String numberStr=getClass().getSimpleName().replaceAll("[a-zA-Z]","");
        int number=Integer.parseInt(numberStr);
        int numberOfPaper=amount/number;
        int remainder=amount%number;
        System.out.printf("Dispense %d paper(s) of %d dollar%n",numberOfPaper,number);
        if(remainder>0){
            nextHandler.handle(remainder);
        }
    }
}
