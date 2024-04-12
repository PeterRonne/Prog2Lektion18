package opgave02;

import opgave01.models.LinkedNodeQueue;
import opgave01.models.Queue;

import java.util.NoSuchElementException;

public class DoubleLinkedQueue<E> implements Queue<E> {
    private Node<E> head;
    private Node<E> tail;
    private int size = 0;

    public DoubleLinkedQueue() {
        head = new Node<>(null);
        tail = new Node<>(null);
        head.next = tail;
        tail.prev = head;
    }

    @Override
    public void add(E e) {
        Node<E> newNode = new Node<>(e, tail.prev, tail);
        tail.prev.next = newNode;
        tail.prev = newNode;
        size++;
    }

    @Override
    public E remove() {
        throwIfEmpty();
        E element = head.next.element;
        head.next.next.prev = head;
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
        tail = new Node<>(null);
        head.next = tail;
        tail.prev = head;
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
        Node<E> prev;

        public Node(E element, Node<E> next) {
            this.next = next;
            this.element = element;
        }

        public Node(E element, Node<E> prev, Node<E> next) {
            this.next = next;
            this.prev = prev;
            this.element = element;
        }

        public Node(E element) {
            this.element = element;
        }
    }
}
