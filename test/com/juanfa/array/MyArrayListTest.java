package com.juanfa.array;

import junit.framework.TestCase;

public class MyArrayListTest extends TestCase {

    public void testNewListShouldBeEmpty() {
        MyArrayList<Integer> list = new MyArrayList<>();
        assertEquals(0, list.size());
    }

    public void testAddingElementShouldIncreaseSize() {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(100);
        assertEquals(1, list.size());


        MyArrayList<String> slist = new MyArrayList<>();
        slist.add("100");
        assertEquals(1, slist.size());
    }

    public void testGetShouldReturnAddedElement() {
        MyArrayList<Integer>list = new MyArrayList<>();
        list.add(10);
        Integer actual = list.get(0);
        assertEquals(Integer.valueOf(10), actual);
    }

    public void testGetWithInvalidIndexShouldThrowException() {
        MyArrayList<Integer>list = new MyArrayList<>();
        list.add(101);
        try {
            list.get(1);
            fail("Se esperaba IndexOutOfBoundsException");
        } catch (IndexOutOfBoundsException e) {
        }
    }
}
