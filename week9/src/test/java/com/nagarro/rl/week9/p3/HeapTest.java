package com.nagarro.rl.week9.p3;

import org.junit.Assert;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HeapTest {

    private Heap<Integer> heap;

    @BeforeEach
    public void setUp() {
        heap = new Heap<>(10);
    }

    @Test
    public void testInsert() {
        heap.insert(3);
        heap.insert(1);
        heap.insert(4);
        heap.insert(2);
        Assert.assertEquals(4, heap.getSize());
        Assert.assertEquals(4, (int) heap.head());
    }

    @Test
    public void testRemove() {
        heap.insert(3);
        heap.insert(1);
        heap.insert(4);
        heap.insert(2);
        Assert.assertEquals(4, heap.getSize());
        Assert.assertEquals(4, (int) heap.remove());
        Assert.assertEquals(3, heap.getSize());
        Assert.assertEquals(3, (int) heap.head());
    }

    @Test
    public void testRemoveFromEmptyHeap() {
        assertThrows(IllegalStateException.class, () -> {
            heap.remove();
        });
    }

    @Test
    public void testClear() {
        heap.insert(3);
        heap.insert(1);
        heap.insert(4);
        heap.insert(2);
        heap.clear();
        Assert.assertEquals(0, heap.getSize());
        Assert.assertTrue(heap.isEmpty());
    }

    @Test
    public void testHeadFromEmptyHeap() {
        assertThrows(IllegalStateException.class, () -> {
            heap.head();
        });
    }

    @Test
    public void testIsEmpty() {
        Assert.assertTrue(heap.isEmpty());
        heap.insert(3);
        Assert.assertFalse(heap.isEmpty());
    }
}