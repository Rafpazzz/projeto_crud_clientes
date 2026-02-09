package Rafael.projeto_crud_clientes.service;

import Rafael.projeto_crud_clientes.entity.Product.Products;
import Rafael.projeto_crud_clientes.entity.ticket.Ticket;
import Rafael.projeto_crud_clientes.exceptions.IdNotFound;
import Rafael.projeto_crud_clientes.repository.ProductsRepository;
import Rafael.projeto_crud_clientes.repository.TicketRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDate;
import java.util.List;

@Service
public class TicketService {

    @Autowired
    ProductsRepository productsRepository;

    private final TicketRepository repository;

    public TicketService(TicketRepository repository) {
        this.repository = repository;
    }

    public void saveTicket(Ticket ticket) {
        Integer id_produto = ticket.getProduto().getId();

        Products produto_banco = productsRepository.findById(id_produto).orElseThrow(IdNotFound::new);

        if(!produto_banco.getIsDisponivel()) throw new RuntimeException("Produto indisponível no estoque!");

        ticket.setProduto(produto_banco);
        ticket.setData_compra(LocalDate.now());

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
        return  repository.findByProductName(name);
     }

     public List<Ticket> findByProductmarca(String marca) {
        return repository.findByProductMarca(marca);
     }

     public void deleteById(Integer id) {
        repository.deleteById(id);
     }
}
