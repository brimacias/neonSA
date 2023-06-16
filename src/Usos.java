import java.util.Date;

public class Usos {

    private Date FechaAlquiler;
    private Date FechaEntrega;
    private float importeAPagar;

    public Usos(Date fechaAlquiler, Date fechaEntrega, float importeAPagar) {
        FechaAlquiler = fechaAlquiler;
        FechaEntrega = fechaEntrega;
        this.importeAPagar = importeAPagar;
    }

    public Date getFechaAlquiler() {
        return FechaAlquiler;
    }

    public void setFechaAlquiler(Date fechaAlquiler) {
        FechaAlquiler = fechaAlquiler;
    }

    public Date getFechaEntrega() {
        return FechaEntrega;
    }

    public void setFechaEntrega(Date fechaEntrega) {
        FechaEntrega = fechaEntrega;
    }

    public float getImporteAPagar() {
        return importeAPagar;
    }

    public void setImporteAPagar(float importeAPagar) {
        this.importeAPagar = importeAPagar;
    }

    @Override
    public String toString() {
        return "Usos{" +
                "FechaAlquiler=" + FechaAlquiler +
                ", FechaEntrega=" + FechaEntrega +
                ", importeAPagar=" + importeAPagar +
                '}';
    }
}
