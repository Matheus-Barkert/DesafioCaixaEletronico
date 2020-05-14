package br.com.compasso.Sistemabanco.controller;


import br.com.compasso.Sistemabanco.converter.CaixaEletronicoConverter;
import br.com.compasso.Sistemabanco.dto.NotaDto;
import br.com.compasso.Sistemabanco.dto.SaqueDto;
import br.com.compasso.Sistemabanco.dto.SaqueDtoEntrada;
import br.com.compasso.Sistemabanco.entity.Saque;
import br.com.compasso.Sistemabanco.entity.notas.Nota;
import br.com.compasso.Sistemabanco.service.CaixaEletronicoService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/caixa")
@Api(value = "API REST Saque")
@CrossOrigin(origins = "*")
public class CaixaEletronicoController {

    private final CaixaEletronicoService caixaEletronicoService;
    private final CaixaEletronicoConverter caixaEletronicoConverter;

    public CaixaEletronicoController(CaixaEletronicoService caixaEletronicoService, CaixaEletronicoConverter caixaEletronicoConverter) {
        this.caixaEletronicoService = caixaEletronicoService;
        this.caixaEletronicoConverter = caixaEletronicoConverter;
    }

    @GetMapping
    @ApiOperation(value = "Lista notas disponiveis")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Lista de notas retornadas com sucesso!", response = NotaDto.class),
            @ApiResponse(code = 500, message = "Erro interno!")
    })
    public ResponseEntity<List<NotaDto>> listarNotas() {
        List<Nota> notas = caixaEletronicoService.listaNotas();
        return ResponseEntity.ok(caixaEletronicoConverter.notasParaNotasDto(notas));
    }

    @PostMapping
    @ApiOperation(value = "Realiza saque")
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "Saque realizado com sucesso!", response = SaqueDto.class),
            @ApiResponse(code = 400, message = "Erro de requisição!"),
            @ApiResponse(code = 500, message = "Erro interno!")
    })
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
