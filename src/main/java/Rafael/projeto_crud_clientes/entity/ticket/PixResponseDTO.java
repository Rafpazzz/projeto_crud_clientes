package Rafael.projeto_crud_clientes.entity.ticket;

import java.math.BigDecimal;
import lombok.AllArgsConstructor;
import lombok.Getter;


@Getter
@AllArgsConstructor
public class PixResponseDTO {
    private Integer ticketId;
    private Long paymentId;
    private String qrCode;
    private String qrCodeBase64;
    private BigDecimal valor;
    private StatusPagamento status;
}
