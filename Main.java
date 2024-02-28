import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        StackFactory<Integer> stackFactory = new StackFactory<Integer>();
        ListFactory<Integer> liStackFactory = new ListFactory<Integer>();
        StackInterface<Integer> stack = null;
        ListInterface<Integer> list = null;
        String[] ADT = { "Stack", "Lista" };
        String[] Stack = { "ArrayListStack", "VectorStack" };
        String[] List = { "SinglyLinkedList", "DoublyLinkedList" };

        
        System.out.println(" ---------- Bienvenido ---------- ");
        System.out.println("Seleccione la estructura de datos a utilizar:");
        System.out.println("1) Pila");
        System.out.println("2) Lista");
        int type =  Integer.parseInt(input.nextLine());
        int typeStack = 0;
        int typeList = 0;

        if (type == 1) {
            System.out.println("Seleccione la implementación del stack:");
            System.out.println("1) ArrayListStack");
            System.out.println("2) VectorStack");
            typeStack = Integer.parseInt(input.nextLine());
            
            stack = stackFactory.createStack(typeStack);
            
        } else if (type == 2) {
            System.out.println("Seleccione la implementación de la lista:");
            System.out.println("1) SinglyLinkedList");
            System.out.println("2) DoublyLinkedList");
            typeList = Integer.parseInt(input.nextLine());
            list = liStackFactory.createList(typeList);
        }

        Calculadora calculadora = Calculadora.obtenerInstancia();
        String expresionPostfix = calculadora.infixToPostfix();
        System.out.println("Expresion convertida a postfix: "+ expresionPostfix);
        
        int resultado = calculadora.compareTo(stack, list,expresionPostfix);
        if (type==1){
            System.out.println("ADT: "+ADT[type-1]+" --- "+Stack[typeStack-1]);
            System.out.println("Resultado: "+resultado);
        }else{
            System.out.println("ADT: "+ADT[type-1]+" --- "+List[typeList-1]);
            System.out.println("Resultado: "+resultado);

        }

        


        input.close();
    }
}
