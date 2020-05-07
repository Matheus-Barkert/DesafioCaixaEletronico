package br.com.compasso.Sistemabanco.entity;

import br.com.compasso.Sistemabanco.entity.notas.Nota;

import java.util.Collections;
import java.util.List;

public class Saque {

    private Long valor;
    private List<Nota> listaNotas = new CaixaEletronico().getListaNotas();

    public Saque(Long valor, List<Integer> quantidadeNotas) {
        this.valor = valor;
        for (int i = 0; i < quantidadeNotas.size(); i++) {
            listaNotas.get(i).setQuantidade(quantidadeNotas.get(i));
        }
    }

    public Long getValor() {
        return valor;
    }

    public List<Nota> getListaNotas() {
        return Collections.unmodifiableList(listaNotas);
    }

}
