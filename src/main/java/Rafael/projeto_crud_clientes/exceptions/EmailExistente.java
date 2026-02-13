package Rafael.projeto_crud_clientes.exceptions;

public class EmailExistente extends RuntimeException {

    public EmailExistente(String message) {
        super(message);
    }
}
