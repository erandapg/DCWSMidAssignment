package dcws.hospital.system.rest.portal;

import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.web.SpringBootServletInitializer;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.ComponentScan;

/*This class for initialize spring boot application class*/
@EntityScan(basePackages = { "dcws.hospital.system.rest.domain" })
@ComponentScan(basePackages = { "dcws.hospital.system.rest" })
public class ServletInitializer extends SpringBootServletInitializer {

	@Override
	protected SpringApplicationBuilder configure(SpringApplicationBuilder application) {
		return application.sources(HospitalServicesApplication.class);
	}

}
