package com.juanfa.array;

import java.util.Arrays;

class MyArrayList<T> {
    private int size = 0;
    private T[] elements = (T[]) new Object[10];

    public int size() {
        return size;
    }

    public void add(T element) {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
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

}