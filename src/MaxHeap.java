package CodeFight;

import java.io.IOException;

/**
 * Created by tranpham on 4/8/18.
 */
public class MaxHeap extends Heap {
    public MaxHeap(int[] arr){
        storage = new int[arr.length];
        System.arraycopy(arr,0,storage,0,arr.length);
        capacity = arr.length;
        heapSize = arr.length;
        rebuild();
    }

    public MaxHeap(int capacity){
        storage = new int[capacity];
        super.capacity = capacity;
    }


    @Override
    public void heapify(int key) {
        int l = left(key);
        int r = right(key);
        int max = key;
        if(key<heapSize && storage[key]<storage[l])
            max = l;
        if(key<heapSize && storage[max]<storage[r])
            max = r;
        if(max!=key){//need to swap
            swap(max,key);
            heapify(max);
        }

    }

    @Override
    public void insertKey(int key) throws IOException {
        if (heapSize==capacity)
            throw new IOException("Heap overflow!");
        //insert at the end of heap
        storage[heapSize++]=key;
        int curr = heapSize-1;
        while (storage[curr]>storage[parent(curr)]){
            swap(curr,parent(curr));
            curr = parent(curr);
        }
    }

    @Override
    public int deleteKey(int key) {
        return 0;
    }
}
