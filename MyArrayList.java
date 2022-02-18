package Home1;

import java.util.*;

/**
 * MyArrayList is my interpretation ArrayList
 *
 * @param <E> is some class
 */
public class MyArrayList<E> implements List<E> {
    private final static int DEFAULT_ARRAY_SIZE = 10;
    private Object[] elementData;
    private int size;


    public MyArrayList() {
        this.elementData = (E[]) new Object[DEFAULT_ARRAY_SIZE];
    }

    /**
     * Just constructor with param defeniteSize
     *
     * @param defeniteSize is size array inside MyArrayList
     */
    public MyArrayList(int defeniteSize) {
        this.elementData = (E[]) new Object[defeniteSize];
    }

    /**
     * Size object MyArrayList
     *
     * @return size MyArrayList
     */
    public int size() {
        return size;
    }

    /**
     * Compares object references
     *
     * @param obj is object that is compared
     * @return true if they are same
     */
    @Override
    public boolean equals(Object obj) {
        return (this == obj);
    }

    /**
     * Check if the object is empty
     *
     * @return true if MyArrayList is empty
     */
    public boolean isEmpty() {
        return size == 0;
    }

    /**
     * Check if object is contains in MyArrayList
     *
     * @param o is element that probably be in MyArrayList
     * @return true if element finds and false if element don't find
     */
    public boolean contains(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null)
                    return true;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == o)
                    return true;
            }
        }
        return false;
    }


    /**
     * Returns an array containing all of the elements in this MyArrayList in proper sequence
     *
     * @return array containing the elements of this list
     */
    public Object[] toArray() {
        return Arrays.copyOf(elementData, size);
    }

    /**
     * @param a   is array into which the elements of this MyArrayList ro be sorted.
     * @param <T> is class in array
     * @return array containing the elements of this list
     */
    public <T> T[] toArray(T[] a) {
        if (a.length < size)
            return (T[]) Arrays.copyOf(elementData, size, a.getClass());
        for (int i = 0; i < size; i++) {
            a[i] = (T) elementData[i];
        }
        if (a.length > size)
            a[size] = null;
        return a;
    }

    private void ensureCapacity() {
        Object[] newElementData = (E[]) new Object[(elementData.length * 3) / 2 + 1];
        for (int i = 0; i < elementData.length; i++) {
            newElementData[i] = elementData[i];
        }
        elementData = newElementData;
    }

    /**
     * This  method is adds an element to MyArraylist
     *
     * @param t is element
     * @return true if adding element was successful
     */
    public boolean add(E t) {
        if (size + 1 > elementData.length) {
            ensureCapacity();
        }
        elementData[size++] = t;
        return true;
    }

    /**
     * Remove element from MyArrayList
     *
     * @param o is object that will be deleted
     * @return true if remove element was successful
     */
    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index < 0)
            return false;
        remove(index);
        return true;
    }

    /**
     * Check that all elements of the collection are contained in myArrayList
     *
     * @param c contain elements to check
     * @return true if all elements contains in myArrayList
     */
    public boolean containsAll(Collection<?> c) {
        E[] newElementData = (E[]) c.toArray();
        for (int i = 0; i < c.size(); i++) {
            if (contains(newElementData[i]))
                continue;
            else
                return false;
        }
        return true;
    }

    /**
     * Add all elements in MyArrayList from collections
     *
     * @param c is collections contains elements for checking the addition
     * @return true if adding was successful
     */
    public boolean addAll(Collection<? extends E> c) {
        Object[] a = c.toArray();
        int aSize = a.length;
        if (aSize == 0)
            return false;
        while (true) {
            if (size + aSize > elementData.length)
                ensureCapacity();
            else
                break;
        }
        int j = size;
        for (int i = 0; i < aSize; i++) {
            elementData[j++] = a[i];
            size++;
        }
        return true;
    }

    /**
     * dds elements from a specific index in MyArrayList. Elements from the collection
     *
     * @param index from which is added in myArrayList
     * @param c     is collections contains elements for checking the addition
     * @return true if adding was successful
     */
    public boolean addAll(int index, Collection<? extends E> c) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        Object[] a = c.toArray();
        int aSize = a.length;
        if (aSize == 0)
            return false;
        while (true) {
            if (size + aSize > elementData.length)
                ensureCapacity();
            else
                break;
        }
        Object[] newElementData = (E[]) new Object[(elementData.length)];
        for (int i = 0; i < index; i++) {
            newElementData[i] = elementData[i];
        }
        int j = index;
        for (int i = 0; i < aSize; i++) {
            newElementData[j++] = a[i];
        }
        size += aSize;
        for (int i = j; i < size; i++) {
            newElementData[i] = elementData[index++];
        }
        elementData = newElementData;
        return true;
    }

    /**
     * Remove all elements of Collections from MyArrayList
     *
     * @param c is collections with elements
     * @return true if removing was successful
     */
    public boolean removeAll(Collection<?> c) {
        Object[] a = c.toArray();
        for (int i = 0; i < a.length; i++) {
            while (contains(a[i])) {
                remove(a[i]);
            }
            ;
        }
        return true;
    }

    /**
     * Retain elements from MyArrayList that are contained in the collections
     *
     * @param c is collections with elements
     * @return true if retaining was successful
     */
    public boolean retainAll(Collection<?> c) {
        Object[] oldElementData = (E[]) new Object[(elementData.length)];
        for (int i = 0; i < size; i++) {
            oldElementData[i] = elementData[i];
        }
        int oldSize = size;
        removeAll(c);
        Object[] newElementData = (E[]) new Object[(elementData.length)];
        for (int i = 0; i < size; i++) {
            newElementData[i] = elementData[i];
        }
        int newSize = size;
        elementData = oldElementData;
        size = oldSize;
        for (int i = 0; i < newSize; i++) {
            while (contains(newElementData[i])) {
                remove(newElementData[i]);
            }
        }
        return true;
    }

    /**
     * Clear elements from myArrayList
     */
    public void clear() {
        for (int i = 0; i < size; i++) {
            elementData[i] = null;
        }
        size = 0;
    }

    /**
     * Return element of MyArrayList by index
     *
     * @param index - position element in MyArrayList
     * @return element
     */
    public E get(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        return (E) elementData[index];
    }

    /**
     * Set element in MyArrayList by index
     *
     * @param index   element in MyArrayList
     * @param element set in MyArrayList instead old element
     * @return element before deletion
     */
    public E set(int index, E element) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        E oldElement = (E) elementData[index];
        elementData[index] = element;
        return oldElement;
    }

    /**
     * Add element in MyArrayList by index
     *
     * @param index is position in MyArrayList where will be new element
     * @param t     is element
     */
    public void add(int index, E t) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

        if (size + 1 > elementData.length) {
            ensureCapacity();
        }

        Object[] newElementData = (E[]) new Object[(elementData.length)];
        for (int i = 0; i != size; i++) {
            newElementData[i] = elementData[i];
        }

        elementData[index] = t;
        for (int i = index; i < size + 1; i++) {
            elementData[i + 1] = newElementData[i];
        }
        size++;
    }

    /**
     * Remove element from MyArrayList by index
     *
     * @param index of deleted item
     * @return element before deletion
     */
    public E remove(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

        Object[] newElementData = (E[]) new Object[(elementData.length)];
        for (int i = 0; i < size; i++) {
            newElementData[i] = elementData[i];
        }
        E oldElement;
        oldElement = (E) elementData[index];
        if (size == 1) {
            elementData[index] = null;
        } else {
            for (int i = index; i < size; i++) {
                elementData[i] = newElementData[i + 1];
            }
            elementData[size] = null;
        }
        size--;
        return oldElement;
    }

    /**
     * Find index in MyArrayLIst by element
     *
     * @param o is element to search for
     * @return index of element
     */
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null)
                    return i;
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == o)
                    return i;
            }
        }
        return -1;
    }

    /**
     * Finds the last occurrence of an element in MyArrayList
     *
     * @param o is element to search for
     * @return last index of element
     */
    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null)
                    return i;
            }
        } else {
            int lastIndex = -1;
            for (int i = 0; i < size; i++) {
                if (elementData[i] == o) {
                    lastIndex = i;
                }
            }
            return lastIndex;
        }
        return -1;
    }

    /**
     * Return data from MyArrayList as a string
     *
     * @return string with elements of MyArrayList
     */
    @Override
    public String toString() {
        if (elementData == null)
            return "null";

        int iMax = size;
        if (iMax == 0)
            return "[]";

        StringBuilder b = new StringBuilder();
        b.append('[');
        for (int i = 0; i < iMax; i++) {
            b.append(String.valueOf(elementData[i]));
            if (i + 1 != iMax)
                b.append(", ");
        }
        return b.append(']').toString();
    }

    //не сделан
    @Override
    public Iterator<E> iterator() {
        return null;
    }

    //не сделан
    @Override
    public ListIterator<E> listIterator() {
        return null;
    }

    //не сделан
    @Override
    public ListIterator<E> listIterator(int index) {
        return null;
    }

    //не сделан
    @Override
    public List<E> subList(int fromIndex, int toIndex) {
        return null;
    }

}


