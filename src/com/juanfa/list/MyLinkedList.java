package com.juanfa.list;


public class MyLinkedList<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    public void add(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
            tail = head;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    public int size() {
        return size;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getValue();
    }

    public void remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        head = null;
        size = 0;
    }

    public void removeLast(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        //public void removeLast() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("Cannot remove from empty list");
        }

        if (size == 1) {
            head = null;
        } else {
            Node<T> current = head;
            while (current.next.next != null) {
                current = current.next;
            }
            current.next = null;
        }
        size--;
    }

    /* if(index == size ){
         if(head == tail){
             head = null;
             tail = null;
         }else{
             Node <T> current = head;
             while (current.next != tail){
                 current = current.next;
             }
             current.next = null;
             tail = current;
         }
         size--;
     }*/
    public void removeI(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index);
        }
        if (index == size - 1) {
            if (index == size) {
                if (head == tail) {
                    head = null;
                    tail = null;
                } else {
                    Node<T> current = head;
                    while (current.next != tail) {
                        current = current.next;
                    }
                    current.next = null;
                    tail = current;
                }
            }
        } else {
            Node<T> current = head;
            for (int i = 0; i < index - 1; i++) {
                current = current.next;
            }
            current.next = current.next.next;
        }
        size--;


    }
    public void removeR(int index){
       head = head.next;
       size--;

    }
}