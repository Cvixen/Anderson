package test.java;


import org.junit.jupiter.api.Test;
import main.java.MyArrayList;
import java.util.*;

import static org.junit.jupiter.api.Assertions.*;

class MyArrayListTest {
    private List<Integer> testListDigit = new MyArrayList<>();
    private List<String> testListString = new MyArrayList<>();


    @org.junit.jupiter.api.Test
    void size() {
//
//    givenSize
//
        int actualSize = 2;

//    whenSizeMethod
//
//
        testListDigit.add(2);
        testListDigit.add(3);
//
//    thenSize(2)
//
        assertEquals(actualSize, testListDigit.size());
    }

    @org.junit.jupiter.api.Test
    void isEmpty() {
        assertTrue(testListDigit.isEmpty());
    }

    @org.junit.jupiter.api.Test
    void contains() {
        testListDigit.add(5);
        testListDigit.add(2);
        testListDigit.add(3);
        assertTrue(testListDigit.contains(2));
        assertFalse(testListDigit.contains(76));
    }

    @Test
    void toArray() {
//
//      givenObjectWithoutElements
//        
        testListDigit.add(1);
        testListDigit.add(2);
//      
//       whenMyArrayListToArray
//        
        Object[] obj = testListDigit.toArray();
//        
//      thenObjectIsArrayWithElements
//
        assertEquals(obj.length, 2);
        assertEquals(obj[0], 1);
        assertEquals(obj[1], 2);
    }

    @org.junit.jupiter.api.Test
    void testToArray() {
//
//      givenObjectWithoutElements
//
        testListDigit.add(1);
        testListDigit.add(2);
//
//       whenMyArrayListToArray
//
        Integer[] integers = new Integer[2];
        testListDigit.toArray(integers);
//
//      thenArrayWithElementsFromMyArrayList
//
        assertEquals(integers.length, 2);
        assertEquals(integers[0], 1);
        assertEquals(integers[1], 2);
    }

    @org.junit.jupiter.api.Test
    void add() {
//
//        givenSizeAndElements
//
        int actualSize = 4;
        int exeptedDigit1 = 1;
        int exeptedDigit2 = 2;
        int exeptedDigit3 = 3;
        int exeptedDigit4 = 4;
        String exeptedString1 = "one";
        String exeptedString2 = "two";
        String exeptedString3 = "three";
        String exeptedString4 = "four";
//
//        whenAddMethod
//
        testListDigit.add(1);
        testListDigit.add(2);
        testListDigit.add(3);
        testListDigit.add(4);
        testListString.add("one");
        testListString.add("two");
        testListString.add("three");
        testListString.add("four");
//
//        thenSize(4)AndElements(1,2,3,4)AndAlso(one.two.three.four)
//
        assertEquals(actualSize, testListDigit.size());
        assertEquals(actualSize, testListString.size());
        assertEquals(exeptedDigit1, testListDigit.get(0));
        assertEquals(exeptedDigit2, testListDigit.get(1));
        assertEquals(exeptedDigit3, testListDigit.get(2));
        assertEquals(exeptedDigit4, testListDigit.get(3));
        assertEquals(exeptedString1, testListString.get(0));
        assertEquals(exeptedString2, testListString.get(1));
        assertEquals(exeptedString3, testListString.get(2));
        assertEquals(exeptedString4, testListString.get(3));
    }


    @org.junit.jupiter.api.Test
    void remove() {
        testListDigit.add(1);
        testListDigit.add(2);
        assertNotNull(testListDigit);
        testListDigit.remove(0);
        testListDigit.remove(0);
        assertNotNull(testListDigit);
    }

    @org.junit.jupiter.api.Test
    void containsAll() {
        testListDigit.add(1);
        testListDigit.add(2);
        List<Integer> integers = new MyArrayList<>();
        integers.add(1);
        assertTrue(testListDigit.containsAll(integers));
        integers.add(2);
        assertTrue(testListDigit.containsAll(integers));
        integers.add(3);
        assertFalse(testListDigit.containsAll(integers));
    }

    @org.junit.jupiter.api.Test
    void addAll() {
        List<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        testListDigit.addAll(list);
        assertNotNull(testListDigit);
    }

    @org.junit.jupiter.api.Test
    void testAddAll() {
        int exeptedSize = 3;
        List<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        testListDigit.add(5);
        testListDigit.addAll(1, list);
        assertEquals(exeptedSize, testListDigit.size());
        assertEquals(1, testListDigit.get(1));
        assertEquals(2, testListDigit.get(2));
    }

    @org.junit.jupiter.api.Test
    void removeAll() {
        int exeptedSize = 2;
        testListDigit.add(1);
        testListDigit.add(2);
        testListDigit.add(3);
        testListDigit.add(4);
        assertNotNull(testListDigit);
        List<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        testListDigit.removeAll(list);
        assertEquals(exeptedSize, testListDigit.size());
        assertEquals(3, testListDigit.get(0));
        assertEquals(4, testListDigit.get(1));
    }

    @org.junit.jupiter.api.Test
    void retainAll() {
        int exeptedSize = 2;
        testListDigit.add(1);
        testListDigit.add(2);
        testListDigit.add(3);
        testListDigit.add(4);
        assertNotNull(testListDigit);
        List<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        testListDigit.retainAll(list);
        assertEquals(exeptedSize, testListDigit.size());
        assertEquals(1, testListDigit.get(0));
        assertEquals(2, testListDigit.get(1));
    }

    @org.junit.jupiter.api.Test
    void clear() {
        testListDigit.add(1);
        testListDigit.add(2);
        assertNotNull(testListDigit);
        testListDigit.clear();
        assertNull(testListDigit.get(0));
    }

    @org.junit.jupiter.api.Test
    void get() {
        int exeptedDigit = 1;
        testListDigit.add(1);
        assertEquals(exeptedDigit, testListDigit.get(0));
    }

    @org.junit.jupiter.api.Test
    void set() {
        int exeptedDigit = 27;
        testListDigit.add(1);
        testListDigit.set(0, exeptedDigit);
        assertEquals(exeptedDigit, testListDigit.get(0));
    }

    @org.junit.jupiter.api.Test
    void testAdd() {
        int exeptedDigit = 27;
        int exeptedSize = 5;
        testListDigit.add(1);
        testListDigit.add(2);
        testListDigit.add(3);
        testListDigit.add(4);
        testListDigit.add(2, exeptedDigit);
        assertEquals(exeptedSize, testListDigit.size());
        assertEquals(exeptedDigit, testListDigit.get(2));
    }

    @org.junit.jupiter.api.Test
    void testRemove() {
        Integer removeDigit = 3;
        testListDigit.add(1);
        testListDigit.add(2);
        testListDigit.add(3);
        testListDigit.remove(removeDigit);
        assertFalse(testListDigit.contains(removeDigit));
    }

    @org.junit.jupiter.api.Test
    void indexOf() {
        Integer Digit = 3;
        int exeptedIndex = 2;
        testListDigit.add(1);
        testListDigit.add(2);
        testListDigit.add(3);
        assertEquals(exeptedIndex, testListDigit.indexOf(Digit));
    }

    @org.junit.jupiter.api.Test
    void lastIndexOf() {
        Integer Digit = 1;
        int exeptedIndex = 2;
        testListDigit.add(1);
        testListDigit.add(2);
        testListDigit.add(1);
        assertEquals(exeptedIndex, testListDigit.lastIndexOf(Digit));
    }
}