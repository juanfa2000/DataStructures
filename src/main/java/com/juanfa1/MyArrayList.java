package com.juanfa1;

import java.util.Iterator;

public class MyArrayList<T> implements Iterable<T> {
    private int size = 0;
    private final T[] elements = (T[]) new Object[10];

    public int size() {
        return size;
    }

    public void add(T element) {
        elements[size] = element;
        size++;
    }

    @SuppressWarnings("unchecked")
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Indice fuera de rango: " + index);
        }
        return elements[index];
    }

    public void sort() {
        if (size > 1) {
            for (int i = 0; i < size - 1; i++) {
                for (int j = 0; j < size - 1 - i; j++) {
                    if (((Comparable) elements[j]).compareTo(elements[j + 1]) > 0) {
                        T temp = elements[j];
                        elements[j] = elements[j + 1];
                        elements[j + 1] = temp;
                    }
                }
            }

        }
    }

    @Override
    public Iterator<T> iterator() {
        return null;
    }
}