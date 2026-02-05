package Rafael.projeto_crud_clientes.entity.Product;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.validator.constraints.CodePointLength;

@Getter
@Setter
@EqualsAndHashCode(of = "id")
@AllArgsConstructor
@NoArgsConstructor

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

    @Column(name = "socket", nullable = false)
    private String socket;

    @Column(name = "cores_processer")
    private Integer cores_processer;

    @Column(name = "threads")
    private Integer threads;


    public Products(String name, TypesProducts type, String marca, String socket, Integer cores_processer, Integer threads) {
        this.name =name;
        this.type = type;
        this.cores_processer = cores_processer;
        this.marca = marca;
        this.socket = socket;
        this.threads = threads;
    }
}
