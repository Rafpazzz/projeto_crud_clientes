package Rafael.projeto_crud_clientes.exceptions;

public class IdNotFound extends RuntimeException {
    public IdNotFound() {
        super("Id não encontrado");
    }

    public IdNotFound(String message) {
        super(message);
    }
}
