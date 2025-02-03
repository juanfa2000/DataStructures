package com.juanfa;

import junit.framework.TestCase;

public class NotNotMyArrayListTest extends TestCase {

    public void testNewArrayShouldHaveSizeZero() {
        var array = new NotMyArrayList();

        assertEquals(0, array.length());
    }

    public void testArrayWithOneElementTheElementCanBeRetrieved(){
        // Given an array
        var array = new NotMyArrayList();

        // When adding one element
        array.add(1);

        // Then that element can be retrieved
        assertEquals(1, array.get(0));
    }

    public void testArrayWithTwoElementTheElementsCanBeRetrieved(){
        // Given an array
        var array = new NotMyArrayList();

        // When adding one element
        array.add(1);
        array.add(11);

        // Then that element can be retrieved
        assertEquals(1, array.get(0));
        assertEquals(11, array.get(1));
    }

    public void testGivenAnRandomNumberOfElementsTheLengthOfTheArrayMatchesTheElements(){
        // Given an array
        var array = new NotMyArrayList();

        // When adding a random number of elements
        int numberOfElements = (int)(Math.random() * 40) + 10;
        for (int i = 0; i < numberOfElements; i++){
            array.add(i);
        }

        // Then the length of the array marches the number of elements
        assertEquals(numberOfElements, array.length());
    }

    public void testNewArrayCanBeCreatedFrom_a_NativeArray(){
        // Given a native array of 3 elements
        var original = new Object[]{1, 2, 4};

        // When creating a MyArrayList from that native array
        var array = new NotMyArrayList(original);

        // Then the length of the MyArrayList is the same as the array
        assertEquals(original.length, array.length());
        // And the elements in the new array are the same as in the original array
        assertEquals(original[0], array.get(0));
        assertEquals(original[1], array.get(1));
        assertEquals(original[2], array.get(2));
    }
}