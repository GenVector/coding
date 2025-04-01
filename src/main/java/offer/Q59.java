package offer;

import java.util.ArrayDeque;
import java.util.ArrayList;

public class Q59 {
    public static ArrayList<Integer> maxInWindows(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        // 窗口大于数组长度的时候，返回空
        if (size <= num.length && size != 0) {
            // 双向队列
            ArrayDeque<Integer> deque = new ArrayDeque<Integer>();
            //先遍历一个窗口
            for (int i = 0; i < size; i++) {
                // 去掉比自己先进队列的小于自己的值
                while (!deque.isEmpty() && num[deque.peekLast()] < num[i])
                    deque.pollLast();
                deque.add(i);
            }
            // 遍历后续数组元素
            for (int i = size; i < num.length; i++) {
                // 取窗口内的最大值
                res.add(num[deque.peekFirst()]);
                while (!deque.isEmpty() && deque.peekFirst() < (i - size + 1))
                    //弹出窗口移走后的值
                    deque.pollFirst();
                // 加入新的值前，去掉比自己先进队列的小于自己的值
                while (!deque.isEmpty() && num[deque.peekLast()] < num[i])
                    deque.pollLast();
                deque.add(i);
            }
            res.add(num[deque.pollFirst()]);
        }
        return res;
    }

    public static ArrayList<Integer> maxInWindows2(int[] num, int size) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        //窗口大于数组长度的时候，返回空
        if (size <= num.length && size != 0) {
            //数组后面要空出窗口大小，避免越界
            for (int i = 0; i <= num.length - size; i++) {
                //寻找每个窗口最大值
                int max = 0;
                for (int j = i; j < i + size; j++) {
                    if (num[j] > max)
                        max = num[j];
                }
                res.add(max);
            }
        }
        return res;
    }

}
