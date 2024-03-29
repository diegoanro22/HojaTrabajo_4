/*Universidad del Valle de Guatemala 
 *Genser Andree - 23401
 *Diego Rosales - 23258
*/

//Interfaz de lista
public interface ListInterface<T> {
    void add(T value);
    T remove(int value);
    T get(int index);
    boolean isEmpty();
    T getHead();
    T getLast();
    int size();


}
