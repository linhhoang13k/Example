package ChainOfResponsibility;

/**
 * Created by tranpham on 8/8/17.
 */
public class BaseHandler {

    BaseHandler nextHandler;

    public void setNextHandler(BaseHandler handler) {
        if(nextHandler==null)
            nextHandler=handler;
        else
            nextHandler.setNextHandler(handler);
    }

    public void handle(int amount){
        nextHandler.handle(amount);
    };
}
