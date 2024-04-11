package opgave03.models;

import opgave02.DoubleLinkedQueue;

import java.util.NoSuchElementException;

public class DoubleLinkedDeque<E> implements Deque<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    public DoubleLinkedDeque() {
        head = new Node<>(null);
        tail = new Node<>(null, head);
        head.next = tail;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void addFirst(E newElement) {

    }

    @Override
    public void addLast(E newElement) {

    }

    @Override
    public E removeFirst() {
        return null;
    }

    @Override
    public E removeLast() {
        return null;
    }

    @Override
    public E getFirst() {
        return null;
    }

    @Override
    public E getLast() {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    private void throwIfEmpty() {
        if (isEmpty()) {
            throw new NoSuchElementException("Queue is empty");
        }
    }

    private class Node<E> {
        E element;
        Node<E> next;
        Node<E> prev;

        public Node(E element, Node<E> next) {
            this.next = next;
            this.element = element;
        }

        public Node(E element, Node<E> next, Node<E> prev) {
            this.next = next;
            this.element = element;
        }

        public Node(E element) {
            this.element = element;
        }
    }
}
