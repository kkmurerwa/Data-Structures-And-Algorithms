package LinkedLists;

public class CircularLinkedList<T> {
    public CircularLinkedList() {}

    int size = 0;

    MyNode head;
    MyNode tail;

    public void add(T value) {
        MyNode newNode = new MyNode(value);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            tail.setNext(newNode);
            tail = newNode;
        }
        
        size += 1;
    }

    public void addFirst(T value) {
        MyNode newNode = new MyNode(value);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setNext(head);
            head = newNode;
            tail.setNext(head);
        }
        
        size += 1;
    }

    public void printAll() {
        MyNode currentNode = head;
        int index = 0;
        while (index < size) {
            System.out.println(String.valueOf(currentNode.value));

            currentNode = currentNode.next;
            index += 1;
        }
    }

    public void remove(int index) {
        if (index >= size){
            throw new IndexOutOfBoundsException();
        }


        int currentIndex = 0;
        MyNode currentNode = head;
        
        while(currentIndex < index - 1) {
            currentNode = currentNode.next;
            currentIndex += 1;
        }

        currentNode.setNext(currentNode.next.next);
        size -= 1;
    }

    public void removeFirst() {
        if (head == null){
            throw new NullPointerException();
        }

        head = head.next;
        tail.setNext(head);
        size -= 1;
    }

    public void removeLast() {
        if (tail == null) {
            throw new NullPointerException();
        }

        MyNode currentNode = head;
        MyNode previousNode = null;

        int index = 0;
        while (index < size) {
            previousNode = currentNode;
            currentNode = currentNode.next;
            index += 1;
        }

        previousNode.setNext(head);
        tail = previousNode;
        size -= 1;
    }
    
    class MyNode {
        MyNode next;
        T value;

        public MyNode(T value) {
            this.value = value;
        }

        public void setNext(MyNode node) {
            this.next = node;
        }

        public T value() {
            return value;
        }
    }

    public int size() {
        return size;
    }

    public MyNode getFirst() {
        return head;
    }

    public MyNode getLast() {
        return tail;
    }
}
