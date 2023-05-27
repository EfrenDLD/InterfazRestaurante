public class Comida{
    private String descripcion;
    private String nombre;
    private String precio;
    private String descripcionB;
    private String nombreB;
    private String precioB;

    public Comida(String descripcion, String nombre, String precio, String descripcionB, String nombreB, String precioB) {
        this.descripcion = descripcion;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcionB = descripcionB;
        this.nombreB = nombreB;
        this.precioB = precioB;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public String getPrecio() {
        return precio;
    }

    public String getDescripcionB() {
        return descripcionB;
    }

    public String getNombreB() {
        return nombreB;
    }

    public String getPrecioB() {
        return precioB;
    }
}