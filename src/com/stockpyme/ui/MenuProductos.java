package com.stockpyme.ui;

import com.stockpyme.model.Producto;

import java.util.Scanner;

public class MenuProductos {
    private Scanner entrada = new Scanner(System.in);
    private Producto[] productos = new Producto[100];
    private int cantidad = 0;

    public MenuProductos() {
        // datos de prueba
        productos[cantidad++] = new Producto("001", "Termo", 25000, 10, 3);
        productos[cantidad++] = new Producto("002", "Mate", 8000, 2, 5);
        productos[cantidad++] = new Producto("003", "Bombilla", 3500, 4, 4);
    }
    
    public void mostrar(){
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
                case 2: listar();break;
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
        System.out.println("--DANDO DE ALTA---");
        System.out.println("Codigo : ");
        String codigo = entrada.nextLine();
        System.out.println("Nombre : ");
        String nombre = entrada.nextLine();
        System.out.println("Precio : ");
        double precio = entrada.nextDouble();
        System.out.println("Stock : ");
        int stock = entrada.nextInt();
        System.out.println("Stock minimo : ");
        int stockMinimo = entrada.nextInt();
        entrada.nextLine();
        if((buscarPorCodigo(codigo))==false){
            productos[cantidad] = new Producto(codigo, nombre, precio, stock, stockMinimo);
            cantidad++;
            System.out.println("Producto creado correctamente..");
        }else {
            System.out.println("El codigo ya existe, no se pudo crear el producto.");
            return;
        }
    }
    private void listar() {
        for (int i = 0; i < cantidad; i++) {
            System.out.println(productos[i].toString());
        }
        System.out.println("Total de productos "+cantidad);
    }
    private void buscarPorCodigo() {
        System.out.println("Digite codigo a buscar: ");
        String codigoAbuscar = entrada.nextLine();
        for (int i = 0; i < cantidad; i++) {
         if (productos[i].getCodigo().equals(codigoAbuscar)) {
             System.out.println(productos[i].toString());
             return;
         }
        }
        System.out.println("No se encuentra el producto con el codigo solicitado...");

    }
    private boolean buscarPorCodigo(String codigo) {
        boolean encontrado = false;
        for (int i = 0; i < cantidad; i++) {
            if (productos[i].getCodigo().equals(codigo)) {
                return encontrado = true;
            }
        }
        return encontrado;
    }
    private void modificarPrecio() {
        Producto p = encontrarProducto();
        if(p !=null){
            System.out.println("Digite precio a modificar: ");
            double precio = entrada.nextDouble();
            if(precio>0){
                entrada.nextLine();
                p.setPrecio(precio);
                System.out.println("Precio modificado correctamente..");
            }else{
                System.out.println("No se puede modificar con un precio negativo.");
            }
        }else {
            System.out.println("El producto no existe, no se pudo modificar");
        }
    }
    private void cargarStock() {
        Producto p = encontrarProducto();
        if(p !=null){
            System.out.println("Digite stock a cargar: ");
            int stock = entrada.nextInt();
            if(stock>0){
                p.agregarStock(stock);
                System.out.println("Stock cargado correctamente..");
            }
        }else  {
            System.out.println("No se encontro el producto...");
        }
    }
    private void listarStockBajo() {
        System.out.println("--- PRODUCTOS CON STOCK BAJO ---");
        boolean hayAlguno = false;
        for (int i = 0; i < cantidad; i++) {
            Producto p = productos[i];
            if (p.isActivo() && p.tieneStockBajo()) {
                System.out.println(p);
                hayAlguno = true;
            }
        }
        if (!hayAlguno) {
            System.out.println("No hay productos con stock bajo.");
        }
    }
    private void darDeBaja() {

    }
    private Producto encontrarProducto(){
        System.out.println("Digite el codigo a buscar: ");
        String codigoProducto = entrada.nextLine();
        for (int i = 0; i < cantidad; i++) {
            if (productos[i].getCodigo().equals(codigoProducto)) {
                return productos[i];
            }
        }
        return null;
    }
}

