package composite;

import java.util.ArrayList;

/**
 * Created by tranpham on 8/7/17.
 */
public class Directory implements IFileStructure {
    String name ="";
    ArrayList<IFileStructure> itemList= new ArrayList<IFileStructure>();
    public void path(String indent) {
        System.out.println(indent+ name.toUpperCase());
        for (IFileStructure structure:itemList){
            structure.path(indent+indent);
        }
    }

    public Directory(String name) {
        this.name = name;
    }

    public void add(IFileStructure structure){
        itemList.add(structure);
    }

}
