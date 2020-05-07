package br.com.compasso.Sistemabanco.entity.notas;

public class DezReais implements Notas {

    private Long valor;
    private int quantidade;

    public DezReais() {
        this.valor = 10L;
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
