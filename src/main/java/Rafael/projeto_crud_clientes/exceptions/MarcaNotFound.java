package Rafael.projeto_crud_clientes.exceptions;

public class MarcaNotFound extends RuntimeException {
    public MarcaNotFound() {
        super("Marca de produto nao encontrado");
    }

    public MarcaNotFound(String message) {
        super(message);
    }
}
