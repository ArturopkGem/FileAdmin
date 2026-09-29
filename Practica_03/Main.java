package Practica_03;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcion;

        System.out.println("===== GESTIÓN DE ALUMNOS (ARCHIVOS BINARIOS) =====");

        do {
            System.out.println("\n--- Menú ---");
            System.out.println("1. Ver todos los alumnos");
            System.out.println("2. Buscar alumno por matrícula");
            System.out.println("3. Agregar nuevo alumno");
            System.out.println("4. Salir");
            System.out.print("Elige una opción: ");

            try {
                opcion = Integer.parseInt(scanner.nextLine());

                switch (opcion) {
                    case 1:
                        GestionAlumnos.mostrarAlumnos();
                        break;
                    case 2:
                        buscarAlumno(scanner);
                        break;
                    case 3:
                        agregarNuevoAlumno(scanner);
                        break;
                    case 4:
                        System.out.println("¡Hasta luego!");
                        break;
                    default:
                        System.out.println("Opción inválida. Intenta de nuevo.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Debes ingresar un número.");
                opcion = 0; // Reiniciar para continuar
            }
        } while (opcion != 4);

        scanner.close();
    }

    private static void buscarAlumno(Scanner scanner) {
        System.out.print("Ingresa la matrícula a buscar: ");
        String matricula = scanner.nextLine().trim();
        if (matricula.isEmpty()) {
            System.out.println("La matrícula no puede estar vacía.");
            return;
        }
        GestionAlumnos.mostrarBusqueda(matricula);
    }

    private static void agregarNuevoAlumno(Scanner scanner) {
        try {
            System.out.print("Ingresa la matrícula: ");
            String matricula = scanner.nextLine().trim();

            System.out.print("Ingresa el nombre: ");
            String nombre = scanner.nextLine().trim();

            System.out.print("Ingresa el promedio: ");
            double promedio = Double.parseDouble(scanner.nextLine().trim());

            if (matricula.isEmpty() || nombre.isEmpty()) {
                System.out.println("La matrícula y el nombre no pueden estar vacíos.");
                return;
            }

            Alumno nuevo = new Alumno(matricula, nombre, promedio);
            GestionAlumnos.agregarAlumno(nuevo);

        } catch (NumberFormatException e) {
            System.out.println("Error: El promedio debe ser un número válido.");
        }
    }
}