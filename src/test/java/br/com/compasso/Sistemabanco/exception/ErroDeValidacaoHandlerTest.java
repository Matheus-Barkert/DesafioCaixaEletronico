package br.com.compasso.Sistemabanco.exception;

import br.com.compasso.Sistemabanco.controller.CaixaEletronicoController;
import br.com.compasso.Sistemabanco.dto.SaqueDto;
import br.com.compasso.Sistemabanco.entity.Saque;
import br.com.compasso.Sistemabanco.service.CaixaEletronicoService;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.mock;

class ErroDeValidacaoHandlerTest {

    CaixaEletronicoService caixaEletronicoService = new CaixaEletronicoService();

    @Test
    public void testaExceptionParaNumeroNegativo() {

        assertThrows(IllegalArgumentException.class, () -> {
            caixaEletronicoService.realizarSaque(-100L);
        });
    }

}