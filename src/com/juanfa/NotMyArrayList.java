package com.juanfa;

public class NotMyArrayList {
    private Object[] container = new Object[]{};

    public NotMyArrayList(){}

    public NotMyArrayList(Object[] original) {
        container = new Object[original.length];
        System.arraycopy(container, 0, original, 0, original.length);
    }

    public int length() {
        return container.length;
    }

    // FIXME: This method has a O(n+1) complexity. Optimize!
    public void add(Object item) {
        var tmp = new Object[container.length + 1];
        System.arraycopy(container, 0, tmp, 0, container.length);
        tmp[container.length] = item;
        container = tmp;
    }

    public Object get(int index) {
        return container[index];
    }
}