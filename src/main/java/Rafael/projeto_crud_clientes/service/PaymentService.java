package Rafael.projeto_crud_clientes.service;

import Rafael.projeto_crud_clientes.entity.ticket.PixResponseDTO;
import Rafael.projeto_crud_clientes.entity.ticket.StatusPagamento;
import Rafael.projeto_crud_clientes.entity.ticket.Ticket;
import Rafael.projeto_crud_clientes.exceptions.IdNotFound;
import Rafael.projeto_crud_clientes.repository.TicketRepository;
import com.mercadopago.MercadoPagoConfig;
import com.mercadopago.client.payment.PaymentClient;
import com.mercadopago.client.payment.PaymentCreateRequest;
import com.mercadopago.client.payment.PaymentPayerRequest;
import com.mercadopago.resources.payment.Payment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.math.BigDecimal;

@Service
public class PaymentService {

    @Value("${mercadopago.access-token}")
    private String accessToken;

    private final TicketRepository ticketRepository;

    public PaymentService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    @PostConstruct
    public void init() {
        MercadoPagoConfig.setAccessToken(accessToken);
    }

    public PixResponseDTO gerarPix (Integer ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId).orElseThrow(IdNotFound::new);

        if(ticket.getStatusPagamento() == StatusPagamento.APROVADO) {
            throw new RuntimeException("Esse ticket ja foi pago");
        }

        try {
            PaymentClient client = new PaymentClient();

            PaymentCreateRequest request = PaymentCreateRequest.builder()
                    .transactionAmount(new BigDecimal("1.00"))
                    .description("Compra " + ticket.getProduto().getName())
                    .paymentMethodId("pix")
                    .payer(PaymentPayerRequest.builder()
                            .email(ticket.getUser().getEmail())
                            .build())
                    .build();

            Payment payment = client.create(request);

            ticket.setPaymentId(payment.getId());
            ticketRepository.save(ticket);

            return new PixResponseDTO(
                    ticket.getId(),
                    payment.getId(),
                    payment.getPointOfInteraction().getTransactionData().getQrCode(),
                    payment.getPointOfInteraction().getTransactionData().getQrCodeBase64(),
                    new BigDecimal("1.00"),
                    StatusPagamento.PENDENTE
            );
        } catch(Exception e) {
            throw new RuntimeException("Erro ao gerar o Pix: " + e.getMessage());
        }
    }

    public StatusPagamento consultarStatus(Integer ticketId) {
        Ticket ticket = ticketRepository.findById(ticketId).orElseThrow(IdNotFound::new);

        try {
            PaymentClient client = new PaymentClient();
            Payment payment = client.get(ticket.getPaymentId());

            StatusPagamento status = switch (payment.getStatus()) {
                case "approved" -> StatusPagamento.APROVADO;
                case "rejected" -> StatusPagamento.REJEITADO;
                case "cancelled" -> StatusPagamento.CANCELADO;
                default -> StatusPagamento.PENDENTE;
            };

            ticket.setStatusPagamento(status);
            ticketRepository.save(ticket);

            return status;
        } catch (Exception e) {
            throw new RuntimeException("Erro ao consultar o pagamento: " + e.getMessage());
        }
    }
}
