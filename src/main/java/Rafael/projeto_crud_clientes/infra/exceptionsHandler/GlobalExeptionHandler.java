package Rafael.projeto_crud_clientes.infra.exceptionsHandler;

import Rafael.projeto_crud_clientes.exceptions.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExeptionHandler<T> {

    @ExceptionHandler(UsernameNotFound.class)
    private ResponseEntity<String> handlerUsernameNotFound(UsernameNotFound username) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(username.getMessage());
    }

    @ExceptionHandler(IdNotFound.class)
    private ResponseEntity<String> handlerIdNotFound(IdNotFound idNotFound) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(idNotFound.getMessage());
    }

    @ExceptionHandler(MarcaNotFound.class)
    private ResponseEntity<String> handlerMarcaNotFound(MarcaNotFound marcaNotFound) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(marcaNotFound.getMessage());
    }

    @ExceptionHandler(NameProductNotFound.class)
    private ResponseEntity<String> handlerNameProductNotFound(NameProductNotFound nameProductNotFound) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(nameProductNotFound.getMessage());
    }

    @ExceptionHandler(TypeNotFound.class)
    private ResponseEntity<String> handlerTypeNotFound(TypeNotFound typeNotFound) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(typeNotFound.getMessage());
    }
}
