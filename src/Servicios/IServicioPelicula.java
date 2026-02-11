package Servicios;

import Dominio.Pelicula;

public interface IServicioPelicula {
    public void ListarPeliculas();
    public void AgregarPeliculas(Pelicula Nombre);
    public void BuscarPeliculas(Pelicula Nombre);
    public void RegistrarAccion(String accion );
    public void MostrarHistorial();
    public void EliminarPelicula (Pelicula Nombre);
}


