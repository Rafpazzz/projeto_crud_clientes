package Rafael.projeto_crud_clientes.entity.ticket;


import Rafael.projeto_crud_clientes.entity.Product.Products;
import Rafael.projeto_crud_clientes.entity.User.Users;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")


@Entity
@Table(name = "ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "produto_id")
    private Products produto;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private Users user;

    @Column(name = "data_compa")
    private LocalDate data_compra;
}
