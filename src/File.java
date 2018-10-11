package composite;

/**
 * Created by tranpham on 8/7/17.
 */
public class File implements IFileStructure {

    String name="";
    public void path(String indent) {
        System.out.println(indent+ name);
    }
    public File(String name){
        this.name=name;
    }
}
