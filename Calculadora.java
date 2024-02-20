import java.io.IOException;
import java.util.ArrayList;

public class Calculadora {
    private Archivo archivoTxt;




    public String infixToPostfix(){
        try {
            ArrayList<String> listInfix = archivoTxt.leerArchivo();     
            for (String linea : listInfix) {
                if (linea.matches("-?\\d+(\\.\\d+)?")){
                }
                }
            }
            
        catch (IOException e) {
            e.printStackTrace();
            System.err.println("No se ha encontrado el archivo");
        }

    


}
}
