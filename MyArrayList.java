package Home1;

public class MyArrayList<T> {
    private final static int DEFAULT_ARRAY_SIZE = 10;
    private Object[] elementData;
    private int size;
    private int defeniteSize;


    public MyArrayList() {
        this.elementData = (T[]) new Object[DEFAULT_ARRAY_SIZE];
    }

    public MyArrayList(int defeniteSize) {
        this.elementData = (T[]) new Object[this.defeniteSize = defeniteSize];
    }

    public int size() {
        return size;
    }

    private void ensureCapacity() {
        Object[] newElementData = (T[]) new Object[(elementData.length * 3) / 2 + 1];
        for (int i = 0; i < elementData.length; i++) {
            newElementData[i] = elementData[i];
        }
        elementData = newElementData;
    }

    public void add(T t) {
        if (size + 1 > elementData.length) {
            ensureCapacity();
        }
        elementData[size++] = t;
    }

    public void add(int index, T t) {
        if (index > size || index < 0)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

        if (size + 1 > elementData.length) {
            ensureCapacity();
        }

        Object[] newElementData = (T[]) new Object[(elementData.length)];
        for (int i = 0; i != size; i++) {
            newElementData[i] = elementData[i];
        }

        elementData[index] = t;
        for (int i = index; i < size + 1; i++) {
            elementData[i + 1] = newElementData[i];
        }
        size++;
    }

    public void remove(int index) {
        if (index >= size || index < 0)
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);

        Object[] newElementData = (T[]) new Object[(elementData.length)];
        for (int i = 0; i != size; i++) {
            newElementData[i] = elementData[i];
        }
        if (size == 1) {
            elementData[index] = null;
        } else {
            for (int i = index; i < size; i++) {
                elementData[i] = newElementData[i + 1];
            }
            elementData[size] = null;
        }
        size--;
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


