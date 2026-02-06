package Rafael.projeto_crud_clientes.exceptions;

public class NameProductNotFound extends RuntimeException {
    public NameProductNotFound() {
        super("Nome de produto nao encontrado");
    }

    public NameProductNotFound(String message) {
        super(message);
    }
}
