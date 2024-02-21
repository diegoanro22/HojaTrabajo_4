import static org.junit.Assert.*;
import org.junit.Test;

public class TestImplementaciones {

    @Test
    public void testArrayListPila() {
        CustomStack<Integer> pila = new ArrayListPila<>();
        pila.push(1);
        pila.push(2);
        pila.push(3);

        assertEquals(Integer.valueOf(3), pila.pop());
        assertEquals(Integer.valueOf(2), pila.pop());
        assertEquals(Integer.valueOf(1), pila.pop());
        assertTrue(pila.isEmpty());
    }

    @Test
    public void testVectorPila() {
        CustomStack<Integer> pila = new VectorPila<>();
        pila.push(1);
        pila.push(2);
        pila.push(3);

        assertEquals(Integer.valueOf(3), pila.pop());
        assertEquals(Integer.valueOf(2), pila.pop());
        assertEquals(Integer.valueOf(1), pila.pop());
        assertTrue(pila.isEmpty());
    }
}
