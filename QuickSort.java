package Home1;

import java.util.ArrayList;
import java.util.Comparator;

class ComparatorInteger implements Comparator<Integer> {

    @Override
    public int compare(Integer o1, Integer o2) {
        if (o1 > o2)
            return 1;
        else if (o1 == o2)
            return 0;
        else
            return -1;
    }
}

class ComparatorString implements Comparator<String> {

    @Override
    public int compare(String o1, String o2) {
        if (o1.length() > o2.length())
            return 1;
        else if (o1.length() == o2.length())
            return 0;
        else
            return -1;
    }
}

public class QuickSort<T> {
    MyArrayList<T> array;

    public QuickSort(MyArrayList<T> array) {
        this.array = array;
    }

    void swap(int i, int j) {
        T temp = array.get(i);
        array.set(i, array.get(j));
        array.set(j, temp);
    }

    int partition(int low, int high, Comparator<T> c) {
        T pivot = array.get(high);
        int i = (low - 1);
        for (int j = low; j <= high - 1; j++) {
            if (c.compare(array.get(j), pivot) < 0) {
                i++;
                swap(i, j);
            }
        }

        swap(i + 1, high);
        return (i + 1);
    }

    public void sort(int low, int high, Comparator<? super T> c) {
        if (low < high) {
            int pi = partition(low, high, (Comparator<T>) c);
            sort(low, pi - 1, c);
            sort(pi + 1, high, c);
        }
    }

}

