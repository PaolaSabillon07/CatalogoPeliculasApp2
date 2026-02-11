package Servicios;

import Dominio.Pelicula;

import java.io.*;

public class ServicioPeliculasArchivo implements IServicioPelicula{

    private final String NOMBRE_ARCHIVO="peliculas.txt";
    private final String NOMBRE_HISTORIAL="historial.txt";

    public ServicioPeliculasArchivo(){
        var archivo=new File(NOMBRE_ARCHIVO);
        try{
            if(archivo.exists()){
                System.out.println("Ya existe el archivo");
            }
            else{
                var salida=new PrintWriter(new FileWriter(archivo));
                System.out.println("Archivo creado con exito");
            }
        } catch (IOException e) {
            System.out.println("Error al abrir el archivo");
        }
    }
    @Override
    public void ListarPeliculas() {
        var archivo =new File(NOMBRE_ARCHIVO);
        try {
            System.out.println("Listando las peliculas...");
            //Abrir el archivo para lectura
            var entrada=new BufferedReader(new FileReader(archivo));
            //Leemos linea por linea el archivo
            String linea;
            linea=entrada.readLine();

            //Ciclos para leer todo_ el documento
            while(linea!=null){
                var pelicula=new Pelicula(linea);
                System.out.println(pelicula);
                //volvemos a llamar y captura el calor de la siguiente

                linea=entrada.readLine();

            }
            entrada.close();

        }catch(Exception e){
            System.out.println("Error al abrir el archivo");
        }
    }

    @Override
    public void AgregarPeliculas(Pelicula pelicula) {
        boolean anexar=false;
        var archivo=new File(NOMBRE_ARCHIVO);
        try {
            if(archivo.exists()){
                anexar=archivo.exists();
                var salida=new PrintWriter(new FileWriter(archivo,anexar));
                //agregar la pelicula

                salida.println(pelicula);
                salida.close();
                System.out.println("Se agrego la peli..."+pelicula+" al archivo");

            }

        }catch (Exception e){
            System.out.println("Error al agregar la peli al archivo");
        }
    }

    @Override
    public void BuscarPeliculas(Pelicula pelicula) {

        var archivo=new File(NOMBRE_ARCHIVO);


        try {
            var entrada=new BufferedReader(new FileReader(archivo));
            String lineaTexto;
            lineaTexto=entrada.readLine();
            var indice=1;
            var encontrada=false;

            var peliculaBuscar=pelicula.getNombre();


            //recorrer archivo
            while (lineaTexto!=null){
                if(peliculaBuscar!=null&&peliculaBuscar.equalsIgnoreCase(lineaTexto)){
                    System.out.println("Pelicula " + lineaTexto + " encontrada en el indice " + indice);
                    encontrada=true;
                    break;
                }
                lineaTexto = entrada.readLine(); // MOVIDO DENTRO DEL WHILE
                indice++;




            }//while
            entrada.close();

            if (!encontrada) {
                System.out.println("No se encontro la pelicula: " + peliculaBuscar);
            }

        }catch (Exception e){
            System.out.println("No se encontro la pelicula en el archivo");
        };
    }

    @Override
    public void RegistrarAccion(String accion) {
        File archivo=new File(NOMBRE_HISTORIAL);
        boolean anexar=false;

        try{
            if(!archivo.exists()){
                anexar=archivo.exists();
                var salida = new PrintWriter(new FileWriter(archivo, anexar));
                salida.println(new java.util.Date()+" - "+accion);
                salida.close();
            }
            else{
                anexar=archivo.exists();
                var salida = new PrintWriter(new FileWriter(archivo, anexar));
                salida.println(new java.util.Date()+" - "+accion);
                salida.close();
            }


        }catch (Exception e){
            System.out.println("Error al registrar en el historial");
        }
    }

    @Override
    public void MostrarHistorial() {
        File archivo = new File(NOMBRE_HISTORIAL);
        try {
            if (!archivo.exists()) {
                System.out.println("No hay acciones registradas en el historial");
            }
            var entrada = new BufferedReader(new FileReader(archivo));
            //Leemos linea por linea el archivo
            String linea;
            linea = entrada.readLine();

            //Ciclos para leer todo_ el documento
            while (linea != null) {

                System.out.println(linea);
                //volvemos a llamar y captura el calor de la siguiente

                linea = entrada.readLine();

            }
            entrada.close();

        } catch (Exception e) {
            System.out.println("Error al abrir el archivo");
        }

    }

    public void EliminarPelicula(String nombrePelicula) {
        var archivo=new File(NOMBRE_ARCHIVO);
        var archivoTemp=new File("temp.txt");
        boolean eliminado=false;

        try {
            var entrada=new BufferedReader(new FileReader(archivo));
            var salida=new PrintWriter(new FileWriter(archivoTemp));

            String linea;
            while ((linea=entrada.readLine()) != null) {

                if (!linea.contains(nombrePelicula)) {
                    salida.println(linea);
                } else {
                    eliminado = true;
                }
            }

            entrada.close();
            salida.close();


            archivo.delete();
            archivoTemp.renameTo(archivo);

            if (eliminado) {
                System.out.println("La película fue eliminada correctamente");
            } else {
                System.out.println("No se encontró la película");
            }

        } catch (Exception e) {
            System.out.println("Error al eliminar la película del archivo");
        }
    }

}