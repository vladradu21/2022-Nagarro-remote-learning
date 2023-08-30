package com.nagarro.rl.week9.p3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.*;

class PriorityQueueTest {

    private PriorityQueue<Integer> priorityQueue;

    @Mock
    private Heap<Integer> heapMock;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
        priorityQueue = new PriorityQueue<>(heapMock);
    }

    @Test
    public void testInsert() {
        priorityQueue.insert(3);
        verify(heapMock).insert(3);
        priorityQueue.insert(1);
        priorityQueue.insert(4);
        priorityQueue.insert(2);
        verify(heapMock, times(4)).insert(anyInt());
    }

    @Test
    public void testRemove() {
        when(heapMock.remove()).thenReturn(4);
        assertEquals(4, (int) priorityQueue.remove());
        verify(heapMock).remove();
    }

    @Test
    public void testClear() {
        priorityQueue.clear();
        verify(heapMock).clear();
    }

    @Test
    public void testHead() {
        when(heapMock.head()).thenReturn(4);
        assertEquals(4, (int) priorityQueue.head());
        verify(heapMock).head();
    }

    @Test
    public void testIsEmpty() {
        when(heapMock.isEmpty()).thenReturn(true);
        assertEquals(true, priorityQueue.isEmpty());
        verify(heapMock).isEmpty();

        when(heapMock.isEmpty()).thenReturn(false);
        assertEquals(false, priorityQueue.isEmpty());
        verify(heapMock, times(2)).isEmpty();
    }

    @Test
    public void testSort() {
        List<Integer> list = List.of(3,1,4,2);

        when(heapMock.remove()).thenReturn(4, 3, 2, 1);
        List<Integer> sortedList = priorityQueue.sort(list);
        assertEquals(List.of(4,3,2,1), sortedList);
    }

    @Test
    public void testGetSize() {
        when(heapMock.getSize()).thenReturn(4);
        assertEquals(4, priorityQueue.getSize());
        verify(heapMock).getSize();
    }



}