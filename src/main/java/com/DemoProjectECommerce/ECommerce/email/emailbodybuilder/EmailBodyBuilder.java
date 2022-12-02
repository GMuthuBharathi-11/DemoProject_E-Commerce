package com.DemoProjectECommerce.ECommerce.email.emailbodybuilder;

import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

@Service
public class EmailBodyBuilder {
    private final TemplateEngine templateEngine;

    public EmailBodyBuilder(TemplateEngine templateEngine) {

        this.templateEngine = templateEngine;
    }

    public String build(String message) {
        Context context = new Context();
        context.setVariable("message", message);
        return templateEngine.process("mailTemplate", context);
    }

}
