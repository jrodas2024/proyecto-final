package proyecto_final;

/**
 *
 * @author Server
 */
import java.util.Scanner;

public class Venta {
    public static void main(String[] args) {
        Scanner lectura = new Scanner(System.in);
        SistemaParque sistema = new SistemaParque(10); // Máximo 10 atracciones

        // Agregar algunas atracciones
        sistema.agregarAtraccion(new Atraccion("Sillas Voladoras", 80, 20)); // Máximo 20 reservas
        sistema.agregarAtraccion(new Atraccion("Carrera de Autos", 120, 30)); // Máximo 30 reservas

        while (true) {
            System.out.println("\nMenú:");
            System.out.println("1. Ver atracciones");
            System.out.println("2. Reservar entradas");
            System.out.println("3. Consultar reservas");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");

            if (!lectura.hasNextInt()) {
                System.out.println("Opción no válida. Ingrese un número.");
                lectura.nextLine();
                continue;
            }

            int opcion = lectura.nextInt();
            lectura.nextLine();

            switch (opcion) {
                case 1:
                    sistema.mostrarAtracciones();
                    break;

                case 2:
                    sistema.mostrarAtracciones();
                    System.out.print("Seleccione una atracción: ");
                    if (!lectura.hasNextInt()) {
                        System.out.println("Opción no válida. Intente de nuevo.");
                        lectura.nextLine();
                        break;
                    }
                    int atraccionSeleccionada = lectura.nextInt();
                    lectura.nextLine();

                    Atraccion atraccion = sistema.seleccionarAtraccion(atraccionSeleccionada);
                    if (atraccion != null) {
                        System.out.print("Nombre de la persona que reserva: ");
                        String nombrePersona = lectura.nextLine();
                        System.out.print("Cantidad de entradas: ");

                        if (!lectura.hasNextInt()) {
                            System.out.println("Entrada no válida.");
                            lectura.nextLine();
                            break;
                        }
                        int cantidad = lectura.nextInt();
                        lectura.nextLine();
                        atraccion.reservarEntradas(nombrePersona, cantidad);
                    }
                    break;

                case 3:
                    sistema.mostrarAtracciones();
                    System.out.print("Seleccione una atracción para consultar reservas: ");
                    if (!lectura.hasNextInt()) {
                        System.out.println("Opción no válida.");
                        lectura.nextLine();
                        break;
                    }
                    int atraccionConsulta = lectura.nextInt();
                    lectura.nextLine();

                    Atraccion atraccionConsultaSeleccionada = sistema.seleccionarAtraccion(atraccionConsulta);
                    if (atraccionConsultaSeleccionada != null) {
                        atraccionConsultaSeleccionada.mostrarInfo();
                    }
                    break;

                case 4:
                    System.out.println("Gracias por visitar el parque.");
                    return;

                default:
                    System.out.println("Opción no válida. Intente de nuevo.");
            }
        }
    }
}