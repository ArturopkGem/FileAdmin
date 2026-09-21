package Practica_03;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

class Act_alumnos {

  public static void escribirAlumnos(){
        var alumnos = new ArrayList<Alumno>();
        alumnos.add(new Alumno("5799", "Sergio",9.7));
        alumnos.add(new Alumno("3466", "Diego",9));
        alumnos.add(new Alumno("2388", "Fernando",8.5));
        alumnos.add(new Alumno("2388", "Jaime",10));

        try (var fos = new FileOutputStream("AlumnosDB.txt");
             ObjectOutputStream oos = new ObjectOutputStream(fos)){
            oos.writeObject(alumnos);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}