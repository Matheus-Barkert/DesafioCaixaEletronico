package br.com.compasso.Sistemabanco.entity.notas;

public class CinquentaReais implements Nota {

    private Long valor;
    private int quantidade;

    public CinquentaReais() {
        this.valor = 50L;
        this.quantidade= 0;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
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
