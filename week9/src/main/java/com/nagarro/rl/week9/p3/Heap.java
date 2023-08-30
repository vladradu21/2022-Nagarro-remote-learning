package com.nagarro.rl.week9.p3;

import java.util.*;

public class Heap<E extends Comparable<E>> {

    private final List<E> heap;

    public Heap() {
        this.heap = new ArrayList<>();
    }

    public Heap(int maxSize) {
        this.heap = new ArrayList<>(maxSize);
    }

    public int getSize() {
        return heap.size();
    }

    public void insert(E element) {
        heap.add(element);
        int current = heap.size() - 1;
        while (current > 0 && heap.get(current).compareTo(heap.get(parent(current))) > 0) {
            swap(current, parent(current));
            current = parent(current);
        }
    }

    public E remove() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        E removed = heap.get(0);
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        heapify(0);
        return removed;
    }

    public void clear() {
        heap.clear();
    }

    public E head() {
        if (heap.isEmpty()) {
            throw new IllegalStateException("Heap is empty");
        }
        return heap.get(0);
    }

    public boolean isEmpty() {
        return heap.isEmpty();
    }

    private void heapify(int i) {
        int left = left(i);
        int right = right(i);
        int largest = i;
        if (left < heap.size() && heap.get(left).compareTo(heap.get(largest)) > 0) {
            largest = left;
        }
        if (right < heap.size() && heap.get(right).compareTo(heap.get(largest)) > 0) {
            largest = right;
        }
        if (largest != i) {
            swap(i, largest);
            heapify(largest);
        }
    }

    private int parent(int i) {
        return (i - 1) / 2;
    }

    private int left(int i) {
        return 2 * i + 1;
    }

    private int right(int i) {
        return 2 * i + 2;
    }

    private void swap(int i, int j) {
        E temp = heap.get(i);
        heap.set(i, heap.get(j));
        heap.set(j, temp);
    }
}
