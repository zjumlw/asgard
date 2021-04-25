package com.will.asgard.algo.leetcode;

/**
 * @ClassName MinStack
 * @Description Problem155
 * 设计一个支持 push ，pop ，top 操作，并能在常数时间内检索到最小元素的栈。
 *
 * push(x) —— 将元素 x 推入栈中。
 * pop() —— 删除栈顶的元素。
 * top() —— 获取栈顶元素。
 * getMin() —— 检索栈中的最小元素。
 *  
 *
 * 示例:
 *
 * 输入：
 * ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 *
 * 输出：
 * [null,null,null,null,-3,null,0,-2]
 *
 * 解释：
 * MinStack minStack = new MinStack();
 * minStack.push(-2);
 * minStack.push(0);
 * minStack.push(-3);
 * minStack.getMin();   --> 返回 -3.
 * minStack.pop();
 * minStack.top();      --> 返回 0.
 * minStack.getMin();   --> 返回 -2.
 *
 * 来源：力扣（LeetCode）
 * 链接：https://leetcode-cn.com/problems/min-stack
 * 著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 * @Auther maolingwei
 * @Date 2020-05-12 19:55
 * @Version 1.0
 **/
public class MinStack {

    private Integer[] elements;
    private int size;
    private int min;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    /** initialize your data structure here. */
    public MinStack() {
        elements = new Integer[DEFAULT_INITIAL_CAPACITY];
        min = Integer.MAX_VALUE;
    }

    public void push(int x) {
        ensureCapacity();
        elements[size++] = x;
        if (x <= min) {
            min = x;
        }
    }

    public void pop() {
        if (size == 0) {
            throw new IllegalStateException();
        }
        int e = elements[--size];
        if (e == min) {
            refindMin();
        }
        elements[size] = null;
        ensureCapacity();

    }

    public int top() {
        return elements[size - 1];
    }

    public int getMin() {
        return min;
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            resize(elements.length * 2);
        }
        if (size > 0 && size == elements.length / 4) {
            resize(elements.length / 2);
        }
    }

    private void resize(int capacity) {
        Integer[] temp = new Integer[capacity];
        if (size > 0) {
            System.arraycopy(elements, 0, temp, 0, size);
        }
        elements = temp;
    }

    private void refindMin() {
        min = Integer.MAX_VALUE;
        for (int i = 0; i < size; i++) {
            if (elements[i] <= min) {
                min = elements[i];
            }
        }
    }
}
