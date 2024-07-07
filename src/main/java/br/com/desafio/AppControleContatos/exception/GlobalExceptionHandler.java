package br.com.desafio.AppControleContatos.exception;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public Map<String, String> validationExceptionHandler(MethodArgumentNotValidException exception) {
        Map<String, String> erros = new HashMap<>();
        exception.getBindingResult().getAllErrors().forEach((error) -> {
            String atributo = ((FieldError) error).getField();
            String mensagem = error.getDefaultMessage();
            erros.put(atributo, mensagem);
        });
        return erros;
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(GlobalNotFoundException.class)
    public Map<String, String> globalNotFoundException(GlobalNotFoundException exception) {
        Map<String, String> erro = new HashMap<>();
        erro.put("mensagem", exception.getMessage());
        return erro;
    }
}
