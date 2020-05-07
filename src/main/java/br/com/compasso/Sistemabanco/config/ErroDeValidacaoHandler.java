package br.com.compasso.Sistemabanco.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@ControllerAdvice
public class ErroDeValidacaoHandler {
    @Autowired
    private MessageSource messageSource;

    @ResponseStatus(code = HttpStatus.BAD_REQUEST)
    @ExceptionHandler(value = {IllegalArgumentException.class})
    public ResponseEntity<ErroDeFormularioDto> handle(IllegalArgumentException exception) {
//        List<ErroDeFormularioDto> dto = new ArrayList<>();

        ErroDeFormularioDto dto = new ErroDeFormularioDto("valor", "O numero deve ser divisivel por 10!");
//        List<FieldError> fieldErrors = exception.getFieldErrors();
//        fieldErrors.forEach(e -> {
//            String mensagem = messageSource.getMessage(e, LocaleContextHolder.getLocale());
//            ErroDeFormularioDto erro = new ErroDeFormularioDto(e.getField(), mensagem);
//            dto.add(erro);
//        });

        return new ResponseEntity<>(dto, HttpStatus.BAD_REQUEST);
    }
}
