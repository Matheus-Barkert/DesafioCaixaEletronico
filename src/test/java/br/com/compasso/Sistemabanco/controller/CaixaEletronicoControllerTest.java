package br.com.compasso.Sistemabanco.controller;


import br.com.compasso.Sistemabanco.dto.SaqueDto;
import br.com.compasso.Sistemabanco.dto.SaqueDtoEntrada;
import br.com.compasso.Sistemabanco.entity.Saque;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.TestConfiguration;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;

import static org.mockito.Mockito.when;


@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@AutoConfigureMockMvc
class CaixaEletronicoControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private CaixaEletronicoController caixaEletronicoController;

    @TestConfiguration
    static class Config {
        @Bean
        private RestTemplateBuilder builder() {
            //todo possivel lugar para dar problema
            return new RestTemplateBuilder().basicAuthentication("", "");
        }
    }

    @Test
    public void testaStatusCodeQuandoEPassadoUmValorValido() {

        Saque saque = new Saque(100L, Arrays.asList(1, 0, 0, 0, 0));
        SaqueDtoEntrada dtoEntrada = new SaqueDtoEntrada(100L);
        SaqueDto saqueDto = new SaqueDto(saque);
        when(caixaEletronicoController.sacar(dtoEntrada)).thenReturn(ResponseEntity.ok(saqueDto));

    }


}