package com.nagarro.rl.week9.p3;

import java.util.ArrayList;
import java.util.List;

public class PriorityQueue<E extends Comparable<E>> implements Comparable<PriorityQueue<E>> {

    private Heap<E> heap;

    public PriorityQueue() {
        this.heap = new Heap<>();
    }

    public PriorityQueue(int maxSize) {
        this.heap = new Heap<>(maxSize);
    }

    public PriorityQueue(Heap<E> heap) {
        this.heap = heap;
    }

    public void insert(E element) {
        heap.insert(element);
    }

    public E remove() {
        return heap.remove();
    }

    public void clear() {
        heap.clear();
    }

    public E head() {
        return heap.head();
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    public List<E> sort(List<E> list) {
        PriorityQueue<E> ePriorityQueue = new PriorityQueue<>(list.size());
        for (E element : list) {
            ePriorityQueue.insert(element);
        }
        List<E> sortedList = new ArrayList<>(list.size());
        while (!ePriorityQueue.isEmpty()) {
            sortedList.add(ePriorityQueue.remove());
        }
        return sortedList;
    }

    @Override
    public int compareTo(PriorityQueue<E> other) {
        return this.head().compareTo(other.head());
    }

    public int getSize() {
        return heap.getSize();
    }
}


