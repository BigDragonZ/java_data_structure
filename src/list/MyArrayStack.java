package list;

import java.util.Calendar;

/**
 * @author <a href="291640894@qq.com">BigDragon</a >
 * @ClassName:MyArrayStack Description: 数组实现的栈
 * @Date Create on 2020/6/14 15:10
 * @since version1.0 Copyright 2019 All Rights Reserved.
 */
public class MyArrayStack<T> implements MyStack<T> {

    private static final int INIT_CAPATITY = 16;

    private static final int INCREAMENT = 10;
    /**
     * 栈顶位置
     */
    private int top;
    /**
     * 存储元素的底层数组
     */
    private T[] values;
    /**
     * 当前栈内元素个数
     */
    private int size;

    public MyArrayStack() {
        size = 0;
        values = (T[]) new Object[INIT_CAPATITY];
    }

    public MyArrayStack(int capacity) {
        size = 0;
        values = (T[]) new Object[capacity];
    }


    @Override
    public boolean clear() {
        size = 0;
        // 此处有两种选择，可以考虑使用初始化容量，也可以使用当前容量value.length,考虑到内存利用率问题，清空时保存当前容量
        values = (T[]) new Object[INIT_CAPATITY];
        top = -1;
        return false;
    }

    @Override
    public boolean empty() {
        return size > 0;
    }

    @Override
    public int length() {
        return size;
    }

    @Override
    public T getTop() {
        if (top <= 0) {
            return null;
        }
        return values[top];
    }

    @Override
    public boolean push(T t) {
        if (size >= values.length) {
            T[] newValues = (T[]) new Object[values.length + INCREAMENT];
            copy(values, 0, newValues, 0, values.length);
            values = newValues;
        }
        top++;
        values[top] = t;
        size++;
        return true;
    }


    @Override
    public T pop() throws Exception {
        if (top <= 0) {
            throw new Exception("空栈");
        }
        T value = values[top];
        values[top] = null;
        top--;
        return value;
    }

    @Override
    public String toString() {
        return "";
    }


    private boolean copy(T[] src, int srcPos, T[] dest, int destPos, int length) {
        for (int i = 0; i < length; i++) {
            dest[destPos + i] = src[srcPos + i];
        }
        return true;
    }
}