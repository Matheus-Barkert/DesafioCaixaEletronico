package br.com.compasso.Sistemabanco.exception;

import br.com.compasso.Sistemabanco.entity.CaixaEletronico;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ErroDeValidacaoHandler {

    private Long menorNota = new CaixaEletronico().getValorMenorNota();

    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {MethodArgumentNotValidException.class, HttpMessageNotReadableException.class, NullPointerException.class})
    public ResponseEntity<ErroDeFormularioDto> handle(Exception e) {

        ErroDeFormularioDto dto;

        if (e.getClass().equals(MethodArgumentNotValidException.class))
            dto = new ErroDeFormularioDto("valor", "O numero deve ser positivo, inteiro e divisivel por " + menorNota + "!");

        else if (e.getClass().equals(HttpMessageNotReadableException.class))
            dto = new ErroDeFormularioDto("valor", "Permitido apenas numeros!");

        else
            dto = new ErroDeFormularioDto("valor", "Nao pode ser nulo!");

        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }
}
