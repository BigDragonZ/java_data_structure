package list;

/**
 * @author <a href="291640894@qq.com">BigDragon</a >
 * @ClassName:MyLinkedStack Description: 链表实现的栈:单向链表实现
 * @Date Create on 2020/6/14 15:29
 * @since version1.0 Copyright 2019 All Rights Reserved.
 */
public class MyLinkedStack<T> implements MyStack<T> {

    /**
     * 栈顶元素位置，考虑到入栈出栈的特殊，特将链表的头结点设置为栈顶，这样调整起来简单
     */
    private Node<T> top;
    private int size;

    public MyLinkedStack() {
        size = 0;
    }

    @Override
    public boolean clear() {
        top = null;
        size = 0;
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
        if (top == null){
            return null;
        }
        return top.item;
    }

    @Override
    public boolean push(T t) {
        Node<T> node = new Node<>(t,top);
        top = node;
        size++;
        return true;
    }

    @Override
    public T pop() throws Exception {
        T t = top.item;
        top = top.next;
        size--;
        return null;
    }

    public static class Node<T> {
        private T item;
        private Node<T> next;

        public Node(T item, Node<T> next) {
            this.item = item;
            this.next = next;
        }
    }
}