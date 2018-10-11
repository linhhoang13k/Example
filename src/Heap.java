package CodeFight;

import java.io.IOException;
import java.util.Arrays;

/**
 * Created by tranpham on 4/8/18.
 */
public abstract class Heap{
    int[] storage;
    int capacity;
    int heapSize;

    //parent node of node i
    public int parent(int i){
        return (i-1)/2;
    }

    public int left(int i){
        return i*2+1;
    }

    public int right(int i){
        return i*2+2;
    }

    public int getRoot(){
        return storage[0];
    }

    public void rebuild(){
        for (int i=heapSize/2;i>=0;i--)
            heapify(i);

    }
    public void swap(int p1,int p2){
        int tmp= storage[p2];
        storage[p2]=storage[p1];
        storage[p1] = tmp;
    }

    public int size(){
        return heapSize;
    }
    abstract public void heapify(int key);

    public int extractRoot(){
        int res = storage[0];
        storage[0] = storage[heapSize-1];
        heapSize--;
        heapify(0);
        return res;
    }

    abstract public void insertKey(int key) throws IOException;

    abstract public int deleteKey(int key);

}
