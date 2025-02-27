package com.juanfa1;

import java.util.Iterator;
import java.util.ListIterator;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;

public class MyLinkedList<T> implements Iterable<T> {
    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    public int size() {
        return size;
    }

    public void append(T element) {
        Node<T> newNode = new Node<>(element);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
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

    public void replaceAll(Function<T, T> func) {
        var it = mutableIterator();
        while (it.hasNext()) {
            var newVal = func.apply(it.getCurrent());
            it.set(newVal);
            it.next();
        }
    }

    public void removeAll(Predicate<T> predicate) {
        var it = mutableIterator();
        while (it.hasNext()) {
            if (predicate.test(it.getCurrent())) {
                it.remove();
                size--;
            } else {
                it.next();
            }
        }
    }

    public void forEach(Consumer<? super T> consumer) {
        for (T i : this) {
            consumer.accept(i);
        }
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedListIterator<>(head);
    }

    private MutableLinkedListIterator<T> mutableIterator() {
        return new MutableLinkedListIterator<>(head);
    }
}

// Add index to node to simplify iteration etc
class Node<T> {
    T data;
    Node<T> next;
    Node<T> prev;

    Node(T data) {
        this.data = data;
    }

}


class LinkedListIterator<T> implements Iterator<T> {
    protected Node<T> current;

    public LinkedListIterator(Node<T> head) {
        this.current = head;
    }

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

class MutableLinkedListIterator<T> extends LinkedListIterator<T> implements ListIterator<T> {
    public MutableLinkedListIterator(Node<T> head) {
        super(head);
    }

    public T getCurrent() {
        return this.current.data;
    }

    @Override
    public boolean hasPrevious() {
        return false;
    }

    @Override
    public T previous() {
        return current.prev.data;
    }

    @Override
    public int nextIndex() {
        return 0;
    }

    @Override
    public int previousIndex() {
        return 0;
    }

    @Override
    public void remove() {
        if (current.next == null) {
            current = null;
        } else {
            if (current.prev != null) {
                current.prev.next = current.next;
            }
            current.next.prev = current.prev;
            current = current.next;
        }
    }

    @Override
    public void set(T o) {
        this.current.data = o;
    }

    //TODO: Implementar el insert(n) usando este método
    @Override
    public void add(T o) {

    }
}

