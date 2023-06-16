import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Empresas {

    private String cif;
    private String NombreEmpresa;
    private String telf;

    public Empresas(String cif, String nombreEmpresa, String telf) {
        this.cif = cif;
        NombreEmpresa = nombreEmpresa;
        this.telf = telf;
        this.productos=new ArrayList<>(); // añadimos un arraylist vacío
    }

    ArrayList<Producto> productos;

    public ArrayList<Producto> getProductos() {
        return productos;
    }

    public void setProductos(ArrayList<Producto> productos) {
        this.productos = productos;
    }


    Scanner sc = new Scanner(System.in);




    public String getCif() {
        return cif;
    }

    public void setCif(String cif) {
        this.cif = cif;
    }

    public String getNombreEmpresa() {
        return NombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        NombreEmpresa = nombreEmpresa;
    }

    public String getTelf() {
        return telf;
    }

    public void setTelf(String telf) {
        this.telf = telf;
    }


    public void crearEmpresa() throws TelefonoInvalidoException {

        System.out.println("Introduce el cif identificativo: ");
        cif = sc.nextLine();
        if (!validarCIF(cif)) {
            throw new CIFInvalidoException("El CIF introducido es inválido.");
        }
        System.out.println("Introduce el nombre de la empresa: ");
        NombreEmpresa = sc.nextLine();

        System.out.println("Introduce el teléfono");
        telf = sc.nextLine();

        if (!validadTLF(telf)) {
            throw new TelefonoInvalidoException("Teléfono no es válido. Debe comenzar con '6' seguido de 8 números.");
            }
        }


    public boolean validarCIF(String cif) {
        // Verificar el formato del CIF
        // CIF válido: 8 dígitos seguidos de una letra
        return cif.matches("\\d{8}[A-Za-z]");
    }

    public boolean validadTLF (String telf){

        return telf.matches("6\\d{8}");
    }

    public static class CIFInvalidoException extends RuntimeException {

        public CIFInvalidoException(String mensaje) {
            super(mensaje);
        }
    }

    public static class TelefonoInvalidoException extends Exception {

        public TelefonoInvalidoException(String mensaje) {
            super(mensaje);
        }
    }

    @Override
    public String toString() {

        return "Empresas = " + "cif='" + cif + '\'' + ", NombreEmpresa = " + NombreEmpresa + '\'' +
                ", telf='" + telf + '\'' +
                '}';

    }

    // Metodo exportacion a XML:
    public static void exportar_Productos_XML(Empresas empresa) {

        String nombreArchivo = empresa.getNombreEmpresa() + "_productos.xml";

        StringBuilder xmlBuilder = new StringBuilder();
        xmlBuilder.append("<productos>\n");

        for (Producto producto : empresa.getProductos()) {
            xmlBuilder.append("\t<producto>\n");
            xmlBuilder.append("\t\t<codigo>").append(producto.getCodigo()).append("</codigo>\n");
            xmlBuilder.append("\t\t<nombre>").append(producto.getMarca()).append("</nombre>\n");
            xmlBuilder.append("\t\t<modelo>").append(producto.getModelo()).append("</modelo>\n");
            xmlBuilder.append("\t</producto>\n");
        }
        xmlBuilder.append("</productos>");

        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            writer.write(xmlBuilder.toString());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //  Exportar JSON
    public static void exportarProductosAJSON(Empresas empresa) {
        String nombreArchivo = empresa.getNombreEmpresa() + " _productos.json";

        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(empresa.getProductos());

        try (FileWriter writer = new FileWriter(nombreArchivo)) {
            writer.write(json);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}

