package com.juanfa.list;

import junit.framework.TestCase;


public class MyLinkedListTest extends TestCase {
    public void testNewListShouldBeEmpty() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        assertEquals(0, list.size());
    }

    public void testAddingElementShouldIncreaseSize() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(10);
        assertEquals(1, list.size());
    }

    public void testGetElementAtIndex() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(5);
        list.add(10);

        assertEquals(2, list.size());
        assertEquals(Integer.valueOf(5), list.get(0));
        assertEquals(Integer.valueOf(10), list.get(1));
    }

    public void testGetWithInvalidIndexShouldThrowException() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(10);
        try {
            list.get(1);
            fail("IndexOutOfBoundsException was expected");
        } catch (IndexOutOfBoundsException e) {
        }
    }

    public void testShouldRemoveTheFirstElement() {
        // Given a list with one element
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(10);

        //When the fist one is removed
        list.remove(0);

        // Then the size is zero
        assertEquals(0, list.size());
        try{
            list.get(0);
            fail("Should have thrown IndexOutOfBoundException");
        }catch (IndexOutOfBoundsException e){}
    }

    public void testRemoveFirstElementWhitRandomNumbersOfElements() {
        int numberOfElements = (int) (Math.random() * 10) + 1;
        MyLinkedList<Integer> list = new MyLinkedList<>();
        for (int i = 0; i < numberOfElements; i++) {
            list.add(i);
        }
        list.removeR(0);
        assertEquals(numberOfElements - 1, list.size());
    }

    public void testShouldRemoveTheLastElement() {
        // Given a list with two element
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(10);
        list.add(11);

        //When the last one is removed
        list.removeLast(1);

        // Then the size is one
        assertEquals(1, list.size());
        assertEquals(Integer.valueOf(10), list.get(0));
    }

    public void testShouldRemoveIntermediateElement() {
        MyLinkedList<Integer> list = new MyLinkedList<>();
        list.add(10);
        list.add(11);
        list.add(13);

        list.removeI(1);

        assertEquals(2, list.size());
        assertEquals(Integer.valueOf(10), list.get(0));
        assertEquals(Integer.valueOf(13), list.get(1));
    }
}



