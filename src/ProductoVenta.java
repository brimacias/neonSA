import java.util.Scanner;

public class ProductoVenta extends Producto {

    private float precioVenta;

    Scanner sc = new Scanner(System.in);

    public ProductoVenta(String codigo, String marca, String modelo, float precioVenta) {
        super(codigo, marca, modelo);
        this.precioVenta = precioVenta;
    }

    public float getPrecioVenta() {
        return precioVenta;
    }

    public void setPrecioVenta(float precioVenta) {
        this.precioVenta = precioVenta;
    }

    public void crearProductoVenta(){

        System.out.println("Introduzca el codigo del producto: ");
        super.codigo = sc.nextLine();
        System.out.println("Introduzca la marca: ");
        super.Marca = sc.nextLine();
        System.out.println("Introduzca el modelo del producto: ");
        super.Modelo = sc.nextLine();
        System.out.println("Introduzca el precio de venta: ");
        precioVenta = sc.nextFloat();

    }

    @Override
    public String toString() {
        return "ProductoVenta{" +
                "precioVenta=" + precioVenta +
                ", codigo='" + codigo + '\'' +
                ", Marca='" + Marca + '\'' +
                ", Modelo='" + Modelo + '\'' +
                '}';
    }
}
