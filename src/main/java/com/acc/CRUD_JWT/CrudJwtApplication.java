package com.acc.CRUD_JWT;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import io.github.cdimascio.dotenv.Dotenv;

@SpringBootApplication
public class CrudJwtApplication {

	public static void main(String[] args) {
		Dotenv dotenv = Dotenv.load();
		System.setProperty("JWT_SECRET", dotenv.get("JWT_SECRET"));
		System.setProperty("DB_USERNAME", dotenv.get("DB_USERNAME")); // Configurar variável DB_USERNAME
		System.setProperty("DB_PASSWORD", dotenv.get("DB_PASSWORD")); // Configurar variável DB_PASSWORD
		SpringApplication.run(CrudJwtApplication.class, args);
	}

}
