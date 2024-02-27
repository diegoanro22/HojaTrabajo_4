import static org.junit.Assert.*;
import org.junit.Test;

public class TestImplementaciones {

    //Test de la implementacion de la clase Arraylist
    @Test
    public void TestArrayListPila() {
        StackInterface<Integer> pila = new ArrayListStack<>();
        pila.push(1);
        pila.push(2);
        pila.push(3);

        assertEquals(Integer.valueOf(3), pila.pop());
        assertEquals(Integer.valueOf(2), pila.pop());
        assertEquals(Integer.valueOf(1), pila.pop());
        assertTrue(pila.isEmpty());
    }

    //Test de la implementacion de la clase Vector
    @Test
    public void TestVectorPila() {
        VectorStack<Integer> pila = new VectorStack<>();
        pila.push(1);
        pila.push(2);
        pila.push(3);

        assertEquals(Integer.valueOf(3), pila.pop());
        assertEquals(Integer.valueOf(2), pila.pop());
        assertEquals(Integer.valueOf(1), pila.pop());
        assertTrue(pila.isEmpty());
    }

    //Test de la implementacion de la clase de listas dobles
    @Test
    public void TestDoublyLinkedList() {
        DoublyLinkedList<Integer> list = new DoublyLinkedList<>();
        assertTrue(list.isEmpty());

        list.add(1);
        assertFalse(list.isEmpty());
        assertEquals(Integer.valueOf(1), list.getHead().getValue());
        assertEquals(Integer.valueOf(1), list.getLast().getValue());

        list.add(2);
        assertEquals(Integer.valueOf(2), list.getLast().getValue());
    }

    //Test de la implementacion de la clase de lista unica
    @Test
    public void TestSinglyLinkedList() {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);

        assertEquals(Integer.valueOf(1), list.get(0).getValue());
        assertEquals(Integer.valueOf(2), list.get(1).getValue());
        assertEquals(Integer.valueOf(3), list.get(2).getValue());
        assertNull(list.get(3));
    }
}
