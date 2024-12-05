package proyecto_final;

/**
 *
 * @author Server
 */
public class SistemaParque {
    private Atraccion[] atracciones; // Matriz para atracciones
    private int numAtracciones; // Cantidad actual de atracciones

    public SistemaParque(int capacidadMaxima) {
        this.atracciones = new Atraccion[capacidadMaxima];
        this.numAtracciones = 0;
    }

    public void agregarAtraccion(Atraccion atraccion) {
        if (numAtracciones < atracciones.length) {
            atracciones[numAtracciones++] = atraccion;
        } else {
            System.out.println("No se pueden agregar más atracciones.");
        }
    }

    public void mostrarAtracciones() {
        for (int i = 0; i < numAtracciones; i++) {
            System.out.println((i + 1) + ". " + atracciones[i].getNombre());
        }
    }

    public Atraccion seleccionarAtraccion(int indice) {
        if (indice > 0 && indice <= numAtracciones) {
            return atracciones[indice - 1];
        } else {
            System.out.println("Opción no válida.");
            return null;
        }
    }
}