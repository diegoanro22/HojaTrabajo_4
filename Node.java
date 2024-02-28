/*Universidad del Valle de Guatemala 
 *Genser Andree - 23401
 *Diego Rosales - 23258
*/

public class Node <T> {
    T value;
    Node<T> next;
    Node<T> previous;


    /**Metodo para asignale un valor T 
     * @param value
     */
    public Node(T value){
        this.value = value;
        this.next=null;
        this.previous=null;
    }

    public T getValue(){
        return value;
    }

    public Node<T> getNext(){
        return next;
    }

    public Node<T> getPrevious() {
        return previous;
    }

    public void setValue(T newValue){
        value = newValue;
    }

    public void setNext(Node<T> n){
        next = n;
    }

    public void setPrevious(Node<T> p) {
        previous = p;
    }

    
}