package com.stockpyme.model;

import java.util.Objects;

public class Producto {
    private Long id;
    private String codigo;
    private String nombre;
    private double precio;
    private int stock;
    private int stockMinimo;
    private boolean activo;

    private static long ultimoId;

    public Producto(String codigo, String nombre, double precio, int stock, int stockMinimo) {
        this.id = ++ultimoId;
        this.codigo = codigo;
        this.nombre = nombre;
        this.precio = precio;
        this.stock = stock;
        this.stockMinimo = stockMinimo;
        this.activo = true;
    }

    public String getNombre() {
        return nombre;
    }


    public String getCodigo() {
        return codigo;
    }

    public Long getId() {
        return id;
    }

    public int getStock() {
        return stock;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public int getStockMinimo() {
        return stockMinimo;
    }

    public void setStockMinimo(int stockMinimo) {
        this.stockMinimo = stockMinimo;
    }

    public boolean isActivo() {
        return activo;
    }

    public void setActivo(boolean activo) {
        this.activo = activo;
    }
    public void agregarStock(int cantidad) {
        this.stock += cantidad;
    }
    public boolean tieneStockBajo(){
        if(stock<=stockMinimo){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Producto producto = (Producto) o;
        return Objects.equals(codigo, producto.codigo);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(codigo);
    }

    @Override
    public String toString() {
        return "Producto{" +
                "id=" + id +
                ", codigo='" + codigo + '\'' +
                ", nombre='" + nombre + '\'' +
                ", precio=" + precio +
                ", stock=" + stock +
                ", stockMinimo=" + stockMinimo +
                ", activo=" + activo +
                '}';
    }
}