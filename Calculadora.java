/*Universidad del Valle de Guatemala 
 *Genser Andree - 23401
 *Diego Rosales - 23258
*/

import java.io.IOException;
import java.util.ArrayList;


public class Calculadora {
    private static Calculadora instanciaUnica;
    private Archivo archivoTxt = new Archivo();
    private CustomStack<Character> stackPostfix = new CustomStack<>();

    //Metodos para el patron de diseño Singleton
    private Calculadora() {}

    /**Metodo para llamar a calculadora y aplicar singleton
     * @return Calculadora
     */
    public static Calculadora obtenerInstancia() {
        if (instanciaUnica == null) {
            instanciaUnica = new Calculadora();
        }
        return instanciaUnica;
    }


    /**Metodo para convertir los datos de infix a postfix
     * @return postfix
     */
    public String infixToPostfix(){
        StringBuilder postfixExpression = new StringBuilder(); 

    try {
        ArrayList<String> listinfix = archivoTxt.leerArchivo();
        System.out.println("Expresion en infix: "+listinfix);
        for (String infixExpression : listinfix) {
            for (char ch : infixExpression.toCharArray()) {
                switch (ch) {
                    case '(':
                        stackPostfix.push(ch);
                        break;
                    case ')':
                        while (!stackPostfix.isEmpty() && stackPostfix.peek() != '(') {
                            postfixExpression.append(stackPostfix.pop());
                        }
                        stackPostfix.pop(); // Pop '('
                        break;
                    case '+':
                    case '-':
                        while (!stackPostfix.isEmpty() && (stackPostfix.peek() == '*' || stackPostfix.peek() == '/')) {
                            postfixExpression.append(stackPostfix.pop());
                        }
                        stackPostfix.push(ch);
                        break;
                    case '*':
                    case '/':
                        while (!stackPostfix.isEmpty() && (stackPostfix.peek() == '*' || stackPostfix.peek() == '/')) {
                            postfixExpression.append(stackPostfix.pop());
                        }
                        stackPostfix.push(ch);
                        break;
                    default:
                        if (Character.isLetterOrDigit(ch)) {
                            postfixExpression.append(ch);
                        }
                }
            }

            while (!stackPostfix.isEmpty()) {
                postfixExpression.append(stackPostfix.pop());
            }

            postfixExpression.append("\n");
        }
    } catch (IOException e) {
        e.printStackTrace();
        System.err.println("No se ha encontrado el archivo");
    }

    return postfixExpression.toString();
}

    public int compareTo(StackInterface<Integer> stack, ListInterface<Integer> list, String postfix){
        if (stack == null){
            return calcList(list, postfix);
        }else{
            return calcStack(stack, postfix);
        }
    }


    public int calcStack(StackInterface<Integer> stack, String postfix) {
        String[] expresion = postfix.split(" ");
        for (String character : expresion) {
            for (int i = 0; i < character.length()-1; i++) {
                char caracter = character.charAt(i);
                String strCaracter = String.valueOf(caracter);
                if (esNumero(strCaracter)) {
                    stack.push(Integer.parseInt(strCaracter));
                } else {
                    int b = stack.pop();
                    int a = stack.pop();
                    int resultado = operar(a, b, strCaracter);
                    stack.push(resultado);
                }
            }
        }
        return stack.peek();
    }

    public int calcList(ListInterface<Integer> lista, String postfix) {
        String[] expresion = postfix.split(" ");
        
        for (String character : expresion) {
            for (int i = 0; i < character.length()-1; i++) {
                char caracter = character.charAt(i);
                String strCaracter = String.valueOf(caracter);
                if (esNumero(strCaracter)) {
                    lista.add(Integer.parseInt(strCaracter));
                } else {
                    int b = lista.remove(lista.size() - 1);
                    int a = lista.remove(lista.size() - 1);;
                    int resultado = operar(a, b, strCaracter);
                    lista.add(resultado);
                }
            }
        }
        return lista.getHead();
    }

    


    public boolean esNumero(String token) {
        try {
            Integer.parseInt(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public int operar(int a, int b, String operador) {
        switch (operador) {
            case "+": return a + b;
            case "-": return a - b;
            case "*": return a * b;
            case "/": if (b == 0) throw new IllegalArgumentException("División por cero");
                    return a / b;
            default: throw new IllegalArgumentException("Operador desconocido: " + operador);
        }


}
}
