/*Universidad del Valle de Guatemala 
 *Genser Andree - 23401
 *Diego Rosales - 23258
*/

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


//Clase para leer el archivo
public class Archivo {
    private File archivo;

    public Archivo(String nameArchivo){
        archivo = new File(nameArchivo);
    }

    public ArrayList<String> leerArchivo() throws IOException {
        ArrayList<String> listinfix = new ArrayList<>();
        FileReader fileReader = new FileReader(archivo);
        BufferedReader lector = new BufferedReader(fileReader);

        String linea;
        while ((linea = lector.readLine()) != null){
            String[] elementos = linea.split("\\s+");
            for (String elemento : elementos) {
                if (elemento.matches("[a-zA-Z]+")){
                }
                else{
                    listinfix.add(elemento.toString());
                }
            }
        }
        lector.close();
        return listinfix;
    }



}
