package main.java.lessonThree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;
import java.util.TreeSet;
import java.util.Map.Entry;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap();
        map.put("January", 1);
        map.put("February", 2);
        map.put("March", 3);
        map.put("April", 4);
        map.put("May", 5);
        map.put("June", 6);
        map.put("January", 10);
        System.out.println(map);
        System.out.println(map.get("July"));
        Set<Entry<String, Integer>> set = map.entrySet();
        Iterator iter = set.iterator();

        while(iter.hasNext()) {
            Entry<String, Integer> entry = (Entry)iter.next();
            System.out.println((String)entry.getKey() + ":" + entry.getValue());
        }

    }

    private static void sets() {
        Box b0 = new Box(1, 1);
        Box b1 = new Box(2, 2);
        Box b2 = new Box(3, 3);
        Box b4 = new Box(1, 1);
        TreeSet<Box> set = new TreeSet();
        set.add(b2);
        set.add(b0);
        set.add(b1);
        set.add(b4);
        System.out.println(set);
    }

    private static void lists() {
        Box b0 = new Box(1, 1);
        Box b1 = new Box(2, 2);
        Box b2 = new Box(3, 3);
        Box b4 = new Box(1, 1);
        LinkedList<Box> list = new LinkedList();
        list.add(b0);
        list.add(b1);
        list.add(b2);
        System.out.println(list.contains(b4));
        System.out.println(b0.equals(b4));
        System.out.println(Integer.toHexString(b0.hashCode()));
        System.out.println(Integer.toHexString(b4.hashCode()));
    }

    private static void introduction() {
        ArrayList<String> list0 = new ArrayList();
        ArrayList<Integer> list = new ArrayList();
        list0.add("Hello");
        list0.add("Java");
        list0.add("World");
        list0.add("C'mon!");
        System.out.println(list0);
        System.out.println((String)list0.get(0));
        list.add(0);
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);

        for(int i = 0; i < list.size(); ++i) {
            System.out.println(list.get(i));
        }

        Iterator iter = list.iterator();

        Integer i;
        while(iter.hasNext()) {
            i = (Integer)iter.next();
            System.out.println(i);
        }

        iter = list.iterator();

        while(iter.hasNext()) {
            i = (Integer)iter.next();
            System.out.println(i);
        }

        System.out.println(list.remove(list.size() - 1));
    }
}

