package Rafael.projeto_crud_clientes.controller.Ticket;

import Rafael.projeto_crud_clientes.entity.ticket.PixResponseDTO;
import Rafael.projeto_crud_clientes.entity.ticket.StatusPagamento;
import Rafael.projeto_crud_clientes.service.PaymentService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/ticket")
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/{id}/pagar")
    public ResponseEntity<PixResponseDTO> gerarPix(@PathVariable Integer id) {
        return ResponseEntity.ok(paymentService.gerarPix(id));
    }

    @GetMapping("/{id}/status")
    public ResponseEntity<StatusPagamento> consultStaus(@PathVariable Integer id) {
        return ResponseEntity.ok(paymentService.consultarStatus(id));
    }
}
