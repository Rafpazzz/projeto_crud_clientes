package Rafael.projeto_crud_clientes.exceptions;

public class CpfExistente extends RuntimeException {
    public CpfExistente() {
        super("Esse CPF ja existe");
    }

    public CpfExistente(String message) {
        super(message);
    }
}
