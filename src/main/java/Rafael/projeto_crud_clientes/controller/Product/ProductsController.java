package Rafael.projeto_crud_clientes.controller.Product;

import Rafael.projeto_crud_clientes.entity.Product.Products;
import Rafael.projeto_crud_clientes.entity.Product.TypesProducts;
import Rafael.projeto_crud_clientes.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProductsController {

    private final ProductService service;

    public ProductsController(ProductService service) {
        this.service = service;
    }

    @PostMapping("/saveProduct")
    public ResponseEntity<Void> saveProduct(@RequestBody Products product) {
        service.saveProduct(product);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/saveListProduct")
    public ResponseEntity<Void> saveListProduct(@RequestBody List<Products> list) {
        service.saveListProduct(list);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/findByType")
    public ResponseEntity<List<Products>> findByType(@RequestParam TypesProducts type) {
        return ResponseEntity.ok(service.findByType(type));
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<Products> findById(@PathVariable Integer id) {
        return ResponseEntity.ok(service.findbyId(id));
    }

    @GetMapping("/findByMarca")
    public ResponseEntity<List<Products>> findByMArca (@RequestParam String marca) {
        return ResponseEntity.ok(service.findByMarca(marca));
    }

    @GetMapping("/findByName")
    public ResponseEntity<List<Products>> findByName (@RequestParam String name) {
        return ResponseEntity.ok(service.findByName(name));
    }

    @PutMapping("/updateProduct/{id}")
    public ResponseEntity<Void> updateProduct(@PathVariable Integer id, @RequestBody Products product) {
        service.updateProduct(id, product);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<Void> deleteById (@PathVariable Integer id) {
        service.deleteById(id);

        return ResponseEntity.ok().build();
    }

}
