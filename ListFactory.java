public class ListFactory<T> {
    
    public ListInterface<T> createList(int type){
        switch (type) {
            case 1: return new SinglyLinkedList<>();
            case 2: return new DoublyLinkedList<>();
            default: throw new IllegalArgumentException("Selección no válida");
        }
    }
}
