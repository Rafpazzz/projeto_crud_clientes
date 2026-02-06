package Rafael.projeto_crud_clientes.exceptions;

public class TypeNotFound extends RuntimeException {
    public TypeNotFound() {
        super("Tipo de produto nao encontrado");
    }

    public TypeNotFound(String message) {
        super(message);
    }
}
