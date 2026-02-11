package Dominio;

import java.util.Objects;

public class Pelicula {
    private String Nombre;
    //bob
    public Pelicula(){}
    public Pelicula(String  Nombre ){
        this.Nombre = Nombre ;
    }

    //setter y getter

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    //equals hashco


    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;

        Pelicula pelicula = (Pelicula) o;
        return Objects.equals(Nombre, pelicula.Nombre);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(Nombre);
    }

    @Override
    public String toString() {
        return "Pelicula{" +
                "Nombre='" + Nombre + '\'' +
                '}';
    }
//    public static void main(String[] args) {
//        var Pelicula1 = new Pelicula("Jeepres Creepres");
//        var Pelicula2 = new Pelicula("El Hoyo");
//        System.out.println(Pelicula1);
//        System.out.println(Pelicula2);
//    }
}


