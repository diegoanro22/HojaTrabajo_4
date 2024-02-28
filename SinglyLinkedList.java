/*Universidad del Valle de Guatemala 
 *Genser Andree - 23401
 *Diego Rosales - 23258
*/
    
    public class SinglyLinkedList<T>  implements ListInterface<T> {

    private Node<T> head;
    private int size;
    
    /**
     *Creacion para almacenar en la lista unica
     */
    public SinglyLinkedList() {
        this.head = null;
        this.size = 0;
    }
    
    //Metodo para agregar
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
        size++;
    }

    //Metodo para remover 
    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Índice fuera de rango: " + index);
        }

        Node<T> temp = head;
        if (index == 0) {
            head = temp.getNext();
        } else {
            Node<T> prev = null;
            for (int i = 0; i < index; i++) {
                prev = temp;
                temp = temp.getNext();
            }
            prev.setNext(temp.getNext());
        }
        size--;
        return temp.getValue();
    }

    //Metodo para obtener valor
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

    public T getHead() {
        return head.getValue();
    }

    public T getLast() {
        return getLast(head).getValue();
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

    @Override
    public int size() {
        return size;
    }
    

}