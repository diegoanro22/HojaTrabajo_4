public interface IntAbstractCustomTack<T> {
    void push(T item);
    T pop();
    T peek();
    boolean isEmpty();
}
