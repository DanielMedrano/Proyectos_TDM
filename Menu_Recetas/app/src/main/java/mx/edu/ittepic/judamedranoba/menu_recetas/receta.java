package mx.edu.ittepic.judamedranoba.menu_recetas;

import java.io.Serializable;

/**
 * Created by JuanDaniel on 05/09/17.
 */

public class receta implements Serializable {

    private  String nombre;
    private  Integer imagen;
    private  String contenido;
    private  Integer iterable;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getImagen() {
        return imagen;
    }

    public void setImagen(Integer imagen) {
        this.imagen = imagen;
    }

    public String getContenido() {
        return contenido;
    }

    public void setContenido(String contenido) {
        this.contenido = contenido;
    }

    public Integer getIterable() {
        return iterable;
    }

    public void setIterable(Integer iterable) {
        this.iterable = iterable;
    }
}
