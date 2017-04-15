package dcws.hospital.system.rest.portal;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.velocity.VelocityAutoConfiguration;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import dcws.hospital.system.rest.config.ControllerValidationHandler;
import dcws.hospital.system.rest.config.DocumentationSwaggerConfig;
import dcws.hospital.system.rest.config.RestApplicationSecurity;

/*This class use for start spring boot application with specify parameters*/

@ComponentScan(basePackages = { "dcws.hospital.system.rest.controller", "dcws.hospital.system.rest.service" })
@EnableJpaRepositories(basePackages = { "dcws.hospital.system.rest.repository" })
@EntityScan(basePackages = { "dcws.hospital.system.rest.domain" })
@SpringBootApplication(exclude = VelocityAutoConfiguration.class)
//@SpringBootApplication
@Import({ DocumentationSwaggerConfig.class, ControllerValidationHandler.class, RestApplicationSecurity.class })
public class HospitalServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(HospitalServicesApplication.class, args);
	}

	@Bean(name = "messageSource")
	public ReloadableResourceBundleMessageSource messageSource() {
		ReloadableResourceBundleMessageSource messageBundle = new ReloadableResourceBundleMessageSource();
		messageBundle.setBasename("classpath:messages/messages");
		messageBundle.setDefaultEncoding("UTF-8");
		return messageBundle;
	}

}
