package br.com.aleferamos.BookStore;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@EnableFeignClients
@EnableEncryptableProperties
public class BookStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookStoreApplication.class, args);
	}

	@Bean
	public PasswordEncoder getPasswordEncoder(){
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		return encoder;
	}

}
