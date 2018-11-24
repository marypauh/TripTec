package TextFile;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class TextFile {
    
    public void TextFile(String text) throws IOException{
    
    BufferedWriter bw = null;
    FileWriter fw = null;

    try {
        String data = text;
        File file = new File("Vertices.txt");
        // Si el archivo no existe, se crea!
        if (!file.exists()) {
            file.createNewFile();
        }
        // flag true, indica adjuntar información al archivo.
        fw = new FileWriter(file.getAbsoluteFile(), true);
        bw = new BufferedWriter(fw);
        bw.write(data);
        bw.newLine();
        System.out.println("información agregada!");
    } catch (IOException e) {
        e.printStackTrace();
    } finally {
        try {
                        //Cierra instancias de FileWriter y BufferedWriter
            if (bw != null)
                bw.close();
            if (fw != null)
                fw.close();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    }
}