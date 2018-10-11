package Observer;

/**
 * Created by tranpham on 8/9/17.
 */
public class DemoObserver {
    public static void main(String[] agrs){
        Auctioner auctioner  = new Auctioner();
        Bidder bidder1= new Bidder("Jose",auctioner);
        Bidder bidder2=new Bidder("Tran",auctioner);
        auctioner.subscribe(bidder1);
        auctioner.subscribe(bidder2);
        auctioner.setNewHighBid(10);
        auctioner.setNewHighBid(40);
        auctioner.setNewHighBid(50);
    }
}
