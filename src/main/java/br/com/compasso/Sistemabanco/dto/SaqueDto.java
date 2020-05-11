package br.com.compasso.Sistemabanco.dto;

import br.com.compasso.Sistemabanco.entity.Saque;
import br.com.compasso.Sistemabanco.entity.notas.Nota;

import java.util.Collections;
import java.util.List;

public class SaqueDto {

    private Long valor;

    private List<Nota> listaNotas;

    public SaqueDto() {
    }

    public SaqueDto(Saque saque) {
        this.valor = saque.getValor();
        this.listaNotas = saque.getListaNotas();
    }

    public Long getValor() {
        return valor;
    }

    public List<Nota> getListaNotas() {
        return Collections.unmodifiableList(listaNotas);
    }
}
