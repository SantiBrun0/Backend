public abstract class Vendedor {

    private String nombre;
    private Integer puntos;
    private String categoria;

    public Vendedor(String nombre) {
        this.nombre = nombre;
        this.puntos = 0;
        this.categoria = "NOVATO";
    }

    public void mostrarCategoria() {
        if (this.puntos <= 20) {
            System.out.println("Nombre: " + this.nombre + ", puntos: " + this.puntos + ", categoria: NOVATO");
            this.setCategoria("NOVATO");
        }
        if (this.puntos > 20 && this.getPuntos() <= 30) {
            System.out.println("Nombre: " + this.nombre + ", puntos: " + this.puntos + ", categoria: APRENDIZ");
            this.setCategoria("APRENDIZ");
        }
        if (this.puntos > 30 && this.getPuntos() <= 40) {
            System.out.println("Nombre: " + this.nombre + ", puntos: " + this.puntos + ", categoria: BUENO");
            this.setCategoria("BUENO");
        }
        if (this.puntos > 40) {
            System.out.println("Nombre: " + this.nombre + ", puntos: " + this.puntos + ", categoria: MAESTRO");
            this.setCategoria("MAESTRO");
        }
    }

    public abstract void vender(Integer cantVendidas);

    public Integer getPuntos() {
        return puntos;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setPuntos(Integer puntos) {
        this.puntos = puntos;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

}
