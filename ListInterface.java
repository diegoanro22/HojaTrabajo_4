public interface ListInterface<T> {
    void add(T value);
    T remove(int value);
    T get(int index);
    boolean isEmpty();
    T getHead();
    T getLast();
    int size();


}
