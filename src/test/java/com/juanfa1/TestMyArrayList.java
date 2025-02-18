package com.juanfa1;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class TestMyArrayList {
    @Test
    public void testNewListShouldBeEmpty() {
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        assertEquals(0, arrayList.size());
    }

    @Test
    public void testAddElementIncreasesSize() {
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        arrayList.add(5);
        assertEquals(1, arrayList.size());
    }

    @Test
    public void testGetAddedElement() {
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        arrayList.add(50);
        Integer actual = arrayList.get(0);
        assertEquals(Integer.valueOf(50), actual);
    }

    @Test
    public void testSortSingleElementList() {
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        arrayList.add(5);
        arrayList.sort();
        assertEquals(Integer.valueOf(5), arrayList.get(0));
    }

    @Test
    public void testSortTwoElementList() {
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        arrayList.add(55);
        arrayList.add(5);
        arrayList.sort();
        assertEquals(Integer.valueOf(5), arrayList.get(0));
        assertEquals(Integer.valueOf(55), arrayList.get(1));
    }

    @Test
    public void testSortMultipleElementList() {
        MyArrayList<Integer> arrayList = new MyArrayList<>();
        arrayList.add(66);
        arrayList.add(55);
        arrayList.add(5);
        arrayList.sort();
        assertEquals(Integer.valueOf(5), arrayList.get(0));
        assertEquals(Integer.valueOf(55), arrayList.get(1));
        assertEquals(Integer.valueOf(66), arrayList.get(2));
    }
}