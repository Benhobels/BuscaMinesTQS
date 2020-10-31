package BuscaMines;

public interface GeneradorRandom {
    public abstract Casella[][] generarMinas(int filas, int columnas, int minas);
}