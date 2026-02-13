package Rafael.projeto_crud_clientes.infra.exceptionsHandler;

import Rafael.projeto_crud_clientes.exceptions.*;
import jakarta.validation.executable.ValidateOnExecution;
import org.apache.coyote.Response;
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

    @ExceptionHandler(EmailExistente.class)
    private  ResponseEntity<String> handlerEmailExistente(EmailExistente emailExistente) {
        return ResponseEntity.status(HttpStatus.CONFLICT).body(emailExistente.getMessage());
    }

    @ExceptionHandler(CpfNotFound.class)
    private ResponseEntity<String> handlerCpfNotFound(CpfNotFound cpfNotFound) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(cpfNotFound.getMessage());
    }

    @ExceptionHandler(CpfExistente.class)
    private ResponseEntity<String> handlerCpfExistente(CpfExistente cpfExistente) {
        return  ResponseEntity.status(HttpStatus.CONFLICT).body(cpfExistente.getMessage());
    }
}
