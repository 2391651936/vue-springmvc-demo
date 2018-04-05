package smart.application.appoint;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("smart.application.appoint.dao")
public class AppointApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppointApplication.class, args);
	}
}
