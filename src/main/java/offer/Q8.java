package offer;

import java.util.Stack;

public class Q8 {
    public static void main(String[] args) {

    }

}

class QueueWithTwoStacks {
    private Stack<Integer> inStack = new Stack<>();
    private Stack<Integer> outStack = new Stack<>();

    public void push(Integer num) {

        inStack.push(num);
    }

    public Integer pop() {
        if (outStack.size() > 0) {
            return outStack.pop();
        } else if (inStack.size() > 0) {
            while (inStack.size() > 0) {
                outStack.push(inStack.pop());
            }
            return outStack.pop();
        }
        throw new RuntimeException("queue is null");
    }

}
