package LinkedLists;

import java.util.LinkedList;
import LinkedLists.SinglyLinkedList.MyNode;

public class LinkedListsTester {
    public static void main(String[] args) {
        testSinglyLinkedList();

        LinkedList<String> list = new LinkedList<>();
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

        MyNode first = linkedList.getFirst();
        System.out.println("First: " + first.value);

        MyNode last = linkedList.getLast();
        System.out.println("Last: " + last.value);

        linkedList.remove(21);
    }
}
