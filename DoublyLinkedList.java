public class DoublyLinkedList<T> implements ListInterface<T> {

    private Node<T> head;
    private Node<T> tail;

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
    }

    @Override
    public void remove(T value) {
        if (head == null) {
            return;
        }
        if (head.getValue().equals(value)) {
            head = head.getNext();
            if (head != null) {
                head.setPrevious(null);
            } else {
                tail = null; 
            }
            return;
        }
        Node<T> current = head;
        while (current.getNext() != null && !current.getNext().getValue().equals(value)) {
            current = current.getNext();
        }
        if (current.getNext() != null) {
            current.setNext(current.getNext().getNext());
            if (current.getNext() != null) {
                current.getNext().setPrevious(current);
            } else {
                tail = current; 
            }
        }
    }

    @Override
    public Node<T> get(int index) {
        Node<T> current = head;
        int currentIndex = 0;
        while (current != null) {
            if (currentIndex == index) {
                return current;
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
    
    public Node<T> getHead() {
        return head;
    }

    public Node<T> getLast() {
        return tail;
    }
}
