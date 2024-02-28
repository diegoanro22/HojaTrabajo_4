/*Universidad del Valle de Guatemala 
 *Genser Andree - 23401
 *Diego Rosales - 23258
*/

import java.util.Vector;

public class VectorStack<T> implements StackInterface<T> {

    /**
     *Creacion del almacenamiento en vector
     */
    protected Vector<T> stack = new Vector<T>(); 

    @Override
    //Agregar elemento a la pila
    public void push(T item) {
        stack.add(item); 
    }

    @Override
    //Eliminar elemento de la pila
    public T pop() {
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
        return stack.get(stack.size() - 1); 
    }
}
