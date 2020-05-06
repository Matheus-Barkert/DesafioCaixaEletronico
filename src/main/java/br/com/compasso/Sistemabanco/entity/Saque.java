package br.com.compasso.Sistemabanco.entity;

import br.com.compasso.Sistemabanco.dto.SaqueDto;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import java.util.List;

public class Saque {


    private Long valor;

    private int nota100 = 0;
    private int nota50 = 0;
    private int nota20 = 0;
    private int nota10 = 0;

    //TODO descobrir uma forma melhor de fazer isso
    public Saque(Long valor, List<Integer> valores){
        this.valor = valor;
        this.nota100 = valores.get(0);
        this.nota50 = valores.get(1);
        this.nota20 = valores.get(2);
        this.nota10 = valores.get(3);
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
