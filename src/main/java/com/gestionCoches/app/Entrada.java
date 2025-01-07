package com.gestionCoches.app;

import com.gestionCoches.app.controller.CocheController;
import com.gestionCoches.app.controller.PasajeroController;
import com.gestionCoches.app.model.Coche;
import com.gestionCoches.app.model.Pasajero;

import java.util.Scanner;

public class Entrada {

    private static final CocheController cocheController = new CocheController();
    private static final PasajeroController pasajeroController = new PasajeroController();

    public static void main(String[] args) {
        mostrarMenuPrincipal();
    }

    private static void mostrarMenuPrincipal() {
        Scanner sc = new Scanner(System.in);
        boolean salir = false;

        while (!salir) {
            System.out.println("\n=== MENÚ PRINCIPAL ===");
            System.out.println("1. Gestión de Coches");
            System.out.println("2. Gestión de Pasajeros");
            System.out.println("3. Cerrar menú");
            System.out.print("Selecciona una opción: ");

            int opcion = 0;
            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, introduce un número válido.");
            }

            switch (opcion) {
                case 1:
                    mostrarMenuCoches();
                    break;
                case 2:
                    mostrarMenuPasajeros();
                    break;
                case 3:
                    System.out.println("Cerrando el menú. ¡Hasta luego!");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        }
        sc.close();
    }

    private static void mostrarMenuCoches() {
        Scanner sc = new Scanner(System.in);
        boolean volverAlPrincipal = false;

        while (!volverAlPrincipal) {
            System.out.println("\n=== MENÚ COCHES ===");
            System.out.println("1. Agregar coche");
            System.out.println("2. Borrar coche");
            System.out.println("3. Consultar coche por ID");
            System.out.println("4. Modificar coche");
            System.out.println("5. Listar coches");
            System.out.println("6. Volver al Menú Principal");
            System.out.print("Selecciona una opción: ");

            int opcion = 0;
            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, introduce un número válido.");
                continue;
            }

            switch (opcion) {
                case 1:
                    agregarCoche();
                    break;
                case 2:
                    borrarCoche();
                    break;
                case 3:
                    consultarCochePorId();
                    break;
                case 4:
                    modificarCoche();
                    break;
                case 5:
                    cocheController.listarCoches();
                    break;
                case 6:
                    volverAlPrincipal = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void mostrarMenuPasajeros() {
        Scanner sc = new Scanner(System.in);
        boolean volverAlPrincipal = false;

        while (!volverAlPrincipal) {
            System.out.println("\n=== MENÚ PASAJEROS ===");
            System.out.println("1. Agregar pasajero");
            System.out.println("2. Borrar pasajero");
            System.out.println("3. Consultar pasajero por ID");
            System.out.println("4. Modificar pasajero");
            System.out.println("5. Listar pasajeros");
            System.out.println("6. Asignar pasajero a coche");
            System.out.println("7. Eliminar pasajero de coche");
            System.out.println("8. Listar pasajeros de un coche");
            System.out.println("9. Volver al Menú Principal");
            System.out.print("Selecciona una opción: ");

            int opcion = 0;
            try {
                opcion = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor, introduce un número válido.");
                continue;
            }

            switch (opcion) {
                case 1:
                    agregarPasajero();
                    break;
                case 2:
                    borrarPasajero();
                    break;
                case 3:
                    consultarPasajeroPorId();
                    break;
                case 4:
                    modificarPasajero();
                    break;
                case 5:
                    pasajeroController.listarPasajeros();
                    break;
                case 6:
                    asignarPasajeroACoche();
                    break;
                case 7:
                    eliminarPasajeroDeCoche();
                    break;
                case 8:
                    listarPasajerosDeCoche();
                    break;
                case 9:
                    volverAlPrincipal = true;
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        }
    }

    private static void agregarCoche() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce la marca:");
        String marca = sc.nextLine();
        System.out.println("Introduce el modelo:");
        String modelo = sc.nextLine();
        System.out.println("Introduce los CV:");
        int cv = Integer.parseInt(sc.nextLine());
        System.out.println("Introduce el precio:");
        int precio = Integer.parseInt(sc.nextLine());

        Coche coche = new Coche(marca, modelo, cv, precio);
        cocheController.agregarCoche(coche);
    }

    private static void borrarCoche() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el ID del coche:");
        int id = Integer.parseInt(sc.nextLine());
        cocheController.borrarCoche(id);
    }

    private static void consultarCochePorId() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el ID del coche:");
        int id = Integer.parseInt(sc.nextLine());
        cocheController.consultarCochePorId(id);
    }

