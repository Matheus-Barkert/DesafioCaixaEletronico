package br.com.compasso.Sistemabanco.service;

import br.com.compasso.Sistemabanco.entity.CaixaEletronico;
import br.com.compasso.Sistemabanco.entity.notas.Nota;

import java.util.List;

public class Verificador {

    private List<Nota> listaNotas = new CaixaEletronico().getListaNotas();

    public boolean verificaValor(Long valorSaque) {
        if (valorSaque > 0 && ehDivisivelPor(valorSaque)) return true;
        return false;
    }

    private boolean ehDivisivelPor(Long valor) {
        return valor % listaNotas.get(listaNotas.size() - 1).getValor() == 0;
    }

}
