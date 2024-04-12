package opgave03.models;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.NoSuchElementException;

import static org.junit.jupiter.api.Assertions.*;

class LinkedDequeTest {

    LinkedDeque<String> sut;

    @BeforeEach
    void setUp() {
        sut = new LinkedDeque<>();
    }

    @Test
    void isEmpty() {
        assertTrue(sut.isEmpty());
        sut.addFirst("Test1");
        sut.addFirst("Test2");
        assertFalse(sut.isEmpty());
    }

    @Test
    void addFirst() {
        // Arrange
        int expectedSize = 2;
        String test1 = "Test1";
        String test2 = "Test2";
        // Act
        sut.addFirst(test1);
        sut.addFirst(test2);
        int actualSize = sut.size();
        // Assert
        assertEquals(expectedSize,actualSize);
        assertEquals(test2, sut.getFirst());
    }

    @Test
    void addLast() {
        // Arrange
        int expectedSize = 2;
        String test1 = "Test1";
        String test2 = "Test2";

        // Act
        sut.addLast(test1);
        sut.addLast(test2);
        int actualSize = sut.size();

        // Assert
        assertEquals(expectedSize, actualSize);
        assertEquals(test2, sut.getLast());
    }


    @Test
    void removeFirst() {
        // Arrange
        String test1 = "Test1";
        String test2 = "Test2";
        sut.addFirst(test1);
        sut.addFirst(test2);

        // Act
        String removedElement = sut.removeFirst();

        // Assert
        assertEquals(test2, removedElement);
        assertEquals(test1, sut.getFirst());
    }


    @Test
    void removeLast() {
        // Arrange
        String test1 = "Test1";
        String test2 = "Test2";
        sut.addLast(test1);
        sut.addLast(test2);

        // Act
        String removedElement = sut.removeLast();

        // Assert
        assertEquals(test2, removedElement);
        assertEquals(test1, sut.getLast());
    }


    @Test
    void getFirst() {
        // Throw Exception when empty
        Exception actual = assertThrows(NoSuchElementException.class, () -> sut.getFirst());
        assertEquals("Deque is empty", actual.getMessage());

        // If Not empty get the first element in the dequeue
        sut.addFirst("test1");
        sut.addFirst("test2");
        sut.addLast("test3");
        assertEquals("test2", sut.getFirst());
    }

    @Test
    void getLast() {
        // Throw Exception when empty
        Exception actual = assertThrows(NoSuchElementException.class, () -> sut.getLast());
        assertEquals("Deque is empty", actual.getMessage());

        // If not empty get the first element in the dequeue
        sut.addLast("test1");
        sut.addLast("test2");
        sut.addLast("test3");
        assertEquals("test3", sut.getLast());
    }

    @Test
    void size() {
        int actual = sut.size();
        assertEquals(0, actual);
        sut.addFirst("Test");
        actual = sut.size();
        assertEquals(1, actual);
        sut.removeFirst();
        actual = sut.size();
        assertEquals(0, actual);
    }
}