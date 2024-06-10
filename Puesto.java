public class Puesto {
    private int numero;
    private Carro carro;

    public Puesto(int numero) {
        this.numero = numero;
        this.carro = null;
    }

    public int getNumero() {
        return numero;
    }

    public Carro getCarro() {
        return carro;
    }

    public void ocuparPuesto(Carro carro) {
        this.carro = carro;
    }

    public void desocuparPuesto() {
        this.carro = null;
    }
}
