package com.juanfa1;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.function.Consumer;

import static org.junit.jupiter.api.Assertions.*;

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

    @Test
    public void testIteratorOnEmptyList() {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        Iterator<Integer> iterator = linkedList.iterator();
        assertFalse(iterator.hasNext());
    }

    @Test()
    public void testIteratorOnEmptyListNext() {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        Iterator<Integer> iterator = linkedList.iterator();
        assertThrows(NoSuchElementException.class, iterator::next);
    }

    @Test
    public void testIteratorWhitOneElement() {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.add(77);

        Iterator<Integer> iterator = linkedList.iterator();

        assertTrue(iterator.hasNext());
        assertEquals(Integer.valueOf(77), iterator.next());
    }

    @Test
    public void testIteratorWhitTwoElement() {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.add(77);
        linkedList.add(78);

        var it = linkedList.iterator();
        assertTrue(it.hasNext());
        assertEquals(Integer.valueOf(77), it.next());
        assertTrue(it.hasNext());
        assertEquals(Integer.valueOf(78), it.next());
        assertFalse(it.hasNext());
    }

    @Test
    public void testIteratorWhitARandomNumbers() {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        var size = (int) (Math.random() * 100);

        for (int i = 0; i < size; i++) {
            linkedList.add((int) (Math.random() * 100));
        }

        var iterElements = 0;
        for (var i : linkedList) {
            iterElements += 1;
        }

        assertEquals(size, iterElements);
    }

    @Test
    public void testForEachAppliesConsumer() {
        ///  Given a list with elements
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.add(3);
        linkedList.add(6);
        linkedList.add(9);
        // Y un consumer que eleva cada elemento al cuadrado
        //Consumer<Integer> consumer = integer -> integer = integer * integer;
        AtomicInteger index = new AtomicInteger(0);
        Consumer<Integer> consumer = integer ->
                linkedList.set(index.getAndIncrement(), integer * integer);


        // Cuando aplico el consumer a cada elemento
        linkedList.forEach(consumer);

        // Entonces los elementos de la lista están cada uno, elevados el a=cuadrado
        assertEquals(Integer.valueOf((9)), linkedList.get(0));
        assertEquals(Integer.valueOf((36)), linkedList.get(1));
        assertEquals(Integer.valueOf((81)), linkedList.get(2));
    }
}