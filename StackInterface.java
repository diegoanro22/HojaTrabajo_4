/*Universidad del Valle de Guatemala 
 *Genser Andree - 23401
 *Diego Rosales - 23258
*/

//Interfaz del Stack
public interface StackInterface<T> {
    void push(T value);
    T pop();
    T peek();
    boolean isEmpty();
    
}
