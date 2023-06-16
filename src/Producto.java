import java.util.ArrayList;

public abstract class Producto {

    protected String codigo;
    protected String Marca;
    protected String Modelo;

    public Producto(String codigo, String marca, String modelo) {
        this.codigo = codigo;
        Marca = marca;
        Modelo = modelo;

    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }

    public String getModelo() {
        return Modelo;
    }

    public void setModelo(String modelo) {
        Modelo = modelo;
    }



    @Override
    public String toString() {
        return "Producto{" +
                "codigo='" + codigo + '\'' +
                ", Marca='" + Marca + '\'' +
                ", Modelo='" + Modelo + '\'' +
                '}';
    }
}
