package br.com.api.products.controller;

import br.com.api.products.model.ProductModel;
import br.com.api.products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class ProductController {

    @Autowired
    private ProductService productService;

    @PostMapping("/product")
    public ResponseEntity<?> createProduct(@RequestBody ProductModel product){
        return productService.create(product);
    }

    @GetMapping("/list")
    public Iterable<ProductModel> list(){
        return productService.list();
    }

    @GetMapping("/")
    public String route(){
        return "Api's products";
    }
}
