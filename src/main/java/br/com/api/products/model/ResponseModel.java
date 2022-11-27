package br.com.api.products.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Component;

@Component // O proprio spring ira instanciar o objeto
@Getter
@Setter
public class ResponseModel {
    private String message;
}
