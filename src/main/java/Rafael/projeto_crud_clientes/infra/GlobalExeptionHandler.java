package Rafael.projeto_crud_clientes.infra;

import Rafael.projeto_crud_clientes.exceptions.UsernameNotFound;
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
}
