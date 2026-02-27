package Rafael.projeto_crud_clientes.service;

import Rafael.projeto_crud_clientes.entity.Product.Products;
import Rafael.projeto_crud_clientes.entity.ticket.Ticket;
import Rafael.projeto_crud_clientes.entity.ticket.TicketResponseDTO;
import Rafael.projeto_crud_clientes.exceptions.IdNotFound;
import Rafael.projeto_crud_clientes.repository.ProductsRepository;
import Rafael.projeto_crud_clientes.repository.TicketRepository;
import Rafael.projeto_crud_clientes.repository.UsersRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class TicketService {

    private final ProductsRepository productsRepository;

    private final UsersRepository usersRepository;

    private final TicketRepository repository;

    public TicketService(TicketRepository repository, ProductsRepository productsRepository, UsersRepository usersRepository) {
        this.repository = repository;
        this.productsRepository = productsRepository;
        this.usersRepository = usersRepository;
    }

    public void saveTicket(Ticket ticket) {
        Integer idProduto = ticket.getProduto().getId();

        Products produtoBanco = productsRepository.findById(idProduto).orElseThrow(IdNotFound::new);

        if (!produtoBanco.getIsDisponivel()) throw new RuntimeException("Produto indisponível no estoque!");

        ticket.setProduto(produtoBanco);
        ticket.setDataCompra(LocalDate.now());

        repository.saveAndFlush(ticket);
    }

    public Ticket getTicketById(Integer id) {
        Ticket ticket = repository.findById(id).orElseThrow(IdNotFound::new);

        return ticket;
    }


    public List<Ticket> findByEmail(String email) {
        return repository.findByUserEmail(email);
    }

    public List<Ticket> findByProdutoName(String name) {
        return repository.findByProdutoName(name);
    }

    public List<Ticket> findByProdutoMarca(String marca) {
        return repository.findByProdutoMarca(marca);
    }

    public void deleteById(Integer id) {
        repository.deleteById(id);
    }


    public TicketResponseDTO processarTicket(Integer id_ticket) {
        // Serve para retornar o ticket de forma mais limpa

        Ticket ticket = repository.findById(id_ticket).orElseThrow(IdNotFound::new);

        return new TicketResponseDTO(
                ticket.getId(),
                ticket.getDataCompra(),
                ticket.getProduto().getName(),
                ticket.getProduto().getMarca(),
                ticket.getUser().getEmail(),
                ticket.getUser().getCpf()
        );

    }
}
