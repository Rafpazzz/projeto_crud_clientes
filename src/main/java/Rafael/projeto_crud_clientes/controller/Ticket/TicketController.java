package Rafael.projeto_crud_clientes.controller.Ticket;

import Rafael.projeto_crud_clientes.entity.ticket.Ticket;
import Rafael.projeto_crud_clientes.service.TicketService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor
public class TicketController {

    private TicketService service;

    @GetMapping("/save")
    public ResponseEntity<Void> saveTicket(@RequestBody Ticket ticket) {
        service.saveTicket(ticket);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/processarTicket/{id_ticket}")
    public ResponseEntity<String> processarTiket(@PathVariable Integer id_ticket) {
        return ResponseEntity.ok(service.processarTicket(id_ticket));
    }

    @GetMapping("/getTicketById/{id}")
    public ResponseEntity<Ticket> getTicketById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.getTicketById(id));
    }

    @GetMapping("/findByEmail")
    public ResponseEntity<List<Ticket>> findByEmail(@RequestBody String email) {
        return ResponseEntity.ok(service.findByEmail(email));
    }

    @GetMapping("/findByProdutoName")
    public ResponseEntity<List<Ticket>> findByProdutoName(@RequestBody String name) {
        return  ResponseEntity.ok(service.findByProdutoName(name));
    }

    @GetMapping("/findByProdutoMarca")
    public ResponseEntity<List<Ticket>> findByProdutoMarca(@RequestParam String marca) {
        return  ResponseEntity.ok(service.findByProdutoMarca(marca));
    }

    @DeleteMapping("/deleteById")
    public ResponseEntity<Void> deleteById(@RequestParam Integer id) {
        service.deleteById(id);

        return ResponseEntity.ok().build();
    }
}
