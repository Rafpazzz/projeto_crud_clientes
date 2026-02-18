package Rafael.projeto_crud_clientes.repository;

import Rafael.projeto_crud_clientes.entity.Product.Products;
import Rafael.projeto_crud_clientes.entity.Product.TypesProducts;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductsRepository extends JpaRepository<Products, Integer> {
    @Transactional
    void deleteById(long id);

    Optional<Products> findById(Integer id);

    List<Products> findByType(TypesProducts type);

    List<Products> findByMarca(String marca);

    List<Products> findByName(String name);
}
