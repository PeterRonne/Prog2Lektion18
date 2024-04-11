package opgave01;

import opgave01.models.LinkedNodeQueue;

public class Opgave01 {
    public static void main(String[] args) {
        LinkedNodeQueue<String> linkedNodeQueue = new LinkedNodeQueue<>();
        linkedNodeQueue.add("Hello");
        linkedNodeQueue.add("Hello");
        linkedNodeQueue.add("Hello");
        linkedNodeQueue.add("World");

        System.out.println(linkedNodeQueue.remove());
    }
}
