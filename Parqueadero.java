import java.util.ArrayList;

public class Parqueadero {
    private double tarifa;
    private ArrayList<Puesto> puestos;
    private double ingresos;

    public Parqueadero(int numeroPuestos, double tarifaInicial) {
        this.tarifa = tarifaInicial;
        this.ingresos = 0;
        this.puestos = new ArrayList<>();
        for (int i = 1; i <= numeroPuestos; i++) {
            puestos.add(new Puesto(i));
        }
    }

    public boolean ingresarCarro(Carro carro) {
        for (Puesto puesto : puestos) {
            if (puesto.getCarro() == null) {
                puesto.ocuparPuesto(carro);
                return true;
            }
        }
        return false;
    }

    public int darSalidaCarro(String placa) {
        for (Puesto puesto : puestos) {
            Carro carro = puesto.getCarro();
            if (carro != null && carro.getPlaca().equals(placa)) {
                int horasParqueado = calcularHorasParqueado(carro.getHoraEntrada());
                ingresos += horasParqueado * tarifa;
                puesto.desocuparPuesto();
                return horasParqueado;
            }
        }
        return -1; // Carro no encontrado
    }

    public double informarIngresos() {
        return ingresos;
    }

    public int cantidadPuestosDisponibles() {
        int count = 0;
        for (Puesto puesto : puestos) {
            if (puesto.getCarro() == null) {
                count++;
            }
        }
        return count;
    }

    public int contarCarrosQueComienzanConPlacaPB() {
        int count = 0;
        for (Puesto puesto : puestos) {
            Carro carro = puesto.getCarro();
            if (carro != null && carro.getPlaca().startsWith("PB")) {
                count++;
            }
        }
        return count;
    }

    public boolean hayCarroCon24Horas() {
        for (Puesto puesto : puestos) {
            Carro carro = puesto.getCarro();
            if (carro != null && calcularHorasParqueado(carro.getHoraEntrada()) >= 24) {
                return true;
            }
        }
        return false;
    }

    public int desocuparParqueadero() {
        int count = 0;
        for (Puesto puesto : puestos) {
            if (puesto.getCarro() != null) {
                puesto.desocuparPuesto();
                count++;
            }
        }
        return count;
    }

    private int calcularHorasParqueado(int horaEntrada) {
        // Simulación de cálculo de horas, debes ajustar esto según el reloj del parqueadero
        return 8; // Valor ejemplo, ajusta según la lógica de tu aplicación
    }
}
