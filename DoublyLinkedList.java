public class DoublyLinkedList<T> implements ListInterface<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size;

    @Override
    public void add(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            newNode.setPrevious(tail);
            tail = newNode;
        }
        size+=1;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + index);
        }

        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        T removedValue = current.value;

        if (current.previous != null) {
            current.previous.next = current.next;
        } else {
            head = current.next; // Removing the head
        }

        if (current.next != null) {
            current.next.previous = current.previous;
        } else {
            tail = current.previous; // Removing the tail
        }

        size--;
        return removedValue;
    }

    @Override
    public T get(int index) {
        Node<T> current = head;
        int currentIndex = 0;
        while (current != null) {
            if (currentIndex == index) {
                return current.getValue();
            }
            current = current.getNext();
            currentIndex++;
        }
        return null;
    }


    @Override
    public boolean isEmpty() {
        return head == null;
    }
    
    public T getHead() {
        return head.getValue();
    }

    public T getLast() {
        return tail.getValue();
    }

    @Override
    public int size() {
        return size;
    }
}
