package com.stockpyme.repository;

import com.stockpyme.model.Producto;

public class ProductoRepositorio {
    private Producto [] productos = new Producto[100];
    private int cantidad;

    public void guardar(Producto producto) {
        productos[cantidad] = producto;
        cantidad++;
    }
    //Devuelve solo los cargados
    public Producto[] listar() {
        Producto[] cargados = new Producto[cantidad];
        for (int i = 0; i < cantidad; i++) {
            cargados[i] = productos[i];
        }
        return cargados;
    }
    public Producto buscarPorCodigo(String codigo) {
        for (int i = 0; i < cantidad; i++) {
            if (productos[i].getCodigo().equals(codigo)) {
                return productos[i];
            }
        }
        return null;
    }
    public boolean existeCodigo(String codigo) {
        return buscarPorCodigo(codigo) != null;
    }
}
