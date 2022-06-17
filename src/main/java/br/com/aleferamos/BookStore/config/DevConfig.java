package br.com.aleferamos.BookStore.config;

import br.com.aleferamos.BookStore.services.EmailService;
import br.com.aleferamos.BookStore.services.SmtpEmailService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("dev")
public class DevConfig {

    @Bean
    public EmailService emailService() {
        return new SmtpEmailService();
    }

}
