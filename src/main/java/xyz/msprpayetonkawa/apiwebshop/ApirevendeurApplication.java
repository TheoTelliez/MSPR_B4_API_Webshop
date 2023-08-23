package xyz.msprpayetonkawa.apiwebshop;

import io.swagger.v3.oas.models.info.Info;
import io.swagger.v3.oas.models.ExternalDocumentation;
import io.swagger.v3.oas.models.OpenAPI;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication


public class ApirevendeurApplication {

	public static void main(String[] args) {

		SpringApplication.run(ApirevendeurApplication.class, args);
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

}
