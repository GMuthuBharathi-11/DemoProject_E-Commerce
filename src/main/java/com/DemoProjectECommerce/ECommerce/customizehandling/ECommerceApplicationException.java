package com.DemoProjectECommerce.ECommerce.customizehandling;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ECommerceApplicationException extends RuntimeException{
    public ECommerceApplicationException(String UserNotfound) {
        super(UserNotfound);
    }
}
