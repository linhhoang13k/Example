package Observer;

/**
 * Created by tranpham on 8/9/17.
 */
public class Bidder implements IObserver {

    String name="";
    Auctioner auctioner;
    public Bidder(String name, Auctioner auctioner) {
        this.name=name;
        this.auctioner=auctioner;
    }

    public void update() {
        System.out.printf("%s receive the new high price %d%n",name,auctioner.currentBidPrice);
    }
}
