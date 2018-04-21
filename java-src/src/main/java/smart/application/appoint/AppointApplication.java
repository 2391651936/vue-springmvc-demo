package smart.application.appoint;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

@SpringBootApplication
@MapperScan("smart.application.appoint.dao")
@EnableRedisHttpSession
public class AppointApplication {

	public static void main(String[] args) {
		SpringApplication.run(AppointApplication.class, args);
	}
}
