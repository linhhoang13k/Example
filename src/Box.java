package composite;

import java.util.ArrayList;

/**
 * Created by tranpham on 8/7/17.
 */
public class Box implements AbstractItem {

    String name="";
    ArrayList<AbstractItem> itemArrayList = new ArrayList<AbstractItem>();

    public Box(String name) {
        this.name = name;
    }

    public void showContent(String indent) {
        System.out.println(indent+name);
        for(AbstractItem item:itemArrayList){
            item.showContent(indent+indent);
        }
    }

    public void add(AbstractItem item){
        itemArrayList.add(item);
    }
}
