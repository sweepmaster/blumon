package com.blumonpay.registroOrden;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class RegistroOrdenApplication {

	public static void main(String[] args) {
		SpringApplication.run(RegistroOrdenApplication.class, args);
	}

}
