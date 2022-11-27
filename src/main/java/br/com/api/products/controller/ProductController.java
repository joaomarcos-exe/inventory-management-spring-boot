package br.com.api.products.controller;

import br.com.api.products.model.ProductModel;
import br.com.api.products.model.ResponseModel;
import br.com.api.products.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController()
public class ProductController {

    @Autowired
    private ProductService productService;

    @PutMapping("/update")
    public ResponseEntity<?> updateProduct(@RequestBody ProductModel product){
        return productService.createOrUpdate(product,"UPDATED");
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseModel> deleteProduct(@PathVariable long id){
        return productService.remove(id);
    }

    @PostMapping("/product")
    public ResponseEntity<?> createProduct(@RequestBody ProductModel product){
        return productService.createOrUpdate(product,"CREATE");
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
