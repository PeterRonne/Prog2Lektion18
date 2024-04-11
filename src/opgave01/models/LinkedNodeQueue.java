package opgave01.models;

import java.util.NoSuchElementException;

public class LinkedNodeQueue<E> implements Queue<E>{
    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    public LinkedNodeQueue() {
        head = new Node<>(null);
        tail = new Node<>(null, head);
        head.next = tail;
    }

    @Override
    public void add(E e) {
        Node<E> newNode = new Node<>(e, tail);
        tail.next.next = newNode;
        tail.next = newNode;
        size++;
    }

    @Override
    public E remove() {
        throwIfEmpty();
        E element = head.next.element;
        head.next = head.next.next;
        size--;
        return element;
    }

    @Override
    public E element() {
        throwIfEmpty();
        return head.next.element;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        head = new Node<>(null);
        tail = new Node<>(null, head);
        head.next = tail;
        size = 0;
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

        public Node(E element, Node<E> next) {
            this.next = next;
            this.element = element;
        }

        public Node(E element) {
            this.element = element;
        }
    }
}