    private static void modificarCoche() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el ID del coche a modificar:");
        int id = Integer.parseInt(sc.nextLine());

        // Consultamos primero (opcional) o asumimos que lo conoces
        // Ejemplo simplificado: pedimos todos los nuevos datos.
        System.out.println("Introduce la nueva marca:");
        String nuevaMarca = sc.nextLine();
        System.out.println("Introduce el nuevo modelo:");
        String nuevoModelo = sc.nextLine();
        System.out.println("Introduce los nuevos CV:");
        int nuevosCV = Integer.parseInt(sc.nextLine());
        System.out.println("Introduce el nuevo precio:");
        int nuevoPrecio = Integer.parseInt(sc.nextLine());

        // Creamos un coche con ID y nuevos valores
        Coche cocheModificado = new Coche();
        cocheModificado.setId(id);
        cocheModificado.setMarca(nuevaMarca);
        cocheModificado.setModelo(nuevoModelo);
        cocheModificado.setCv(nuevosCV);
        cocheModificado.setPrecio(nuevoPrecio);

        cocheController.modificarCoche(cocheModificado);
    }

    private static void agregarPasajero() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el nombre:");
        String nombre = sc.nextLine();
        System.out.println("Introduce la edad:");
        int edad = Integer.parseInt(sc.nextLine());
        System.out.println("Introduce el peso:");
        double peso = Double.parseDouble(sc.nextLine());
        System.out.println("Introduce el ID del coche (0 si no asignar):");
        int cocheId = Integer.parseInt(sc.nextLine());

        Pasajero p = new Pasajero();
        p.setNombre(nombre);
        p.setEdad(edad);
        p.setPeso(peso);
        if (cocheId != 0) {
            p.setCocheId(cocheId);
        }

        pasajeroController.agregarPasajero(p);
    }

    private static void borrarPasajero() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el ID del pasajero:");
        int id = Integer.parseInt(sc.nextLine());
        pasajeroController.borrarPasajero(id);
    }

    private static void consultarPasajeroPorId() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el ID del pasajero:");
        int id = Integer.parseInt(sc.nextLine());
        pasajeroController.consultarPasajeroPorId(id);
    }

    private static void modificarPasajero() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el ID del pasajero a modificar:");
        int id = Integer.parseInt(sc.nextLine());

        System.out.println("Introduce nuevo nombre:");
        String nuevoNombre = sc.nextLine();
        System.out.println("Introduce nueva edad:");
        int nuevaEdad = Integer.parseInt(sc.nextLine());
        System.out.println("Introduce nuevo peso:");
        double nuevoPeso = Double.parseDouble(sc.nextLine());
        System.out.println("Introduce nuevo cocheId (0 para desasignar):");
        int nuevoCocheId = Integer.parseInt(sc.nextLine());

        Pasajero pasajero = new Pasajero();
        pasajero.setId(id);
        pasajero.setNombre(nuevoNombre);
        pasajero.setEdad(nuevaEdad);
        pasajero.setPeso(nuevoPeso);
        pasajero.setCocheId(nuevoCocheId); // 0 = no asignado

        pasajeroController.modificarPasajero(pasajero);
    }

    private static void asignarPasajeroACoche() {
        Scanner sc = new Scanner(System.in);
        System.out.println("ID del pasajero:");
        int pasajeroId = Integer.parseInt(sc.nextLine());
        System.out.println("ID del coche:");
        int cocheId = Integer.parseInt(sc.nextLine());
        pasajeroController.asignarPasajeroACoche(pasajeroId, cocheId);
    }

    private static void eliminarPasajeroDeCoche() {
        Scanner sc = new Scanner(System.in);
        System.out.println("ID del pasajero:");
        int pasajeroId = Integer.parseInt(sc.nextLine());
        pasajeroController.eliminarPasajeroDeCoche(pasajeroId);
    }

    private static void listarPasajerosDeCoche() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Introduce el ID del coche:");
        int cocheId = Integer.parseInt(sc.nextLine());
        pasajeroController.listarPasajerosDeCoche(cocheId);
    }
}
