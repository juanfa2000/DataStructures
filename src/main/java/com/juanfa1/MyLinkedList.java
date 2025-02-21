package com.juanfa1;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;

public class MyLinkedList<T> implements Iterable<T> {
    private Node<T> head;
    private int size = 0;

    public int size() {
        return size;
    }

    public void add(T element) {
        Node<T> newNode = new Node<>(element);

        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Indice fuera de rango: " + index);
        }

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.data;
    }

    public void sort() {
        if (size <= 1) {
            return;
        }

        boolean swapped;
        do {
            swapped = false;
            Node<T> current = head;
            Node<T> previous = null;
            Node<T> next = head.next;

            while (next != null) {
                if (((Comparable) current.data).compareTo(next.data) > 0) {
                    swapped = true;

                    if (previous == null) {
                        head = next;
                    } else {
                        previous.next = next;
                    }

                    current.next = next.next;
                    next.next = current;

                    previous = next;
                    next = current.next;
                } else {
                    previous = current;
                    current = next;
                    next = next.next;
                }
            }
        } while (swapped);
    }
    public void set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Indice fuera de rango: " + index);
        }

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.data = element;
    }

    public void forEach(Consumer<? super T> consumer) {
        for (T i: this){
            consumer.accept(i);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator();
    }

    private static class Node<T> {
        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
            this.next = null;
        }
    }

    private class LinkedListIterator implements Iterator<T> {
        private Node<T> current = head;

        @Override
        public boolean hasNext() {
            return current != null;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }
            T data = current.data;
            current = current.next;
            return data;
        }
    }
}

