package jose.armas;

import java.util.Objects;

public class Tarea {

    String nombre;
    boolean completada;

    public Tarea() {
    }

    public Tarea(String nombre) {
        this.nombre = nombre;
        this.completada=false;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean isCompletada() {
        return completada;
    }

    public void setCompletada(boolean completada) {
        this.completada = completada;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tarea tarea = (Tarea) o;
        return Objects.equals(nombre, tarea.nombre);
    }

    @Override
    public int hashCode() {

        return Objects.hash(nombre);
    }

    @Override
    public String toString() {
        return nombre;
    }
}
