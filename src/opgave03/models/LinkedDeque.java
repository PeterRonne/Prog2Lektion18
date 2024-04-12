package opgave03.models;

import opgave02.DoubleLinkedQueue;

import java.util.NoSuchElementException;

public class LinkedDeque<E> implements Deque<E> {

    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    public LinkedDeque() {
        head = new Node<>(null);
        tail = new Node<>(null);
        head.next = tail;
        tail.prev = head;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void addFirst(E newElement) {
        Node<E> newNode = new Node<>(newElement, head, head.next);
        head.next.prev = newNode;
        head.next = newNode;
        size++;
    }

    @Override
    public void addLast(E newElement) {
        Node<E> newNode = new Node<>(newElement, tail.prev, tail);
        tail.prev.next = newNode;
        tail.prev = newNode;
        size++;
    }

    @Override
    public E removeFirst() {
        throwIfEmpty();
        E element = head.next.element;
        head.next.next.prev = head;
        head.next = head.next.next;
        size--;
        return element;
    }

    @Override
    public E removeLast() {
        throwIfEmpty();
        E element = tail.prev.element;
        tail.prev.prev.next = tail;
        tail.prev = tail.prev.prev;
        size--;
        return element;
    }

    @Override
    public E getFirst() {
        throwIfEmpty();
        return head.next.element;
    }

    @Override
    public E getLast() {
        throwIfEmpty();
        return tail.prev.element;
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

        public Node(E element, Node<E> prev, Node<E> next) {
            this.prev = prev;
            this.next = next;
            this.element = element;
        }

        public Node(E element) {
            this.element = element;
        }
    }
}
