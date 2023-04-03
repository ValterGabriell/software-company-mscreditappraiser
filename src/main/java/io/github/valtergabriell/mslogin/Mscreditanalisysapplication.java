package io.github.valtergabriell.mslogin;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class Mscreditanalisysapplication {

	public static void main(String[] args) {
		SpringApplication.run(Mscreditanalisysapplication.class, args);
	}

}
