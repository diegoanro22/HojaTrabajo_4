import java.io.IOException;
import java.util.ArrayList;


public class Calculadora {
    private static Calculadora instanciaUnica;
    private Archivo archivoTxt = new Archivo();
    private CustomStack<Character> stackPostfix = new CustomStack<>();

    //Metodos para el patron de diseño Singleton
    private Calculadora() {}

    public static Calculadora obtenerInstancia() {
        if (instanciaUnica == null) {
            instanciaUnica = new Calculadora();
        }
        return instanciaUnica;
    }


    public String infixToPostfix(){
        StringBuilder postfixExpression = new StringBuilder(); 

    try {
        ArrayList<String> listinfix = archivoTxt.leerArchivo();
        System.out.println(listinfix);
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
}
