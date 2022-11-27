package br.com.api.products.service;

import br.com.api.products.model.ProductModel;
import br.com.api.products.model.ResponseModel;
import br.com.api.products.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    @Autowired
    private ProductRepository product;

    @Autowired
    private ResponseModel responseModel;

    public Iterable<ProductModel> list(){
        return product.findAll();
    }

    public ResponseEntity<?> create(ProductModel productModel){
        if(productModel.getName().equals("")){
            responseModel.setMessage("Invalid name");
            return new ResponseEntity<ResponseModel>(responseModel, HttpStatus.BAD_REQUEST);
        } else if(productModel.getQuantity() <= 0){
            responseModel.setMessage("Invalid quantity");
            return new ResponseEntity<ResponseModel>(responseModel, HttpStatus.BAD_REQUEST);
        } else {
            return new ResponseEntity<ProductModel>(product.save(productModel), HttpStatus.CREATED);
        }
    }

}
