package br.com.compasso.Sistemabanco.entity.notas;

public class CincoReais implements Nota{

    private Long valor;
    private int quantidade;

    public CincoReais(){
        valor = 5L;
        quantidade = 0;
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
