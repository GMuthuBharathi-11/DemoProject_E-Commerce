package com.Demo_Project_ECommerce.Demo_Project_E_Commerce.Email.EmailBodyBuilder;

import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;

import javax.naming.Context;

@Service
public class Email_Body_Builder {
    private final TemplateEngine templateEngine;

    public Email_Body_Builder(TemplateEngine templateEngine) {

        this.templateEngine = templateEngine;
    }

//    public String build(String message) {
//        Context context = new Context()
//        Context context = new org.thymeleaf.context.Context()
//                context.setVariable("message", message);
//        return templateEngine.process("mailTemplate", context);




}
