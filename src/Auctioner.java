package Observer;

import java.util.ArrayList;

/**
 * Created by tranpham on 8/9/17.
 */
public class Auctioner {

    ArrayList<IObserver> observerArrayList = new ArrayList<IObserver>();
    int currentBidPrice=0;
    public void subscribe(IObserver observer){
        observerArrayList.add(observer);
    }

    public void unsubscribe(IObserver observer){
        observerArrayList.remove(observer);
    }

    public void setNewHighBid(int newHighBid){
        currentBidPrice=newHighBid;
        notifyToAll();
    }

    public void notifyToAll(){
        for (IObserver observer:observerArrayList){
            observer.update();
        }
    }
}
