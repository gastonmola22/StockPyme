package com.stockpyme.model;

public class Producto {
    private Long id;
    private String codigo;
    private String nombre;
    private double precio;
    private int stock;
    private int stockMin;
    private boolean activo;

    private static long ultimoId;

}
