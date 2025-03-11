package offer;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * 利用两个栈模拟一个队列
 */
public class Q9 {
    public static void main(String[] args) {
        QueueWithTwoStacks queue = new QueueWithTwoStacks();
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.print(queue.pop() + " | ");
        queue.push(4);
        while (!queue.isEmpty()) {
            System.out.print(queue.pop() + " | ");
        }
    }

}

class QueueWithTwoStacks {
    private Stack<Integer> inStack = new Stack<>();
    private Stack<Integer> outStack = new Stack<>();

    public boolean isEmpty() {
        return inStack.isEmpty() && outStack.isEmpty();
    }

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

class StackWithQueue {

    private Queue<Integer> queue1 = new LinkedList<>();
    private Queue<Integer> queue2 = new LinkedList<>();

    public static void main(String[] args) {
        StackWithQueue stack = new StackWithQueue();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.print(stack.pop() + " | ");
        stack.push(5);
        while (!stack.isEmpty()) {
            System.out.print(stack.pop() + " | ");
        }
    }

    public boolean isEmpty() {
        return queue1.isEmpty() && queue2.isEmpty();
    }

    public Integer pop() {
        if (queue1.isEmpty() && queue2.isEmpty()) {
            return null;
        }
        if (!queue2.isEmpty() && !queue1.isEmpty()) {
            throw new RuntimeException("data error");
        }
        if (queue1.isEmpty()) {
            Integer num;
            while (queue2.size() > 1) {
                num = queue2.poll();
                queue1.offer(num);
            }
            return queue2.poll();
        } else {
            Integer num;
            while (queue1.size() > 1) {
                num = queue1.poll();
                queue2.offer(num);
            }
            return queue1.poll();
        }

    }

    public void push(Integer num) {
        if (queue1.isEmpty()) {
            queue2.offer(num);
        } else {
            queue1.offer(num);
        }
    }

}

