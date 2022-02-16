package Home1;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Integer> origin = new ArrayList<>(0);
         MyArrayList<Integer> lol = new MyArrayList<>(0);
        lol.add(1);
        lol.add(2);
        lol.add(3);
//        lol.add(4);
//        lol.add(5);
//        lol.add(5,100);
        lol.remove(0);
        origin.add(1);
        origin.add(2);
        origin.add(3);
//        origin.add(4);
//        origin.add(5);
//        origin.add(6,100);
        origin.remove(0);
        System.out.println(lol);
        System.out.println(origin);
    }

}
