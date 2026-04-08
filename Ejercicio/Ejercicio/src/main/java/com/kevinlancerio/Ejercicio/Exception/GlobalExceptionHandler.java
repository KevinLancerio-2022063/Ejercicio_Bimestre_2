package com.kevinlancerio.Ejercicio.Exception;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> validarCampos(Exception e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("Error:", e.getMessage()));
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> validarAnotaciones(MethodArgumentNotValidException ex) {
        List<String> mensajes = ex.getBindingResult().getFieldErrors().stream().map(err -> err.getDefaultMessage()).toList();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("Errores: ", mensajes));
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<?> validarTipoDato(HttpMessageNotReadableException e){
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("Error: ", "Tipo de dato incorrecto."));
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<?> validarFk(DataIntegrityViolationException e) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(Map.of("Error: ", "Error en el FK"));
    }

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<?> validarId(IllegalArgumentException e){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(Map.of("Error", "el id no se encontro"));
    }
}