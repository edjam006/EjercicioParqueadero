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
                int horasParqueado = carro.getHorasParqueo();
                ingresos += horasParqueado * tarifa;
                puesto.desocuparPuesto();
                return horasParqueado;
            }
        }
        return -1;
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
            if (carro != null && carro.getHorasParqueo() >= 24) {
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

    public void avanzarReloj(int horas) {
        for (Puesto puesto : puestos) {
            Carro carro = puesto.getCarro();
            if (carro != null) {
                carro.setHoraEntrada(carro.getHoraEntrada() + horas);
            }
        }
    }

    public void cambiarTarifa(double nuevaTarifa) {
        this.tarifa = nuevaTarifa;
    }

    public boolean establecerHorasParqueo(String placa, int horasParqueo) {
        for (Puesto puesto : puestos) {
            Carro carro = puesto.getCarro();
            if (carro != null && carro.getPlaca().equals(placa)) {
                carro.setHorasParqueo(horasParqueo);
                return true;
            }
        }
        return false;
    }
}
