package com.example.crud3.Controller;

import com.example.crud3.Model.Product;
import com.example.crud3.Service.ProductService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping()
    public ResponseEntity<Product> addProduct(@RequestBody Product product) {
        Product savedProduct = productService.addProduct(product);
        return new ResponseEntity<>(savedProduct, HttpStatus.CREATED);
    }

    @GetMapping()
    public ResponseEntity<List<Product>> getAllProducts() {
        List<Product> product = productService.getAllProducts();
        return new ResponseEntity<>(product, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable int id,@RequestBody Product product) {
        Product updatedProduct = productService.updateProduct(id,product);
        return ResponseEntity.ok(updatedProduct);
    }



}
