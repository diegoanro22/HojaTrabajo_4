public class SinglyLinkedList<T>  implements ListInterface<T> {

    private Node<T> head;
    
    @Override
    public void add(T value) {
        Node<T> newNode = new Node<>(value);
        if (head == null) {
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.getNext() != null) {
                current = current.getNext();
            }
            current.setNext(newNode);
        }
    }

    @Override
    public void remove(T value) {
        if (head == null) {
            return;
        }
        if (head.getValue().equals(value)) {
            head = head.getNext();
            return;
        }
        Node<T> current = head;
        while (current.getNext() != null && !current.getNext().getValue().equals(value)) {
            current = current.getNext();
        }
        if (current.getNext() != null) {
            current.setNext(current.getNext().getNext());
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

    public Node<T> getHead() {
        return head;
    }

    public Node<T> getLast() {
        return getLast(head);
    }
    
    private Node<T> getLast(Node<T> node) {
        if (node.getNext() == null) {
            return node;
        }
        return getLast(node.getNext());
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }
    

}