package com.example.crud3.Service;

import com.example.crud3.Controller.ProductController;
import com.example.crud3.Model.Product;
import com.example.crud3.Repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    public Product addProduct(Product product) {
        return productRepository.save(product);
    }

    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    public Product updateProduct(int id,Product product) {
        product.setId(id);
        return productRepository.save(product);
    }


}
