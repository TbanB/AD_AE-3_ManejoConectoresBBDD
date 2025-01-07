package com.gestionCoches.app.controller;

import com.gestionCoches.app.dao.PasajeroDAO;
import com.gestionCoches.app.model.Pasajero;

import java.util.List;

public class PasajeroController {

    private final PasajeroDAO pasajeroDAO;

    public PasajeroController() {
        this.pasajeroDAO = new PasajeroDAO();
    }

    public void agregarPasajero(Pasajero p) {
        try {
            pasajeroDAO.insertarPasajero(p);
            System.out.println("Pasajero agregado con éxito.");
        } catch (Exception e) {
            System.out.println("Error al agregar pasajero: " + e.getMessage());
        }
    }

    public void borrarPasajero(int id) {
        try {
            int filas = pasajeroDAO.borrarPasajero(id);
            if (filas > 0) {
                System.out.println("Pasajero borrado correctamente.");
            } else {
                System.out.println("No se encontró pasajero con ID " + id);
            }
        } catch (Exception e) {
            System.out.println("Error al borrar pasajero: " + e.getMessage());
        }
    }

    public void consultarPasajeroPorId(int id) {
        try {
            Pasajero pasajero = pasajeroDAO.consultarPasajeroPorId(id);
            if (pasajero != null) {
                System.out.println("=== Información del Pasajero ===");
                System.out.println("ID: " + pasajero.getId());
                System.out.println("Nombre: " + pasajero.getNombre());
                System.out.println("Edad: " + pasajero.getEdad());
                System.out.println("Peso: " + pasajero.getPeso());
                System.out.println("CocheID: " + pasajero.getCocheId());
            } else {
                System.out.println("No existe un pasajero con ID " + id);
            }
        } catch (Exception e) {
            System.out.println("Error al consultar pasajero: " + e.getMessage());
        }
    }

    public void modificarPasajero(Pasajero p) {
        try {
            int filas = pasajeroDAO.modificarPasajero(p);
            if (filas > 0) {
                System.out.println("Pasajero modificado correctamente.");
            } else {
                System.out.println("No se pudo modificar el pasajero.");
            }
        } catch (Exception e) {
            System.out.println("Error al modificar el pasajero: " + e.getMessage());
        }
    }

    public void listarPasajeros() {
        try {
            List<Pasajero> lista = pasajeroDAO.listarPasajeros();
            if (lista.isEmpty()) {
                System.out.println("No hay pasajeros registrados.");
                return;
            }
            System.out.println("=== LISTA DE PASAJEROS ===");
            for (Pasajero pas : lista) {
                System.out.println("ID: " + pas.getId() +
                        " | Nombre: " + pas.getNombre() +
                        " | Edad: " + pas.getEdad() +
                        " | Peso: " + pas.getPeso() +
                        " | CocheID: " + pas.getCocheId());
            }
        } catch (Exception e) {
            System.out.println("Error al listar pasajeros: " + e.getMessage());
        }
    }

    public void asignarPasajeroACoche(int pasajeroId, int cocheId) {
        try {
            int filas = pasajeroDAO.asignarPasajeroACoche(pasajeroId, cocheId);
            if (filas > 0) {
                System.out.println("Pasajero asignado al coche con éxito.");
            } else {
                System.out.println("No se pudo asignar el pasajero (revisa si existen los IDs).");
            }
        } catch (Exception e) {
            System.out.println("Error al asignar pasajero a coche: " + e.getMessage());
        }
    }

    public void eliminarPasajeroDeCoche(int pasajeroId) {
        try {
            int filas = pasajeroDAO.eliminarPasajeroDeCoche(pasajeroId);
            if (filas > 0) {
                System.out.println("Pasajero desasignado del coche correctamente.");
            } else {
                System.out.println("No se pudo desasignar el pasajero. ¿Existen esos IDs?");
            }
        } catch (Exception e) {
            System.out.println("Error al desasignar pasajero: " + e.getMessage());
        }
    }

    public void listarPasajerosDeCoche(int cocheId) {
        try {
            List<Pasajero> pasajeros = pasajeroDAO.listarPasajerosDeCoche(cocheId);
            if (pasajeros.isEmpty()) {
                System.out.println("El coche con ID " + cocheId + " no tiene pasajeros o no existe.");
                return;
            }
            System.out.println("=== PASAJEROS DEL COCHE " + cocheId + " ===");
            for (Pasajero p : pasajeros) {
                System.out.println("ID: " + p.getId() +
                        " | Nombre: " + p.getNombre() +
                        " | Edad: " + p.getEdad() +
                        " | Peso: " + p.getPeso());
            }
        } catch (Exception e) {
            System.out.println("Error al listar pasajeros de coche: " + e.getMessage());
        }
    }
}
