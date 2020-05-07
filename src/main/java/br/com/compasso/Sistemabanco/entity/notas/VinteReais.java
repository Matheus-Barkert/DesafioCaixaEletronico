package br.com.compasso.Sistemabanco.entity.notas;

public class VinteReais implements Notas{

    private Long valor;
    private int quantidade;

    public VinteReais() {
        this.valor = 20L;
        this.quantidade = 0;
    }

    @Override
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public int getQuantidade() {
        return quantidade;
    }

    @Override
    public Long getValor() {
        return valor;
    }
}
