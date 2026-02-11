package Presentacion;
import Dominio.Pelicula;
import Servicios.IServicioPelicula;
import Servicios.ServicioPeliculasArchivo;

import java.util.Scanner;

public class CatalogoPelicula {
    public static void main(String[] args) {
        var salir = false;
        var consola = new Scanner(System.in);

        //IServicioPeliculas servicioPeliculas = new Servicio();
        IServicioPelicula servicioPeliculas = new ServicioPeliculasArchivo();

        while(!salir){
            try{
                salir = ejecutarOpciones(consola,servicioPeliculas);
            }
            catch(Exception e){
                System.out.println("Ocurrio Un Error Si Sos Maje:"+e.getMessage());
            }

        }
    }

    private static void mostrarMenu(){
        System.out.println("""
            
            *** Catalago De Peliculas ***
            1. Agregar Pelicula
            2. Listar Peliculas
            3. Buscar Peliculas
            4. Mostrar Historial
            5. Salir
            """);
    }
    private static boolean ejecutarOpciones(Scanner consola,IServicioPelicula servicioPeliculas){
        System.out.println("...");
        mostrarMenu();
        var opciones=Integer.parseInt(consola.nextLine());
        var salir = false;
        switch (opciones){
            case 1->{
                System.out.println("Introduce El Nombre De La Pelicula:");

                var nombrePelicula=consola.nextLine();

                servicioPeliculas.AgregarPeliculas(new Pelicula(nombrePelicula));
                servicioPeliculas.RegistrarAccion("El usuario agrego una pelicula al catalogo");

            }
            case 2->{
                servicioPeliculas.ListarPeliculas();
                servicioPeliculas.RegistrarAccion("El usuario entro al catalogo de peliculas");

            }
            case 3->{
                System.out.println("Introduce El Nombre De La Pelicula a Buscar:");
                var buscar=consola.nextLine();

                servicioPeliculas.BuscarPeliculas(new Pelicula(buscar));
                servicioPeliculas.RegistrarAccion("EL usuario busco una pelicula en el catalogo");
            }

            case 4->{
                System.out.println("Mostrando historial de registros");
                servicioPeliculas.MostrarHistorial();

            }
            case 5->{
                System.out.println("Esta Saliendo El Cerote...");
                salir=true;
            }

            default -> {
                System.out.println("SI SOS MAJE NO VES QUE ES DEL 1 AL 4 OMBE RAMOOOOOOS");
            }
        }
        return salir;
    }
}