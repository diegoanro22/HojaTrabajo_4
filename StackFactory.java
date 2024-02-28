/*Universidad del Valle de Guatemala 
 *Genser Andree - 23401
 *Diego Rosales - 23258
*/

//Interfaz del stack con implementacion del patron de diseño factory
public class StackFactory<T> {
    
    public StackInterface<T> createStack(int type){
        switch (type) {
            case 1: return new ArrayListStack<T>();
            case 2: return new VectorStack<T>();
            default: throw new IllegalArgumentException("Selección no válida");

    }       
}
}
