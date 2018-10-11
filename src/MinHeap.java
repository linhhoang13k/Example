package CodeFight;

import java.io.IOException;

/**
 * Created by tranpham on 4/8/18.
 */
public class MinHeap extends Heap {

    public MinHeap(int[] arr){
        storage = new int[arr.length];
        System.arraycopy(arr,0,storage,0,arr.length);
        capacity = arr.length;
        heapSize = arr.length;
        rebuild();
    }

    public MinHeap(int capacity){
        storage = new int[capacity];
        super.capacity = capacity;
    }


    //this method heapify the subtree at [key] index,
    // potentially key is new inserted node that violate the heap propterty
    //this method assume that all subtrees are already heapified
    @Override
    public void heapify(int key) {
        int l = left(key);
        int r=right(key);
        int smallest = key;
        if(l<heapSize && storage[smallest]>storage[l])
            smallest = l;
        if(r<heapSize && storage[smallest]>storage[r])
            smallest = r;

        if(smallest!=key){//heap property is violated, need to swap
            swap(smallest,key);
            heapify(smallest);
        }
    }

    @Override
    public void insertKey(int key) throws IOException {
        if(heapSize>=capacity)
            throw new IOException("Heap overflow!");
        storage[heapSize++]=key;//insert to the end
        int curr = heapSize-1;
        while (storage[curr]<storage[parent(curr)]){
            swap(curr,parent(curr));
            curr = parent(curr);
        }
    }

    @Override
    public int deleteKey(int key) {
        return 0;
    }
}
