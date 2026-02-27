package Rafael.projeto_crud_clientes.entity.ticket;

import java.time.LocalDate;

public class TicketResponseDTO {
    private Integer id;
    private LocalDate dataCompra;

    private String produtoName;
    private String produtoMarca;

    private String userEmail;
    private String userCPF;

    public TicketResponseDTO(Integer id, LocalDate dataCompra, String produtoNome,
                             String produtoMarca, String userEmail, String userCPF) {
        this.id = id;
        this.dataCompra = dataCompra;
        this.produtoName = produtoNome;
        this.produtoMarca = produtoMarca;
        this.userEmail = userEmail;
        this.userCPF = userCPF;
    }
}
