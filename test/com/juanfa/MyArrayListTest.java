package com.juanfa;

import junit.framework.TestCase;

public class MyArrayListTest extends TestCase {

    public void testNewListShouldBeEmpty() {
        MyArrayList<Integer> list = new MyArrayList<>();
        assertEquals(0, list.size());
    }

    public void testAddingElementShouldIncreaseSize() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(10);
        assertEquals(1, list.size());
    }

    public void testGetShouldReturnAddedElement() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(10);
        assertEquals((Integer) 10, list.get(0));
    }

    public void testGetWithInvalidIndexShouldThrowException() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(10);
        try {
            list.get(1);
            fail("Se esperaba IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
        }
    }
}
