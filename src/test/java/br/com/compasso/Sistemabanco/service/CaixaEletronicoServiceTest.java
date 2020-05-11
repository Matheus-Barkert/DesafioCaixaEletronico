package br.com.compasso.Sistemabanco.service;

import br.com.compasso.Sistemabanco.entity.Saque;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.http.converter.HttpMessageNotReadableException;

import static org.junit.jupiter.api.Assertions.*;

class CaixaEletronicoServiceTest {

    CaixaEletronicoService caixaEletronicoService = new CaixaEletronicoService();

    @Test
    public void testaRealizaSaqueComValorNegativo() {

        assertThrows(IllegalArgumentException.class, () ->{
            Saque saque = caixaEletronicoService.realizarSaque((long) -10);
        });
    }

    @Test
    public void testaRealizaSaqueComValorInvalido() {

        assertThrows(IllegalArgumentException.class, () ->{
            Saque saque = caixaEletronicoService.realizarSaque(128L);
        });
    }

    @Test
    public void testaRealizaSaqueComValorValido() {

        Saque saque = caixaEletronicoService.realizarSaque(100L);
        assertEquals(100L, saque.getValor());

    }

    @Test
    public void testaNotasDeCincoReais() {
        Saque saque = caixaEletronicoService.realizarSaque(5L);
        assertEquals(5L, saque.getValor());
    }

    @Test
    public void testaNotasDeDezReais() {
        Saque saque = caixaEletronicoService.realizarSaque(10L);
        boolean notaDezPresente = saque.getListaNotas().stream().anyMatch(s -> s.getValor() == 10L);
        assertTrue(notaDezPresente);
    }

    @Test
    public void testaNotasDeVinteReais() {
        Saque saque = caixaEletronicoService.realizarSaque(30L);
        boolean notaDeVinteReaisPresente = saque.getListaNotas().stream().anyMatch(s -> s.getValor() == 20L);
        assertTrue(notaDeVinteReaisPresente);
    }

    @Test
    public void testaNotasDeCinquentaReais() {
        Saque saque = caixaEletronicoService.realizarSaque(60L);
        boolean notaCinquentaReaisPresente = saque.getListaNotas()
                .stream().anyMatch(nota -> nota.getValor().equals(50L));

        assertTrue(notaCinquentaReaisPresente);
    }

    @Test
    public void testaNotasDeCemReais() {
        Saque saque = caixaEletronicoService.realizarSaque(110L);
        boolean notaDeCemReaisPresente = saque.getListaNotas().stream().anyMatch(nota -> nota.getValor() == 100L);
        boolean possuiApenasUmaNota = saque.getListaNotas().stream().anyMatch(nota -> nota.getQuantidade() == 1);

        assertTrue(notaDeCemReaisPresente);
        assertTrue(possuiApenasUmaNota);

    }


}