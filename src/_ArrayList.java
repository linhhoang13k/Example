package ArrayList;

/**
 * Created by Trung on 5/30/2017.
 */
public class _ArrayList<E> {

    public static final int DEFAULT_CAPACITY = 10;

    private E[] data;

    private int size;


    public _ArrayList() {
        data = (E[]) new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    public boolean isEmpty() {
        return size == 0 ? true : false;
    }

    public int indexOf(E element) {
        for (int i = 0; i < size; i++) {
            if (data[i].equals(element)) return i;
        }
        return -1;
    }

    public E get(int index) {
        if (index < 0 || index >= size) throw new IndexOutOfBoundsException("Index out of bounds");
        return data[index];
    }

    public int size() {
        return this.size;
    }

    public void add(E element) {

        if (size == data.length) {      //Array is full
            addAtEnd(element);
        } else {
            data[size] = element;
            size++;
        }

    }

    public void set(E element, int index) {
        if (index >= 0) {
            if (index >= size) addAtEnd(element);
            else {
                if (size + 1 > data.length) {   //set 1 element will overflow the array
                    E[] newArray = (E[]) new Object[data.length * 2];
                    //Copy new array
                    for (int i = 0; i < data.length; i++) {
                        newArray[i] = data[i];
                    }
                    data = newArray;

                }
                E swap = data[index];
                data[index] = element;
                //Go from index to end, swapping back and forth
                for (int i = index + 1; i <= size; i++) {
                    E temp = data[i];
                    data[i] = swap;
                    swap = temp;
                }

            }
            size++;
        }
    }

    public void remove(int index) {
        if  (index > 0 && index < size) {
            for (int i = index; i < size - 1; i++) {
                data[i] = data[i + 1];
            }
        } else throw new IndexOutOfBoundsException();
        size--;
    }

    public void clear() {
        data = (E[]) new Object[data.length];
        size = 0;
    }

    private void addAtEnd(E element) {
        E[] newArray = (E[]) new Object[data.length * 2];
        //Copy new array
        for (int i = 0; i < data.length; i++) {
            newArray[i] = data[i];
        }
        //Add the element
        newArray[size] = (E) element;
        size++;
        data = newArray;
    }




    public static void main(String...args) {
        _ArrayList<Integer> arr = new _ArrayList();
        arr.add(0);
        arr.add(2);
        arr.add(4);

        arr.set(1, 1);
        arr.set(3, 3);
        arr.set(5, 5);
    }

}
