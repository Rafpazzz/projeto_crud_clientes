package Rafael.projeto_crud_clientes.controller;

import Rafael.projeto_crud_clientes.entity.Product.Products;
import Rafael.projeto_crud_clientes.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/produto")
public class ProductsController {

    private final ProductService service;

    public ProductsController(ProductService service) {
        this.service = service;
    }


    @GetMapping("/findByType")
    public ResponseEntity<Void> findByType(@RequestParam String type) {
        service.findByType(type);

        return ResponseEntity.ok().build();
    }

}
