package Rafael.projeto_crud_clientes.exceptions;

public class CpfNotFound extends RuntimeException {
    public CpfNotFound() {
        super("Cpf passado nao foi encontrado ou ");
    }

    public CpfNotFound(String message) {
        super(message);
    }
}
