import java.util.ArrayList;
import java.util.Scanner;

public class ProductoAlquiler extends Producto {

    private float precioDia;
    private char estado;

    Scanner sc = new Scanner(System.in);


    public ProductoAlquiler(String codigo, String marca, String modelo, float precioDia, char estado) {
        super(codigo, marca, modelo);
        this.precioDia = precioDia;
        this.estado = estado;
        this.usos=new ArrayList<>(); // arraylist vacio
    }

    ArrayList<Usos> usos;

    public ArrayList<Usos> getUsos() {
        return usos;
    }

    public void setUsos(ArrayList<Usos> usos) {
        this.usos = usos;
    }

    public float getPrecioDia() {
        return precioDia;
    }

    public void setPrecioDia(float precioDia) {
        this.precioDia = precioDia;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }


    public void crearProductoAlquiler() {

        System.out.println("Introduzca el codigo del producto: ");
        super.codigo = sc.nextLine();
        System.out.println("Introduzca la marca: ");
        super.Marca = sc.nextLine();
        System.out.println("Introduzca el modelo del producto: ");
        super.Modelo = sc.nextLine();
        System.out.println("Introduzca el precio de venta: ");
        precioDia = sc.nextFloat();

    }


    @Override
    public String toString() {
        return "ProductoAlquiler{" +
                "precioDia=" + precioDia +
                ", estado=" + estado +
                ", codigo='" + codigo + '\'' +
                ", Marca='" + Marca + '\'' +
                ", Modelo='" + Modelo + '\'' +
                '}';
    }


}



