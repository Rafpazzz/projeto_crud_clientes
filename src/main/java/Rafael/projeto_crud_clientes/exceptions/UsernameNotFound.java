package Rafael.projeto_crud_clientes.exceptions;

public class UsernameNotFound extends RuntimeException{
    public UsernameNotFound() {
        super("Usuario não encontrado");
    }

    public UsernameNotFound(String  message) {
        super(message);
    }
}
