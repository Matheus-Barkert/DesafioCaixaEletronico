package br.com.compasso.Sistemabanco.service;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class VerificadorTest {

    Verificador verificador = new Verificador();

    @Test
    public void testaValor() {
        boolean valorVerificado = verificador.verificaValor(100L);
        assertTrue(valorVerificado);
    }

    @Test
    public void testaValorInvalido(){
        boolean valorInvalido = verificador.verificaValor(2L);
        assertFalse(valorInvalido);
    }

}