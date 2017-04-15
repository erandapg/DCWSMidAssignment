
package dcws.hospital.system.rest.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class DocumentationSwaggerConfig {

	/* This class for API documentation using swagger libraries */
	@Bean
	public Docket newsApi() {

		return new Docket(DocumentationType.SWAGGER_2).groupName("DCWSHospitalSystem").useDefaultResponseMessages(false)
				.apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("dcws.hospital.system.rest.controller"))
				.paths(PathSelectors.any()).build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("DCWSHospitalSystem Documentation")
				.description("DCWS HospitalSystem REST API Documentation")
				.termsOfServiceUrl("http://www-03.ibm.com/software/sla/sladb.nsf/sla/bm?Open")
				.contact(new Contact("Eranda Gunasena", "erandapg@gmail.com", "erandapg@gmail.com"))
				.license("Apache License Version 2.0")
				.licenseUrl("https://github.com/IBM-Bluemix/news-aggregator/blob/master/LICENSE").version("1.0")
				.build();
	}
}
