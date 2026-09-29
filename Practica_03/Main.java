package Practica_03;

public class Main {
    public static void main(String[] args) {
        // 1. Crear la base de datos inicial con los 4 alumnos
        GestionAlumnos.escribirAlumnos();

        // 2. Leer y mostrar todos los alumnos
        GestionAlumnos.mostrarAlumnos();

        // 3. Buscar alumno por matrícula
        System.out.println("\nBuscando matrícula 3466...");
        GestionAlumnos.mostrarBusqueda("3466");

        // 4. Agregar un alumno nuevo
        System.out.println("Agregando nuevo alumno...");
        GestionAlumnos.agregarAlumno(new Alumno("1122", "Ana", 9.3));

        // 5. Verificar que se guardó en el archivo mostrando la lista
        System.out.println("\nLista actualizada:");
        GestionAlumnos.mostrarAlumnos();
    }
}