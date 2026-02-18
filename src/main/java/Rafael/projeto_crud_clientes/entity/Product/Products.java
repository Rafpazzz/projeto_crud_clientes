package Rafael.projeto_crud_clientes.entity.Product;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.CodePointLength;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor
@Builder

@Entity
@Table(name = "products")
public class Products {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "tipo", nullable = false)
    private TypesProducts type;

    @Column(name="marca", nullable = false)
    private String marca;

    @Column(name="price", nullable = false)
    private Double price;

    @Column(name = "socket", nullable = false)
    private String socket;

    @Column(name = "cores_processer", columnDefinition = "integer default 0")
    private Integer cores_processer;

    @Column(name = "threads", columnDefinition = "integer default 0")
    private Integer threads;

    @Column(name="image_text")
    private String image_text;

    @Column(name = "isDisponivel", columnDefinition = "boolean default false")
    private Boolean isDisponivel;

}
