package lock;

import com.google.common.collect.Lists;

import java.util.ArrayList;
import java.util.List;

public class SynchronizedTest {

    public static void main(String[] args) {
        Integer a = 1;
        Integer b = 2;
        Integer c = 3;
        Integer d = 3;
        Integer e = 321;
        Integer f = 321;
        Long g = 3L;
        System.out.println(c == d);
        System.out.println(e == f);
        System.out.println(c == (a + b));
        System.out.println(c.equals(a + b));
        System.out.println(g == (a + b));
        System.out.println(g.equals(a + b));
        List<String> strings = Lists.newArrayList("1", "2");
        String[] strings1 = strings.stream().toArray(String[]::new);
    }


}

class TypeErasureGenerics<E> {
//    public void doSomething(Object item) {
//        if (item instanceof E) {
//            // 不合法，无法对泛型进行实例判断 ...
//        }
//        E newItem = new E(); // 不合法，无法使用泛型创建对象
//        E[] itemArray = new E[10]; // 不合法，无法使用泛型创建数组
//    }
}
