package br.com.compasso.Sistemabanco.exception;

import br.com.compasso.Sistemabanco.entity.CaixaEletronico;
import br.com.compasso.Sistemabanco.entity.notas.Nota;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ErroDeValidacaoHandler {

    Nota menorNota = new CaixaEletronico().getMenorNota();

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {IllegalArgumentException.class})
    public ResponseEntity<ErroDeFormularioDto> handle() {

        ErroDeFormularioDto dto = new ErroDeFormularioDto("valor", "O numero deve ser positivo e divisivel por " + menorNota.getValor() + "!");


        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }
}
