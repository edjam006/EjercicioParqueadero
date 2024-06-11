public class Carro {
    private String placa;
    private int horaEntrada;
    private int horasParqueo;

    public Carro(String placa, int horaEntrada, int horasParqueo) {
        this.placa = placa;
        this.horaEntrada = horaEntrada;
        this.horasParqueo = horasParqueo;
    }

    public String getPlaca() {
        return placa;
    }

    public int getHoraEntrada() {
        return horaEntrada;
    }

    public void setHoraEntrada(int horaEntrada) {
        this.horaEntrada = horaEntrada;
    }

    public int getHorasParqueo() {
        return horasParqueo;
    }

    public void setHorasParqueo(int horasParqueo) {
        this.horasParqueo = horasParqueo;
    }
}
