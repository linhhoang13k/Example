package Iterator;

import java.util.ArrayList;
import java.util.Random;

/**
 * Created by tranpham on 8/7/17.
 */
public class MysteriousCollection<T> {

    ArrayList<T> arrayList = new ArrayList<T>();

    IMysteriousIterator createIterator(){
        return new Iterator();
    }

    IMysteriousIterator createRandomIterator(){
        return new RandomIterator();
    }

    public void add(T item){
        arrayList.add(item);
    }

    private class Iterator implements IMysteriousIterator{

        int index =0;
        public boolean hasNext() {
            if(index + 1<arrayList.size())
                return true;
            return false;
        }

        public T next() {
            if(hasNext()){
                index++;
                return arrayList.get(index);
            }
            return null;
        }
    }

    private class RandomIterator implements IMysteriousIterator{

        int[] chosenIdx= new int[arrayList.size()];
        public boolean hasNext() {
            for (int idx:chosenIdx)
                if(idx==0)
                    return true;
            return false;
        }

        //randomize the next item
        public T next() {
            if(!hasNext())
                return null;

            Random rand = new Random();
            int randIdx=0;
            do {
                randIdx=rand.nextInt(arrayList.size());
            }while (chosenIdx[randIdx]==1);

            chosenIdx[randIdx]=1;
            return arrayList.get(randIdx);
        }
    }
}
