import java.util.Vector;

public class VectorPila<T> implements StackInterface<T> {

    protected Vector<T> stack = new Vector<T>(); 

    @Override
    public void push(T item) {
        stack.add(item); 
    }

    @Override
    public T pop() {
        return stack.remove(stack.size() - 1);
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public T peek() {
        return stack.get(stack.size() - 1); 
    }
}
