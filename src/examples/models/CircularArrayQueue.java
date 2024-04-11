package examples.models;

import opgave01.models.Queue;

import java.util.NoSuchElementException;

public class CircularArrayQueue<E> implements Queue<E> {
    private E[] elements;
    private int size = 0;
    private int head = 0;
    private int tail = 0;

    public CircularArrayQueue(int size) {
        elements = (E[]) new Object[size];
    }

    @Override
    public void add(E element) {
        if (size == elements.length) {
            increaseCapacity();
        }
        size++;
        elements[tail] = element;
        tail = (tail + 1) % elements.length;
    }

    @Override
    public E remove() {
        throwIfEmpty();
        E removed = elements[head];
        head = (head + 1) % elements.length;
        size--;
        return removed;
    }


    @Override
    public E element() {
        throwIfEmpty();
        return elements[head];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        head = 0;
        tail = 0;
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    private void throwIfEmpty() {
        if (size == 0) {
            throw new NoSuchElementException("Queue is empty");
        }
    }

    private void increaseCapacity() {
        E[] newElementsArray = (E[]) new Object[elements.length * 2];
        for (int index = 0; index < elements.length; index++) {
            newElementsArray[index] = elements[(head + index) % elements.length];
        }
        elements = newElementsArray;
        head = 0;
        tail = size;
    }

}
