import java.io.*;
import java.util.ArrayList;

public class Act_Stream {
    public static void escribir( ) throws IOException {
        OutputStream fos = new FileOutputStream("ListaAsistencia.txt", true);
        fos.write(0x31);
        fos.write(50);
        fos.write(0x0A);

        fos.flush();
        fos.close();
    }

    public static void leer() throws IOException {
        InputStream fis = new FileInputStream("ListaAsistencia.txt");
        int byteFile;
        byteFile = fis.read();
        System.out.println(byteFile);
        fis.close();
    }

    public static void leerTryWith(){
        try (InputStream fis = new FileInputStream("ListaAsistencia.txt")){
            int byteFile;
            byteFile = fis.read();
            System.out.println(byteFile);
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public static void escribirObjectoTryWith(){
        try (OutputStream fos = new FileOutputStream("object_data.txt");
             ObjectOutputStream oos = new ObjectOutputStream(fos);){
            ArrayList<String> listaAsistencia = new ArrayList<>();
            listaAsistencia.add("Arturo");
            listaAsistencia.add("Cecilia");
            listaAsistencia.add("Diego");
            listaAsistencia.add("Fernando");

            oos.writeBoolean(true);
            oos.writeUTF("Hola Mundo!");
            oos.writeObject(listaAsistencia);
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public static void leerObjectoTryWith(){
        try (InputStream fis = new FileInputStream("object_data.txt");
             ObjectInputStream ois = new ObjectInputStream(fis);){

            System.out.println(ois.readBoolean());
            System.out.println(ois.readUTF());
            ArrayList<String> ListaAsistenciaInput = (ArrayList<String>) ois.readObject();
            System.out.println("Total de Estudiantes: "+ListaAsistenciaInput.size());
        } catch (IOException e){
            throw new RuntimeException(e);
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        }
    }
}
