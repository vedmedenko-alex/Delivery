package com.solvd.delivery.classes.customLinkedList;

public class MyLinkedList {

    private static class Node<T> {

        T data;
        Node<T> next;

        Node(T data) {
            this.data = data;
        }
    }

    private static class CustomLinkedList<T> {
        private Node<T> head;
        public void add(T data) {
            Node<T> newNode = new Node<>(data);

            if (head == null) {
                head = newNode;
                return;
            }

            Node<T> currentNode = head;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }

            currentNode.next = newNode;
        }

        public void remove(T data) {

            if (head == null) {
                return;
            }

            if (head.data.equals(data)) {
                head = head.next;
                return;
            }

            Node<T> currentNode = head;
            while (currentNode.next != null && !currentNode.next.data.equals(data)) {
                currentNode = currentNode.next;
            }

            if (currentNode.next != null && currentNode.next.data.equals(data)) {
                currentNode.next = currentNode.next.next;
            }
        }

        public void print() {
            Node<T> currentNode = head;
            while (currentNode != null) {
                System.out.println(currentNode.data + " / ");
                currentNode = currentNode.next;
            }
        }

        public T get(int index) {
            if (index < 0) {
                System.out.println("Invalid index");
                return null;
            }

            Node<T> currentNode = head;
            int currentIndex = 0;
            while (currentNode != null) {
                if (currentIndex == index) {
                    System.out.println(currentNode.data);
                    return currentNode.data;
                }
                currentNode = currentNode.next;
                currentIndex ++;
            }
            System.out.println("No element");
            return null;
        }
    }

    public static void main(String[] args) {
        CustomLinkedList<String> list = new CustomLinkedList<>();

        list.add(" -abcd");
        list.add(" -efgh");
        list.add(" -ijkl");
        list.add(" -mnop");

        list.print();
        
        list.remove("ijkl");

        list.print();

        list.get(2);
    }
}
