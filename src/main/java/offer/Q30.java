package offer;

import java.util.Stack;

/*
 * 题目：定义栈的数据结构，请在该类型中实现一个能够得到栈中所含最小元素的min函数（时间复杂度应为O（1））。
 */
public class Q30 {
    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(1);
        minStack.push(2);
        minStack.push(-3);
        minStack.push(0);
        minStack.push(-7);
        minStack.push(-8);
        minStack.push(-5);
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
    }
}

class MinStack {

    private Stack<Integer> minStack = new Stack<>();
    private Stack<Integer> numStack = new Stack<>();

    public void push(int num) {
        numStack.push(num);
        if (!minStack.isEmpty()) {
            int min = minStack.peek();
            minStack.push(Math.min(num, min));
        } else {
            minStack.push(num);
        }
    }

    public int pop() {
        minStack.pop();
        return numStack.pop();
    }

    public int min() {
        return minStack.peek();
    }
}
