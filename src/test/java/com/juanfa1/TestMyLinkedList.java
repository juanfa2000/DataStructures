package com.juanfa1;

import org.junit.jupiter.api.Test;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Consumer;
import java.util.function.Predicate;

import static org.junit.jupiter.api.Assertions.*;

public class TestMyLinkedList {
    @Test
    public void testNewListShouldBeEmpty() {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        assertEquals(0, linkedList.size());
    }

    @Test
    public void testAppendElementIncreasesSize() {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.append(5);
        assertEquals(1, linkedList.size());
    }

    @Test
    public void testGetAddedElement() {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.append(50);
        Integer actual = linkedList.get(0);
        assertEquals(Integer.valueOf(50), actual);
    }

    @Test
    public void testSortSingleElementList() {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.append(5);
        linkedList.sort();
        assertEquals(Integer.valueOf(5), linkedList.get(0));
    }

    @Test
    public void testSortTwoElementList() {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.append(55);
        linkedList.append(5);
        linkedList.sort();
        assertEquals(Integer.valueOf(5), linkedList.get(0));
        assertEquals(Integer.valueOf(55), linkedList.get(1));
    }

    @Test
    public void testSortMultipleElementList() {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.append(66);
        linkedList.append(55);
        linkedList.append(5);
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
        linkedList.append(77);

        Iterator<Integer> iterator = linkedList.iterator();

        assertTrue(iterator.hasNext());
        assertEquals(Integer.valueOf(77), iterator.next());
    }

    @Test
    public void testIteratorWhitTwoElement() {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.append(77);
        linkedList.append(78);

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
            linkedList.append((int) (Math.random() * 100));
        }

        var iterElements = 0;
        for (var i : linkedList) {
            iterElements += 1;
        }

        assertEquals(size, iterElements);
    }

    @Test
    public void testGetWithIndexGreaterThanSize() {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.append(5);

        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            linkedList.get(10);
        });

        assertTrue(exception.getMessage().contains("Indice fuera de rango"));
    }

    @Test
    public void testGetWithNegativeIndex() {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.append(5);

        Exception exception = assertThrows(IndexOutOfBoundsException.class, () -> {
            linkedList.get(-1);
        });

        assertTrue(exception.getMessage().contains("Indice fuera de rango"));
    }

    @Test
    public void testForEachAppliesConsumer() {
        ///  Given a list with elements
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();
        linkedList.append(3);
        linkedList.append(6);
        linkedList.append(9);
        // Y un consumer que eleva cada elemento al cuadrado
        List<Integer> squares = new java.util.ArrayList<>();
        Consumer<Integer> consumer = i -> squares.add(i * i);


        // Cuando aplico el consumer a cada elemento
        linkedList.forEach(consumer);

        // Entonces los elementos de la lista están cada uno, elevados el a=cuadrado
        assertEquals(Integer.valueOf((9)), squares.get(0));
        assertEquals(Integer.valueOf((36)), squares.get(1));
        assertEquals(Integer.valueOf((81)), squares.get(2));
    }

    @Test
    public void testReplaceAllOnEmptyListWontFail() {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();

        try {
            linkedList.replaceAll(x -> x * 2);
        } catch (Exception e) {
            fail("This should have not failed damn it!");
        }
    }

    @Test
    public void testReplaceAllIncrementByOne() {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();

        linkedList.append(5);
        linkedList.append(10);
        linkedList.append(15);

        linkedList.replaceAll(x -> x + 1);

        assertEquals(Integer.valueOf(6), linkedList.get(0));
        assertEquals(Integer.valueOf(11), linkedList.get(1));
        assertEquals(Integer.valueOf(16), linkedList.get(2));
    }

    @Test
    public void testRemoveAllEmptyList() {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();

        try {
            linkedList.removeAll(num -> num % 2 == 0);
        } catch (Exception e) {
            fail("This should not have failed");
        }
    }

    @Test
    public void testRemoveAllSingleElement() {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();

        linkedList.append(5);

        linkedList.removeAll(num -> num == 5);

        assertEquals(0, linkedList.size());
    }

    @Test
    public void testRemoveAllTwoElement() {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();

        linkedList.append(5);
        linkedList.append(5);

        linkedList.removeAll(num -> num == 5);

        assertEquals(0, linkedList.size());
    }

    @Test
    public void testRemoveAllEvenNumbers() {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();

        linkedList.append(1);
        linkedList.append(2);
        linkedList.append(3);
        linkedList.append(4);
        linkedList.append(5);

        Predicate<Integer> isEven = num -> num % 2 == 0;

        linkedList.removeAll(isEven);

        assertEquals(3, linkedList.size());
        assertEquals(1, (int) linkedList.get(0));
        assertEquals(3, (int) linkedList.get(1));
        assertEquals(5, (int) linkedList.get(2));
    }

    @Test
    public void testRemoveAllDeleteEverything() {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();

        linkedList.append(2);
        linkedList.append(4);
        linkedList.append(6);

        Predicate<Integer> isEven = num -> num % 2 == 0;

        linkedList.removeAll(isEven);

        assertEquals(0, linkedList.size());
    }

    @Test
    public void testInsertAtBeginningWhenEmptyList() {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();

        linkedList.insert(0, 10);

        assertEquals(1, linkedList.size());
        assertEquals(10, linkedList.get(0));
    }

    @Test
    public void testInsertAtBeginningWhenNotEmptyList() {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();

        linkedList.append(11);
        linkedList.append(13);
        linkedList.append(14);

        linkedList.insert(0, 10);

        assertEquals(4, linkedList.size());
        assertEquals(10, linkedList.get(0));
        assertEquals(11, linkedList.get(1));
        assertEquals(13, linkedList.get(2));
        assertEquals(14, linkedList.get(3));
    }


    @Test
    public void testInsertAtEndWhenNotEmptyList() {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();

        linkedList.append(11);
        linkedList.append(13);
        linkedList.append(14);

        linkedList.insert(3, 15);

        assertEquals(4, linkedList.size());
        assertEquals(11, linkedList.get(0));
        assertEquals(13, linkedList.get(1));
        assertEquals(14, linkedList.get(2));
        assertEquals(15, linkedList.get(3));
    }

    @Test
    public void testAddInMiddle() {
        MyLinkedList<Integer> linkedList = new MyLinkedList<>();

        linkedList.append(10);
        linkedList.append(13);

        linkedList.insert(1, 12);

        assertEquals(3, linkedList.size());
        assertEquals(12, linkedList.get(1));
    }
    
}