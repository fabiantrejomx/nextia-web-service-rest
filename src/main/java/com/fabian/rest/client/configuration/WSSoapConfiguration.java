package com.fabian.rest.client.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import org.springframework.ws.client.core.WebServiceTemplate;

@Configuration
public class WSSoapConfiguration {

    @Bean
    public Jaxb2Marshaller marshaller() {
        final Jaxb2Marshaller marshaller = new Jaxb2Marshaller();
        marshaller.setContextPath("com.fabian.rest.client.task");
        return marshaller;
    }

    @Bean
    public WebServiceTemplate template(final Jaxb2Marshaller marshaller){
        return new WebServiceTemplate(marshaller);
    }

}
