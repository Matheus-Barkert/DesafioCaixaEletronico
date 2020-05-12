package br.com.compasso.Sistemabanco.controller;


import br.com.compasso.Sistemabanco.converter.CaixaEletronicoConverter;
import br.com.compasso.Sistemabanco.dto.SaqueDto;
import br.com.compasso.Sistemabanco.dto.SaqueDtoEntrada;
import br.com.compasso.Sistemabanco.entity.Saque;
import br.com.compasso.Sistemabanco.service.CaixaEletronicoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/caixa")
@Api(value="API REST Saque")
@CrossOrigin(origins = "*")
public class CaixaEletronicoController {

    private final CaixaEletronicoService caixaEletronicoService;
    private final CaixaEletronicoConverter caixaEletronicoConverter;

    public CaixaEletronicoController(CaixaEletronicoService caixaEletronicoService, CaixaEletronicoConverter caixaEletronicoConverter) {
        this.caixaEletronicoService = caixaEletronicoService;
        this.caixaEletronicoConverter = caixaEletronicoConverter;
    }

    @PostMapping
    @ApiOperation(value = "Realiza saque.")
    public ResponseEntity<SaqueDto> sacar(@Valid @RequestBody SaqueDtoEntrada saqueDtoEntrada) {

        try {
            Saque saque = caixaEletronicoService.realizarSaque(saqueDtoEntrada.getValor());
            return ResponseEntity.ok(caixaEletronicoConverter.saqueParaSaqueDto(saque));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            throw new IllegalArgumentException();
        }

    }


}
