import java.util.Arrays;

public class MyArrayList<E> implements MyList<E> {
    private Object[] array;
    private int size;

    public MyArrayList() {
        array = new Object[10];
        size = 0;
    }

    public MyArrayList(E[] array) {
        this.array = array;
        size = array.length;
    }

    @Override
    public void add(E e) {
        checkLength(size + 1);
        array[size] = e;
        size++;
    }
    
    @Override
    public void clear() {
        setArray(new Object[10]);
        size = 0;
    }
    
    @Override
    public E get(int index) {
        return (E) array[index];
    }
    
    @Override
    public boolean isEmpty() {
        return array.length == 0;
    }
    
    @Override
    public E remove(int index) {
        checkRange(index);
        E removedValue = (E) array[index];

        doRemove(index);

        return removedValue;
    }
    
    @Override
    public boolean remove(Object o) {
        for(int i = 0; i < size; i++) {
            if(o.equals(array[i])) {
                doRemove(i);
                return true;
            }
        }
        return false;
    }
    
    @Override
    public int size() {
        return size;
    }

    public void setArray(Object[] array) {
        this.array = array;
    }

    public void checkRange(int index) {
        if(index >= size) {
            throw new IndexOutOfBoundsException();
        }
    }

    public void doRemove(int index) {
        if(size - index - 1 > 0) {
            System.arraycopy(array, index+1, array, index, size - index - 1);
        }
        size--;
        array[size] = null;
    }

    public void checkLength(int minLength) {
        int oldLength = array.length;
        if(minLength > oldLength) {
            int newLength = (oldLength * 3) / 2;
            array = Arrays.copyOf(array, newLength);
        }
    }
}