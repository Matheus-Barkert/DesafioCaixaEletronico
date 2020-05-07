package br.com.compasso.Sistemabanco.dto;

import br.com.compasso.Sistemabanco.entity.Saque;
import br.com.compasso.Sistemabanco.entity.notas.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class SaqueDto {


    private Long valor;

    private List<Notas> listaNotas;

    public SaqueDto() {
        
    }

    public SaqueDto(Saque saque) {
        this.valor = saque.getValor();
        this.listaNotas = saque.getListaNotas();
    }

    public Long getValor() {
        return valor;
    }

    public List<Notas> getListaNotas() {
        return Collections.unmodifiableList(listaNotas);
    }

}
