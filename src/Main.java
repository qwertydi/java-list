package src;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello!");

        LinkedList linkedList = new LinkedList();
        linkedList.addToList(new Node(1));
        linkedList.addToList(new Node(2));
        linkedList.addToList(new Node(3));
        linkedList.removeFromIndex(0);
        linkedList.addToIndex(new Node(99), 1);

        System.out.println("ReferenceLinkedList: {}" + linkedList);
    }

    public static class Node {
        int value;
        Node next;

        public Node(int value) {
            this.value = value;
            this.next = null;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "value=" + value +
                    ", next=" + next +
                    '}';
        }
    }

    public static class LinkedList {
        Node head;
        int length;

        public LinkedList() {
            System.out.println("Init LinkedList!");
            this.head = null;
            this.length = 0;
        }

        public void addToList(Node node) {
            System.out.println("Add to list val: " + node.value);
            // if head is null create a new item to the list
            if (this.head == null) {
                this.head = node;
                this.length++;
                return;
            }

            Node last = this.head;
            while (last.next != null) {
                last = last.next;
            }

            last.next = node;
            this.length++;
        }

        public void addToIndex(Node node, int index) {
            System.out.println("Add to list index: " + node.value + " " + index);
            // if head is null create a new item to the list
            if (index > this.length) {
                throw new IndexOutOfBoundsException("Index is out of bounds! Index: " + index + " Size: " + this.length);
            }

            int position = 0;
            Node previousNode = null;
            Node nextNode = null;
            Node last = this.head;

            if (index == 0) {
                this.head = node;
                this.head.next = last;
                this.length++;
            }

            while (last.next != null && position <= index) {
                position++;
                previousNode = last;
                nextNode = last.next;
            }

            if (previousNode == null) {
                throw new IndexOutOfBoundsException("Invalid previousNode!");
            }

            previousNode.next = node;
            node.next = nextNode;
            this.length++;
        }

        public void removeFromIndex(int index) {
            System.out.println("Removing from list, index:" + index);

            if (index > this.length) {
                throw new IndexOutOfBoundsException("Index is out of bounds! Index: " + index + " Size: " + this.length);
            }

            Node prev = null;
            Node curr = this.head;
            Node next = curr.next;

            if (index == 0) {
                this.head = next;
                this.length--;
            }

            int counter = 0;
            while (next.next != null && counter <= index) {
                counter++;
                prev = curr;
                curr = next;
                next = curr.next;
                if (counter == index) {
                    prev.next = next;
                    this.length--;
                    return;
                }
            }
        }

        @Override
        public String toString() {
            return "LinkedList{" +
                    "head=" + head +
                    ", length=" + length +
                    '}';
        }
    }
}