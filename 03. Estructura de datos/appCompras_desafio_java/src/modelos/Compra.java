package modelos;
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
