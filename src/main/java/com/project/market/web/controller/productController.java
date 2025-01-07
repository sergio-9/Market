package com.project.market.web.controller;

import com.project.market.domain.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.market.domain.service.ProductService;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class productController {
    @Autowired
    private ProductService productService;

    public List<Product> getAll(){
        return productService.getAll();
    }
    public Optional<Product> getProduct(int categoryId){
        return productService.getProduct(categoryId);
    }
    public Optional<List<Product>> getByCategory(int categoryId){
        return productService.getByCategoria(categoryId);
    }
    public Product save(Product product){
        return productService.save(product);
    }
    public boolean delete(int productId){
        return productService.delete(productId);
    }
}
