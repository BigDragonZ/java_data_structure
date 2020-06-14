package list;

import com.sun.tools.corba.se.idl.constExpr.Not;

/**
 * @author <a href="291640894@qq.com">BigDragon</a >
 * @ClassName:MyLinkedQueue Description:
 * @Date Create on 2020/6/14 15:49
 * @since version1.0 Copyright 2019 All Rights Reserved.
 */
public class MyLinkedQueue<T> implements MyQueue<T> {

    private int size;
    private Node<T> top;

    public MyLinkedQueue() {
        size = 0;
    }

    @Override
    public boolean clear() {
        top = null;
        size = 0;
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
    public T getHead() {
        if (size == 0) {
            return null;
        }
        return top.item;
    }

    @Override
    public boolean enQueue(T t) {
        Node<T> x = new Node<>(t, top);
        top = x;
        size++;
        return true;
    }

    @Override
    public T deQueue() {
        if (size == 0) {
            return null;
        }
        T t = top.item;
        top = top.next;
        size--;
        return t;
    }

    private static class Node<T> {
        private T item;
        private Node<T> next;

        public Node(T item, Node<T> next) {
            this.item = item;
            this.next = next;
        }
    }
}