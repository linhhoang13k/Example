package composite;

/**
 * Created by tranpham on 8/7/17.
 */
public class Item implements AbstractItem,IFileStructure {
    String name="";

    public Item(String name) {
        this.name = name;
    }

    public void showContent(String indent) {
        System.out.println(indent+ name);
    }

    public void path(String indent) {

    }
}
