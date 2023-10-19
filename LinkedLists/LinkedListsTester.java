package LinkedLists;

public class LinkedListsTester {
    public static void main(String[] args) {
        // testSinglyLinkedList();

        testDoublyLinkedList();
    }

    public static void testDoublyLinkedList() {
        DoublyLinkedList<String> linkedList = new DoublyLinkedList<String>();
        linkedList.add("Hello");
        linkedList.add("World");
        linkedList.add("How");
        linkedList.add("is");
        linkedList.add("Java");
        linkedList.add("Coming");
        linkedList.add("Along");

        linkedList.printAllWithNextAndPrevious();

        System.out.println("\n\n\n");

        linkedList.removeFirst();
        linkedList.printAllWithNextAndPrevious();

        System.out.println("\n\n\n");
        linkedList.removeLast();
        linkedList.printAllWithNextAndPrevious();

        System.out.println("\n\n\n");
        linkedList.remove(3);
        linkedList.printAllWithNextAndPrevious();
    }

    public static void testSinglyLinkedList() {
        SinglyLinkedList<String> linkedList = new SinglyLinkedList<String>();
        linkedList.add("Hello");
        linkedList.add("World");
        linkedList.add("How");
        linkedList.add("is");
        linkedList.add("Java");
        linkedList.add("Coming");
        linkedList.add("Along");

        linkedList.printAll();

        System.out.println("Size: " + linkedList.size());

        linkedList.remove(2);

        linkedList.printAll();
        System.out.println("Size: " + linkedList.size());

        linkedList.addFirst("******************");
        linkedList.printAll();
        System.out.println("Size: " + linkedList.size());

        linkedList.removeFirst();
        linkedList.printAll();
        System.out.println("Size: " + linkedList.size());

        linkedList.removeLast();
        linkedList.printAll();
        System.out.println("Size: " + linkedList.size());

        linkedList.remove(21);
    }
}
