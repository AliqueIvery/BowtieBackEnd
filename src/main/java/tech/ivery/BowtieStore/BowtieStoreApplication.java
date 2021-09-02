package tech.ivery.BowtieStore;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
@SpringBootApplication
public class BowtieStoreApplication {

	public static void main(String[] args) {
		SpringApplication.run(BowtieStoreApplication.class, args);
	}

}
