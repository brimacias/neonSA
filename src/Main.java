import java.io.FileWriter;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Empresas> empresas = new ArrayList<>();

        ArrayList<Producto> productos = new ArrayList<>();

        // Obtener la fecha y hora actual
        Date fechaActual = new Date();

        // Definir el formato de fecha y hora
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");

        // Formatear la fecha actual según el formato definido
        String fechaFormateada = formato.format(fechaActual);

        LocalDate fecha_hoy = LocalDate.now();

        Scanner sc = new Scanner(System.in);

        // introducimos algunos arrays por codigo;

        Empresas Intel = new Empresas("13478964A", "Intel", "985647123");

        Empresas Nvidia = new Empresas("23456785M", "Nvidia", "652145874");

        Producto grafica1 = new ProductoVenta("123V", "Nvidia",
                "GFORCE 650", 200.50f);

        Producto ordenador_portatil1 = new ProductoAlquiler("456A", "Asus", "Aspire 100",
                10.00f, 'L');

        // añadimos al arraylist

        empresas.add(Intel);
        empresas.add(Nvidia);

        empresas.get(0).getProductos().add(grafica1); // Insertamos los datos en la posicion del primer arraylist
        empresas.get(1).getProductos().add(ordenador_portatil1);



        try {

            // Forma de ir registrando Operaciones en .txt
            FileWriter fileWriter = new FileWriter("registro.txt",true);
            PrintWriter printWriter = new PrintWriter(fileWriter);

            int opcion;

            do {

                System.out.println("Bienvenido al gestor de empresas Neon.SA ");
                System.out.println("1. Alta de empresa: ");
                System.out.println("2. Alta de productos en venta y alquiler: ");
                System.out.println("3. Dar de baja a un producto: ");
                System.out.println("4. Modificar los precios de los productos: ");
                System.out.println("5. Alquilar un producto: ");
                System.out.println("6. Devolver un producto"); // WIP
                System.out.println("7. Mostrar Empresas dadas de alta: ");
                System.out.println("8. Documentación"); // WIP
                System.out.println("9. Salir ");

                System.out.println("-----------------------------------------------------");

                System.out.println("Introduzca una opción de las anteriores: ");


                opcion = sc.nextInt();

                sc.nextLine();

                switch (opcion) {

                    case 1 -> {


                        try {
                            printWriter.println("Opcion de creacion de empresa: ");
                            Empresas empresa = new Empresas("", "", "");
                            empresa.crearEmpresa();
                            empresas.add(empresa);
                            printWriter.println(empresa.toString());
                            printWriter.println("Hora de creación: " + fechaFormateada);
                            System.out.println("Empresa dada de alta");
                        } catch (Empresas.CIFInvalidoException | Empresas.TelefonoInvalidoException e) {
                            System.out.println("Error: " + e.getMessage());
                        }

                    }


                    case 2 -> {

                        System.out.println("Elija la empresa dueña del producto");
                        String empresa_dueña = sc.nextLine();
                        System.out.println("Producto para venta o de alquiler? V/A ");
                        String venta_alquiler = sc.nextLine();

                        //Para productos en venta o alquiler

                        for (Empresas emp : empresas) {

                            if (empresa_dueña.equalsIgnoreCase(emp.getNombreEmpresa())
                                    && venta_alquiler.equalsIgnoreCase("V")) {

                                ProductoVenta producto = new ProductoVenta("", "", "", 0.00f);
                                producto.crearProductoVenta();
                                emp.getProductos().add(producto); // añadimos el producto a la empresa
                                System.out.println("Producto para venta dado de alta ");
                                System.out.println();
                                break;

                            } else if (empresa_dueña.equalsIgnoreCase(emp.getNombreEmpresa())
                                    && venta_alquiler.equalsIgnoreCase("A")) {

                                ProductoAlquiler producto = new ProductoAlquiler("", "", "",
                                        0.00f, 'L');
                                producto.crearProductoAlquiler();
                                emp.getProductos().add(producto); // añadimos el producto a la empresa
                                System.out.println("Producto para alquiler dado de alta");
                                System.out.println();
                                break;

                            } else {

                                System.out.println("Debe especificar si es para venta o alquiler");

                            }

                        }

                    }

                    case 3 -> { // borrar producto por posicion del arraylist

                        System.out.println("Empresas disponibles:");

                        for (Empresas empresa : empresas) {
                            System.out.println("Empresa: " + empresa.getNombreEmpresa());
                            System.out.println("Productos:");

                            for (Producto producto : empresa.getProductos()) {
                                System.out.println("  - " + empresa.getProductos().toString());
                            }
                            System.out.println("--------------------");
                        }
                        System.out.println();

                        System.out.println("----------------------------------------------------");

                        System.out.println("Ingrese el nombre de la empresa dueña del producto: ");
                        String nombreEmpresa = sc.nextLine();
                        System.out.println("Ingrese el código del producto a dar de baja: ");
                        String codigoProducto = sc.nextLine();

                        boolean encontrado = false;

                        for (Empresas empresa : empresas) {
                            if (empresa.getNombreEmpresa().equalsIgnoreCase(nombreEmpresa)) {
                                ArrayList<Producto> productosEmpresa = empresa.getProductos();

                                for (int i = 0; i < productosEmpresa.size(); i++) {
                                    Producto producto = productosEmpresa.get(i);
                                    if (producto.getCodigo().equalsIgnoreCase(codigoProducto)) {
                                        productosEmpresa.remove(i);
                                        encontrado = true;
                                        System.out.println("Producto dado de baja exitosamente.");
                                        break;
                                    }
                                }
                            }

                            if (encontrado) {
                                break;
                            }
                        }

                        if (!encontrado) {
                            System.out.println("No se encontró el producto en la empresa especificada.");
                        }

                        System.out.println();

                    }

                    case 4 -> {

                        System.out.println("Empresas disponibles:");
                        for (Empresas empresa : empresas) {
                            System.out.println("Empresa: " + empresa.getNombreEmpresa());
                            System.out.println("Productos:");
                            for (Producto producto : empresa.getProductos()) {
                                System.out.println("  - " + empresa.getProductos().toString());
                            }
                            System.out.println("--------------------");
                        }
                        System.out.println();

                        System.out.println("Ingrese el nombre de la empresa dueña del producto: ");
                        String nombreEmpresa = sc.nextLine();
                        System.out.println("Ingrese el código del producto que va a modificar: ");
                        String codigoProducto = sc.nextLine();
                        System.out.println("¿El producto a modificar el de venta o alquiler? V/A ");
                        String venta_alquiler = sc.nextLine();

                        boolean encontrado = false;

                        for (Empresas empresa : empresas) {

                            if (empresa.getNombreEmpresa().equalsIgnoreCase(nombreEmpresa)) {
                                ArrayList<Producto> productosEmpresa = empresa.getProductos();

                                if (venta_alquiler.equalsIgnoreCase("V")) {

                                    for (Producto producto : productosEmpresa) {

                                        if (producto instanceof ProductoVenta &&
                                                producto.getCodigo().equalsIgnoreCase(codigoProducto)) {

                                            System.out.println("Introduce el nuevo precio de venta: ");
                                            float nuevoPrecioVenta = sc.nextFloat();

                                            ((ProductoVenta) producto).setPrecioVenta(nuevoPrecioVenta);
                                            encontrado = true;

                                            System.out.println("Producto de venta modificado correctamente.");
                                            break;

                                        }
                                    }

                                } else if (venta_alquiler.equalsIgnoreCase("A")) {

                                    for (Producto producto : productosEmpresa) {

                                        if (producto instanceof ProductoAlquiler &&
                                                producto.getCodigo().equalsIgnoreCase(codigoProducto)) {

                                            System.out.println("Introduce el nuevo precio diario de alquiler: ");

                                            float nuevoPrecioAlquiler = sc.nextFloat();

                                            ((ProductoAlquiler) producto).setPrecioDia(nuevoPrecioAlquiler);
                                            encontrado = true;

                                            System.out.println("Producto de alquiler modificado correctamente.");
                                            break;
                                        }
                                    }
                                }

                                if (encontrado) {
                                    break;

                                }

                            }
                        }

                        if (!encontrado) {
                            System.out.println("No se encontró el producto en la empresa especificada.");
                        }

                        System.out.println();
                    }


                    case 5 -> {

                        System.out.println("Productos disponibles para alquilar: ");

                        System.out.println();

                        for (Empresas c : empresas) {

                            System.out.println(c.toString());

                            for (Producto producto : c.getProductos()) {
                                if (producto instanceof ProductoAlquiler &&
                                        ((ProductoAlquiler) producto).getEstado() == 'L') {
                                    System.out.println(producto.toString());
                                }
                            }
                        }

                        System.out.println("-------------------------------------------------");

                        System.out.println("Introduzca el código del producto a alquilar: ");

                        String codigo_intro = sc.nextLine();

                        for (Empresas c : empresas) {

                            for (Producto producto : c.getProductos()) {

                                if (producto.getCodigo().equals(codigo_intro)) {

                                    if (producto instanceof ProductoAlquiler &&
                                            ((ProductoAlquiler) producto).getEstado() == 'L') {

                                        Usos uso = new Usos(fechaActual, null, 0);

                                        // añadimos el array al arraylist de productosAlquiler
                                        ((ProductoAlquiler) producto).getUsos().add(uso);

                                        // Cambiamos el estado del producto a "Reservado"
                                        ((ProductoAlquiler) producto).setEstado('R');

                                        System.out.println("Producto alquilado en fecha de " + fecha_hoy);
                                        System.out.println("---------------------------------------------");
                                        System.out.println("Usos del producto:");

                                        for (Usos u : ((ProductoAlquiler) producto).getUsos()) {
                                            System.out.println(u.toString());
                                        }

                                        System.out.println("---------------------------------------------");

                                    } else {

                                        System.out.println("NO se ha encontrado el producto");
                                        System.out.println("---------------------------------------------");
                                    }
                                    break;
                                }
                            }
                        }
                    }


                    case 6 -> {

                        System.out.println("Introduzca el código del producto que desea devolver: ");
                        String codigoProductoDevolver = sc.nextLine();

                        System.out.println("Introduzca la fecha de alquiler (dd/MM/yyyy): ");
                        String fechaAlquilerStr = sc.nextLine();

                        System.out.println("Introduzca la fecha de devolución (dd/MM/yyyy): ");
                        String fechaDevolucionStr = sc.nextLine();

                        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
                        Date fechaAlquiler;
                        Date fechaDevolucion;

                        try {

                            fechaAlquiler = dateFormat.parse(fechaAlquilerStr);
                            fechaDevolucion = dateFormat.parse(fechaDevolucionStr);

                            float importeTotal = 0;

                            for (Empresas empresa : empresas) {
                                for (Producto producto : empresa.getProductos()) {
                                    if (producto instanceof ProductoAlquiler
                                            productoAlquiler && producto.getCodigo().equals(codigoProductoDevolver)) {

                                        for (Usos uso : productoAlquiler.getUsos()) {

                                            Date fechaUso = uso.getFechaAlquiler();

                                            if (fechaUso.after(fechaAlquiler) && fechaUso.before(fechaDevolucion)) {

                                                // TODO sumarle el importe correspondiente dependiendo de los dias alquilados

                                                importeTotal = productoAlquiler.getPrecioDia();
                                                ((ProductoAlquiler) producto).setEstado('L');
                                            }
                                        }
                                    }
                                }
                            }

                            System.out.println("Importe total por los dias alquilado: " + importeTotal);

                        } catch (ParseException e) {
                            System.out.println("Error en las fechas.");
                        }
                    }


                    case 7 -> {

                        System.out.println("\nLista de Empresas con sus productos:");
                        System.out.println();

                        for (Empresas c : empresas) {
                            System.out.println(c.toString());

                            for (Producto p : c.getProductos()) {

                                System.out.println(p.toString());
                            }
                        }

                        System.out.println("-----------------------------------------------------");

                    }

                    case 8 -> {


                        System.out.println("Generación de documentación: ");
                        System.out.println("Ingrese el nombre de la empresa cuyos productos desea exportar: ");
                        String nombreEmpresaExportar = sc.nextLine();

                        Empresas empresaExportar = null;
                        for (Empresas empresa : empresas) {
                            if (empresa.getNombreEmpresa().equalsIgnoreCase(nombreEmpresaExportar)) {
                                empresaExportar = empresa;
                                break;
                            }
                        }

                        if (empresaExportar != null) {
                            Empresas.exportar_Productos_XML(empresaExportar);
                            Empresas.exportarProductosAJSON(empresaExportar);
                            System.out.println("Documentación generada exitosamente.");
                        } else {
                            System.out.println("No se encontró la empresa especificada.");
                        }

                        System.out.println("-----------------------------------------------------");

                    }

                }

            } while (opcion != 9);

            printWriter.println("--------------------------------------------");
            printWriter.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    // Metodos de la documentacion:



}