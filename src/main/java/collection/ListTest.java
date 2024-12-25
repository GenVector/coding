package collection;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.concurrent.ConcurrentHashMap;

public class ListTest {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(3);
        list.add(2);
        list.add(1);
        list.remove(new Integer(1));
        for (Integer i : list) {
            System.out.println(i);
        }

        list = new ArrayList<>();
        list.add(3);
        list.add(2);
        list.add(1);
        list.remove(1);
        for (Integer i : list) {
            System.out.println(i);
        }
    }


}

class SetTest {
    public static void main(String[] args) {
        TreeSet<String> treeSet = new TreeSet<String>(Comparator.reverseOrder());
        treeSet.add("d");
        treeSet.add("c");
        treeSet.add("a");
        treeSet.add("b");
        treeSet.add("a");
        treeSet.add("b");
        for (String s : treeSet) {
            System.out.println(s);
        }

        System.out.println("----------------------");
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("d");
        linkedHashSet.add("c");
        linkedHashSet.add("a");
        linkedHashSet.add("b");
        for (String s : linkedHashSet) {
            System.out.println(s);
        }
    }

}

class MapTest {
    public static void main(String[] args) {
        // TreeMap 底层是红黑树，按照键的自然顺序或者创建TreeMap时提供的Comparator进行排序
        TreeMap<String, String> treeMap = new TreeMap<>();
        treeMap.put("3", "c");
        treeMap.put("1", "a");
        treeMap.put("2", "b");
        for (String s : treeMap.keySet()) {
            System.out.println(s);
        }
        System.out.println("----------------------");
        // LinkedHashMap 通过一个双向链表来维护元素的顺序。
        LinkedHashMap<String, String> linkedHashMap = new LinkedHashMap<>();
        linkedHashMap.put("3", "c");
        linkedHashMap.put("1", "a");
        linkedHashMap.put("2", "b");
        for (String s : linkedHashMap.keySet()) {
            System.out.println(s);
        }

        ConcurrentHashMap<String, String> concurrentHashMap = new ConcurrentHashMap<>();
        concurrentHashMap.put("3", "c");
    }
}
