package offer;

import java.util.Stack;

public class Q30 {
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
