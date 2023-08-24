package xyz.msprpayetonkawa.apiwebshop;

import io.swagger.v3.oas.models.OpenAPI;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class ApiwebshopApplicationTests {

	@Autowired
	private ApplicationContext applicationContext;

	@Test
	void contextLoads() {
	}

	@Test
	public void openAPIBeanIsPresent() {
		OpenAPI openAPI = applicationContext.getBean(OpenAPI.class);
		assertThat(openAPI).isNotNull();
		assertThat(openAPI.getInfo().getTitle()).isEqualTo("API CRM");
		assertThat(openAPI.getInfo().getDescription()).isEqualTo("API for CRM");
		assertThat(openAPI.getInfo().getVersion()).isEqualTo("0.0.1");
		assertThat(openAPI.getExternalDocs().getDescription()).isEqualTo("Documentation");
		assertThat(openAPI.getExternalDocs().getUrl()).isEqualTo("https:/wiki....");
	}
}
