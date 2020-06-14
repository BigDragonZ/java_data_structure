package list;

/**
 * @author <a href="291640894@qq.com">BigDragon</a >
 * @ClassName:MyArrayList Description: 数组形式的线性表的简单实现
 * @Date Create on 2020/6/8 22:29
 * @since version1.0 Copyright 2019 All Rights Reserved.
 */
public class MyArrayMyList<T>  implements MyList<T> {
    /**
     * 初始化容量
     */
    private static final int INIT_CAPACITY = 16;
    /**
     * 扩容容量
     */
    private static final int INCREAMENT_CAPACITY = 10;

    private Integer size;
    private T[] values;

    public MyArrayMyList(Integer capatity) {
        this.size = 0;
        this.values = (T[]) new Object[size];
    }


    public MyArrayMyList() {
        this.size = 0;
        this.values = (T[]) new Object[INIT_CAPACITY];
    }

    public boolean clear() {
        size = 0;
        values = (T[]) new Object[values.length];
        return true;
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
    public T get(int index) {
        checkIndex(index);
        return values[index];
    }


    /**
     * 查看列表中是否存在该元素不存在返回-1
     *
     * @param t
     * @return
     */
    @Override
    public int indexOf(T t) {
        if (null == t) {
            for (int i = 0; i < size; i++) {
                if (values[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (t.equals(values[i])) {
                    return i;
                }
            }
        }
        return -1;
    }


    public T pre(int index) {
        checkIndex(index);
        return values[index - 1];
    }

    public T next(int index) {
        checkIndex(index);
        return values[index + 1];
    }


    /**
     * 在指定位置插入索引
     *
     * @param index
     * @param t
     */
    @Override
    public boolean insert(int index, T t) {
        checkIndex(index);
        if (size >= values.length) {
            T[] newValues = (T[]) new Object[values.length + INCREAMENT_CAPACITY];
            copy(values, 0, newValues, 0, values.length);
            values = newValues;
        }
        for (int i = size; i > index; i--) {
            values[i + 1] = values[i];
        }
        values[index] = t;
        size++;
        return true;
    }

    @Override
    public T delete(int index) {
        checkIndex(index);
        T t = values[index];
        for (int i = index; i > index; i++) {
            values[i] = values[i + 1];
        }
        size--;
        return t;
    }

    @Override
    public boolean update(int index, T t){
        checkIndex(index);
        values[index] = t;
        return true;
    }


    /**
     * 检查索引
     *
     * @param index
     */
    private void checkIndex(int index) {
        if (index >= size) {
            throw new IllegalArgumentException();
        }
    }

    private boolean copy(T[] src, int srcPos, T[] dest, int destPos, int length) {
        for (int i = 0; i < length; i++) {
            dest[destPos + i] = src[srcPos + i];
        }
        return true;
    }

}