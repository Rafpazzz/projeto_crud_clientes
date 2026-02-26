package Rafael.projeto_crud_clientes.entity.User;

public record RegisterDTO(String username,String cpf, String email, String password, UserRole role) {
}
