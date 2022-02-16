package Home1;

import java.util.*;

public class MyArrayList<E>  {
    private final static int DEFAULT_ARRAY_SIZE = 10;
    private Object[] elementData;
    private int size;


    public MyArrayList() {
        this.elementData = (E[]) new Object[DEFAULT_ARRAY_SIZE];
    }

    public MyArrayList(int defeniteSize) {
        this.elementData = (E[]) new Object[defeniteSize];
    }

    public int size() {
        return size;
    }


    public boolean isEmpty() {
        return size == 0;
    }


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



    public Object[] toArray() {
        return Arrays.copyOf(elementData, size);
    }


    public <T> T[] toArray(T[] a) {
        if (a.length < size)
            return (T[]) Arrays.copyOf(elementData, size, a.getClass());
        for(int i = 0; i < size; i++){
            a[i] = (T)elementData[i];
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

    public boolean add(E t) {
        if (size + 1 > elementData.length) {
            ensureCapacity();
        }
        elementData[size++] = t;
        return true;
    }


    public boolean remove(Object o) {
        int index = indexOf(o);
        if (index < 0)
            return false;
        remove(index);
        return true;
    }


    public boolean containsAll(Collection<?> c) {
        E[] newElementData = (E[]) c.toArray();
        for(int i = 0; i < c.size(); i++){
            if(contains(newElementData[i]))
                continue;
            else
                return false;
        }
        return true;
    }


    public boolean addAll(Collection<? extends E> c) {
        Object [] a = c.toArray();
        int aSize = a.length;
        if (aSize == 0)
            return false;
        while(true) {
            if (size + aSize > elementData.length)
                ensureCapacity();
            else
                break;
        }
        int j = size;
        for(int i = 0; i < aSize; i++){
            elementData[j++] = a[i];
            size++;
        }
        return true;
    }


    public boolean addAll(int index, Collection<? extends E> c) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        Object [] a = c.toArray();
        int aSize = a.length;
        if (aSize == 0)
            return false;
        while(true) {
            if (size + aSize > elementData.length)
                ensureCapacity();
            else
                break;
        }
        Object[] newElementData = (E[]) new Object[(elementData.length)];
        for(int i = 0; i < index; i++)
        {
            newElementData[i] = elementData[i];
        }
        int j = index;
        for(int i = 0; i < aSize; i++){
            newElementData[j++] = a[i];
        }
        size += aSize;
        for(int i = j; i < size; i++){
            newElementData[i] = elementData[index++];
        }
        elementData = newElementData;
        return true;
    }


    public boolean removeAll(Collection<?> c) {
        Object [] a = c.toArray();
        for(int i = 0; i < a.length; i++){
            while(contains(a[i])){
                remove(a[i]);
            };
        }
        return true;
    }


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
        for(int i = 0; i < newSize; i++){
            while(contains(newElementData[i])){
                remove(newElementData[i]);
            }
        }
        return true;
    }


    public void clear() {
        for(int i = 0; i < size; i++)
            elementData[i] = null;
        size = 0;
    }


    public E get(int index) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        return (E) elementData[index];
    }


    public E set(int index, E element) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        E oldElement =  (E)elementData[index];
        elementData[index] = element;
        return oldElement;
    }

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

    public E remove(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

        Object[] newElementData = (E[]) new Object[(elementData.length)];
        for (int i = 0; i < size; i++) {
            newElementData[i] = elementData[i];
        }
        E oldElement;
        oldElement = (E)elementData[index];
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


    public int indexOf(Object o){
            if (o == null) {
                for (int i = 0; i < size; i++) {
                    if (elementData[i] == null)
                        return i;
                }
            }
            else {
                for (int i = 0; i < size; i++) {
                    if (elementData[i] == o)
                        return i;
                }
            }
            return -1;
        }


    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elementData[i] == null)
                    return i;
            }
        }
        else {
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
}


