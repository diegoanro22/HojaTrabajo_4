/*Universidad del Valle de Guatemala 
 *Genser Andree - 23401
 *Diego Rosales - 23258
*/

public class CustomStack <T> {
    private Node<T> lastNode;
    private Node<T> firstNode;


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

public T pop(){
    if (firstNode!= null){
        T value = firstNode.getValue();
        firstNode = firstNode.getNext();
        return value;
    }else{
        throw new IllegalStateException("Error");
    }
}

public T peek(){
    return firstNode.getValue();
}

public boolean isEmpty(){
    return firstNode == null;
}

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
