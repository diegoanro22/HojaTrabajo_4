import java.util.Vector;

public class VectorPila<T> extends AbstractCustomStack<T> {
    private CustomStack<T> stack;

    public VectorPila() {
        stack = new CustomStack<>();
    }

    @Override
    public void push(T item) {
        stack.push(item);
    }

    @Override
    public T pop() {
        return stack.pop();
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public T peek() {
        return stack.peek();
        
    }
}
