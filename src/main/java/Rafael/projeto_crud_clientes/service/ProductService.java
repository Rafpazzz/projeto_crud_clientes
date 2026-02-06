package Rafael.projeto_crud_clientes.service;


import Rafael.projeto_crud_clientes.entity.Product.Products;
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

    public ProductService (ProductsRepository repository) {
        this.repository = repository;
    }

    public void saveProduct(Products product) {
        repository.saveAndFlush(product);
    }

    public Products findbyId(Integer id) {
        return repository.findById(id).orElseThrow(IdNotFound::new);
    }

    public List<Products> findByType(String type) {
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


    public void deleteById(Integer id) {
        Products product = repository.findAll().get(id);

        if(product == null) {
            new IdNotFound().getMessage();
        }else {
            repository.deleteById(id);
        }
    }

}
