package list;

import sun.security.util.Length;

/**
 * @author <a href="291640894@qq.com">BigDragon</a >
 * @ClassName:MyQueue Description: 队列接口定义
 * @Date Create on 2020/6/14 15:04
 * @since version1.0 Copyright 2019 All Rights Reserved.
 */
public interface MyQueue<T> {
    boolean clear();

    boolean empty();

    int length();

    T getHead();

    boolean enQueue(T t);

    T deQueue();


}