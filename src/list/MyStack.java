package list;

/**
 * @author <a href="291640894@qq.com">BigDragon</a >
 * @ClassName:MyStack Description: 栈接口定义
 * @Date Create on 2020/6/14 15:06
 * @since version1.0 Copyright 2019 All Rights Reserved.
 */
public interface MyStack<T> {

    boolean clear();

    boolean empty();

    int length();

    T getTop();

    boolean push(T t);

    T pop() throws Exception;
}