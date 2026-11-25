package com.stockpyme.ui;

import com.stockpyme.model.Producto;
import com.stockpyme.repository.ProductoRepositorio;

import java.util.Scanner;

public class MenuProductos {
    private Scanner entrada ;
    private ProductoRepositorio repo;

    public MenuProductos(Scanner entrada, ProductoRepositorio repo) {
        this.entrada = entrada;
        this.repo = repo;
    }

    public void mostrar() {
        int opcion;
        do {
            System.out.println("=== StockPyme - Productos ===");
            System.out.println("1. Alta de producto");
            System.out.println("2. Listar productos");
            System.out.println("3. Buscar por código");
            System.out.println("4. Modificar precio");
            System.out.println("5. Cargar stock (entró mercadería)");
            System.out.println("6. Productos con stock bajo");
            System.out.println("7. Dar de baja producto");
            System.out.println("0. Volver al menu anterior");
            System.out.print("Opción: ");
            opcion = entrada.nextInt();
            entrada.nextLine(); // limpia el Enter

            switch (opcion) {
                case 1: alta(); break;
                case 2: listar(); break;
                case 3: buscarPorCodigo(); break;
                case 4: modificarPrecio(); break;
                case 5: cargarStock(); break;
                case 6: listarStockBajo(); break;
                case 7: darDeBaja(); break;
                case 0: System.out.println("Saliendo..."); break;
                default: System.out.println("Opción no existe.");
            }
        } while (opcion != 0);
    }

    private void alta() {
        System.out.print("Código: ");
        String codigo = entrada.nextLine();
        if (repo.existeCodigo(codigo)) {
            System.out.println("Error: ya existe un producto con código " + codigo + ".");
            return;
        }
        System.out.print("Nombre: ");
        String nombre = entrada.nextLine();
        System.out.print("Precio: ");
        double precio = entrada.nextDouble();
        System.out.print("Stock: ");
        int stock = entrada.nextInt();
        System.out.print("Stock mínimo: ");
        int stockMinimo = entrada.nextInt();
        entrada.nextLine();
        if (precio <= 0 || stock < 0 || stockMinimo < 0) {
            System.out.println("Error: datos inválidos.");
            return;
        }
        Producto p = new Producto(codigo, nombre, precio, stock, stockMinimo);
        if (repo.guardar(p)) {
            System.out.println("Producto creado con id " + p.getId() + ".");
        } else {
            System.out.println("Error: no hay más lugar para productos.");
        }
    }
    private void listar() {
        Producto[] lista = repo.listar();
        if (lista.length == 0) {
            System.out.println("No hay productos cargados");
            return;
        }
        System.out.printf("%-4s %-8s %-20s %10s %8s%n", "ID", "CÓDIGO", "NOMBRE", "PRECIO", "STOCK");
        for (Producto p : lista) {
            if (p.isActivo()) {
                System.out.printf("%-4d %-8s %-20s %10.2f %8d", p.getId(), p.getCodigo(), p.getNombre(), p.getPrecio(), p.getStock());
                if (p.tieneStockBajo()) System.out.print("  (stock bajo)");
                System.out.println();
            }
        }
    }

    private void buscarPorCodigo() {
        Producto p = encontrarProducto();
        if (p == null) {
            System.out.println("No se encuentra el producto con el codigo solicitado...");
        } else {
            System.out.println(p);
        }
    }

    private void modificarPrecio() {
        Producto p = encontrarProducto();
        if (p != null) {
            System.out.println("Digite precio a modificar: ");
            double precio = entrada.nextDouble();
            entrada.nextLine();
            if (precio > 0) {
                p.setPrecio(precio);
                System.out.println("Precio modificado correctamente..");
            } else {
                System.out.println("No se puede modificar con un precio negativo.");
            }
        } else {
            System.out.println("El producto no existe, no se pudo modificar");
        }
    }

    private void cargarStock() {
        Producto p = encontrarProducto();
        if (p != null) {
            System.out.println("Digite stock a cargar: ");
            int stock = entrada.nextInt();
            entrada.nextLine();
            if (stock > 0) {
                p.agregarStock(stock);
                System.out.println("Stock cargado correctamente..");
            } else {
                System.out.println("La cantidad debe ser mayor a 0.");
            }
        } else {
            System.out.println("No se encontro el producto...");
        }
    }

    private void listarStockBajo() {
        boolean hayAlguno = false;
        for (Producto p : repo.listar()) {
            if (p.isActivo() && p.tieneStockBajo()) {
                System.out.println(p.getCodigo() + " " + p.getNombre() + ": stock " + p.getStock() + " (mínimo " + p.getStockMinimo() + ")");
                hayAlguno = true;
            }
        }
        if (!hayAlguno) {
            System.out.println("No hay productos con stock bajo.");
        }
    }

    private void darDeBaja() {
        Producto p = encontrarProducto();
        if (p !=null){
            if(!p.isActivo()){
                System.out.println("El producto ya esta inactivo");
            }else {
                p.darDeBaja( );
                System.out.println("Producto dado de baja correctamente..");
            }
        }else {
            System.out.println("El producto no existe...");
        }
    }

    private Producto encontrarProducto() {
        System.out.println("Digite el codigo a buscar: ");
        String codigo = entrada.nextLine();
        return repo.buscarPorCodigo(codigo);
    }
}