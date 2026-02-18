package Rafael.projeto_crud_clientes.controller.Ticket;

import Rafael.projeto_crud_clientes.entity.ticket.Ticket;
import Rafael.projeto_crud_clientes.service.TicketService;
import lombok.AllArgsConstructor;
import org.apache.coyote.Response;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@AllArgsConstructor
public class TicketController {

    private TicketService service;

    @GetMapping("/save")
    public ResponseEntity<Void> saveTicket(@RequestBody Ticket ticket) {
        service.saveTicket(ticket);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/processarTicket")
    public ResponseEntity<String> processarTiket(@RequestParam Integer id_ticket) {
        return ResponseEntity.ok(service.processarTicket(id_ticket));
    }
}
