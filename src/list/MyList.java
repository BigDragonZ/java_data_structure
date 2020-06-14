package list;

/**
 * @author <a href="291640894@qq.com">BigDragon</a >
 * @ClassName:List Description: 线性表接口定义
 * @Date Create on 2020/6/14 09:47
 * @since version1.0 Copyright 2019 All Rights Reserved.
 */
public interface MyList<T> {

    boolean empty();

    int length();

    T get(int index);

    int indexOf(T t);

    boolean insert(int index,T t);

    T delete(int index);

    boolean update(int index,T t);

}