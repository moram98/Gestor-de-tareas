import java.time.LocalDate;

public class Tarea {

    //Atributos

    private int id;
    private String titulo;
    private String descripcion;
    private LocalDate fechaDeVencimiento;
    private String  estado;

    //Constructor


    public Tarea(int id, String titulo, String descripcion, LocalDate fechaDeVencimiento) {
        this.id = id;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.fechaDeVencimiento = fechaDeVencimiento;
        this.estado = "Pendiente";
    }

    //Metodos Get y Set


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public LocalDate getFechaDeVencimiento() {
        return fechaDeVencimiento;
    }

    public void setFechaDeVencimiento(LocalDate fechaDeVencimiento) {
        this.fechaDeVencimiento = fechaDeVencimiento;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

     @Override
    public String toString(){
        return "ID: " + id + "| Titulo: " + titulo + "| Estado: " + estado +
         "| Vence: " + fechaDeVencimiento + "\nDescripcion: " + descripcion;
     }
}
