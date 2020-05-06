package br.com.compasso.Sistemabanco.dto;

import br.com.compasso.Sistemabanco.entity.Saque;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

public class SaqueDto {


    private Long valor;

    private int nota100 = 0;
    private int nota50 = 0;
    private int nota20 = 0;
    private int nota10 = 0;

    public SaqueDto(){

    }

    public SaqueDto(Saque saque){
        this.valor = saque.getValor();
        this.nota100 = saque.getNota100();
        this.nota50 = saque.getNota50();
        this.nota20 = saque.getNota20();
        this.nota10 = saque.getNota10();
    }

    public Long getValor() {
        return valor;
    }

    public int getNota100() {
        return nota100;
    }

    public int getNota50() {
        return nota50;
    }

    public int getNota20() {
        return nota20;
    }

    public int getNota10() {
        return nota10;
    }
}
