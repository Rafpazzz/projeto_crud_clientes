package Rafael.projeto_crud_clientes.controller;

import Rafael.projeto_crud_clientes.entity.Product.Products;
import Rafael.projeto_crud_clientes.service.ProductService;
import org.apache.coyote.Response;
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

    @GetMapping("/findByType")
    public ResponseEntity<Void> findByType(@RequestParam String type) {
        service.findByType(type);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/findById")
    public ResponseEntity<Products> findById(@RequestParam Integer id) {
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

    @DeleteMapping("/deleteById")
    public ResponseEntity<Void> deleteById (@RequestParam Integer id) {
        service.deleteById(id);

        return ResponseEntity.ok().build();
    }

}
