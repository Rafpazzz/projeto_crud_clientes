package Rafael.projeto_crud_clientes.repository;

import Rafael.projeto_crud_clientes.entity.User.Users;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Optional;

public interface UsersRepositiry extends JpaRepository<Users, Integer> {

    @Transactional
    void deleteById(Integer id);

    Optional<Users> findById(long id);

    UserDetails findByEmail(String email);

    Optional<Users> findByCpf(String cpf);

    boolean existsByEmail(String email);

    boolean existsBycpf(String cpf);
}
