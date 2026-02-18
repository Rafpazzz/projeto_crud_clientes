package Rafael.projeto_crud_clientes.service;


import Rafael.projeto_crud_clientes.entity.Product.Products;
import Rafael.projeto_crud_clientes.entity.Product.TypesProducts;
import Rafael.projeto_crud_clientes.exceptions.IdNotFound;
import Rafael.projeto_crud_clientes.exceptions.MarcaNotFound;
import Rafael.projeto_crud_clientes.exceptions.NameProductNotFound;
import Rafael.projeto_crud_clientes.exceptions.TypeNotFound;
import Rafael.projeto_crud_clientes.repository.ProductsRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    private final ProductsRepository repository;

    public ProductService(ProductsRepository repository) {
        this.repository = repository;
    }

    public void saveProduct(Products product) {
        repository.saveAndFlush(product);
    }

    public void saveListProduct(List<Products> list) {
        repository.saveAllAndFlush(list);
    }

    public Products findbyId(Integer id) {
        return repository.findById(id).orElseThrow(IdNotFound::new);
    }

    public List<Products> findByType(TypesProducts type) {
        try {
            return repository.findByType(type).stream().toList();
        } catch (TypeNotFound e) {
            e.getMessage();
        }
        return List.of();
    }

    public List<Products> findByMarca(String marca) {
        try {
            return repository.findByMarca(marca).stream().toList();
        } catch (MarcaNotFound e) {
            e.getMessage();
        }

        return List.of();
    }

    public List<Products> findByName(String name) {
        try {
            return repository.findByName(name).stream().toList();
        } catch (NameProductNotFound e) {
            e.getMessage();
        }

        return List.of();
    }

    public void updateProduct(Integer id, Products product) {
        Products existingProduct = repository.findById(id).orElseThrow(IdNotFound::new);

        // 2. Atualiza apenas os campos que NÃO vieram nulos
        if (product.getName() != null) {
            existingProduct.setName(product.getName());
        }
        if (product.getType() != null) {
            existingProduct.setType(product.getType());
        }
        if (product.getMarca() != null) {
            existingProduct.setMarca(product.getMarca());
        }
        if (product.getPrice() != null) {
            existingProduct.setPrice(product.getPrice());
        }
        if (product.getSocket() != null) {
            existingProduct.setSocket(product.getSocket());
        }
        if (product.getCores_processer() != null) {
            existingProduct.setCores_processer(product.getCores_processer());
        }
        if (product.getThreads() != null) {
            existingProduct.setThreads(product.getThreads());
        }
        if (product.getImage_text() != null) {
            existingProduct.setImage_text(product.getImage_text());
        }

        repository.save(existingProduct);

    }

    public void deleteById(Integer id) {
        Products product = repository.findById(id).orElseThrow(IdNotFound::new);

        if (product == null) {
            new IdNotFound().getMessage();
        } else {
            repository.deleteById(id);
        }
    }

}
