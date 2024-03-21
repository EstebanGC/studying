package com.mycompany.app;
import java.util.Arrays;
import java.util.List;
import java.util.Collections;
import java.util.Comparator;
import java.util.stream.Collectors;


public class Main {

    public static void main(String[] args) {

        List<Compra> ultimas3Compras = Arrays.asList(
                new Compra("Ana", "2024-03-18", new Producto("Camisa", 20.0)),
                new Compra("Juan", "2024-03-19", new Producto("Libro", 15.0)),
                new Compra("Pedro", "2024-03-20", new Producto("Zapatos", 50.0)),
                new Compra("Maria", "2024-03-17", new Producto("Celular", 100.0)),
                new Compra("Luis", "2024-03-16", new Producto("Audífonos", 30.0))
        );

        ultimas3Compras.stream()
                .sorted((c1, c2) -> c2.getFecha().compareTo(c1.getFecha()))
                .limit(3)
                .collect(Collectors.toList());

        // Imprime las últimas 3 compras
        for (Compra compra : ultimas3Compras) {
            System.out.println(compra.getNombre() + " - " + compra.getProducto().getNombre());
        }
    }
}

public class Compra {

    private String nombre;
    private String fecha;
    private Producto producto;

    public Compra(String nombre, String fecha, Producto producto) {
        this.nombre = nombre;
        this.fecha = fecha;
        this.producto = producto;
    }

    // Getters and setters
}

public class Producto {

    private String nombre;
    private double precio;

    public Producto(String nombre, double precio) {
        this.nombre = nombre;
        this.precio = precio;
    }

    // Getters and setters
}
