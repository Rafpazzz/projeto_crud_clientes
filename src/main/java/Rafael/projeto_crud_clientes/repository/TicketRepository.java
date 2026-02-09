package Rafael.projeto_crud_clientes.repository;

import Rafael.projeto_crud_clientes.entity.ticket.Ticket;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    public Optional<Ticket> findById(Integer id);

    public List<Ticket> findByUserEmail(String email);

    public List<Ticket> findByProductName(String nameProduct);

    public List<Ticket> findByProductMarca(String marca);

    @Transactional
    public void deleteById(Integer id);
}
