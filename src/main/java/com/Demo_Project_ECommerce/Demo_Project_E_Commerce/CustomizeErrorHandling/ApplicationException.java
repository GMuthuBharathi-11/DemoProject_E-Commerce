package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.CustomizeErrorHandling;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class ApplicationException extends RuntimeException{
    public ApplicationException(String user_not_found) {
        super(user_not_found);
    }
}
