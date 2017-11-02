import java.util.NoSuchElementException;

public class MyLinkedList<E> implements MyList<E> {
    private Element<E> first = new Element<>(null, null, null);
    private Element<E> last = first;
    private int size;

    public MyLinkedList() {
        first.next = first;
        first.previous = first;
    }

    public void add(E e) {
        Element<E> newElem = new Element<>(e, last, null);
        newElem.previous.next = newElem;
        last = newElem;
        size++;
    }

    public void clear() {
        Element<E> e = first.next;
        for(int i = 0; i < size; i++) {
            Element<E> next = e.next;
            e.next = e.previous = null;
            e.elem = null;
            e = next;
        }
        first.next = first.previous = first;
        size = 0;
    }

    public E get(int index) {
        return getElement(index).elem;
    }

    public Element<E> getElement(int index) {
        if(index < 0 || index >= size) {
            throw new IndexOutOfBoundsException();
        }
        Element<E> e = null;
        if(index < size / 2) {
            e = first;
            for(int i = 0; i <= index; i++) {
                e = e.next;
            }
        }
        else {
            e = last;
            for(int i = size; i > index; i--) {
                e = e.previous;
            }
        }
        return e;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public E remove(int index) {
        Element<E> e = getElement(index);
        return e.elem;
    }

    public boolean remove(Object o) {
        for(int i = 0; i < size; i++) {
            if(o.equals(get(i))) {
                remove(getElement(i));
                return true;
            }
        }
        return false;
    }

    public void remove(Element<E> e) {
        if(size == 0) {
            throw new NoSuchElementException();
        }

        e.previous.next = e.next;
        e.next.previous = e.previous;
        e.next = e.previous = null;
        e.elem = null;
        size--;
    }

    public int size() {
        return size;
    }

    public class Element<E> {
        E elem;
        Element<E> previous;
        Element<E> next;

        public Element(E elem, Element previous, Element next) {
            this.elem = elem;
            this.previous = previous;
            this.next = next;
        }
    }
}