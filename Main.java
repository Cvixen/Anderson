package Home1;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Main {
    static class  Person{
        int id;
        String name;

        public  Person(int id, String name) {
            this.id = id;
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }

    public static void main(String[] args) {
        Person one = new Person(1, "a");
        Person two = new Person(2, "b");
        Person three = new Person(3, "d");

        List<String> origin = new ArrayList<>();
        List<String> origin2 = new LinkedList<>();
         MyArrayList<String > lol = new MyArrayList<>();
        MyArrayList<String > lol2 = new MyArrayList<>();
//        lol.add(1);
//        lol.add(2);
//        lol.add(3);
//        lol.add(4);
//        lol.add(3);
//        lol.add(5,100);
//        lol.remove(0);
//        origin.add(1);
//        origin.add(2);
//        origin.add(3);
//        origin.add(4);
//        origin.add(3);
//        origin.add(6,100);
//        origin.remove(0);


//        lol.add(one);
//        lol.add(two);
//        lol.add(three);
//
//        origin.add(one);
//        origin.add(two);
//        origin.add(three);

        lol.add("lol");
        lol.add("kek");
        lol.add("check");
        lol.add("lolll");
        lol.add("kek");
        lol.add("lol");
//        lol.set(0,"kek");
//        lol.clear();
//        lol.remove(1);
        lol2.add("lol");
        lol2.add("kek");
        lol2.add("check");
//        lol2.add("pip");
//        lol.addAll(5,lol2);
//        lol.removeAll(lol2);
//        lol.retainAll(lol2);

        origin.add("lol");
        origin.add("kek");
        origin.add("check");
        origin.add("lolll");
        origin.add("kek");
        origin.add("lol");

        origin2.add("lol");
        origin2.add("kek");
        origin2.add("check");
//        origin.retainAll(origin2);
//        origin.removeAll(origin2);
//        origin.addAll(5,origin2);
//        origin2.add("pip");
//        origin.remove(1);
//        origin.clear();
//        origin.set(0,"kek");
        System.out.println(lol.subList(1,4));
        System.out.println(origin.subList(1,4));
    }
}
