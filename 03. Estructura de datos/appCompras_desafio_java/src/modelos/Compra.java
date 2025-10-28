package modelos;

public class Compra implements Comparable<Compra> {
    private String descripcion;
    private double valor;

    public Compra(String descripcion, double valor) {
        this.descripcion = descripcion;
        this.valor = valor;
    }
    @Override
    public String toString() {
        return "Compra: *" +
                "descripcion '" + descripcion + '\'' +
                "/ valor " + valor +
                '*';
    }

    @Override
    public int compareTo(Compra otraCompra) {
        return Double.valueOf(this.valor).compareTo(Double.valueOf(otraCompra.getValor()));
    }
}
