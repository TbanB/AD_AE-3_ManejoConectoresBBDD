package com.gestionCoches.app.controller;

import com.gestionCoches.app.dao.CocheDAO;
import com.gestionCoches.app.model.Coche;

import java.util.List;

public class CocheController {

    private final CocheDAO cocheDAO;

    public CocheController() {
        // Instancia un DAO
        this.cocheDAO = new CocheDAO();
    }

    public void agregarCoche(Coche coche) {
        try {
            cocheDAO.insertarCoche(coche);
            System.out.println("Coche agregado con éxito.");
        } catch (Exception e) {
            System.out.println("Error al agregar el coche: " + e.getMessage());
        }
    }

    public void borrarCoche(int id) {
        try {
            int filasAfectadas = cocheDAO.borrarCoche(id);
            if (filasAfectadas > 0) {
                System.out.println("Coche borrado correctamente.");
            } else {
                System.out.println("No se encontró el coche con ID " + id);
            }
        } catch (Exception e) {
            System.out.println("Error al borrar el coche: " + e.getMessage());
        }
    }

    public void consultarCochePorId(int id) {
        try {
            Coche coche = cocheDAO.consultarCochePorId(id);
            if (coche != null) {
                System.out.println("=== Información del Coche ===");
                System.out.println("ID: " + coche.getId());
                System.out.println("Marca: " + coche.getMarca());
                System.out.println("Modelo: " + coche.getModelo());
                System.out.println("CV: " + coche.getCv());
                System.out.println("Precio: " + coche.getPrecio());
            } else {
                System.out.println("No existe un coche con ID " + id);
            }
        } catch (Exception e) {
            System.out.println("Error al consultar el coche: " + e.getMessage());
        }
    }

    public void modificarCoche(Coche coche) {
        try {
            int filasAfectadas = cocheDAO.modificarCoche(coche);
            if (filasAfectadas > 0) {
                System.out.println("Coche modificado correctamente.");
            } else {
                System.out.println("No se pudo modificar el coche.");
            }
        } catch (Exception e) {
            System.out.println("Error al modificar el coche: " + e.getMessage());
        }
    }

    public void listarCoches() {
        try {
            List<Coche> lista = cocheDAO.listarCoches();
            if (lista.isEmpty()) {
                System.out.println("No hay coches registrados.");
                return;
            }
            System.out.println("=== LISTA DE COCHES ===");
            for (Coche c : lista) {
                System.out.println("ID: " + c.getId() +
                        " | Marca: " + c.getMarca() +
                        " | Modelo: " + c.getModelo() +
                        " | CV: " + c.getCv() +
                        " | Precio: " + c.getPrecio());
            }
        } catch (Exception e) {
            System.out.println("Error al listar coches: " + e.getMessage());
        }
    }
}
