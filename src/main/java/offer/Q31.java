package offer;

import java.util.Stack;

//题目：输入两个整数序列，第一个序列表示栈的压入顺序，请判断第二个序列是
//否为该栈的弹出顺序。假设压入栈的所有数字均不相等。例如序列1、2、3、4、
//5是某栈的压栈序列，序列4、5、3、2、1是该压栈序列对应的一个弹出序列，但
//4、3、5、1、2就不可能是该压栈序列的弹出序列。
public class Q31 {
    public static void main(String[] args) {

        int[] arr1 = {1, 2, 3, 4, 5};
        int[] arr2 = {3, 4, 5, 2, 1};
        System.out.println(StackPushPopOrder.isPopOrder(arr1, arr2));
    }
}

class StackPushPopOrder {
    public static boolean isPopOrder(int[] pushA, int[] popA) {
        if (popA == null || pushA == null) {
            return false;
        }
        Stack<Integer> stack = new Stack<>();
        int push = 0;
        int pop = 0;
        while (push < pushA.length) {
            stack.push(pushA[push]);
            while (!stack.isEmpty() && stack.peek() == popA[pop]) {
                stack.pop();
                pop++;
            }
            push++;
        }

        System.out.println(push);
        System.out.println(pop);
        return stack.isEmpty();
    }
}