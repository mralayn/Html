import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.StringTokenizer;

public class PalabrasTotales {
    public void palabras(String fileName){
        int palabrasTotales =0;

        FileReader fileReader = null;

        try {
            fileReader = new FileReader(fileName);
        } catch (FileNotFoundException e) {
            System.out.println("el nombre del archivo no se encuentra");
            System.exit(2);
        }

        BufferedReader in = new BufferedReader(fileReader);
        String textLine = null;

        while (true) {
            try {
                if (!((textLine = in.readLine())   != null))

                    break;
            } catch (IOException e) {
                System.out.println("error al leer el archivo");
                System.exit(3);
            }

            StringTokenizer st = new StringTokenizer(textLine);
            palabrasTotales = palabrasTotales + st.countTokens();

        }

        try {
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("El archivo tiene "+palabrasTotales+" palabras");

    }
}
