package Servicios;

import java.util.ArrayList;
import Dominio.Pelicula;

public class Servicios implements IServicioPelicula {
    ArrayList<Pelicula> pelicula=new ArrayList<>();


    @Override
    public void ListarPeliculas() {
        System.out.println("Listado de Peliculas: ");
        pelicula.forEach(System.out::println);
    }

    @Override
    public void AgregarPeliculas(Pelicula Nombre) {
        pelicula.add(Nombre);
        System.out.println("Agregando Pelicula....");
    }

    @Override
    public void BuscarPeliculas(Pelicula Nombre) {
        var indice = pelicula.indexOf(pelicula);
        if (indice == -1) {
            System.out.println("Pelicula no encontrada..");
        } else {
            System.out.println("La pelicula fue encontra en el indice ( " + indice + ")");
        }
    }

    @Override
    public void RegistrarAccion(String accion) {

    }

    @Override
    public void MostrarHistorial() {

    }

    public static void main(String[]args){
        //objetos
        var Pelicula1=new Pelicula("Jeepers Creepers");
        var Pelicula2=new Pelicula("Xmen");
        var Pelicula3= new Pelicula("Hoyo");
        var Pelicula4=new Pelicula("Ted");
        var Pelicula5=new Pelicula("Spiderman ");

        //creamso servivio
        IServicioPelicula servicioPelicula=new Servicios();
        servicioPelicula.AgregarPeliculas(Pelicula1);
        servicioPelicula.AgregarPeliculas(Pelicula2);
        servicioPelicula.AgregarPeliculas(Pelicula3);
        servicioPelicula.AgregarPeliculas(Pelicula4);
        servicioPelicula.AgregarPeliculas(Pelicula5);


        servicioPelicula.ListarPeliculas();
        servicioPelicula.BuscarPeliculas(Pelicula1);

        servicioPelicula.BuscarPeliculas(new Pelicula("Batman"));

    }

}
