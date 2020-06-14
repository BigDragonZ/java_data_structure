package list;

import java.util.LinkedList;

/**
 * @author <a href="291640894@qq.com">BigDragon</a >
 * @ClassName:MyLinkedList Description: 单向链表形式的线性表的简单实现
 * @Date Create on 2020/6/14 09:39
 * @since version1.0 Copyright 2019 All Rights Reserved.
 */
public class MyLinkedMyList<T> implements MyList<T> {


    private int size;

    private Node<T> first;

    public MyLinkedMyList() {
        size = 0;
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
        Node<T> node = node(index);
        return node.item;
    }



    @Override
    public int indexOf(T t) {
        if (t == null){
            Node<T> x = first;
            for (int i = 0;i < size;i++){
                if (x.item == null) {
                    return i;
                }
                x = x.next;
            }
        }else {
            Node<T> x = first;
            for (int i = 0;i < size;i++){
                if (t.equals(x.item)) {
                    return i;
                }
                x = x.next;
            }
        }
        return -1;
    }

    @Override
    public boolean insert(int index, T t) {
        checkIndex(index);
        if (index == 0){
            Node<T> x = new Node<T>(t,first);
            first = x;
            size++;
            return true;
        }
        if (index == size){
            Node<T> last = node(size-1);


        }
        return false;
    }

    @Override
    public T delete(int index) {
        return null;
    }

    @Override
    public boolean update(int index, T t) {
        return false;
    }

    private static class Node<T> {
        private T item;
        private Node<T> next;

        public Node(T item, Node<T> next) {
            this.item = item;
            this.next = next;
        }
    }


    private Node<T> node(int index) {
        Node<T> x = first;
        for (int i = 0; i < index; i++) {
            x = x.next;
        }
        return x;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException();
        }
    }

    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.add(1);
        list.add(2);
        System.out.println(list);
        System.out.println(list.get(0));

    }
}