public interface MyList<E> {

    
    /** Appends the specified element to the end of this list */
    void add(E e);

    /** Removes all of the elements from this list **/
    void clear();

    /** Returns the element at the specified position in this list. */
    E get(int index);

    /** Returns true if this list contains no elements. **/
    boolean isEmpty();

    /** Removes the element at the specified position in this list. Returns the removed element. */
    E remove(int index);

    /** Removes the first occurrence of the specified element from this list, if it is present (return true) */
    boolean remove(Object o);

    /** Returns the number of elements in this list. */
    int size();
}