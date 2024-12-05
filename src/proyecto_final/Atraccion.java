package proyecto_final;

/**
 *
 * @author Server
 */
public class Atraccion {
    private String nombre;
    private int entradasDisponibles;
    private String[][] reservas; // Matriz: fila = reserva, [0] = nombre persona, [1] = cantidad entradas
    private int numReservas; // Cantidad actual de reservas realizadas

    public Atraccion(String nombre, int entradasDisponibles, int capacidadReservas) {
        this.nombre = nombre;
        this.entradasDisponibles = entradasDisponibles;
        this.reservas = new String[capacidadReservas][2];
        this.numReservas = 0;
    }

    public String getNombre() {
        return nombre;
    }

    public int getEntradasDisponibles() {
        return entradasDisponibles;
    }

    public void reservarEntradas(String nombrePersona, int cantidad) {
        if (entradasDisponibles >= cantidad) {
            if (numReservas < reservas.length) {
                reservas[numReservas][0] = nombrePersona;
                reservas[numReservas][1] = String.valueOf(cantidad);
                entradasDisponibles -= cantidad;
                numReservas++;
                System.out.println("Reserva realizada con éxito.");
            } else {
                System.out.println("No se pueden realizar más reservas para esta atracción.");
            }
        } else {
            System.out.println("No hay suficientes entradas disponibles.");
        }
    }

    public void mostrarInfo() {
        System.out.println("Atracción: " + nombre);
        System.out.println("Entradas disponibles: " + entradasDisponibles);
        if (numReservas == 0) {
            System.out.println("No hay reservas.");
        } else {
            System.out.println("Personas que han reservado:");
            System.out.printf("%-15s %-10s%n", "Nombre", "Cantidad");
            for (int i = 0; i < numReservas; i++) {
                System.out.printf("%-15s %-10s%n", reservas[i][0], reservas[i][1]);
            }
        }
    }
}