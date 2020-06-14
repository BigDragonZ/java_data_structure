package list;

/**
 * @author <a href="291640894@qq.com">BigDragon</a >
 * @ClassName:MyArrayQueue Description:简单数组实现的队列
 * @Date Create on 2020/6/14 15:38
 * @since version1.0 Copyright 2019 All Rights Reserved.
 */
public class MyArrayQueue<T> implements MyQueue<T> {


    private static final int INIT_CAPATITY = 16;

    private static final int INCREAMENT = 10;

    private T[] values;

    /**
     * 队尾元素：也就是最先入队的元素位置
     */
    private int end;


    public MyArrayQueue() {
        end = -1;
        values = (T[]) new Object[INIT_CAPATITY];
    }

    @Override
    public boolean clear() {
        end = -1;
        return true;
    }

    @Override
    public boolean empty() {
        return end >= 0;
    }

    @Override
    public int length() {
        return end + 1;
    }

    @Override
    public T getHead() {
        if (end >= 0) {
            return values[end];
        }
        return null;
    }

    @Override
    public boolean enQueue(T t) {
        if (end >= values.length) {
            T[] newValues = (T[]) new Object[values.length + INCREAMENT];
            copy(values, 0, newValues, 0, end + 1);
            values = newValues;
        }
        for (int i = end; i > 0; i--) {
            values[i + 1] = values[i];
        }
        values[0] = t;
        end++;
        return true;
    }

    @Override
    public T deQueue() {
        T value = values[end];
        values[end] = null;
        end--;
        return value;
    }


    private boolean copy(T[] src, int srcPos, T[] dest, int destPos, int length) {
        for (int i = 0; i < length; i++) {
            dest[destPos + i] = src[srcPos + i];
        }
        return true;
    }
}