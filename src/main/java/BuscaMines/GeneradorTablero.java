package BuscaMines;

// se encarga de colocar las minas en el tablero
public interface GeneradorTablero {
    public abstract Casella[][] generarMinas(int filas, int columnas, int minas);
}