package br.com.compasso.Sistemabanco.service;

import br.com.compasso.Sistemabanco.entity.Saque;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CaixaEletronicoServiceTest {

    CaixaEletronicoService caixaEletronicoService = new CaixaEletronicoService();

    @Test
    public void testaRealizaSaqueComValorNegativo() {

        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            Saque saque = caixaEletronicoService.realizarSaque((long) -10);
        });
    }

    @Test
    public void testaRealizaSaqueComValorInvalido() {

        Assertions.assertThrows(IllegalArgumentException.class, () ->{
            Saque saque = caixaEletronicoService.realizarSaque(128L);
        });
    }

    @Test
    public void testaRealizaSaqueComValorValido() {

        Saque saque = caixaEletronicoService.realizarSaque(100L);

        Assertions.assertEquals(100L, saque.getValor());

    }



}