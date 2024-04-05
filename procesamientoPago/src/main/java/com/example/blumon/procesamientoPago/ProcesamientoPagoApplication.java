package com.example.blumon.procesamientoPago;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class ProcesamientoPagoApplication {

	public static void main(String[] args) {
		SpringApplication.run(ProcesamientoPagoApplication.class, args);
	}

}
