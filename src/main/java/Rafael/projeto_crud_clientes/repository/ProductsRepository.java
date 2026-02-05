package Rafael.projeto_crud_clientes.repository;

import Rafael.projeto_crud_clientes.entity.Product.Products;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductsRepository extends JpaRepository<Products, Integer> {
    @Transactional
    void deleteById(long id);

    Optional<Products> findById(Integer id);

    Optional<Products> findByType(String type);

    Optional<Products> findByMarca(String marca);

    Optional<Products> findByName(String name);
}
