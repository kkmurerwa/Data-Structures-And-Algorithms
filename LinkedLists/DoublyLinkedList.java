package LinkedLists;

public class DoublyLinkedList<T> {
    public DoublyLinkedList() {}

    int size = 0;

    DoublyNode head;
    DoublyNode tail;

    public void add(T value) {
        DoublyNode newNode = new DoublyNode(value);

        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            newNode.setPrevious(tail);
            tail.setNext(newNode);
            tail = newNode;
        }
        
        size += 1;
    }

    public void printAll() {
        DoublyNode currentNode = head;
        while (currentNode != null) {
            System.out.println(String.valueOf(currentNode.value));

            currentNode = currentNode.next;
        }
    }

    public void printAllWithNextAndPrevious() {
        DoublyNode currentNode = head;
        while (currentNode != null) {
            System.out.println("=====================================");
            
            if (currentNode.previous != null) {
                System.out.println("Previous Value: " + String.valueOf(currentNode.previous.value));
            }

            System.out.println("Current Value: " + String.valueOf(currentNode.value));
            
            if (currentNode.next != null) {
                System.out.println("Next Value: " + String.valueOf(currentNode.next.value));
            }

            System.out.println("=====================================");

            currentNode = currentNode.next;
        }
    }

    public void remove(int index) {
        if (index >= size){
            throw new IndexOutOfBoundsException();
        }

        int currentIndex = 0;
        DoublyNode currentNode = head;
        
        while(currentIndex < index - 1) {
            currentNode = currentNode.next;
            currentIndex += 1;
        }

        DoublyNode target = currentNode.next.next;

        currentNode.setNext(target);

        if (target != null) {
            target.setPrevious(currentNode);
        }

        size -= 1;
    }

    public void removeFirst() {
        if (head == null){
            throw new NullPointerException();
        }

        head = head.next;

        if (head.next != null) {
            head.setPrevious(null);
        }
        size -= 1;
    }

    public void removeLast() {
        if (tail == null) {
            throw new NullPointerException();
        }

        DoublyNode previousNode = tail.previous;

        if (previousNode != null) {
            previousNode.setNext(null);
            tail = previousNode;
        }

        size -= 1;
    }

    class DoublyNode {
        DoublyNode next;
        DoublyNode previous;
        T value;

        public DoublyNode(T value) {
            this.value = value;
        }

        public void setNext(DoublyNode node) {
            this.next = node;
        }

        public void setPrevious(DoublyNode node) {
            this.previous = node;
        }

        public T value() {
            return value;
        }
    }

    public int size() {
        return size;
    }

    public DoublyNode getFirst() {
        return head;
    }

    public DoublyNode getLast() {
        return tail;
    }
}
