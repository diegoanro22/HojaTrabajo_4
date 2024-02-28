import java.util.ArrayList;
import java.util.EmptyStackException;

public class ArrayListStack<T> implements StackInterface<T> {
    protected ArrayList<T> stack = new ArrayList<>();

    @Override
    //Agregar elemento a la pila
    public void push(T item) {
        stack.add(item);
    }

    @Override
    //Eliminar elemento de la pila
    public T pop() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.remove(stack.size() - 1);
    }

    @Override
    //Verifica si la pila esta vacia
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    //Devuelve el ultimo elemento de la pila
    public T peek() {
        if (isEmpty()) {
            throw new EmptyStackException();
        }
        return stack.get(stack.size() - 1);
    }

    public void printStack() {

    }
}
