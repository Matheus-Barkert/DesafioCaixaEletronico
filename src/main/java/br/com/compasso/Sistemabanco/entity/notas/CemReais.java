package br.com.compasso.Sistemabanco.entity.notas;

public class CemReais implements Nota {

    private Long valor = 100L;
    private int quantidade = 0;

//    public CemReais() {
//        this.valor = 100L;
//        this.quantidade = 0;
//    }

    @Override
    public void setQuantidade(Integer quantidade) {
        this.quantidade = quantidade;
    }

    @Override
    public Long getValor() {
        return valor;
    }

    @Override
    public int getQuantidade() {
        return quantidade;
    }
}
