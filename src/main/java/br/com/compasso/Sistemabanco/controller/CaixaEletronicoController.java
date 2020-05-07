package br.com.compasso.Sistemabanco.controller;


import br.com.compasso.Sistemabanco.converter.CaixaEletronicoConverter;
import br.com.compasso.Sistemabanco.dto.SaqueDto;
import br.com.compasso.Sistemabanco.entity.Saque;
import br.com.compasso.Sistemabanco.service.CaixaEletronicoService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/caixa")
public class CaixaEletronicoController {

    private final CaixaEletronicoService caixaEletronicoService;
    private final CaixaEletronicoConverter caixaEletronicoConverter;

    public CaixaEletronicoController(CaixaEletronicoService caixaEletronicoService, CaixaEletronicoConverter caixaEletronicoConverter) {
        this.caixaEletronicoService = caixaEletronicoService;
        this.caixaEletronicoConverter = caixaEletronicoConverter;
    }

    @PostMapping
    public ResponseEntity<SaqueDto> sacar(@Valid @RequestBody SaqueDto saqueDto) {

        try {
            Saque saque = caixaEletronicoService.realizarSaque(saqueDto.getValor());
            return ResponseEntity.ok(caixaEletronicoConverter.saqueToSaqueDto(saque));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            throw new IllegalArgumentException();
        }

    }


}
