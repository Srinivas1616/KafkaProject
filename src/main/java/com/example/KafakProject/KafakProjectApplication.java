package com.example.KafakProject;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@SpringBootApplication
@RestController
public class KafakProjectApplication {

	@Autowired
	private KafkaTemplate<String, Object> template;

	private String topic = "communication";

	@GetMapping("/publish/sms/{name}")
	@ResponseBody
	public String publishMessage(@PathVariable String name) {
		template.send(topic, "Hi " + name + " Welcome to java techie");
		return "Data published";
	}

	@GetMapping("/publish/email")
	public String publishMessage() {
		Email email = new Email();
		
		template.send(topic, email);
		return "Json Data published";
	}

	public static void main(String[] args) {
		SpringApplication.run(KafakProjectApplication.class, args);
	}
}
