package xyz.msprpayetonkawa.apiwebshop;

import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Bean;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import java.util.Properties;

@SpringBootApplication
public class ApiwebshopApplication {

	public static void main(String[] args) {

		SpringApplication.run(ApiwebshopApplication.class, args);
	}

	@Bean
	public OpenAPI apiDocConfig() {
		return new OpenAPI()
				.info(new Info()
						.title("API CRM")
						.description("API for CRM")
						.version("0.0.1"))
				.externalDocs(new ExternalDocumentation()
						.description("Documentation")
						.url("https:/wiki...."));
	}

	@Bean
	public JavaMailSender getJavaMailSender() {
		JavaMailSenderImpl mailSender = new JavaMailSenderImpl();
		mailSender.setHost("smtp.gmail.com");
		mailSender.setPort(587);

		mailSender.setUsername("epsiprojets@gmail.com");
		mailSender.setPassword("rwmxappuiugdeasn");

		Properties props = mailSender.getJavaMailProperties();
		props.put("mail.transport.protocol", "smtp");
		props.put("mail.smtp.auth", "true");
		props.put("mail.smtp.starttls.enable", "true");
		props.put("mail.debug", "true");

		return mailSender;
	}

}
