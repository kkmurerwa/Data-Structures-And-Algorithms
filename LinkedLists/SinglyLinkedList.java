package LinkedLists;

public class SinglyLinkedList<T> {
    public SinglyLinkedList(){}

    int size = 0;

    MyNode head;
    MyNode tail;

    public void add(T value) {
        MyNode newNode = new MyNode(value);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
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
        }
        
        size += 1;
    }

    public void printAll() {
        MyNode currentNode = head;
        while (currentNode != null) {
            System.out.println(String.valueOf(currentNode.value));

            currentNode = currentNode.next;
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
        size -= 1;
    }

    public void removeLast() {
        if (tail == null) {
            throw new NullPointerException();
        }

        MyNode currentNode = head;
        MyNode previousNode = null;

        while (currentNode != null) {
            if (currentNode.next != null) {
                previousNode = currentNode;
            }
            currentNode = currentNode.next;
        }

        previousNode.setNext(null);
        tail = previousNode;
        size -= 1;
    }

    public class MyNode {
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