package br.com.compasso.Sistemabanco.entity;

import br.com.compasso.Sistemabanco.entity.notas.Nota;
import lombok.Getter;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Saque {

    @Getter
    private Long valor;
    @Getter
    private List<Nota> listaNotas = new CaixaEletronico().getListaNotas();

    public Saque(Long valor, List<Integer> quantidadeParaCadaNota) {
        this.valor = valor;
        for (int i = 0; i < quantidadeParaCadaNota.size(); i++) {
            listaNotas.get(i).setQuantidade(quantidadeParaCadaNota.get(i));
        }
    }



}
