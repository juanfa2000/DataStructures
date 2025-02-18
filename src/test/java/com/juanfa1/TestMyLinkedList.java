package com.juanfa1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMyLinkedList {
    @Test
    public void testNewListShouldBeEmpty() {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        assertEquals(0, linkedList.size());
    }

    @Test
    public void testAddElementIncreasesSize() {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.add(5);
        assertEquals(1, linkedList.size());
    }

    @Test
    public void testGetAddedElement() {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.add(50);
        Integer actual = linkedList.get(0);
        assertEquals(Integer.valueOf(50), actual);
    }

    @Test
    public void testSortSingleElementList() {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.add(5);
        linkedList.sort();
        assertEquals(Integer.valueOf(5), linkedList.get(0));
    }

    @Test
    public void testSortTwoElementList() {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.add(55);
        linkedList.add(5);
        linkedList.sort();
        assertEquals(Integer.valueOf(5), linkedList.get(0));
        assertEquals(Integer.valueOf(55), linkedList.get(1));
    }

    @Test
    public void testSortMultipleElementList() {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.add(66);
        linkedList.add(55);
        linkedList.add(5);
        linkedList.sort();
        assertEquals(Integer.valueOf(5), linkedList.get(0));
        assertEquals(Integer.valueOf(55), linkedList.get(1));
        assertEquals(Integer.valueOf(66), linkedList.get(2));
    }
}