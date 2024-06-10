import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parqueadero parqueadero = new Parqueadero(40, 5.0); // Inicializamos con 40 puestos y tarifa de 5.0
        boolean salir = false;

        do {
            System.out.println("Menú del Parqueadero:");
            System.out.println("1. Ingresar un carro al parqueadero");
            System.out.println("2. Dar salida a un carro del parqueadero");
            System.out.println("3. Informar los ingresos del parqueadero");
            System.out.println("4. Consultar la cantidad de puestos disponibles");
            System.out.println("5. Contar carros con placa PB");
            System.out.println("6. Saber si hay carros con más de 24 horas");
            System.out.println("7. Desocupar parqueadero");
            System.out.println("8. Salir");
            System.out.print("Elija una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine(); // Consumir la nueva línea

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la placa del carro: ");
                    String placa = scanner.nextLine();
                    System.out.print("Ingrese la hora de entrada (entre 6:00 y 21:00): ");
                    int horaEntrada = scanner.nextInt();
                    scanner.nextLine(); // Consumir la nueva línea
                    if (parqueadero.ingresarCarro(new Carro(placa, horaEntrada))) {
                        System.out.println("Carro ingresado correctamente.");
                    } else {
                        System.out.println("No se pudo ingresar el carro. Verifique los datos o disponibilidad.");
                    }
                    break;
                case 2:
                    System.out.print("Ingrese la placa del carro a dar salida: ");
                    placa = scanner.nextLine();
                    int horasParqueado = parqueadero.darSalidaCarro(placa);
                    if (horasParqueado != -1) {
                        System.out.println("Carro salido. Horas parqueado: " + horasParqueado);
                    } else {
                        System.out.println("No se encontró un carro con esa placa.");
                    }
                    break;
                case 3:
                    System.out.println("Ingresos del parqueadero: $" + parqueadero.informarIngresos());
                    break;
                case 4:
                    System.out.println("Cantidad de puestos disponibles: " + parqueadero.cantidadPuestosDisponibles());
                    break;
                case 5:
                    System.out.println("Cantidad de carros con placa PB: " + parqueadero.contarCarrosQueComienzanConPlacaPB());
                    break;
                case 6:
                    boolean hayCarro24Horas = parqueadero.hayCarroCon24Horas();
                    System.out.println("Hay carro parqueado por 24 o más horas: " + (hayCarro24Horas ? "Sí" : "No"));
                    break;
                case 7:
                    int carrosSacados = parqueadero.desocuparParqueadero();
                    System.out.println("Cantidad de carros sacados: " + carrosSacados);
                    break;
                case 8:
                    salir = true;
                    System.out.println("Saliendo del sistema.");
                    break;
                default:
                    System.out.println("Opción no válida.");
                    break;
            }
        } while (!salir);

        scanner.close();
    }
}
