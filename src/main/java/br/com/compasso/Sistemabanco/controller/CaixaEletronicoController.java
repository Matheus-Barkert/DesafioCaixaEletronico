package br.com.compasso.Sistemabanco.controller;


import br.com.compasso.Sistemabanco.config.ErroDeFormularioDto;
import br.com.compasso.Sistemabanco.config.ErroDeValidacaoHandler;
import br.com.compasso.Sistemabanco.converter.CaixaEletronicoConverter;
import br.com.compasso.Sistemabanco.dto.SaqueDto;
import br.com.compasso.Sistemabanco.entity.Saque;
import br.com.compasso.Sistemabanco.service.CaixaEletronicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequestMapping("/caixa")
public class CaixaEletronicoController {

    @Autowired
    public CaixaEletronicoService caixaEletronicoService;

    @Autowired
    public CaixaEletronicoConverter caixaEletronicoConverter;

    //todo revisar, nao passei pelo contrutor para tentar fazer os testes
//    private final CaixaEletronicoService caixaEletronicoService;
//    private final CaixaEletronicoConverter caixaEletronicoConverter;
//
//    public CaixaEletronicoController(CaixaEletronicoService caixaEletronicoService, CaixaEletronicoConverter caixaEletronicoConverter) {
//        this.caixaEletronicoService = caixaEletronicoService;
//        this.caixaEletronicoConverter = caixaEletronicoConverter;
//    }

    @PostMapping
    public ResponseEntity<SaqueDto> sacar(@Valid @RequestBody SaqueDto saqueDto) {

        try {
            Saque saque = caixaEletronicoService.realizarSaque(saqueDto.getValor());
            return ResponseEntity.ok(caixaEletronicoConverter.saqueToSaqueDto(saque));
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
            return ResponseEntity.badRequest().build();
        }

    }


}
