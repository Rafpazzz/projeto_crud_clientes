package Rafael.projeto_crud_clientes.repository;

import Rafael.projeto_crud_clientes.entity.Users;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsersRepositiry extends JpaRepository<Users, Integer> {

    @Transactional
    void deleteById(long id);

    Optional<Users> findById(long id);
}
