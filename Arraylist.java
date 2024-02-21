import java.util.ArrayList;

public class ArrayListPila<T> extends AbstractCustomStack<T> {
    private CustomStack<T> stack;

    public ArrayListPila() {
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
}
