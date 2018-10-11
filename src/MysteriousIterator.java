package Iterator;

import java.util.ArrayList;

/**
 * Created by tranpham on 8/7/17.
 */
public class MysteriousIterator<T> implements IMysteriousIterator {

    ArrayList<T> arrayList;
    int currentPointer=0;
    public MysteriousIterator(ArrayList<T> arrayList) {
        this.arrayList=arrayList;
    }

    public boolean hasNext() {
        if(currentPointer<arrayList.size()-1)
            return true;
        return false;
    }

    public T next() {
        currentPointer++;
        return arrayList.get(currentPointer);
    }
}
