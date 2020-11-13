package Modelo;

// Interficie que se encarga de colocar las minas en el tablero, útil para el uso de los Mocks
public interface GeneradorTablero {
    public abstract Casella[][] generarMinas(int filas, int columnas, int minas);
}