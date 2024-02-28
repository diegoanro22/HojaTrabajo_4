/*Universidad del Valle de Guatemala 
 *Genser Andree - 23401
 *Diego Rosales - 23258
*/

public class CustomStack <T> implements  StackInterface<T>{
    private Node<T> lastNode;
    private Node<T> firstNode;

@Override
//Agregar elemento a la pila
public void push(T value){
    if (lastNode == null) {
        lastNode = new Node<T>(value);
        firstNode = lastNode;
    }else{
        Node<T> current = new Node<T>(value);
        current.setNext(firstNode);
        firstNode = current;
    }
}

@Override
//Eliminar elemento de la pila
public T pop(){
    if (firstNode!= null){
        T value = firstNode.getValue();
        firstNode = firstNode.getNext();
        return value;
    }else{
        throw new IllegalStateException("Error");
    }
}

@Override
//Devuelve el ultimo elemento de la pila
public T peek(){
    return firstNode.getValue();
}

@Override
//Verifica si la pila esta vacia
public boolean isEmpty(){
    return firstNode == null;
}

/**
 * Metodo de output para mostrar el stack
 */
public void printStack() {
    Node<T> current = firstNode;
    System.out.print("[");
    while (current != null) {
        System.out.print(current.getValue());
        if (current.getNext() != null) {
            System.out.print(", ");
        }
        current = current.getNext();
    }
    System.out.println("]");
}


}
