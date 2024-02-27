public interface ListInterface<T> {
    void add(T value);
    void remove(T value);
    Node<T> get(int index);
    boolean isEmpty();
    Node<T> getHead();
    Node<T> getLast();


}
