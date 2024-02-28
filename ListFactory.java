/*Universidad del Valle de Guatemala 
 *Genser Andree - 23401
 *Diego Rosales - 23258
*/

public class ListFactory<T> {
    
    /**Interfaz con implementacion del patron de diseño factory
     * @param type
     * @return
     */
    public ListInterface<T> createList(int type){
        switch (type) {
            case 1: return new SinglyLinkedList<>();
            case 2: return new DoublyLinkedList<>();
            default: throw new IllegalArgumentException("Selección no válida");
        }
    }
}
