package com.caiojacinthodev.patrimonio;

import com.caiojacinthodev.patrimonio.domain.patrimonio.Patrimonio;
import com.caiojacinthodev.patrimonio.service.EmailSenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class PatrimonioApplication {
	@Autowired
	private EmailSenderService senderService;
	public static void main(String[] args) {
		SpringApplication.run(PatrimonioApplication.class, args);
	}
}
