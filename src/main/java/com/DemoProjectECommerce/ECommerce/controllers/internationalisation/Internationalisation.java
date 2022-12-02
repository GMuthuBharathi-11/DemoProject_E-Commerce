package com.DemoProjectECommerce.ECommerce.controllers.internationalisation;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.context.MessageSource;

import java.util.Locale;


@RestController
public class Internationalisation
{
    private MessageSource messageSource;
    public Internationalisation(MessageSource messageSource)
    {
        this.messageSource = messageSource;
    }
    @GetMapping("/welcome")
    public String messages1()
    {
        Locale locale = LocaleContextHolder.getLocale();
        return messageSource.getMessage("welcome.message",null,"Default Message",locale);
    }
}
